import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class Game {
    public static Snake snake = new Snake();
    public static ArrayList<Wall> walls = new ArrayList<Wall>();
    public static boolean running = true;

    public static void main(String[] args) {
        gloop();
    }

    public static void gloop() {
        JFrame frame = new JFrame();
        Gpanel panel = new Gpanel();
        frame.add(panel);
        frame.setTitle("tron");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        while (running) {
            walls.add(new Wall(snake.x, snake.y));
            snake.move();
            panel.
        }
    }

    public static void Smove(KeyEvent imp) {
        snake.imMove(imp);
    }
}
