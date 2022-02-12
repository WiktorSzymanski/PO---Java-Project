package pl.vik.ui;

import javax.swing.*;
import java.awt.*;

public class AchievementsPanel extends JPanel {
    private final MainFrame mainFrame;

    AchievementsPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout());

        this.add(createMainMenuButton());
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.MAIN_MENU));
        return mainMenuButton;
    }
}