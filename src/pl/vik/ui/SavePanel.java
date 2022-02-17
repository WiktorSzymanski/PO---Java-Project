package pl.vik.ui;

import pl.vik.gm.exceptions.EmptyLabelException;
import pl.vik.gm.exceptions.NoSpacesInNameAllowed;
import pl.vik.gm.save_load.SaveGame;
import pl.vik.gm.exceptions.Validators;

import javax.swing.*;
import java.awt.*;

public class SavePanel extends JPanel {
    private final MainFrame mainFrame;

    private final Image background = new ImageIcon("img/menuBg.png").getImage();
    private JTextField textField = new JTextField();

    private JLabel exceptionLavel = new JLabel("",JLabel.CENTER);

    SavePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout(3,3));

        exceptionLavel.setForeground(Color.red);


        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(allContainers());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Back");
        mainMenuButton.addActionListener(e -> {
            exceptionLavel.setText("");
            textField.setText("");
            mainFrame.openPanel(View.MAIN_MENU);
        });
        return mainMenuButton;
    }

    private JButton createSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                SaveGame.saveGame(Validators.getFileNameFromKeyboard(textField.getText()));
                exceptionLavel.setText("");
                textField.setText("");
                mainFrame.openPanel(View.MAIN_MENU);
            } catch (EmptyLabelException | NoSpacesInNameAllowed ex) {
                exceptionLavel.setText(ex.toString());
            }

        });
        return saveButton;
    }

    private Container saveContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        container.setLayout(gridLayout);
        JLabel label = new JLabel("Name your save file", JLabel.CENTER);
        label.setForeground(Color.white);
        container.add(label);
        container.add(textField);

        return container;
    }

    private Container buttonsContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(2,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        container.setLayout(gridLayout);

        container.add(exceptionLavel);

        Container miniContainer = new Container();
        GridLayout miniGridLayout = new GridLayout(1,2);
        miniContainer.setLayout(miniGridLayout);
        miniContainer.add(createSaveButton());
        miniContainer.add(createMainMenuButton());

        container.add(miniContainer);

        return container;
    }

    private Container allContainers() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        container.setLayout(gridLayout);

        container.add(saveContainer());
        container.add(buttonsContainer());

        return container;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, this);
        g2D.setFont(new Font("Nunito", Font.BOLD, 30));
        g2D.setPaint(Color.white);
        g2D.drawString("Save game", 220,150);
    }
}
