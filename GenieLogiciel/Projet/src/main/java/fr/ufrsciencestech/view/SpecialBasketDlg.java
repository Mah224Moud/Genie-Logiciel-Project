package fr.ufrsciencestech.view;

import fr.ufrsciencestech.controller.Controleur;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author cristan
 */
public final class SpecialBasketDlg extends JDialog implements VueG {

    private JPanel top;
    private JPanel center;
    private JPanel centerLeft;
    private JPanel centerRight;
    private JPanel centerNorth;
    JPanel centerSouth;
    private JPanel bottom;

    private JLabel choiceText;
    private JLabel northText;
    private JLabel info;

    JComboBox choice;

    private String selectedChoice;

    JButton pic;
    JButton create;

    JTextArea panier;

    List<JRadioButton> radioButtons;
    List<JCheckBox> checkboxButtons;
        /**
     * This is the constructor for the SpecialBasketDlg class.
     * It sets up the dialog, initializes the components, and adds ActionListeners
     * to the choice JComboBox and the create JButton.
     *
     * @param parent The parent JFrame of this dialog.
     * @param modal  Specifies whether dialog blocks user input to other top-level
     *               windows when shown.
     * @param fruits The list of fruits to be added to the choice JComboBox.
     */
    public SpecialBasketDlg(JFrame parent, boolean modal, final List<String> fruits) {
        super(parent, modal);

        instanciation();
        initComponent(fruits.size());
        initVariablesNames();
        vueSpecs();
        initChoice();

        selectedChoice = choice.getSelectedItem().toString();
        choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedChoice = choice.getSelectedItem().toString();
                if (selectedChoice != null) {
                    choiceType(fruits, selectedChoice);
                    panier.setText("");
                    info.setText("");
                }
            }
        });

        choiceType(fruits, selectedChoice);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = getChoice();
                if ("Jus de fruit simple".equals(choice)) {
                    String selectedFruit = getSelectedFruitFromRadio();
                    if (selectedFruit != null) {
                        panier.setText("\n\n\n\nVous venez préparer un jus de: " + selectedFruit);
                        updatePicIcon("Jus "+selectedFruit);
                        info.setText("");
                    } else {
                        info.setText("Aucun fruit n'est sélectionné.");
                    }
                } else {
                    List<String> selectedFruits = getSelectedFruitsFromCheckbox();
                    if (!selectedFruits.isEmpty()) {
                        if (choice.equals("Jus multifruit")) {
                            updatePicIcon("Jus multifruit");
                            panier.setText("\n\n\n\nVous venez préparer un jus multifruit composé de:\n " + selectedFruits);
                            info.setText("");
                        } else {
                            panier.setText("\n\n\n\nVous venez préparer une macédoine composé de:\n" + selectedFruits);
                            updatePicIcon("Macedoine");
                            info.setText("");
                        }

                    } else {
                        info.setText("Aucun fruit n'est sélectionné.");
                    }
                }
            }
        });

    }
     /**
     * This method instantiates the components used in the dialog.
     * It creates the panels, labels, combo box, buttons, and text area.
     * 
     * @return void
     */
    private void instanciation() {
        top = new JPanel();
        center = new JPanel();
        centerLeft = new JPanel();
        centerRight = new JPanel();
        centerSouth = new JPanel();
        centerNorth = new JPanel();
        bottom = new JPanel();

        choiceText = new JLabel("Quel type de panier souhaitez-vous faire ?", JLabel.CENTER);
        info = new JLabel("", JLabel.CENTER);
        northText = new JLabel("Faites votre choix dans la liste ci-dessous", JLabel.CENTER);
        choice = new JComboBox();

        radioButtons = new ArrayList<>();
        checkboxButtons = new ArrayList<>();

        pic = new JButton();
        create = new JButton("Préparer");

        panier = new JTextArea();
    }
        /**
     * This method initializes the components used in the dialog.
     * It sets up the layout, size, and other properties of the components based on
     * the size of the list.
     *
     * @param listeSize The size of the list of fruits.
     * @return void
     */
    private void initComponent(int listeSize) {
        choice.setModel(new DefaultComboBoxModel<>());

        top.setLayout(new java.awt.GridLayout(1, 2));

        top.add(choiceText);
        top.add(choice);

        center.setLayout(new java.awt.GridLayout(1, 2));
        center.add(centerLeft);
        center.add(centerRight);

        centerRight.setLayout(new java.awt.GridLayout(2, 1));
        centerRight.add(pic);
        centerRight.add(panier);

        centerLeft.setLayout(new java.awt.GridLayout(3, 1));

        centerLeft.add(new JPanel());
        centerLeft.add(centerNorth);
        centerLeft.add(centerSouth);

        centerNorth.add(northText);
        centerSouth.setLayout(new java.awt.GridLayout((int) (listeSize / 2), listeSize));

        bottom.setLayout((new java.awt.GridLayout(1, 2)));
        bottom.add(create);
        bottom.add(info);
        panier.setEditable(false);

        this.add(top, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);

    }

    private void initVariablesNames() {
    }
    
    /**
     * This method sets the specifications for the dialog view.
     * It sets the minimum size, title, and location of the dialog.
     *
     * @return void
     */
    private void vueSpecs() {
        this.setMinimumSize(new Dimension(700, 500));
        this.setTitle("Créer un panier particulier");
        this.setLocation(100, 50);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void addControleur(Controleur c) {
    }
        /**
     * This method initializes the choice JComboBox.
     * It adds the items to the choice JComboBox.
     *
     * @return void
     */
    void initChoice() {
        choice.addItem("Jus de fruit simple");
        choice.addItem("Jus multifruit");
        choice.addItem("Macédoine");
    }
        /**
     * This method creates a group of radio buttons for the list of fruits.
     * It removes all existing components from the centerSouth panel and clears the
     * radioButtons list.
     * Then it creates a new radio button for each fruit in the list, adds it to the
     * group and the centerSouth panel, and adds an ItemListener to it.
     * The ItemListener updates the info label and the icon when a radio button is
     * selected.
     *
     * @param fruits The list of fruits for which to create radio buttons.
     * @return void
     */
    public void radioBox(List<String> fruits) {
        centerSouth.removeAll();
        radioButtons.clear();

        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < fruits.size(); i++) {
            JRadioButton radio = new JRadioButton(fruits.get(i).toString());
            group.add(radio);
            centerSouth.add(radio);

            radio.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        JRadioButton selectedRadio = (JRadioButton) e.getItem();
                        String selectedFruit = selectedRadio.getText();
                        info.setText(selectedFruit + " sélectionné");
                        updatePicIcon(selectedFruit);
                        panier.setText("");
                    }
                }
            });

            radioButtons.add(radio);
        }
    }
        /**
     * This method creates a group of checkboxes for the list of fruits.
     * It removes all existing components from the centerSouth panel and clears the
     * checkboxButtons list.
     * Then it creates a new checkbox for each fruit in the list, adds it to the
     * centerSouth panel, and adds an ItemListener to it.
     * The ItemListener updates the info label and the icon when a checkbox is
     * selected.
     *
     * @param fruits The list of fruits for which to create checkboxes.
     * @return void
     */
    public void checkBox(List<String> fruits) {
        centerSouth.removeAll();
        checkboxButtons.clear();
        for (int i = 0; i < fruits.size(); i++) {
            JCheckBox checkbox = new JCheckBox(fruits.get(i).toString());
            centerSouth.add(checkbox);

            checkbox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        JCheckBox selectedCheckBox = (JCheckBox) e.getItem();
                        String selectedFruit = selectedCheckBox.getText();
                        info.setText(selectedFruit + " sélectionné");
                        updatePicIcon(selectedFruit);
                        panier.setText("");
                    }
                }
            });

            checkboxButtons.add(checkbox);
        }

    }
        /**
     * This method determines the type of selection to be used based on the type
     * parameter.
     * If the type is "Single fruit juice", it calls the radioBox method to create
     * radio buttons for the fruits.
     * Otherwise, it calls the checkBox method to create checkboxes for the fruits.
     * It then revalidates and repaints the dialog.
     *
     * @param fruits The list of fruits for which to create selection components.
     * @param type   The type of selection to be used.
     * @return void
     */
    void choiceType(List<String> fruits, String type) {
        if (type.equals("Jus de fruit simple")) {
            radioBox(fruits);
        } else {
            checkBox(fruits);
        }

        revalidate();
        repaint();
    }
        /**
     * This method returns the currently selected choice.
     *
     * @return String The currently selected choice.
     */
    public String getChoice() {
        return this.selectedChoice;
    }
    /**
     * This method returns the text of the selected radio button from the
     * radioButtons list.
     * It iterates over the radioButtons list and returns the text of the first
     * radio button it finds that is selected.
     * If no radio button is selected, it returns null.
     *
     * @return String The text of the selected radio button, or null if no radio
     *         button is selected.
     */
    public String getSelectedFruitFromRadio() {
        for (JRadioButton radio : radioButtons) {
            if (radio.isSelected()) {
                return radio.getText();
            }
        }
        return null;
    }
     /**
     * This method returns a list of the texts of the selected checkboxes from the
     * checkboxButtons list.
     * It creates a new list, then iterates over the checkboxButtons list and adds
     * the text of each checkbox that is selected to the new list.
     * It then returns the new list.
     *
     * @return List<String> The list of the texts of the selected checkboxes.
     */
    public List<String> getSelectedFruitsFromCheckbox() {
        List<String> selectedFruits = new ArrayList<>();
        for (JCheckBox checkbox : checkboxButtons) {
            if (checkbox.isSelected()) {
                selectedFruits.add(checkbox.getText());
            }
        }
        return selectedFruits;
    }
     /**
     * This method updates the icon of the pic JButton based on the selected fruit.
     * It creates a path to the image file based on the selected fruit, then creates
     * an ImageIcon from that file.
     * It gets the original image from the ImageIcon, then resizes it to the size of
     * the pic JButton.
     * It then sets the icon of the pic JButton to the resized image.
     * If the selected fruit is null, it does nothing.
     *
     * @param selectedFruit The fruit based on which to update the pic icon.
     * @return void
     */
    public void updatePicIcon(String selectedFruit) {
    if (selectedFruit != null) {
        String imagePath = "/ufr/sciencestech/assets/" + selectedFruit + ".jpg";
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagePath));
        Image originalImage = ((ImageIcon) originalIcon).getImage();


        int width = pic.getWidth();
        int height = pic.getHeight();


        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);


        Icon icon = new ImageIcon(resizedImage);
        pic.setIcon(icon);
    }
}

    Object getRadioButtons() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public JPanel getCenterSouth() {
    return centerSouth;
}

}