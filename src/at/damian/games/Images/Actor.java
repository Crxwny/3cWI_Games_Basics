package at.damian.games.Images;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Actor {

    public void render(Graphics graphics);

    public void update(GameContainer gameContainer, int delta);

}
