package pl.vik.gm;

public class Achievements {
    GameData gameData = GameData.getInstance();

    public Achievements() {
        for (Achievement achievement : gameData.data.achievements) {
            System.out.println(achievement.name + " : " + achievement.completed);
        }
    }
}
