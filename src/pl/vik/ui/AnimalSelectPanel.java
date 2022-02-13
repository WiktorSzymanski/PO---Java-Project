package pl.vik.ui;

import pl.vik.gm.GameData;
import pl.vik.gm.animals.Animal;
import pl.vik.gm.levels.Level;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AnimalSelectPanel extends JPanel {
    private final MainFrame mainFrame;
    private GameData gameData;
    private Level level;

    private final Image background = new ImageIcon("img/menuBg.png").getImage();

    private int levelId;
    private int playerAnimalId;
    private int enemyAnimalId;

    AnimalSelectPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.gameData = GameData.getInstance();

        GridLayout gridLayout = new GridLayout(3,3);
        this.setLayout(gridLayout);
    }

    public void render() {
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

    private void createAllAnimalsButtons(Container container) {
        for (Integer i : level.playableAnimals.keySet()) {
            container.add(createAnimalButton(i,level.playableAnimals.get(i)));
        }
    }

    private JButton createAnimalButton(Integer animalId, Animal animal) {
        JButton animalButton = new JButton(animal.name);
        animalButton.addActionListener(e -> {
            playerAnimalId = animalId;
            enemyAnimalId = randomPick(level);
            mainFrame.openGamePanel(levelId, playerAnimalId, enemyAnimalId);
        });
        return animalButton;
    }

    private  JButton createBackButton() {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            removeAll();
            mainFrame.openPanel(View.LEVEL_SELECT);
        });
        return backButton;
    }

    public void setLevel(Integer levelId) {
        this.levelId = levelId;
        this.level = gameData.data.levels.get(levelId);
    }

    private Integer randomPick(Level level) {
        Random random = new Random();

        int randomNum = random.nextInt(level.possibleEnemies.size()) + 1;

        return randomNum;
    }

    private Container buttonsContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        container.setLayout(gridLayout);

        createAllAnimalsButtons(container);
        container.add(new JLabel());
        container.add(createBackButton());

        return container;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, this);
        g2D.setFont(new Font("Nunito", Font.BOLD, 30));
        g2D.setPaint(Color.white);
        g2D.drawString("Select Your Animal", 160,150);
    }
}

