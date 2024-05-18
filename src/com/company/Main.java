package com.company;

import com.company.GameView.DisasterView;
import com.company.GameView.GameView;
import com.company.Sprite.Moses;
import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    public static final int CELL = 50;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int ROW = HEIGHT / CELL;
    public static final int COLUMN = WIDTH / CELL;

    Moses moses;
    public static GameView gameView;

    public Main(){
        moses = new Moses(1,1);
        gameView = new DisasterView();
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        gameView.drawView(g);
        moses.draw(g);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Bible Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main()); // 將paintComponent內，所畫的東西，設定在window裡面
        window.pack();

        window.setLocationRelativeTo(null); // 將視窗放在中間

        window.setVisible(true);
        window.setResizable(false); // 設定為false，使用者就無法調整大小
    }
}
