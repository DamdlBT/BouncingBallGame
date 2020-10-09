package cegepst.engine;

import java.awt.*;
import java.util.Random;

public class Ball {

    private int radius;
    private int x;
    private int y;
    private int velocityX;
    private int velocityY;

    public Ball(int radius) {
        this.radius = radius;

        x = getRandom(radius * 2, 800 - radius * 2);
        y = getRandom(radius * 2, 600 - radius * 2);
        velocityX = getRandom(0, 1) == 0 ? 3: -3;
        velocityY = getRandom(0, 1) == 0 ? 3 : -3;
    }

    public void update() {
        x += velocityX;
        y += velocityY;
        if (hasTouchVerticalBound()) {
            velocityY *= -1;
        }
        if (hasTouchHorizontalBound()) {
            velocityX *= -1;
        }
    }

    public void draw(Buffer buffer, Color color) {
        buffer.drawCircle(x, y, radius, color);
    }

    public boolean hasTouchBound() {
        return hasTouchHorizontalBound() || hasTouchVerticalBound();
    }

    public int getRadius() {
        return radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    private boolean hasTouchHorizontalBound() {
        return x <= radius || x >= 800 - radius;
    }

    private boolean hasTouchVerticalBound() {
        return y <= radius || y >= 600 -radius;
    }

    private int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
