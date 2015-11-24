package fatsoenlijkeversie;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Sikkel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage img = null;

    public static void main(String[] args) {
        new Sikkel();
    }


    public Sikkel() {
        JFrame frame = new JFrame();
        Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
        try {
            URL url = new URL("http://wwwhome.cs.utwente.nl/~sikkel/klaas200905.jpg");
            img = ImageIO.read(url);
        } catch (IOException e) {
        }
        frame.getContentPane().add(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(fullScreen);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
        g.drawImage(img, 0, 0, fullScreen.width, fullScreen.height, null);
    }
}
