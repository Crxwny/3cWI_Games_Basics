package at.damian.games.firstGame;

import org.newdawn.slick.*;

public class Demo extends BasicGame {
    private float ovalX;
    private float circleY;
    private float rectX, rectY;
    private float oSpeed;
    private float cSpeed;
    private int direction;
    private float speed = 4;


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

    }

    @Override
    public void update(GameContainer gameContainer, int deltaTime) throws SlickException {
        this.ovalX += deltaTime / this.oSpeed;

        if (this.ovalX >= 600 || this.ovalX <= 100) {
            this.oSpeed = -this.oSpeed;
        }

        this.circleY += deltaTime / this.cSpeed;

        if (this.circleY >= 400 || this.circleY <= 100) {
            this.cSpeed = -this.cSpeed;
        }


        float deltaSpeed = deltaTime / speed;
        switch (direction) {
            case 0:
                rectX += deltaSpeed;
                if (rectX >= 500) {
                    rectX = 500;
                    direction = 1;
                }
                break;
            case 1:
                rectY += deltaSpeed;
                if (rectY >= 400) {
                    rectY = 400;
                    direction = 2;
                }
                break;
            case 2:
                rectX -= deltaSpeed;
                if (rectX <= 150) {
                    rectX = 150;
                    direction = 3;
                }
                break;
            case 3:
                rectY -= deltaSpeed;
                if (rectY <= 100) {
                    rectY = 100;
                    direction = 0;
                }
                break;
        }
        }

        @Override
        public void render (GameContainer gameContainer, Graphics graphics) throws SlickException {
            graphics.drawOval(this.ovalX, 10, 100, 40);
            graphics.drawOval(50, this.circleY, 50, 50);
            graphics.drawRect(this.rectX, this.rectY, 50, 50);

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

