package zelda.items;

import java.awt.Rectangle;
import zelda.enemy.Behavior;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.link.Link;

/**
 *
 * @author vincentklarholz
 */
public class Bomb extends GObject {

    private final static String[] bombAnimation	= { "bomb" };
    private Behavior behavior;

    public Bomb(Game game, int x, int y)
    {
        super(game, x, y, 18, 21, "images/bomb.png");
        spriteLoc.put("bomb", new Rectangle(0, 0, 18, 21));

        sprite.setSprite(spriteLoc.get("bomb"));
        setAnimation(bombAnimation);

		liquid = true;
        behavior = new BombBehavior(this);
    }

	@Override
    public void doInLoop()
    {
        behavior.behave();
    }

	@Override
	public void collision(GObject obj)
	{
		System.out.println("Collision");

		if (obj instanceof Link)
		{
			alive = false;
		}
	}

}
