package com.company;

import com.company.GameView.DisasterView;
import com.company.GameView.GameView;
import com.company.Sprite.Moses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {

    public static final int CELL = 50;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int ROW = HEIGHT / CELL;
    public static final int COLUMN = WIDTH / CELL;

    Moses moses;
    public static GameView gameView;
    private int level;

    public Main() {
        resetGame(new DisasterView());

        addKeyListener(this);
    }

    public void resetGame(GameView game){
        level = 1;
        moses = new Moses(1,1);
        gameView = game;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        gameView.drawView(g);
        moses.draw(g);
        requestFocusInWindow();
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point mosesPoint = moses.getRelativePosition();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (mosesPoint.y > 1) {
                    String result = moses.overlap(mosesPoint.x, mosesPoint.y - 1);
                    if (result.equals("Die")) {
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.y -= 1;
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if (mosesPoint.y < ROW) {
                    String result = moses.overlap(mosesPoint.x, mosesPoint.y + 1);
                    if (result.equals("Die")) {
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.y += 1;
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (mosesPoint.x < COLUMN) {
                    String result = moses.overlap(mosesPoint.x + 1, mosesPoint.y);
                    if (result.equals("Die")) {
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.x += 1;
                    }

                }
                break;
            case KeyEvent.VK_LEFT:
                if (mosesPoint.x > 1) {
                    String result = moses.overlap(mosesPoint.x - 1, mosesPoint.y);
                    if (result.equals("Die")) {
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.x -= 1;
                    }

                }
                break;
        }
        moses.setPosition(mosesPoint);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
