package pl.vik.ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private final MainFrame mainFrame;

    MainMenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout(0,1));

        this.add(new JLabel("THE game"));
        this.add(createLevelSelectButton());
        this.add(createSaveButton());
        this.add(createLoadButton());
        this.add(createAchievementsButton());
        this.add(createExitButton());
    }

    private JButton createLoadButton() {
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(e -> mainFrame.openPanel(View.LOAD));
        return loadButton;
    }

    private JButton createLevelSelectButton() {
        JButton levelSelectButton = new JButton("Play");
        levelSelectButton.addActionListener(e -> mainFrame.openPanel(View.LEVEL_SELECT));
        return levelSelectButton;
    }

    private JButton createSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> mainFrame.openPanel(View.SAVE));
        return saveButton;
    }

    private JButton createAchievementsButton() {
        JButton achievementsButton = new JButton("Achievements");
        achievementsButton.addActionListener(e -> mainFrame.openPanel(View.ACHIEVEMENTS));
        return achievementsButton;
    }

    private JButton createExitButton() {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> mainFrame.dispose());
        return exitButton;
    }
}
