package scenes;

import core.Window;
import core.scene.Scene;
import org.lwjgl.util.vector.Vector3f;
import shapes.d3.Torus;

public class HypnosisTorusScene extends Scene {
    @Override
    protected void addItemsOnStartScene() {
        for (int i = 0; i < 200 ; i++){
            addEntity(new Torus(new Vector3f((float) (Math.random() * Window.WIDTH), (float) (Math.random() * 250f), (float) (Math.random() * Window.HEIGHT))));
        }
    }
}