import java.awt.event.KeyEvent;

public class Snake {
    char dir;
    int x;
    int y;

    Snake() {
        dir = 'R';
        x = 0;
        y = 0;
    }

    public void imMove(KeyEvent imp) {
        switch (imp.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                dir = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                dir = 'R';
                break;
            case KeyEvent.VK_DOWN:
                dir = 'D';
                break;
            case KeyEvent.VK_UP:
                dir = 'U';
                break;

        }
    }

    public void move() {
        switch (dir) {
            case 'L':
                x = x - 1;
                break;
            case 'R':
                x = x + 1;
                break;
            case 'U':
                y = y - 1;
                break;
            case 'D':
                y = y + 1;
                break;
        }
    }
}