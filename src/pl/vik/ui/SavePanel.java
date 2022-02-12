package pl.vik.ui;

import pl.vik.gm.save_load.EmptyLabelException;
import pl.vik.gm.save_load.NoSpacesInNameAllowed;
import pl.vik.gm.save_load.SaveGame;
import pl.vik.gm.save_load.Validators;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SavePanel extends JPanel {
    private final MainFrame mainFrame;

    private JTextField textField = new JTextField();

    SavePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout(2,1));

        add(saveContainer());
        add(buttonsContainer());

    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.MAIN_MENU));
        return mainMenuButton;
    }

    private JButton createSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            SaveGame.saveGame(getFileName());
            mainFrame.openPanel(View.MAIN_MENU);
        });
        return saveButton;
    }

    private String getFileName(){
        String fileName;

        try {
            fileName = Validators.getFileNameFromKeyboard(textField.getText());
        } catch (EmptyLabelException | NoSpacesInNameAllowed e) {
            System.out.println(e.toString());
            fileName = getFileName();
        }
        return fileName;
    }

    private Container saveContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        container.setLayout(gridLayout);
        container.add(new JLabel("Save file name:"));
        container.add(textField);

        return container;
    }

    private Container buttonsContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(1,2);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        container.setLayout(gridLayout);

        container.add(createSaveButton());
        container.add(createMainMenuButton());

        return container;
    }
}
