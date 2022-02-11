package pl.vik.gm;

public class Achievements {
    GameData gameData = GameData.getInstance();

    public Achievements() {
        for (String name : gameData.data.achievements.keySet()) {
            System.out.println("Win against " + name + " : " + gameData.data.achievements.get(name));
        }
    }
}
