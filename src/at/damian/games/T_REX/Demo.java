package at.damian.games.T_REX;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo extends BasicGame {
    private List<Actor> actors;
    private List<Actor> obstacles;
    private float timeSinceLastObstacle = 0;
    private float spawnDelay = 2000;
    Random random = new Random();
    T_Rex t_rex = null;







    public Demo(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        this.obstacles = new ArrayList<>();
        t_rex= new T_Rex();
        this.actors.add(t_rex);
        Obstacle1 obstacle1_1 = new Obstacle1();
        this.actors.add(obstacle1_1);
        Obstacle2 obstacle2_1 = new Obstacle2();
        this.actors.add(obstacle2_1);

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        timeSinceLastObstacle += i;

        if (timeSinceLastObstacle >= spawnDelay) {

            if (random.nextInt(0, 2) == 0) {
                Obstacle1 newObstacleSpawn1 = new Obstacle1();
                this.actors.add(newObstacleSpawn1);
            } else if (random.nextInt(0, 2) == 1) {
                Obstacle2 newObstacleSpawn2 = new Obstacle2();
                this.actors.add(newObstacleSpawn2);

            }
            timeSinceLastObstacle = 0;
            spawnDelay = random.nextInt(350, 2500);
        }


        for (Actor actor : this.actors) {
            if(actor instanceof Obstacle1 || actor instanceof Obstacle2) {
                checkCollision(t_rex, actor);
            }
        }




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

    public void checkCollision(T_Rex t_rex, Actor actor) {
        if (t_rex.getX()+t_rex.getWidth()>=actor.getX()) {
            System.out.println("Collision");
        }
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
