package cegepst.engine;

import java.awt.*;

public class Game {
    private static final int SLEEP = 25;
    private long before;
    private RenderingEngine renderingEngine;
    private Ball ball;
    private Ball ball2;
    private boolean playing = true;
    private int score = 0;

    public Game() {
        renderingEngine = new RenderingEngine();
        ball = new Ball(25);
        ball2 = new Ball(50);
    }

    public void start() {
        renderingEngine.start();
        updateSyncTime();
        while (playing) {
            update();
            drawOnBuffer(renderingEngine.getRenderingBuffer());
            renderingEngine.renderBufferOnScreen();
            sleep();
        }
        renderingEngine.stop();
    }

    private void update() {
        ball.update();
        ball2.update();
        if (ball.hasTouchBound() || ball2.hasTouchBound()) {
            score += 10;
        }
    }

    private void drawOnBuffer(Graphics2D buffer) {
        ball.draw(buffer, Color.red);
        ball2.draw(buffer, Color.green);
        buffer.setPaint(Color.white);
        buffer.drawString("Score: " + score, 10, 20);
    }

    private void updateSyncTime() {
        before = System.currentTimeMillis();
    }

    private long getSleepTIme() {
        long sleep = SLEEP - (System.currentTimeMillis() - before);
        if (sleep < 0) {
            sleep = 4;
        }
        return sleep;
    }

    private void sleep() {
        try {
            Thread.sleep(getSleepTIme());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateSyncTime();
    }


}
