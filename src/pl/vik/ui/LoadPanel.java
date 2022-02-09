package pl.vik.ui;

import javax.swing.*;
import java.awt.*;

public class LoadPanel extends JPanel {
    private final MainFrame mainFrame;

    LoadPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout());

        this.add(createMainMenuButton());
        this.add(createGameButton());
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.MAIN_MENU));
        return mainMenuButton;
    }

    private JButton createGameButton() {
        JButton mainMenuButton = new JButton("Game");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.GAME));
        return mainMenuButton;
    }
}
