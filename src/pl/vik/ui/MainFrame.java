package pl.vik.ui;

import javax.swing.*;
import java.util.Map;

public class MainFrame extends JFrame {

    private static final String TITLE = "Name";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    private View currentView;

    private final Map<View, JPanel> views = Map.of(
            View.MAIN_MENU, new MainMenuPanel(this),
            View.GAME, new GamePanel(this),
            View.LOAD, new LoadPanel(this));

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

    private void refreshView() {
        revalidate();
        repaint();
    }
}
