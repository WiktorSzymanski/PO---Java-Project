package pl.vik.ui;

import javax.swing.*;
import java.awt.*;

public class SavePanel extends JPanel {
    private final MainFrame mainFrame;

    SavePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout(2,1));

        this.add(createMainMenuButton());
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.MAIN_MENU));
        return mainMenuButton;
    }
}
