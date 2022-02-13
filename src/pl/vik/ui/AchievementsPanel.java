package pl.vik.ui;

import pl.vik.gm.Achievement;
import pl.vik.gm.Achievements;
import pl.vik.gm.GameData;

import javax.swing.*;
import java.awt.*;

public class AchievementsPanel extends JPanel {
    private final MainFrame mainFrame;

    private final Image background = new ImageIcon("img/menuBg.png").getImage();

    private GameData gameData;

    AchievementsPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        BorderLayout borderLayout = new BorderLayout();

        this.setLayout(borderLayout);
        this.gameData = GameData.getInstance();
    }

    public void render() {
        add(achievementsScrollPlane());
        add(createMainMenuButton(),BorderLayout.SOUTH);
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(200, 100 ,100 ,30);
        mainMenuButton.addActionListener(e -> {
            removeAll();
            mainFrame.openPanel(View.MAIN_MENU);
        });

        return mainMenuButton;
    }

    private void printAllAchievements(Container container) {
        for (Achievement achievement : gameData.data.achievements) {
            container.add(achievementContainer(achievement.image, achievement.name, achievement.completed));
        }
    }

    private Container achievementContainer(ImageIcon imageIcon, String name, Boolean completed) {
        Container container = new Container();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        container.add(new JLabel(imageIcon));
        JLabel nameLabel = new JLabel(name);
        nameLabel.setForeground(Color.white);
        container.add(nameLabel);
        JLabel completedLabel;
        if (completed) {
            completedLabel = new JLabel("Completed");
        } else {
            completedLabel = new JLabel("Uncompleted");
        }
        completedLabel.setForeground(Color.white);
        container.add(completedLabel);

        return container;
    }

    private Container achievementsScrollPlane() {
        Container container = new Container();
        container.setLayout(new GridLayout(0,3));
        printAllAchievements(container);

        return container;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, this);
        g2D.setFont(new Font("Nunito", Font.BOLD, 30));
        g2D.setPaint(Color.white);
//        g2D.drawString("THE game", 220,150);
    }
}