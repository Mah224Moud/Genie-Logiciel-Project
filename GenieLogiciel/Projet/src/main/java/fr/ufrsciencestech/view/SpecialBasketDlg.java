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
 * @author mamoudou
 */
public class SpecialBasketDlg extends JDialog implements VueG {

    private JPanel top;
    private JPanel center;
    private JPanel centerLeft;
    private JPanel centerRight;
    private JPanel centerNorth;
    private JPanel centerSouth;
    private JPanel bottom;

    private JLabel choiceText;
    private JLabel northText;
    private JLabel info;

    private JComboBox choice;

    private String selectedChoice;

    private JButton pic;
    private JButton create;

    private JTextArea panier;

    private List<JRadioButton> radioButtons;
    List<JCheckBox> checkboxButtons;

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

    public void initChoice() {
        choice.addItem("Jus de fruit simple");
        choice.addItem("Jus multifruit");
        choice.addItem("Macédoine");
    }

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

    public void choiceType(List<String> fruits, String type) {
        if (type.equals("Jus de fruit simple")) {
            radioBox(fruits);
        } else {
            checkBox(fruits);
        }

        revalidate();
        repaint();
    }

    public String getChoice() {
        return this.selectedChoice;
    }

    public String getSelectedFruitFromRadio() {
        for (JRadioButton radio : radioButtons) {
            if (radio.isSelected()) {
                return radio.getText();
            }
        }
        return null;
    }

    public List<String> getSelectedFruitsFromCheckbox() {
        List<String> selectedFruits = new ArrayList<>();
        for (JCheckBox checkbox : checkboxButtons) {
            if (checkbox.isSelected()) {
                selectedFruits.add(checkbox.getText());
            }
        }
        return selectedFruits;
    }

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
}
