package cegepst.engine;

import java.awt.*;

public class BouncingBallGame extends Game{

    private Ball ball;
    private Ball ball2;
    private Ball ball3;
    private Ball ball4;
    private int score = 0;

    public BouncingBallGame() {
        ball = new Ball(25);
        ball2 = new Ball(50);
        ball3 = new Ball(10);
        ball4 = new Ball(40);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }

    @Override
    public void update() {
        ball.update();
        ball2.update();
        ball3.update();
        ball4.update();
        if (ball.hasTouchBound() || ball2.hasTouchBound() || ball3.hasTouchBound() || ball4.hasTouchBound()) {
            score += 10;
        }
    }

    @Override
    public void draw(Buffer buffer) {
        ball.draw(buffer, Color.RED);
        ball2.draw(buffer, Color.GREEN);
        ball3.draw(buffer, Color.blue);
        ball4.draw(buffer, Color.MAGENTA);
        buffer.drawText(10, 20, "Score: " + score, Color.white);
        buffer.drawText(10,40, "FPS: " + GameTime.getCurrentFps(), Color.white);
        buffer.drawText(10,60,"Time: " + GameTime.getElapsedFormattedTime(), Color.white);
    }
}
