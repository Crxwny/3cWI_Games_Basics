package at.damian.games.snowWorld;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor {
    public enum SIZE {SMALL,MEDIUM,LARGE}
    private float x,y;
    private int size;
    private int speed;
    private Random random;

    public Snowflake(SIZE size) {
        this.random = new Random();
        if (size == SIZE.SMALL) {
            this.size = 4;
            this.speed = 12;
        }

        if (size == SIZE.MEDIUM) {
            this.size = 8;
            this.speed = 6;
        }

        if (size == SIZE.LARGE) {
            this.size = 16;
            this.speed = 3;
        }

        setRandomPosition();
    }

    private void setRandomPosition() {
        this.x = random.nextFloat(800);
        this.y = random.nextFloat(600) - 600;
    }


    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.size, this.size);

    }

    @Override
    public void update(int delta) {
        this.y += (float) delta /speed;
        if (this.y > 600) {
            setRandomPosition();
        }

    }
}
