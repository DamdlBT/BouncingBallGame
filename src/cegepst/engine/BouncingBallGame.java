package cegepst.engine;

import java.awt.*;

public class BouncingBallGame extends Game{

    private Ball ball;
    private Ball ball2;
    private int score = 0;

    public BouncingBallGame() {
        ball = new Ball(25);
        ball2 = new Ball(50);
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
        if (ball.hasTouchBound() || ball2.hasTouchBound()) {
            score += 10;
        }
    }

    @Override
    public void draw(Buffer buffer) {
        ball.draw(buffer, Color.RED);
        ball2.draw(buffer, Color.GREEN);
        buffer.drawText(10, 20, "Score: " + score, Color.white);
    }
}
