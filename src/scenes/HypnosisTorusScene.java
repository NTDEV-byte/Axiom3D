package scenes;

import cooking.MeshCooker;
import core.Window;
import core.scene.Scene;
import core.utils.shaders.ThePainter;
import org.lwjgl.util.vector.Vector3f;
import shapes.d3.Torus;
import shapes.d3.Tree;

public class HypnosisTorusScene extends Scene {

    private MeshCooker cooker;
    private ThePainter painter;

    @Override
    protected void addItemsOnStartScene() {
        for (int i = 0; i < 200 ; i++){
            addEntity(new Torus(new Vector3f((float) (Math.random() * Window.WIDTH), (float) (Math.random() * 250f), (float) (Math.random() * Window.HEIGHT))));
        }
        painter = new ThePainter(this);
    }

    @Override
    public void update(){
        super.update();
        painter.update();
    }


}
