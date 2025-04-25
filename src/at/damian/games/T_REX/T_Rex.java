package at.damian.games.T_REX;

import org.newdawn.slick.*;

public class T_Rex implements Actor {
    private Animation runningRex;
    private float x, y;
    private float ground = 275;
    private float gravity = 0.01f;
    private float jumpStrength = -1.8f;
    private float velocityY = 0;
    private boolean jumping = false;

    public T_Rex() throws SlickException {
        this.runningRex = new Animation();

        runningRex.addFrame(new Image("testdata/running_frame1.gif").getScaledCopy(50, 50), 100);
        runningRex.addFrame(new Image("testdata/running_frame2.gif").getScaledCopy(50, 50), 100);

        this.x = 150;
        this.y = ground;

    }

    @Override
    public void render(Graphics graphics) {
        runningRex.draw(this.x, this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        runningRex.update(delta);

        if (gameContainer.getInput().isKeyPressed(Input.KEY_SPACE) && y >= ground) {
            velocityY = jumpStrength;
        }

        if (this.y < ground) {
            jumping = true;
        } else {
            jumping = false;
        }

        velocityY += gravity;
        y += velocityY;


        if (y > ground) {
            y = ground;
            velocityY = 0;
        }
    }

    @Override
    public float getX() {
        return this.x;
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
        return false;
    }

    @Override
    public void setHasPassed(boolean hasPassed) {

    }

    @Override
    public void setSpeed(float speed) {
        return;
    }

    public boolean isJumping() {
        return jumping;
    }
}
