package fr.ufrsciencestech.controller;

import fr.ufrsciencestech.model.Modele;
import fr.ufrsciencestech.view.VueG;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controleur implements ActionListener {
    private Modele m;
    private VueG vg;
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        
        String clicks = ((Component)e.getSource()).getName();
        
        switch (clicks) {
            case "plus":
                m.update(1);
                break;
            case "moins":
                m.update(-1);
                break;
            case "reset":
                m.reset();
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Attention cette action n'est pas valide");
                
        }
    }
    
    public void setModele(Modele m){
        this.m = m;
    }
    public void setVue(VueG vg){
        this.vg = vg;
    }
}
