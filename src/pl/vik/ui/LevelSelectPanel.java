package pl.vik.ui;

import pl.vik.gm.GameData;
import pl.vik.gm.levels.Level;

import javax.swing.*;
import java.awt.*;

public class LevelSelectPanel extends JPanel {
    private final MainFrame mainFrame;

    private final Image background = new ImageIcon("img/menuBg.png").getImage();

    private GameData gameData;

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
        for (Integer i : gameData.getData().levels.keySet()) {
            container.add(createLevelButton(i, gameData.getData().levels.get(i)));
        }
    }

    private JButton createLevelButton(Integer lvId, Level level) {
        JButton levelButton = new JButton(level.getName());
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

        createAllLvButtons(container);
        container.add(new JLabel());
        container.add(createMainMenuButton());

        return container;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, this);
        g2D.setFont(new Font("Nunito", Font.BOLD, 30));
        g2D.setPaint(Color.white);
        g2D.drawString("Select level", 210,150);
    }
}
