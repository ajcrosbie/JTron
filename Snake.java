import java.awt.event.KeyEvent;

import javax.swing.event.*;

public class Snake {
    char dir;
    int x;
    int y;

    Snake() {
        dir = 'L';
        x = 0;
        y = 0;
    }

    public void imMove(KeyEvent imp) {

        switch (imp.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                dir = 'L';
            case KeyEvent.VK_RIGHT:
                dir = 'R';
            case KeyEvent.VK_DOWN:
                dir = 'D';
            case KeyEvent.VK_UP:
                dir = 'U';

        }
    }

    public void move() {
        switch (dir) {
            case 'L':
                x = x + 1;
            case 'R':
                x = x - 1;
            case 'U':
                y = y + 1;
            case 'D':
                y = y - 1;
        }
    }
}