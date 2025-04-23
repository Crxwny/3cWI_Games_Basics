package at.damian.games.T_REX;

import at.damian.games.T_REX.Actor;
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
        T_Rex t_rex = new T_Rex();
        this.actors.add(t_rex);

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

        graphics.drawLine(0, 325, 800, 325);

    }

    @Override
    public void keyPressed(int key, char c) {
        System.out.println(key + "pressed");
    }

    public static void main (String[]argv){
        try {
            AppGameContainer container = new AppGameContainer(new Demo("T-Rex"));
            container.setDisplayMode(800, 400, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
