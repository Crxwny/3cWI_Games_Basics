package at.damian.games.T_REX;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Obstacle2 implements Actor {
    private Image Obstacle2Image;
    private float x, y;
    private boolean hasPassed;
    private float speed = 0.65f;


    public Obstacle2() throws SlickException {
        this.Obstacle2Image = new Image("testdata/obstacle-2.gif").getScaledCopy(100, 50);
        this.x = 850;
        this.y = 275;
    }

    @Override
    public void render(Graphics graphics) {
        Obstacle2Image.draw(this.x, this.y);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x -= speed;

    }

    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public float getWidth() {
        return 100;
    }

    @Override
    public float getHeight() {
        return 50;
    }

    @Override
    public boolean hasPassed() {
        return this.hasPassed;
    }

    @Override
    public void setHasPassed(boolean hasPassed) {
        this.hasPassed = hasPassed;

    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}


