package fr.ufrsciencestech.utils;

import fr.ufrsciencestech.panier.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

/**
 *
 * @author roudet
 */
public class Panier {

    private ArrayList<Fruit> fruits; // attribut pour stocker les fruits
    private int contenanceMax; // nb maximum d'oranges que peut contenir le panier
    private List<String> origines; // pour stocker les origines

    // groupe 1
    public Panier(int contenanceMax) { // initialise un panier vide ayant une certaine contenance maximale (precisee en
        // parametre)
        this.fruits = new ArrayList<Fruit>();
        this.contenanceMax = contenanceMax;
        this.origines = new ArrayList<>();
    }

    public String toString() { // affichage de ce qui est contenu dans le panier : liste des fruits presents
        Map<String, Integer> fruitCount = new HashMap<>();
        StringBuilder res = new StringBuilder("Contenu du panier : \n\n");

        if (this.getTaillePanier() > 0) {
            for (Fruit fruit : fruits) {
                String fruitName = fruit.toString(); // Obtient le résultat de toString du fruit
                fruitCount.put(fruitName, fruitCount.getOrDefault(fruitName, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : fruitCount.entrySet()) {
                String fruitName = entry.getKey();
                int quantity = entry.getValue();

                res.append(quantity).append(" x ").append(fruitName).append("\n");
            }

            if (this.getTaillePanier() > 1) {
                res.append("\nLe panier contient " + this.getTaillePanier() + " fruits");
            } else {
                res.append("\nLe panier contient " + this.getTaillePanier() + " fruit");
            }
            res.append(" sur "+this.getContenanceMax()+" avec une valeur total de ").append(this.getPrix()).append("€");

        } else {
            res.append("\nLe panier ne contient aucun fruit il est complètement vide !!!");
        }

        return res.toString();
    }

    // groupe 2
    public ArrayList<Fruit> getFruits() { // accesseur du premier attribut
        return this.fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { // modificateur du premier attribut
        this.fruits = fruits;
    }

    public int getTaillePanier() { // accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size();
    }

    public int getContenanceMax() { // accesseur du second attribut
        return this.contenanceMax;
    }

    // groupe 3
    public Fruit getFruit(int i) { // accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou
        // null s'il n'y a rien a cet emplacement
        if (i >= 0 && i < fruits.size()) {
            return fruits.get(i);
        }
        return null;
    }

    // groupe 4
    public void ajout(Fruit o) throws PanierPleinException { // ajoute le fruit o a la fin du panier si celui-ci n'est
        // pas plein
        if (fruits.size() < contenanceMax) {
            fruits.add(o);
        } else {
            throw new PanierPleinException();
        }
    }

    public void setFruit(int i, Fruit f) { // modificateur du fruit contenu dans le panier a l'emplacement n°i par f
        // (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        if (i >= 0 && i < fruits.size() && fruits.get(i) != null) {
            fruits.set(i, f);
        }
    }

    public boolean estVide() { // predicat indiquant que le panier est vide
        return this.fruits.isEmpty();
    }

    public boolean estPlein() { // predicat indiquant que le panier est plein
        return this.fruits.size() == contenanceMax;
    }

    // groupe 5
    public void retrait() throws PanierVideException { // retire le dernier fruit du panier si celui-ci n'est pas vide
        if (!fruits.isEmpty()) {
            fruits.remove(fruits.size() - 1);
        } else {
            throw new PanierVideException();
        }
    }

    public double getPrix() { // calcule le prix du panier par addition des prix de tous les fruits contenus
        // dedans
        double prixTotal = 0.0;
        for (Fruit fruit : this.fruits) {
            prixTotal += fruit.getPrix();
        }

        // Utiliser DecimalFormat avec la locale "en-US" pour formater le résultat
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        String formattedPrix = df.format(prixTotal);

        // Convertir la chaîne formatée en double
        return Double.parseDouble(formattedPrix);
    }

    // groupe 7
    public void boycotteOrigine(String origine) { // supprime du panier tous les fruits provenant du pays origine
        for (int i = fruits.size() - 1; i >= 0; --i) {
            if (fruits.get(i).getOrigine().equals(origine)) {
                fruits.remove(i);
            }
        }
    }

    // groupe 8    
    @Override
    public boolean equals(Object o) {/// predicat pour tester si 2 paniers sont equivalents : s'ils contiennent
        /// exactement les memes fruits
        if (o != null && o instanceof Panier) {
            Panier or = (Panier) o;
            if (getTaillePanier() == or.getTaillePanier()) {
                for (int i = 0; i < getTaillePanier(); i++) {
                    Fruit f1 = getFruit(i);
                    Fruit f2 = or.getFruit(i);
                    if (f1 == null || f2 == null || !f1.equals(f2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String clearAll() {
        if (this.estVide()) {
            return "Le panier est dèjà vide !!!";
        } else {
            this.fruits.clear();
            this.origines.clear();
            return "Le panier a été complètement vidé.";
        }
    }

    public List<String> getOriginesSansDoublons() {
        List<String> originesDoublons = new ArrayList<>();

        for (Fruit fruit : this.getFruits()) {
            originesDoublons.add(fruit.getOrigine());
        }

        HashSet<String> originesSansDoublons = new HashSet<>(originesDoublons);

        return new ArrayList<>(originesSansDoublons);
    }

    public List<String> getOrigines() {
        return this.origines = getOriginesSansDoublons();
    }

}
