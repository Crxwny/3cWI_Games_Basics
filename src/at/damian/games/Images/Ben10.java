package at.damian.games.Images;

import org.newdawn.slick.*;

public class Ben10 implements Actor {
    private Image Ben10Image;
    private float x,y;


    @Override
    public void render(Graphics graphics) {
        Ben10Image.draw(this.x, this.y);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            this.x -= ((float) 1 /delta);
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            this.x += ((float) 1 /delta);
        }

    }

    public Ben10() throws SlickException {
        this.Ben10Image = new Image("testdata/ben10.png").getScaledCopy(50,50);
        this.x = 100;
        this.y= 100;
    }
}
