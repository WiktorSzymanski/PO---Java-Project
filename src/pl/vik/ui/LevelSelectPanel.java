package pl.vik.ui;

import pl.vik.gm.GameData;
import pl.vik.gm.levels.Level;

import javax.swing.*;

public class LevelSelectPanel extends JPanel {
    private final MainFrame mainFrame;

    private GameData gameData;

    private Integer selectedLevelId;

    LevelSelectPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.gameData = GameData.getInstance();

        createAllLvButtons(this);
        this.add(createMainMenuButton());
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
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> mainFrame.openPanel(View.MAIN_MENU));
        return mainMenuButton;
    }
}
