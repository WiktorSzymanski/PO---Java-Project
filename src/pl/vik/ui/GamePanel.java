package pl.vik.ui;

import pl.vik.gm.GameData;
import pl.vik.gm.animals.Skill;
import pl.vik.gm.fight_maneger.FightManeger;
import pl.vik.gm.levels.Level;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final MainFrame mainFrame;

    private GameData gameData;

    private FightManeger fightManeger;
    private Level level;

    private JLabel playerHealth;
    private JLabel playerEnergy;

    private JLabel enemyHealth;
    private JLabel enemyEnergy;

    GamePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        this.setLayout(new GridLayout(0,1));

        this.gameData = GameData.getInstance();
    }

    public void render() {

        playerHealth = new JLabel("Health : " + fightManeger.player.currentHealth);
        playerEnergy = new JLabel("Energy : " + fightManeger.player.currentEnergy);

        enemyHealth = new JLabel("Health : " + fightManeger.enemy.currentHealth);
        enemyEnergy = new JLabel("Energy : " + fightManeger.enemy.currentEnergy);

        add(enemyContainer());
        add(playerContainer());
        add(buttonsContainer());

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
        this.level = gameData.data.levels.get(levelId);
        this.fightManeger = new FightManeger(this, level.playableAnimals.get(playerAnimalId), level.possibleEnemies.get(enemyAnimalId));
    }

    private void createAllSkillsButtons(Container container) {
        for (Integer i : fightManeger.playerAnimal.skills.keySet()) {
            container.add(createSkillButton(fightManeger.playerAnimal.skills.get(i)));
        }
    }

    private JButton createSkillButton(Skill skill) {
        JButton skillButton = new JButton(skill.name);
        skillButton.addActionListener(e -> {

            if (fightManeger.player.makeMove(skill)) {
                    fightManeger.playerTurn();
                    refreshPanel();

                if (fightManeger.ifEndGame()) {
                    return;
                }

                fightManeger.enemyTurn();
                refreshPanel();

                if (fightManeger.ifEndGame()) {
                    return;
                }
            }
        });
        return skillButton;
    }

    private void refreshPanel() {
        playerHealth.setText("Health : " + fightManeger.player.currentHealth);
        playerEnergy.setText("Energy : " + fightManeger.player.currentEnergy);
        enemyHealth.setText("Health : " + fightManeger.enemy.currentHealth);
        enemyEnergy.setText("Energy : " + fightManeger.enemy.currentEnergy);
    }

    public void endGame(boolean playerWon) {
        removeAll();
        if (playerWon) {
            gameData.achievementCheck(fightManeger.enemyAnimal.name);
            add(new JLabel("Player Won"));
        } else {
            add(new JLabel("Player Lost"));
        }
        add(createBackButton());
    }

    private Container enemyContainer() {
        Container container = new Container();
        container.setLayout(new GridLayout(1,2));

        container.add(statsContainer("Enemy",fightManeger.enemyAnimal.name, enemyHealth, enemyEnergy));
        container.add(new JLabel(fightManeger.enemyAnimal.image));

        return container;
    }

    private Container playerContainer() {
        Container container = new Container();
        container.setLayout(new GridLayout(1,2));

        container.add(new JLabel(fightManeger.playerAnimal.image));
        container.add(statsContainer("Player",fightManeger.playerAnimal.name, playerHealth, playerEnergy));

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

        createAllSkillsButtons(container);

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
        container.add(new JLabel(who + " : " + name));
        container.add(health);
        container.add(energy);

        return container;
    }
}
