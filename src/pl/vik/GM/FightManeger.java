package pl.vik.GM;

public class FightManeger {

    public Animal playerAnimal = null;
    public Animal enemyAnimal = null;

    private boolean isPlayerTurn = true;

    private Player player = null;
    private Enemy enemy = null;

    public FightManeger(Animal player, Animal enemy) {
        this.playerAnimal = player;
        this.enemyAnimal = enemy;

        this.player = new Player(this);
    }

    public void dealDmg(int ammount) {
        if (isPlayerTurn) {
            enemy.currentHealth -= ammount;
        } else {
            player.currentHealth -= ammount;
        }
    }
}
