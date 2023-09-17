package drag_and_drop;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;
/**
 * Target created for the path (invalid drop)
 * @author DongHoon J
 *
 */
public class InvalidTarget extends Target{
	public InvalidTarget(Image image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public boolean drag (Source source, Payload payload, float x, float y, int pointer) {//Makes sure towers cannot be placed on the path
		getActor().setColor(Color.RED);
		return false;
	}

	public void reset (Source source, Payload payload) {
		getActor().setColor(Color.WHITE);
	}

	public void drop (Source source, Payload payload, float x, float y, int pointer) {
	}


}
