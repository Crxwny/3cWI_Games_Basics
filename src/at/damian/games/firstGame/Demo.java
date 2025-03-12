package at.damian.games.firstGame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Demo extends BasicGame {
    private enum DIRECTION {RIGHT, DOWN, LEFT, UP};
    private float ovalX;
    private float circleY;
    private float rectX, rectY;
    private float oSpeed;
    private float cSpeed;
    private float speed = 4;
    private DIRECTION objectdirection;
    private Rectangle rect;
    private List<Rectangle> rects;
    private List<Circle> circles;


    public Demo(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.oSpeed = 4;
        this.ovalX = 100;
        this.cSpeed = 4;
        this.circleY = 100;
        this.rectX = 200;
        this.rectY = 100;
        this.rect = new Rectangle(100, 100,5);
        this.objectdirection = DIRECTION.RIGHT;

        this.rects = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Rectangle r = new Rectangle(random.nextInt(600), random.nextInt(600), random.nextInt(50));
            rects.add(r);


        }

        this.circles = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            Circle c = new Circle();
            this.circles.add(c);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int deltaTime) throws SlickException {
        this.rect.update(deltaTime);
        this.ovalX += deltaTime / this.oSpeed;

        if (this.ovalX >= 600 || this.ovalX <= 100) {
            this.oSpeed = -this.oSpeed;
        }

        this.circleY += deltaTime / this.cSpeed;

        if (this.circleY >= 400 || this.circleY <= 100) {
            this.cSpeed = -this.cSpeed;
        }


        float deltaSpeed = deltaTime / speed;
        if (objectdirection == DIRECTION.RIGHT) {
            rectX += deltaSpeed;
            if (rectX >= 500) {
                rectX = 500;
                objectdirection = DIRECTION.DOWN;
            }
        } else if (objectdirection == DIRECTION.DOWN) {
            rectY += deltaSpeed;
            if (rectY >= 400) {
                rectY = 400;
                objectdirection = DIRECTION.LEFT;
            }
        } else if (objectdirection == DIRECTION.LEFT) {
            rectX -= deltaSpeed;
            if (rectX <= 150) {
                rectX = 150;
                objectdirection = DIRECTION.UP;
            }
        } else if (objectdirection == DIRECTION.UP) {
            rectY -= deltaSpeed;
            if (rectY <= 100) {
                rectY = 100;
                objectdirection = DIRECTION.RIGHT;
            }

        }

        for (Rectangle r : rects) {
            r.update(deltaTime);
        }

        for (Circle c : circles) {
            c.update(deltaTime);
        }
        }



        @Override
        public void render (GameContainer gameContainer, Graphics graphics) throws SlickException {
            graphics.drawOval(this.ovalX, 10, 100, 40);
            graphics.drawOval(50, this.circleY, 50, 50);
            graphics.drawRect(this.rectX, this.rectY, 50, 50);
            this.rect.render(graphics);
            for (Rectangle r : rects) {
                r.render(graphics);
            }

            for (Circle c : circles) {
                c.render(graphics);
            }

        }


        public static void main (String[]argv){
            try {
                AppGameContainer container = new AppGameContainer(new Demo("Demo"));
                container.setDisplayMode(800, 600, false);
                container.start();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }

