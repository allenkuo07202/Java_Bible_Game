import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    public static final int CELL = 50;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int ROW = HEIGHT / CELL;
    public static final int COLUMN = WIDTH / CELL;


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {

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
