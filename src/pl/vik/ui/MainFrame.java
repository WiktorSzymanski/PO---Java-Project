package pl.vik.ui;

import pl.vik.gm.GameData;
import pl.vik.gm.levels.Level;

import javax.swing.*;
import java.util.Map;

public class MainFrame extends JFrame {

    private static final String TITLE = "THE game";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private View currentView;

    private final Map<View, JPanel> views = Map.of(
            View.MAIN_MENU, new MainMenuPanel(this),
            View.GAME, new GamePanel(this),
            View.LOAD, new LoadPanel(this),
            View.SAVE, new SavePanel(this),
            View.LEVEL_SELECT, new LevelSelectPanel(this),
            View.ANIMAL_SELECT, new AnimalSelectPanel(this),
            View.ACHIEVEMENTS, new AchievementsPanel(this));

    public MainFrame() {
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.add(views.get(View.MAIN_MENU));
        currentView = View.MAIN_MENU;
    }

    public void openPanel(View viewToOpen) {
        this.remove(views.get(currentView));
        currentView = viewToOpen;
        this.add(views.get(currentView));
        this.refreshView();
    }

    public void openAnimalPanel(Integer levelId) {
        this.remove(views.get(currentView));

        AnimalSelectPanel animalPanel = (AnimalSelectPanel) views.get(View.ANIMAL_SELECT);
        animalPanel.setLevel(levelId);
        animalPanel.render();

        currentView = View.ANIMAL_SELECT;
        this.add(animalPanel);
        this.refreshView();
    }

    public void openAchievementsPanel() {
        this.remove(views.get(currentView));

        AchievementsPanel achievementsPanel = (AchievementsPanel) views.get(View.ACHIEVEMENTS);
        achievementsPanel.render();

        currentView = View.ACHIEVEMENTS;
        this.add(achievementsPanel);
        this.refreshView();
    }

    public void openLoadPanel() {
        this.remove(views.get(currentView));

        LoadPanel loadPanel = (LoadPanel) views.get(View.LOAD);
        loadPanel.render();

        currentView = View.LOAD;
        this.add(loadPanel);
        this.refreshView();
    }


    public void openGamePanel(Integer levelId, Integer playerAnimalId, Integer enemyAnimalId) {
        this.remove(views.get(currentView));

        GamePanel gamePanel = (GamePanel) views.get(View.GAME);
        gamePanel.setGameData(levelId, playerAnimalId, enemyAnimalId);
        gamePanel.render();

        currentView = View.GAME;
        this.add(gamePanel);
        this.refreshView();
    }

    private void refreshView() {
        revalidate();
        repaint();
    }
}
