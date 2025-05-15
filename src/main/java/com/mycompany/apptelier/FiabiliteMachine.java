package com.mycompany.apptelier;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import java.sql.*;

public class FiabiliteMachine {

    static class StatMachine {
        String machine;
        Duration tempsPanne = Duration.ZERO;
        Duration observation = Duration.between(LocalTime.of(6, 0), LocalTime.of(20, 0));

        public double getFiabilite() {
            long fonctionnement = observation.minus(tempsPanne).toMinutes();
            return (double) fonctionnement / observation.toMinutes();
        }
    }

    public static void calculerFiabiliteDepuisFichier(String cheminFichier) {
        Map<String, StatMachine> stats = new HashMap<>();
        Map<String, LocalTime> enPanneDepuis = new HashMap<>();
        List<StatMachine> machinesTriees = new ArrayList<>();

        try {
            List<String> lignes = Files.readAllLines(Paths.get(cheminFichier));
            for (String ligne : lignes) {
                if (ligne.trim().isEmpty()) continue;
                String[] parts = ligne.split(" ");
                if (parts.length < 5) continue;

                String heure = parts[1];
                String machine = parts[2];
                String evenement = parts[3];

                LocalTime h = LocalTime.parse(heure);
                stats.putIfAbsent(machine, new StatMachine());
                stats.get(machine).machine = machine;

                if (evenement.equals("A")) {
                    enPanneDepuis.put(machine, h);
                } else if (evenement.equals("D")) {
                    LocalTime debut = enPanneDepuis.get(machine);
                    if (debut != null) {
                        Duration d = Duration.between(debut, h);
                        stats.get(machine).tempsPanne = stats.get(machine).tempsPanne.plus(d);
                        enPanneDepuis.remove(machine);
                    }
                }
            }

            machinesTriees = new ArrayList<>(stats.values());
            machinesTriees.sort(Comparator.comparingDouble(StatMachine::getFiabilite).reversed());

            System.out.println("=== Fiabilité des machines ===");
            for (StatMachine stat : machinesTriees) {
                System.out.printf("%s : %.2f %%\n", stat.machine, stat.getFiabilite() * 100);
            }

            // Enregistrement BDD
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:atelier.db")) {
                String insert = "INSERT INTO Fiabilite(refMachine, fiabilite, dateCalc) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insert);
                String dateCalc = LocalDate.now().toString();

                for (StatMachine stat : machinesTriees) {
                    pstmt.setString(1, stat.machine);
                    pstmt.setDouble(2, stat.getFiabilite() * 100);
                    pstmt.setString(3, dateCalc);
                    pstmt.executeUpdate();
                }

                System.out.println("Résultats enregistrés dans la base !");
            }

        } catch (IOException | SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
