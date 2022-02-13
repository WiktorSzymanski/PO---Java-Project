package pl.vik.ui;

import pl.vik.gm.save_load.LoadGame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class LoadPanel extends JPanel {
    private final MainFrame mainFrame;
    private final Image background = new ImageIcon("img/menuBg.png").getImage();

    LoadPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        GridLayout gridLayout = new GridLayout(3,3);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        this.setLayout(gridLayout);

    }

    public void render() {
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        this.add(buttonsContainer());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
    }

    private JButton createMainMenuButton() {
        JButton mainMenuButton = new JButton("Back");
        mainMenuButton.addActionListener(e -> {
            removeAll();
            mainFrame.openPanel(View.MAIN_MENU);
        });
        return mainMenuButton;
    }

    private void printAllSavesButtons(Container container) {
        HashMap<Integer,String> filesNames = LoadGame.getFilesMap();
        for (Integer i : filesNames.keySet()) {
            container.add(createLoadButton(filesNames.get(i)));
        }

        if (filesNames.isEmpty()) {
            container.add(new Label("There are no saves to load :<"));
        }
    }

    private JButton createLoadButton(String name) {
        JButton loadButton = new JButton(name);
        loadButton.addActionListener(e -> {
            LoadGame.load(name);
            removeAll();
            mainFrame.openPanel(View.MAIN_MENU);
        });

        return loadButton;
    }

    private Container buttonsContainer() {
        Container container = new Container();
        GridLayout gridLayout = new GridLayout(0,1);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        container.setLayout(gridLayout);

        JLabel label = new JLabel("Select save you want to load", JLabel.CENTER);
        label.setForeground(Color.white);
        container.add(label);
        printAllSavesButtons(container);
        container.add(new JLabel());
        container.add(createMainMenuButton());

        return container;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(background, 0, 0, this);
        g2D.setFont(new Font("Nunito", Font.BOLD, 30));
        g2D.setPaint(Color.white);
        g2D.drawString("Load game", 215,150);
    }
}
