package pl.vik.gm.fight_maneger;

import pl.vik.gm.animals.Animal;

public class FightManeger {

    public Animal playerAnimal = null;
    public Animal enemyAnimal = null;

    private boolean isPlayerTurn = true;

    public Player player = null;
    public Enemy enemy = null;

    public static boolean playerWon;

    public FightManeger(Animal player, Animal enemy) {
        this.playerAnimal = player;
        this.enemyAnimal = enemy;

        this.player = new Player(this);
        this.enemy = new Enemy(this);

        //playerWon = fight();
        //System.out.println("Player Won: " + playerWon);

    }

    public static boolean returnFightResult(Animal player, Animal enemy) {
        new FightManeger(player, enemy);

        return playerWon;
    }

    public void dealDmg(int ammount) {
        if (isPlayerTurn) {
            enemy.currentHealth -= ammount;
        } else {
            player.currentHealth -= ammount;
        }
    }

    private boolean playerWinCondition() {
        if (this.enemy.currentHealth <= 0) {
            return true;
        }
        return false;
    }

    private boolean fight() {
        while (player.currentHealth > 0 && enemy.currentHealth > 0) {
            System.out.println("Player Health: " + player.currentHealth);
            System.out.println("Player Energy: " + player.currentEnergy);
            System.out.println("Enemy Health: " + enemy.currentHealth);
            System.out.println("Enemy Energy: " + enemy.currentEnergy);
            if (isPlayerTurn) {
                player.makeMove();
                isPlayerTurn = false;
                enemy.afterRoundRegen();
            } else {
                enemy.makeMove();
                isPlayerTurn = true;
                player.afterRoundRegen();
            }
        }

        return playerWinCondition();
    }
}
