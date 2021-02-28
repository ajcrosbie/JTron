import javax.swing.*;

public class Game {
    static final int DELAY = 75;

    public static void main(String[] args) {
        gstart();
    }

    public static void gstart() {
        JFrame frame = new JFrame();
        Gpanel panel = new Gpanel();
        panel.gStart();
        frame.add(panel);
        frame.setTitle("tron");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        time(panel);
    }

    public static void time(Gpanel panel) {
        Timer timer = new Timer(DELAY, panel);
        timer.start();
    }
}
