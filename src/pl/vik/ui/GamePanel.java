package pl.vik.ui;

import pl.vik.gm.GameData;
import pl.vik.gm.animals.Skill;
import pl.vik.gm.fight_manager.FightManager;
import pl.vik.gm.levels.Level;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final MainFrame mainFrame;
    private final Image background = new ImageIcon("img/menuBg.png").getImage();
    private GameData gameData;

    private FightManager fightManager;
    private Level level;

    private JLabel playerHealth;
    private JLabel playerEnergy;

    private JLabel enemyHealth;
    private JLabel enemyEnergy;

    private static JLabel noEnergyLabel = new JLabel("",JLabel.CENTER);

    GamePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        this.gameData = GameData.getInstance();

        this.noEnergyLabel.setForeground(Color.red);
    }

    public void render() {
        this.setLayout(new GridLayout(0,1));
        playerHealth = new JLabel("Health : " + fightManager.getPlayer().getCurrentHealth());
        playerEnergy = new JLabel("Energy : " + fightManager.getPlayer().getCurrentEnergy());

        enemyHealth = new JLabel("Health : " + fightManager.getEnemy().getCurrentHealth());
        enemyEnergy = new JLabel("Energy : " + fightManager.getEnemy().getCurrentEnergy());

        playerHealth.setForeground(Color.white);
        playerEnergy.setForeground(Color.white);
        enemyHealth.setForeground(Color.white);
        enemyEnergy.setForeground(Color.white);

        add(allContainers());

    }

    private  JButton createBackButton() {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            removeAll();
            mainFrame.openPanel(View.ANIMAL_SELECT);
        });
        return backButton;
    }

    public void setGameData(Integer levelId, Integer playerAnimalId, Integer enemyAnimalId) {
        this.level = gameData.getData().levels.get(levelId);
        this.fightManager = new FightManager(this, level.getPlayableAnimals().get(playerAnimalId), level.getPossibleEnemies().get(enemyAnimalId));
    }

    private void createAllSkillsButtons(Container container) {
        for (Integer i : fightManager.getPlayerAnimal().getSkills().keySet()) {
            container.add(createSkillButton(fightManager.getPlayerAnimal().getSkills().get(i)));
        }
    }

    private JButton createSkillButton(Skill skill) {
        JButton skillButton = new JButton(skill.name);
        skillButton.addActionListener(e -> {

            if (fightManager.getPlayer().makeMove(skill)) {
                    fightManager.playerTurn();
                    noEnergyLabel.setText("");
                    refreshPanel();

                if (fightManager.ifEndGame()) {
                    return;
                }

                fightManager.enemyTurn();
                refreshPanel();

                if (fightManager.ifEndGame()) {
                    return;
                }
            }
        });
        return skillButton;
    }

    private void refreshPanel() {
        playerHealth.setText("Health : " + fightManager.getPlayer().getCurrentHealth());
        playerEnergy.setText("Energy : " + fightManager.getPlayer().getCurrentEnergy());
        enemyHealth.setText("Health : " + fightManager.getEnemy().getCurrentHealth());
        enemyEnergy.setText("Energy : " + fightManager.getEnemy().getCurrentEnergy());
    }

    public void endGame(boolean playerWon) {
        removeAll();
        setLayout(new GridLayout(3,3));
        Container container = new Container();
        container.setLayout(new GridLayout(0,1));
        JLabel label = new JLabel("",JLabel.CENTER);
        label.setForeground(Color.white);
        if (playerWon) {
            gameData.achievementCheck(fightManager.getEnemyAnimal().getName());
            label.setText("Player Won");
        } else {
            label.setText("Player Lost");
        }
        container.add(label);
        container.add(new JLabel());
        JButton button = createBackButton();
        button.setText("Continue");
        container.add(button);

        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(container);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
    }

    private Container enemyContainer() {
        Container container = new Container();
        container.setLayout(new GridLayout(1,2));

        container.add(statsContainer("Enemy", fightManager.getEnemyAnimal().getName(), enemyHealth, enemyEnergy));
        container.add(new JLabel(fightManager.getEnemyAnimal().getImage()));

        return container;
    }

    private Container playerContainer() {
        Container container = new Container();
        container.setLayout(new GridLayout(1,2));

        container.add(new JLabel(fightManager.getPlayerAnimal().getImage()));
        container.add(statsContainer("Player", fightManager.getPlayerAnimal().getName(), playerHealth, playerEnergy));

        return container;
    }

    private Container buttonsContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(1, 2);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        container.setLayout(gridLayout);

        container.add(skillsButtonsContainer());
        container.add(backNlog());

        return container;
    }

    private Container skillsButtonsContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(0, 1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        container.setLayout(gridLayout);

        container.add(noEnergyLabel);
        createAllSkillsButtons(container);
        container.add(new JLabel());

        return container;
    }

    private Container backNlog() {
        Container container = new Container();
        container.setLayout(new GridLayout(0,1));

        container.add(createBackButton());

        return container;
    }

    private Container statsContainer(String who, String name, JLabel health, JLabel energy) {
        Container container = new Container();
        container.setLayout(new GridLayout(0,1));
        JLabel label = new JLabel(who + " : " + name);
        label.setForeground(Color.white);
        container.add(label);
        container.add(health);
        container.add(energy);

        return container;
    }

    private Container allContainers() {
        Container container = new Container();

        BoxLayout boxLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(boxLayout);

        container.add(enemyContainer());
        container.add(playerContainer());
        container.add(buttonsContainer());

        return container;
    }

    public static void printNoEnergyAlert(String alert) {
        noEnergyLabel.setText(alert);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, this);
    }
}
