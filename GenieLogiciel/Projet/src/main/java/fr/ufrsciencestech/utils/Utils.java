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

    /**
     * This method lists the names of all the classes in the specified package.
     * It uses the ClassLoader to get the path of the package, and then lists all
     * the files in that path that end with ".class".
     *
     * @param packageName The name of the package.
     * @return List<String> The names of all the classes in the specified package.
     * @throws ClassNotFoundException If the specified package cannot be located.
     * @throws IOException            If an I/O error occurs.
     */
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

    /**
     * This method creates an instance of a class that extends Fruit.
     * It throws an IllegalArgumentException if the specified class does not extend
     * Fruit.
     *
     * @param className The name of the class that extends Fruit.
     * @return Fruit An instance of the specified class.
     * @throws ClassNotFoundException If the specified class cannot be located.
     * @throws InstantiationException If this Class represents an abstract class, an
     *                                interface, an array class, a primitive type,
     *                                or void; or if the class has no nullary
     *                                constructor; or if the instantiation fails for
     *                                some other reason.
     * @throws IllegalAccessException If the class or its nullary constructor is not
     *                                accessible.
     */
    public static Fruit createFruit(String className)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> fruitClass = Class.forName(className);
        if (Fruit.class.isAssignableFrom(fruitClass)) {
            Fruit instance = (Fruit) fruitClass.newInstance();
            return instance;
        } else {
            throw new IllegalArgumentException("La classe spécifiée ne doit pas être une sous-classe de Fruit.");
        }
    }

    /**
     * This method creates an instance of a class that extends Fruit, and sets the
     * price and origin of the fruit.
     * It throws an IllegalArgumentException if the specified class does not extend
     * Fruit.
     *
     * @param className The name of the class that extends Fruit.
     * @param prix      The price of the fruit.
     * @param origine   The origin of the fruit.
     * @return Fruit An instance of the specified class, with the specified price
     *         and origin.
     * @throws ClassNotFoundException If the specified class cannot be located.
     * @throws InstantiationException If this Class represents an abstract class, an
     *                                interface, an array class, a primitive type,
     *                                or void; or if the class has no nullary
     *                                constructor; or if the instantiation fails for
     *                                some other reason.
     * @throws IllegalAccessException If the class or its nullary constructor is not
     *                                accessible.
     */
    public static Fruit createFruitWithParams(String className, double prix, String origine)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
