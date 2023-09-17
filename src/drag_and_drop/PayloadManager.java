package drag_and_drop;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
/**
 * Controls the DragAndDrop functionality
 * @author DongHoon J
 *
 */
public class PayloadManager extends Source{
	private Skin skin;
	private DragAndDrop drag;
	private Stage stage;
	private String imageName;

	public PayloadManager(Actor actor, Skin skin, DragAndDrop drag, Stage stage, String imageName) {
		super(actor);
		this.skin = skin;
		this.drag = drag;
		this.stage = stage;
		this.imageName = imageName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Payload dragStart (InputEvent event, float x, float y, int pointer) {//Indicates which tower image you are using to drag
		Payload payload = new Payload();
		payload.setObject(imageName);


		Image image = new Image(skin, imageName);
		image.setBounds(50, 125, 100, 100);
		stage.addActor(image);
		drag.setDragActorPosition(-image.getWidth()/2, image.getHeight()/2);
		payload.setDragActor(image);

		Label validLabel = new Label("VALID", skin);
		validLabel.setColor(0, 1, 0, 1);
		payload.setValidDragActor(validLabel);

		Label invalidLabel = new Label("INVALID", skin);
		invalidLabel.setColor(1, 0, 0, 1);
		payload.setInvalidDragActor(invalidLabel);

		return payload;
	}

}
