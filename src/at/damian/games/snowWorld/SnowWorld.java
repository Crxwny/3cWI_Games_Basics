package at.damian.games.snowWorld;

import at.damian.games.firstGame.A_07;
import org.newdawn.slick.*;

public class SnowWorld extends BasicGame {

    public SnowWorld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }

    public static void main (String[]argv){
        try {
            AppGameContainer container = new AppGameContainer(new A_07("A_07"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
