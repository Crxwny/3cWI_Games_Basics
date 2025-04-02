package at.damian.games.Actors;

import org.newdawn.slick.Graphics;
import java.util.Random;

public class Ellipse implements Actor {
    private float x, y;
    private float speed;
    private double width, height;

    Random random = new Random();

    public Ellipse() {
        this.x = random.nextFloat(800);
        this.y = random.nextFloat(600);
        this.speed = 10;
        this.width = random.nextDouble(30) + 20;
        this.height = random.nextDouble(20) + 15;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, (float) this.width, (float) this.height);
    }

    public void update(int delta) {
        this.y += (float)delta / this.speed;
        if (this.y > (600 - this.height)) {
            this.y = 0;
        }
    }
}