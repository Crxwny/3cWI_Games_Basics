package at.damian.games.Images;

import at.damian.games.Images.Actor;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Demo extends BasicGame {
    private List<Actor> actors;

    public Demo(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Ben10 ben10 = new Ben10();
        this.actors.add(ben10);

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer,i);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

    }

    @Override
    public void keyPressed(int key, char c) {
        System.out.println(key + "pressed");
    }

    public static void main (String[]argv){
        try {
            AppGameContainer container = new AppGameContainer(new at.damian.games.Images.Demo("Demo"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
