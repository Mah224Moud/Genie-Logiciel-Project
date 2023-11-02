/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.utils;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

/**
 *
 * @author cristanemir
 */
public class UtilsTest {
    
   @Test
    public void testListClassNamesInPackage() {
        String packageName = "fr.ufrsciencestech.panier"; // Modifiez pour correspondre à votre structure de packages

        //la méthode qu'on veut tester
        List<String> classNames = ClassLister.listClassNamesInPackage(packageName);
        assertNotNull(classNames);
        assertTrue(classNames.contains("Mangue"));
        assertTrue(classNames.contains("SimpleFruit"));
    }
}
