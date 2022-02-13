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

        GridLayout gridLayout = new GridLayout(0,3);
        setLayout(gridLayout);

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

    private void createAllLvButtons(Container container) {
        for (Integer i : gameData.data.levels.keySet()) {
            container.add(createLevelButton(i,gameData.data.levels.get(i)));
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

    private Container buttonsContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        container.setLayout(gridLayout);

        container.add(new JLabel("Select level", JLabel.CENTER));
        createAllLvButtons(container);
        container.add(new JLabel());
        container.add(createMainMenuButton());

        return container;
    }


}
