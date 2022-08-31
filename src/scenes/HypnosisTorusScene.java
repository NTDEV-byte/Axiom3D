package scenes;

import core.Window;
import core.scene.Scene;
import core.scene.cubemap.CubeMap;
import org.lwjgl.util.vector.Vector3f;
import scenes.models.AlmightyPenguin;
import scenes.shapes.d3.Torus;

public class HypnosisTorusScene extends Scene {

    @Override
    protected void addItemsOnStartScene() {
        for (int i = 0; i < 200 ; i++){
            addEntity(new Torus(new Vector3f((float) (Math.random() * Window.WIDTH), (float) (Math.random() * 250f), (float) (Math.random() * Window.HEIGHT))));
           // addEntity(new Tree(new Vector3f((float) (Math.random() * Window.WIDTH), (float) (Math.random() * 250f), (float) (Math.random() * Window.HEIGHT))));
        }
        addEntity(new AlmightyPenguin(new Vector3f(-5,0,-50)));
        addEntity(new CubeMap(new Vector3f(0,0,0)));

    }
    @Override
    public void update(){
        super.update();
    }
}
