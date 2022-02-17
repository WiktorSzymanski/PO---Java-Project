package pl.vik.gm;

public class Achievements {
    GameData gameData = GameData.getInstance();

    public Achievements() {
        for (Achievement achievement : gameData.getData().achievements) {
            System.out.println(achievement.getName() + " : " + achievement.isCompleted());
        }
    }
}
