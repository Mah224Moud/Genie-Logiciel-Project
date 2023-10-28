package fr.ufrsciencestech.utils;

import fr.ufrsciencestech.panier.Fruit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author mamoudou
 */
public class Utils {

    public static List<String> listClassNamesInPackage(String packageName) {
        List<String> classNames = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                String resourcePath = resource.getFile();
                File directory = new File(resourcePath);
                File[] files = directory.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.getName().endsWith(".class")) {
                            String simpleClassName = file.getName().substring(0, file.getName().length() - 6);
                            classNames.add(simpleClassName);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classNames;
    }

    public static Fruit createFruit(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return createFruitWithParams(className, 0.0, null);
    }

    public static Fruit createFruitWithParams(String className, double prix, String origine) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> fruitClass = Class.forName(className);
        if (Fruit.class.isAssignableFrom(fruitClass)) {
            Fruit instance = (Fruit) fruitClass.newInstance();
            instance.setPrix(prix);
            instance.setOrigine(origine);
            return instance;
        } else {
            throw new IllegalArgumentException("La classe spécifiée ne doit pas être une sous-classe de Fruit.");
        }
    }

}
