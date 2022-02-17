package pl.vik.gm.fight_manager;

import pl.vik.gm.animals.Animal;
import pl.vik.ui.GamePanel;

public class FightManager {
    private final GamePanel gamePanel;

    private Animal playerAnimal = null;
    private Animal enemyAnimal = null;

    private boolean isPlayerTurn = true;

    private Player player = null;
    private Enemy enemy = null;

    private boolean gameEnded = false;

    public FightManager(GamePanel gamePanel, Animal player, Animal enemy) {
        this.gamePanel = gamePanel;

        this.setPlayerAnimal(player);
        this.setEnemyAnimal(enemy);

        this.setPlayer(new Player(this));
        this.setEnemy(new Enemy(this));


//        playerWon = fight();
//        System.out.println("Player Won: " + playerWon);

    }

    public void dealDmg(int amount) {
        if (isPlayerTurn) {
            getEnemy().setCurrentHealth(getEnemy().getCurrentHealth() - amount);
        } else {
            getPlayer().setCurrentHealth(getPlayer().getCurrentHealth() - amount);
        }
    }

    private boolean playerWinCondition() {
        if (this.getEnemy().getCurrentHealth() <= 0) {
            System.out.println(this.getEnemy().getCurrentHealth());
            return true;
        }
        System.out.println(this.getEnemy().getCurrentHealth());
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
        getEnemy().afterRoundRegen();
    }

    public void enemyTurn() {
        getEnemy().enemyAI();
        isPlayerTurn = true;
        getPlayer().afterRoundRegen();
    }

    public boolean ifEndGame() {
        if (getPlayer().getCurrentHealth() <= 0 || getEnemy().getCurrentHealth() <= 0) {
            setGameEnded(true);
            gamePanel.endGame(playerWinCondition());
            return true;
        }

        return false;
    }

    public Animal getPlayerAnimal() {
        return playerAnimal;
    }

    public void setPlayerAnimal(Animal playerAnimal) {
        this.playerAnimal = playerAnimal;
    }

    public Animal getEnemyAnimal() {
        return enemyAnimal;
    }

    public void setEnemyAnimal(Animal enemyAnimal) {
        this.enemyAnimal = enemyAnimal;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }
}
