package at.damian.games.T_REX;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.List;

public class Obstacle1 implements Actor {
    private Image Obstacle1Image;
    private float x,y;
    private boolean hasPassed = false;
    private float speed = 0.65f;



    public Obstacle1() throws SlickException {
        this.Obstacle1Image = new Image("testdata/obstacle-1.gif").getScaledCopy(50,50);
        this.x = 850;
        this.y= 275;
    }

    @Override
    public void render(Graphics graphics) {
        Obstacle1Image.draw(this.x, this.y);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x-=speed;

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
        return 50;
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


