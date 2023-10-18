/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author mamoudou
 */
public class Mangue extends SimpleFruit {
    public Mangue() {
        this(1.5, "Honduras");
    }

    public Mangue(double prix, String origine) {
        super(prix, origine);
    }

    @Override
    public String toString() {
        return "Mangue du " + getOrigine() + " à " + getPrix() + " €";
    }
}
