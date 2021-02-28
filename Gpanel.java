import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Gpanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT_SIZE;

    Gpanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }

    public void paintComponent(Graphics g, ArrayList<Wall> walls, Snake snake) {
        super.paintComponent(g);
        draw(g, walls, snake);
    }

    public static void draw(Graphics g, ArrayList<Wall> walls, Snake snake) {
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        g.setColor(Color.RED);
        g.fillRect(snake.x, snake.y, UNIT_SIZE, UNIT_SIZE);

        for (int i = 0; i < walls.size(); i++) {
            g.setColor(new Color(45, 180, 0));
            g.fillRect(walls.get(i).x * UNIT_SIZE, walls.get(i).y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            Game.Smove(e);
        }
    }
}
