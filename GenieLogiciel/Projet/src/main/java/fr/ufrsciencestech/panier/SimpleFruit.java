/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author mamoudou
 */
public class SimpleFruit implements Fruit{
    private double prix;
    private String origine;
    
    
    public SimpleFruit(double prix, String origine) {
        if (prix < 0)
            this.prix = Math.abs(prix);
        else
            this.prix = prix;

        if (origine.equals(""))
            this.origine = "Origine inconnu";
        else
            this.origine = origine;
    }
    public boolean isSeedless(){
        return false;
    }
    public double getPrix(){
        return this.prix;
    }
    
    public String getOrigine(){
        return this.origine;
    }
    
    @Override
    public String toString() {
        return "Fruit de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o) { 
        if (o != null && getClass() == o.getClass()) {
            Banane or = (Banane) o;
            return (prix == or.getPrix() && origine.equals(or.getOrigine()));
        }
        return false;
    }

}
