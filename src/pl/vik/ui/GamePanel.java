package pl.vik.ui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final MainFrame mainFrame;

    GamePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout(2,1));

        this.add(createMainMenuButton());
        this.add(createLoadButton());
    }

    private JButton createLoadButton() {
        JButton mainMenuButton = new JButton("Load");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.LOAD));
        return mainMenuButton;
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.MAIN_MENU));
        return mainMenuButton;
    }
}
