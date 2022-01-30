package pl.vik.UI;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    private final MainFrame mainFrame;

    MainMenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout());

        this.add(createLoadButton());
        this.add(createGameButton());
    }

    private JButton createLoadButton() {
        JButton mainMenuButton = new JButton("Load");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.LOAD));
        return mainMenuButton;
    }

    private JButton createGameButton() {
        JButton mainMenuButton = new JButton("Game");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.GAME));
        return mainMenuButton;
    }
}
