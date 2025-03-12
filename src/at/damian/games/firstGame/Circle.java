package at.damian.games.firstGame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle {
    private float x,y;
    private float speed;
    private int diameter;

Random random = new Random();
    public Circle() {
        this.x = random.nextFloat(800);
        this.y = random.nextFloat(600);
        this.speed = random.nextFloat(40) + 10;
        this.diameter = random.nextInt(20) + 20;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    public void update(int delta) {
        this.y += (float)delta/this.speed;
        if(this.y>600) {
            this.y = 0;
        }
    }

}



