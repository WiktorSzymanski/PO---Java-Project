package pl.vik.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MainMenuPanel extends JPanel {
    private final MainFrame mainFrame;

    private final Image background = new ImageIcon("img/menuBg.png").getImage();

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

//        container.add(new JLabel("THE game", JLabel.CENTER));
        container.add(createLevelSelectButton());
        container.add(createSaveButton());
        container.add(createLoadButton());
        container.add(createAchievementsButton());
        container.add(createExitButton());

        return container;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, this);
        g2D.setFont(new Font("Nunito", Font.BOLD, 30));
        g2D.setPaint(Color.white);
        g2D.drawString("THE game", 220,150);
    }
}
