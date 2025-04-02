package at.damian.games.Actors;
import org.newdawn.slick.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class A_07 extends BasicGame {
    private List<Actor> actors;


    public A_07(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        Random random = new Random();

        this.actors = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Circle c = new Circle();
            actors.add(c);
        }

        for (int i = 0; i < 10; i++) {
            Rectangle r = new Rectangle(random.nextInt(600), random.nextInt(600),10, Rectangle.DIRECTION.LEFT);
            actors.add(r);

        }

        for (int i = 0; i < 10; i++) {
            Ellipse e = new Ellipse();
            actors.add(e);
        }
    }

    @Override
    public void update (GameContainer gameContainer,int deltaTime) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(deltaTime);
        }
    }


    @Override
    public void render (GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
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