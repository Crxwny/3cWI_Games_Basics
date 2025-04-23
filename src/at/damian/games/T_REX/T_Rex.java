package at.damian.games.T_REX;

import org.newdawn.slick.*;

public class T_Rex implements Actor {
    private Animation runningRex;
    private float x, y;
    private float ground = 275;
    private float gravity = 0.5f;
    private float jumpStrength = -10f;
    private float velocityY = 0;

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

        Input input = gameContainer.getInput();

        if (input.isKeyPressed(Input.KEY_SPACE) && y >= ground) {
            velocityY = jumpStrength;
        }

        velocityY += gravity;

        y += velocityY;

        if (y > ground) {
            y = ground;
            velocityY = 0;
        }
    }
}
