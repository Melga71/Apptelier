package com.mycompany.apptelier;

public abstract class Equipement {
    //Attributs
    String refEquipement;
    String dEquipement;
    
    //Classe abstraite, pas de constructeur
    //Méthodes
    public abstract void afficher();
    
    
    
    //Getters & Setters
    public String getRefEquipement() {
        return refEquipement;
    }

    public void setRefEquipement(String refEquipement) {
        this.refEquipement = refEquipement;
    }

    public String getdEquipement() {
        return dEquipement;
    }

    public void setdEquipement(String dEquipement) {
        this.dEquipement = dEquipement;
    }
    
}
