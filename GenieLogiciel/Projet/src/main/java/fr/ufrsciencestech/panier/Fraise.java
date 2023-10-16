/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author mamoudou
 */
public class Fraise extends SimpleFruit{
    public Fraise() {
        this(0.35, "Hawai");
    }

    public Fraise(double prix, String origine) {
        super(prix, origine);
    }

    @Override
    public String toString() {
        return "Fraise de " + this.getOrigine() + " à " + this.getPrix() + " €";
    }
}
