/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.main;

import fr.ufrsciencestech.controller.Controleur;
import fr.ufrsciencestech.model.*;
import fr.ufrsciencestech.view.VueG;
import fr.ufrsciencestech.view.VueGraphSwing;
/**
 *
 * @author Mamoudou
 */
public class Main {
    private VueG vueg;      //pour pouvoir changer de vue si on le souhaite
    private Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite
    
    /**
     * @return the vueg
     */
    public VueG getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueG vueg) {
        this.vueg = vueg;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
    
    
    public Main(){
        //sans utiliser SpringIoC :
        vueg = new VueGraphSwing();
        controleur = new Controleur();
        Modele modele = new Modele();

        controleur.setModele(modele);                 
        modele.addObserver(vueg);       
        vueg.addControleur(controleur);
    }
    
    public static void main(String[] args){
        Main test = new Main();
        
    }
}
