package pl.vik.ui;

import pl.vik.gm.GameData;
import pl.vik.gm.animals.Animal;
import pl.vik.gm.animals.Skill;
import pl.vik.gm.fight_maneger.FightManeger;
import pl.vik.gm.fight_maneger.Player;
import pl.vik.gm.levels.Level;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final MainFrame mainFrame;

    private GameData gameData;

    private FightManeger fightManeger;
    private Level level;

    GamePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout(0,1));

        this.gameData = GameData.getInstance();
    }

    public void render() {
        add(new JLabel("Player : " + fightManeger.playerAnimal.name));
        add(new JLabel("Health : " + fightManeger.player.currentHealth));
        add(new JLabel("Energy : " + fightManeger.player.currentEnergy));

        add(new JLabel(" "));

        add(new JLabel("Enemy : " + fightManeger.enemyAnimal.name));
        add(new JLabel("Health : " + fightManeger.enemy.currentHealth));
        add(new JLabel("Energy : " + fightManeger.enemy.currentEnergy));



        add(createBackButton());
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
        this.fightManeger = new FightManeger(level.playableAnimals.get(playerAnimalId), level.possibleEnemies.get(enemyAnimalId));
    }

    private void createAllSkillsButtons() {
        for (Integer i : fightManeger.playerAnimal.skills.keySet()) {
            add(createSkillButton(fightManeger.playerAnimal.skills.get(i)));
        }
    }

    private JButton createSkillButton(Skill skill) {
        JButton skillButton = new JButton(skill.name);
        skillButton.addActionListener(e -> fightManeger.player.useSkill(skill));
        return skillButton;
    }
}
