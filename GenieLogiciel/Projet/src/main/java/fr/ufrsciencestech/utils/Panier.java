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

    /**
     * Constructor for the Panier class with specified maximum capacity.
     * It creates a Panier object with an empty list of fruits and the given maximum
     * capacity.
     * It also initializes an empty list of origins.
     *
     * @param contenanceMax The maximum capacity of the Panier.
     * @return An instance of the Panier class.
     */
    public Panier(int contenanceMax) {
        this.fruits = new ArrayList<Fruit>();
        this.contenanceMax = contenanceMax;
        this.origines = new ArrayList<>();
    }

    /**
     * This method returns a string representation of the Panier object.
     * The string representation includes the list of fruits in the Panier.
     * For each type of fruit in the Panier, it includes the name of the fruit and
     * the number of that fruit in the Panier.
     *
     * @return String The string representation of the Panier object.
     */
    public String toString() {
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
            res.append(" sur " + this.getContenanceMax() + " avec une valeur total de ").append(this.getPrix())
                    .append("€");

        } else {
            res.append("\nLe panier ne contient aucun fruit il est complètement vide !!!");
        }

        return res.toString();
    }

    /**
     * This method gets the list of fruits in the Panier.
     *
     * @return ArrayList<Fruit> The list of fruits in the Panier.
     */
    public ArrayList<Fruit> getFruits() {
        return this.fruits;
    }

    /**
     * This method sets the list of fruits in the Panier.
     *
     * @param fruits The new list of fruits in the Panier.
     * @return void
     */
    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    /**
     * This method gets the current size of the Panier.
     * It returns the number of fruits in the Panier.
     *
     * @return int The current size of the Panier.
     */
    public int getTaillePanier() {
        return this.fruits.size();
    }

    /**
     * This method gets the maximum capacity of the Panier.
     *
     * @return int The maximum capacity of the Panier.
     */
    public int getContenanceMax() {
        return this.contenanceMax;
    }

    /**
     * This method sets the maximum capacity of the Panier.
     *
     * @param contenanceMax The new maximum capacity of the Panier.
     * @return void
     */
    public void setContenanceMax(int contenanceMax) {
        this.contenanceMax = contenanceMax;
    }

    /**
     * This method gets the fruit at the specified index in the Panier.
     * If the index is out of range (index < 0 or index >= size of the Panier), it
     * returns null.
     *
     * @param i The index of the fruit to get.
     * @return Fruit The fruit at the specified index in the Panier, or null if the
     *         index is out of range.
     */
    public Fruit getFruit(int i) {
        if (i >= 0 && i < fruits.size()) {
            return fruits.get(i);
        }
        return null;
    }

    /**
     * This method adds a fruit to the Panier.
     * If the Panier is full, it throws a PanierPleinException.
     *
     * @param o The fruit to add to the Panier.
     * @throws PanierPleinException If the Panier is full.
     * @return void
     */
    public void ajout(Fruit o) throws PanierPleinException {
        if (fruits.size() < contenanceMax) {
            fruits.add(o);
        } else {
            throw new PanierPleinException();
        }
    }

    /**
     * This method sets the fruit at the specified index in the Panier.
     * If there is no fruit at the specified index, it does nothing.
     *
     * @param i The index of the fruit to set.
     * @param f The new fruit to set at the specified index in the Panier.
     * @return void
     */
    public void setFruit(int i, Fruit f) {
        if (i >= 0 && i < fruits.size() && fruits.get(i) != null) {
            fruits.set(i, f);
        }
    }

    /**
     * This method checks if the Panier is empty.
     *
     * @return boolean Whether the Panier is empty.
     */
    public boolean estVide() {
        return this.fruits.isEmpty();
    }

    /**
     * This method checks if the Panier is full.
     *
     * @return boolean Whether the Panier is full.
     */
    public boolean estPlein() {
        return this.fruits.size() == contenanceMax;
    }

    /**
     * This method removes the last fruit in the Panier.
     * If the Panier is empty, it throws a PanierVideException.
     *
     * @throws PanierVideException If the Panier is empty.
     * @return void
     */
    public void retrait() throws PanierVideException {
        if (!fruits.isEmpty()) {
            fruits.remove(fruits.size() - 1);
        } else {
            throw new PanierVideException();
        }
    }

    /**
     * This method calculates the total price of the Panier.
     * It adds up the prices of all the fruits in the Panier.
     *
     * @return double The total price of the Panier.
     */
    public double getPrix() {
        double prixTotal = 0.0;
        for (Fruit fruit : this.fruits) {
            prixTotal += fruit.getPrix();
        }

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        String formattedPrix = df.format(prixTotal);

        return Double.parseDouble(formattedPrix);
    }

    /**
     * This method removes all the fruits in the Panier that come from the specified
     * origin.
     * It iterates over the list of fruits in the Panier, and if a fruit comes from
     * the specified origin, it removes that fruit.
     *
     * @param origine The origin of the fruits to remove from the Panier.
     * @return void
     */
    public void boycotteOrigine(String origine) {
        for (int i = fruits.size() - 1; i >= 0; --i) {
            if (fruits.get(i).getOrigine().equals(origine)) {
                fruits.remove(i);
            }
        }
    }

    /**
     * This method checks if the Panier is equal to another object.
     * It checks if the other object is not null, is an instance of the Panier
     * class, and contains exactly the same fruits as the Panier.
     *
     * @param o The object to be compared with the Panier.
     * @return boolean Whether the Panier is equal to the other object.
     */
    @Override
    public boolean equals(Object o) {
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

    /**
     * This method removes all the fruits in the Panier and clears the list of
     * origins.
     * If the Panier is already empty, it returns a message indicating that the
     * Panier is already empty.
     * Otherwise, it clears the list of fruits and the list of origins in the
     * Panier, and returns a message indicating that the Panier has been completely
     * emptied.
     *
     * @return String A message indicating whether the Panier was already empty or
     *         has been completely emptied.
     */
    public String clearAll() {
        if (this.estVide()) {
            return "Le panier est dèjà vide !!!";
        } else {
            this.fruits.clear();
            this.origines.clear();
            return "Le panier a été complètement vidé.";
        }
    }

    /**
     * This method retrieves the list of origins of the fruits in the Basket.
     * It creates a new list of origins, adds the origin of each fruit in the Basket
     * to the list, and then returns a new list without duplicates.
     *
     * @return List<String> The list of unique origins of the fruits in the Basket.
     */
    public List<String> getOriginesSansDoublons() {
        List<String> originesDoublons = new ArrayList<>();

        for (Fruit fruit : this.getFruits()) {
            originesDoublons.add(fruit.getOrigine());
        }

        HashSet<String> originesSansDoublons = new HashSet<>(originesDoublons);

        return new ArrayList<>(originesSansDoublons);
    }

    /**
     * This method gets the list of unique origins of the fruits in the Panier.
     * It assigns the list of unique origins to the list of origins in the Panier,
     * and then returns the list of origins in the Panier.
     *
     * @return List<String> The list of unique origins of the fruits in the Panier.
     */
    public List<String> getOrigines() {
        return this.origines = getOriginesSansDoublons();
    }

}
