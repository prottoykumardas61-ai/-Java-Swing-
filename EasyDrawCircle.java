import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class EasyDrawCircle extends JFrame implements ActionListener {

    JButton drawBtn, clearBtn;
    JPanel panel;
    int x = -1, y = -1;   // circle position
    int r = 40;          // radius
    Random rand = new Random();

    EasyDrawCircle() {

        // Buttons
        drawBtn = new JButton("Draw Circle");
        clearBtn = new JButton("Clear");

        drawBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        // Top panel for buttons
        JPanel top = new JPanel();
        top.add(drawBtn);
        top.add(clearBtn);

        // Drawing panel
        panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (x != -1 && y != -1) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x, y, r, r);
                }
            }
        };

        // Frame setup
        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setTitle("Easy Draw Circle");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Button click handling
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == drawBtn) {
            x = rand.nextInt(panel.getWidth() - r);
            y = rand.nextInt(panel.getHeight() - r);
        }

        if (e.getSource() == clearBtn) {
            x = -1;
            y = -1;
        }

        panel.repaint();
    }

    public static void main(String[] args) {
        new EasyDrawCircle();
    }
}
