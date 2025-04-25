package at.damian.games.T_REX;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.lwjgl.opengl.Display.getWidth;

public class Demo extends BasicGame {
    private List<Actor> actors;
    private float timeSinceLastObstacle = 0;
    private float spawnDelay = 500;
    Random random = new Random();
    T_Rex t_rex = null;
    private int score = 0;
    private boolean gameOver = false;
    private float speed = 0.65f;
    private float elapsedTime = 0;

    public Demo(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        t_rex = new T_Rex();
        this.actors.add(t_rex);
        System.out.println(score);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        if (gameOver) return;
        speed+=0.00001f;
        elapsedTime += i / 1000.0f;

        timeSinceLastObstacle += i;

        if (timeSinceLastObstacle >= spawnDelay) {
            if (random.nextInt(0, 2) == 0) {
                Obstacle1 newObstacleSpawn1 = new Obstacle1();
                this.actors.add(newObstacleSpawn1);
            } else {
                Obstacle2 newObstacleSpawn2 = new Obstacle2();
                this.actors.add(newObstacleSpawn2);
            }
            timeSinceLastObstacle = 0;
            spawnDelay = random.nextInt(400, 600);
        }

        for (Actor actor : this.actors) {
            if (actor instanceof Obstacle1 || actor instanceof Obstacle2) {
                if (actor.getX() + actor.getWidth() < 0) {
                    this.actors.remove(actor);
                    break;
                }
            }
        }

        for (Actor actor : this.actors) {
            if ((actor instanceof Obstacle1 || actor instanceof Obstacle2) && !actor.hasPassed()) {
                if (actor.getX() < 150) {
                    actor.setHasPassed(true);
                    score += 1;
                    System.out.println(score);
                    break;
                }
            }
        }

        for (Actor actor : this.actors) {
            if (actor instanceof Obstacle1 || actor instanceof Obstacle2) {
                checkCollision(t_rex, actor);
            }
        }

        for (Actor actor : this.actors) {
            actor.update(gameContainer, i);
            actor.setSpeed(speed);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

        graphics.drawLine(0, 325, 800, 325);
        graphics.drawString("Score: " + score, 680, 10);
        graphics.drawString("Speed: " + speed, 7, 40);
        graphics.drawString("Time: " + (int)elapsedTime + "s", 680, 40);

        if (gameOver) {
            Font font = new TrueTypeFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 36), true);
            graphics.setFont(font);
            graphics.setColor(Color.red);
            String gameOverText = "Game Over";
            graphics.drawString(gameOverText, (gameContainer.getWidth() - font.getWidth(gameOverText)) / 2, 100);

            graphics.setColor(Color.white);
            String restartText = "Click to Restart";
            graphics.drawString(restartText, (gameContainer.getWidth() - font.getWidth(restartText)) / 2, 200);

            int textWidth = font.getWidth(restartText);
            int textHeight = font.getHeight(restartText);
            graphics.setColor(Color.white);
            graphics.drawRect((gameContainer.getWidth() - textWidth) / 2 - 10, 190, textWidth + 20, textHeight + 20);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
    }

    public void checkCollision(T_Rex t_rex, Actor actor) {
        boolean isHorizontalCollision = t_rex.getX() + t_rex.getWidth() > actor.getX() && t_rex.getX() < actor.getX() + actor.getWidth();
        boolean isVerticalCollision = t_rex.getY() + t_rex.getHeight() > actor.getY() && t_rex.getY() < actor.getY() + actor.getHeight();

        if (isHorizontalCollision && isVerticalCollision) {
            if (t_rex.isJumping() && t_rex.getY() < actor.getY()) {
            } else {
                gameOver = true;
            }
        }
    }

    public void restartGame() throws SlickException {
        score = 0;
        this.actors.clear();
        t_rex = new T_Rex();
        this.actors.add(t_rex);
        speed = 0.65f;
        elapsedTime = 0f;
        gameOver = false;
    }



    @Override
    public void mousePressed(int button, int x, int y) {
        if (gameOver) {
            String restartText = "Click to Restart";
            Font font = new TrueTypeFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 36), true);

            int textWidth = font.getWidth(restartText);
            int textHeight = font.getHeight(restartText);
            int buttonX = (800 - textWidth) / 2;
            int buttonY = 190;

            boolean isClickInsideButton = (x >= buttonX) && (x <= buttonX + textWidth) &&
                    (y >= buttonY) && (y <= buttonY + textHeight);

            if (isClickInsideButton) {
                try {
                    restartGame();
                } catch (SlickException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }



    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Demo("T-Rex"));
            container.setDisplayMode(800, 400, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
