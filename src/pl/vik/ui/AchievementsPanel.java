package pl.vik.ui;

import pl.vik.gm.Achievement;
import pl.vik.gm.Achievements;
import pl.vik.gm.GameData;

import javax.swing.*;
import java.awt.*;

public class AchievementsPanel extends JPanel {
    private final MainFrame mainFrame;

    private GameData gameData;

    AchievementsPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout(0,1));

        this.gameData = GameData.getInstance();
    }

    public void render() {
        add(createAchievementsPanel());
        add(createMainMenuButton());
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> {
            removeAll();
            mainFrame.openPanel(View.MAIN_MENU);
        });

        return mainMenuButton;
    }

    private void printAllAchievements(Container panel) {
        for (Achievement achievement : gameData.data.achievements) {
            panel.add(new JLabel(achievement.image));
            panel.add(new JLabel(achievement.name));
            if (achievement.completed) {
                panel.add(new JLabel("Completed"));
            } else {
                panel.add(new JLabel("Uncompleted"));
            }
        }
        new Achievements();
    }

    private Container createAchievementsPanel() {
        Container achievementContainer = new Container();
        achievementContainer.setLayout(new GridLayout(0,3));
        printAllAchievements(achievementContainer);

        return achievementContainer;
    }
}