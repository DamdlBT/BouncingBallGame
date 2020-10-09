package cegepst.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderingEngine {
    private JPanel panel;
    private JFrame frame;
    private BufferedImage bufferedImage;

    public RenderingEngine() {
        initializeFrame();
        initializePanel();
    }

    public void start() {
        frame.setVisible(true);
    }

    public void stop() {
        frame.setVisible(false);
        frame.dispose();
    }


    public Graphics2D getRenderingBuffer() {
        bufferedImage = new BufferedImage(800,600,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setRenderingHints(getOptimalRenderingHints());
        return graphics;
    }

    public void renderBufferOnScreen() {
        Graphics2D graphics2D = (Graphics2D) panel.getGraphics();
        graphics2D.drawImage(bufferedImage, 0, 0, panel);
        Toolkit.getDefaultToolkit().sync();
        graphics2D.dispose();
    }

    private void initializePanel() {
        panel = new JPanel();
        panel.setBackground(Color.blue);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        frame.add(panel);
    }

    private void initializeFrame() {
        frame = new JFrame();
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Bouncing Ball BouncingBallGame");
        //setUndecorated(true);  Enlever la bar en haut de la page
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private RenderingHints getOptimalRenderingHints() {
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        return rh;
    }
}
