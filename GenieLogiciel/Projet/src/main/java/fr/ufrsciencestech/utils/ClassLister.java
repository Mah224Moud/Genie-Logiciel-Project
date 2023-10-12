package fr.ufrsciencestech.utils;

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
public class ClassLister {

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

}
