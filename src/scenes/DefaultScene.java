package scenes;

import core.scene.Scene;
import org.lwjgl.util.vector.Vector3f;
import shapes.d2.Rectangle;

public class DefaultScene extends Scene {
    @Override
    protected void addItemsOnStartScene() {
        addEntity(new Rectangle(new Vector3f(0,0,0)));
    }
}
