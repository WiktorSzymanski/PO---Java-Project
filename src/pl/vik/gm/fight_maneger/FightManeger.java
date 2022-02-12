package pl.vik.gm.fight_maneger;

import pl.vik.gm.animals.Animal;
import pl.vik.ui.GamePanel;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class FightManeger {
    private final GamePanel gamePanel;

    public Animal playerAnimal = null;
    public Animal enemyAnimal = null;

    private boolean isPlayerTurn = true;

    public Player player = null;
    public Enemy enemy = null;

    public boolean gameEnded = false;

    public FightManeger(GamePanel gamePanel, Animal player, Animal enemy) {
        this.gamePanel = gamePanel;

        this.playerAnimal = player;
        this.enemyAnimal = enemy;

        this.player = new Player(this);
        this.enemy = new Enemy(this);


//        playerWon = fight();
//        System.out.println("Player Won: " + playerWon);

    }

    public void dealDmg(int amount) {
        if (isPlayerTurn) {
            enemy.currentHealth -= amount;
        } else {
            player.currentHealth -= amount;
        }
    }

    private boolean playerWinCondition() {
        if (this.enemy.currentHealth <= 0) {
            System.out.println(this.enemy.currentHealth);
            return true;
        }
        System.out.println(this.enemy.currentHealth);
        return false;
    }

//    private boolean fight() {
//        while (player.currentHealth > 0 && enemy.currentHealth > 0) {
//            System.out.println("Player Health: " + player.currentHealth);
//            System.out.println("Player Energy: " + player.currentEnergy);
//            System.out.println("Enemy Health: " + enemy.currentHealth);
//            System.out.println("Enemy Energy: " + enemy.currentEnergy);
//            if (isPlayerTurn) {
//                player.makeMove();
//                isPlayerTurn = false;
//                enemy.afterRoundRegen();
//            } else {
//                enemy.makeMove();
//                isPlayerTurn = true;
//                player.afterRoundRegen();
//            }
//        }
//
//        return playerWinCondition();
//    }

    public void playerTurn() {
        isPlayerTurn = false;
        enemy.afterRoundRegen();
    }

    public void enemyTurn() {
        enemy.enemyAI();
        isPlayerTurn = true;
        player.afterRoundRegen();
    }

    public boolean ifEndGame() {
        if (player.currentHealth <= 0 || enemy.currentHealth <= 0) {
            gameEnded = true;
            gamePanel.endGame(playerWinCondition());
            return true;
        }

        return false;
    }
}
