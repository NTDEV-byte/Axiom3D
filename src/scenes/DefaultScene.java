package scenes;

import core.scene.Scene;
import org.lwjgl.util.vector.Vector3f;
import scenes.shapes.d3.Cube;
import scenes.shapes.d3.Torus;
import scenes.models.SuzanneMonkey;

public class DefaultScene extends Scene {
    @Override
    protected void addItemsOnStartScene() {
         addEntity(new Torus(new Vector3f(0,20,0)));
         addEntity(new Cube(new Vector3f(0,15,-15)));
         addEntity(new SuzanneMonkey(new Vector3f(0,50,0)));
    }

}
