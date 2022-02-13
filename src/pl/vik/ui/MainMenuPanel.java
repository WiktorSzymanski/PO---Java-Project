package pl.vik.ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private final MainFrame mainFrame;

    MainMenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        GridLayout gridLayout = new GridLayout(0,3);
        this.setLayout(gridLayout);

        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        this.add(buttonsContainer());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
    }

    private JButton createLoadButton() {
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(e -> mainFrame.openLoadPanel());
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
        achievementsButton.addActionListener(e -> mainFrame.openAchievementsPanel());
        return achievementsButton;
    }

    private JButton createExitButton() {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> mainFrame.dispose());
        return exitButton;
    }

    private Container buttonsContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        container.setLayout(gridLayout);

        container.add(new JLabel("THE game", JLabel.CENTER));
        container.add(createLevelSelectButton());
        container.add(createSaveButton());
        container.add(createLoadButton());
        container.add(createAchievementsButton());
        container.add(createExitButton());

        return container;
    }
}
