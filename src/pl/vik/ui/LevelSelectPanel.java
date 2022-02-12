package pl.vik.ui;

import pl.vik.gm.GameData;
import pl.vik.gm.levels.Level;

import javax.swing.*;
import java.awt.*;

public class LevelSelectPanel extends JPanel {
    private final MainFrame mainFrame;

    private GameData gameData;

    private Integer selectedLevelId;

    LevelSelectPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.gameData = GameData.getInstance();

        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        setLayout(gridLayout);

        createAllLvButtons(this);
        add(new JLabel());
        add(createMainMenuButton());
    }

    private void createAllLvButtons(JPanel panel) {
        for (Integer i : gameData.data.levels.keySet()) {
            panel.add(createLevelButton(i,gameData.data.levels.get(i)));
        }
    }

    private JButton createLevelButton(Integer lvId, Level level) {
        JButton levelButton = new JButton(level.name);
        levelButton.addActionListener(e -> mainFrame.openAnimalPanel(lvId));
        return levelButton;
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Back");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.MAIN_MENU));
        return mainMenuButton;
    }
}
