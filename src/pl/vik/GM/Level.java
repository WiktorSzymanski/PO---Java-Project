package pl.vik.GM;

public class Level {
    String name;
    Animal player;
    Animal enemy;
    String bg;
    String planes;


    Level(String name,Animal player, Animal enemy, String bg, String planes) {
        this.name = name;
        this.player = player;
        this.enemy = enemy;
        this.bg = bg;
        this.planes = planes;
    }

    public void endGameCondition() {
        if (player.health <= 0) {
            System.out.println("You Lost");
        } else if (enemy.health <= 0) {
            System.out.println("You Won");
        }
    }
}
