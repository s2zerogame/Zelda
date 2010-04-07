package zelda.items;

import java.awt.Rectangle;
import zelda.engine.GObject;
import zelda.engine.Game;
import zelda.link.Link;

/**
 *
 * @author Tom
 */

public class Heart extends GObject
{
    private final static String[] heartAnimation = {"heart"};

    public Heart (Game game, int x, int y)
    {
    super(game, x, y, 14, 10, "images/heart.png");
    spriteLoc.put("heart",new Rectangle(0, 0, 14, 10));
    
    sprite.setSprite(spriteLoc.get("heart"));
    setAnimation(heartAnimation);
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