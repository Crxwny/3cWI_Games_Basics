package at.damian.games.Actors;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {
    private float x;
    private float y;
    private float speed;


    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 100;
        this.y = 100;
        this.speed = 3;

    }

    @Override
    public void update(GameContainer gameContainer, int deltaTime) throws SlickException {
        this.x += (float) deltaTime /this.speed;
        this.y+= (float) deltaTime /4;

        if (this.x == 800 - 100 || this.y == 600-100) {
            this.x = 0;
            this.y = 0;
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.x, y, 100, 100);
        graphics.drawString("Hello", 50, 100);

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
