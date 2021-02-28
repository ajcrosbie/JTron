import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gpanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT_SIZE;
    public static boolean running = true;
    Snake snake;
    ArrayList<Wall> walls;

    Gpanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g, walls, snake);
    }

    public static void draw(Graphics g, ArrayList<Wall> walls, Snake snake) {
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        g.setColor(Color.RED);
        g.fillRect(snake.x * UNIT_SIZE, snake.y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);

        for (int i = 0; i < walls.size(); i++) {
            g.setColor(new Color(45, 180, 0));
            g.fillRect(walls.get(i).x * UNIT_SIZE, walls.get(i).y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
        }
    }

    public void gStart() {
        snake = new Snake();
        walls = new ArrayList<Wall>();
    }

    public void collisions() {
        for (int i = 0; i < walls.size(); i++) {
            if (walls.get(i).x == snake.x & walls.get(i).y == snake.y) {
                running = false;
            }
        }
        if (snake.x < 0) {
            running = false;
        }
        if (snake.y < 0) {
            running = false;
        }
        if (snake.y > SCREEN_HEIGHT / UNIT_SIZE) {
            running = false;
        }
        if (snake.x > SCREEN_WIDTH / UNIT_SIZE)
            running = false;
    }

    public void reset() {

        snake = new Snake();
        walls = new ArrayList<Wall>();
        running = true;
    }

    public void actionPerformed(ActionEvent e) {
        if (running) {
            walls.add(new Wall(snake.x, snake.y));
            snake.move();
            collisions();
        } else {
            reset();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            snake.imMove(e);
        }
    }
}
