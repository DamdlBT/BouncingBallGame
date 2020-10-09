package cegepst.engine;

import java.awt.*;

public class Buffer {

    private Graphics2D graphics;

    public Buffer(Graphics2D graphics) {
        this.graphics = graphics;
    }

    public void drawRectangle(int x, int y, int width, int height, Paint paint) {
        graphics.setPaint(paint);
        graphics.fillRect(x, y, width, height);
    }

    public void drawCircle(int x, int y, int radius, Paint paint) {
        graphics.setPaint(paint);
        graphics.fillOval(x, y, radius * 2, radius * 2);
    }

    public void drawText(int x, int y, String text, Paint paint) {
        graphics.setPaint(paint);
        graphics.drawString(text, x, y);
    }
}
