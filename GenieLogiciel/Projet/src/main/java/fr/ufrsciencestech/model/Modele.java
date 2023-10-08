/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.model;

//import java.util.Observable;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Mamoudou
 */
public class Modele {//extends Observable{
    private int compteur;   //compteur toujours positif
    
    PropertyChangeSupport pcs = new  PropertyChangeSupport(this);
	
    public void addObserver(PropertyChangeListener l) {
	pcs.addPropertyChangeListener("value", l);
    }
    
    public Modele(){
        compteur = 0;
    }
    public void update(int incr) {
        int old = this.compteur;
        compteur += incr;
        if(compteur < 0)
            compteur = 0;
        
        pcs.firePropertyChange("value", old, this.compteur);
        //setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        //notifyObservers(getCompteur());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
    }
    
    public void reset(){
        int old = getCompteur();
        setCompteur(0);
        pcs.firePropertyChange("value", old, getCompteur());
    }

    /**
     * @return the compteur
     */
    public int getCompteur() {
        return compteur;
    }

    /**
     * @param compteur the compteur to set
     */
    public void setCompteur(int compteur) {
        int old = this.compteur;
        this.compteur = compteur;
        if(this.compteur < 0)
            this.compteur = 0;
        
        pcs.firePropertyChange("value", old, this.compteur);
        //setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        //notifyObservers(getCompteur());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
    }
    
}