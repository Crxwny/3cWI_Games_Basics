package at.damian.games.Images;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ben10 implements Actor {
    private Image Ben10Image;
    private float x,y;


    @Override
    public void render(Graphics graphics) {
        Ben10Image.draw(this.x, this.y);

    }

    @Override
    public void update(int delta) {
        this.x++;

    }

    public Ben10() throws SlickException {
        this.Ben10Image = new Image("testdata/ben10.png").getScaledCopy(50,50);
        this.x = 100;
        this.y= 100;
    }
}
