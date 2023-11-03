/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package fr.ufrsciencestech.utils;
import fr.ufrsciencestech.panier.Fruit;
import org.junit.Test;
import java.util.List;
/**
 *
 * @author cristanemir
 */
public class UtilsTest {
    @Test
    public void testListClassNamesInPackage() {
        String packageName = "fr.ufrsciencestech.panier";
        List<String> classNames = Utils.listClassNamesInPackage(packageName);
        assert !classNames.isEmpty();
    }

    @Test
    public void testCreateFruit() {
        String className = "fr.ufrsciencestech.panier.Orange";
        try {
            Fruit fruit = Utils.createFruit(className);
            assert fruit instanceof Fruit;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateFruitWithParams() {
        String className = "fr.ufrsciencestech.panier.Apple"; 
        double prix = 2.0;
        String origine = "France"; 
        try {
            Fruit fruit = Utils.createFruitWithParams(className, prix, origine);
            assert fruit instanceof Fruit;
            assert fruit.getPrix() == prix;
            assert fruit.getOrigine().equals(origine);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
}
