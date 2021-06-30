package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bidTimer {

    private bidTimer() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());
        jFrame.add(new timerPane());
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new bidTimer();
    }
}

class timerPane extends JPanel {
    private JLabel jLabel;
    private int count;

    timerPane() {
        jLabel = new JLabel("...");
        this.setLayout(new GridBagLayout());
        this.add(jLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count <= 10) {
                    jLabel.setText(Integer.toString(count));
                } else {
                    ((Timer) (e.getSource())).stop();
                }
            }
        });

        timer.setInitialDelay(0);
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}