package at.damian.games.Actors;

import org.newdawn.slick.Graphics;

public class Rectangle implements  Actor {
    public enum DIRECTION {LEFT, RIGHT}

    ;
    private float x;
    private float y;
    private float speed;
    private DIRECTION direction;

    public Rectangle(int x, int y, float speed, DIRECTION direction) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 10, 10);

    }

    public void update(int deltaTime) {
        if (direction == DIRECTION.RIGHT) {
            this.x += (float) deltaTime / this.speed;
            if (this.x > (800-10)) {
                this.x = 0;
            }
        } else if (direction == DIRECTION.LEFT) {
            this.x -= (float) deltaTime / this.speed;
            if (this.x < (10)) {
                this.x = 800;
            }


        }
    }
}

