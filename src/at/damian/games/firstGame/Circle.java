package at.damian.games.firstGame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor {
    private float x,y;
    private float speed;
    private double diameter;

Random random = new Random();
    public Circle() {
        this.x = random.nextFloat(800);
        this.y = random.nextFloat(600);
        this.speed = 10;
        this.diameter = random.nextDouble(20) + 20;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, (float) this.diameter, (float) this.diameter);
    }

    public void update(int delta) {
        this.diameter= this.diameter+0.005;
        this.y += (float)delta/this.speed;
        if(this.y>(600-this.diameter)) {
            this.y = 0;
        }
    }

}



