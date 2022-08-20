package cooking;

import core.scene.Scene;
import models.SuzanneMonkey;
import org.lwjgl.util.vector.Vector3f;
public class MeshCookingScene extends Scene {
    private MeshCooker cooker = new MeshCooker();
    @Override
    protected void addItemsOnStartScene() {
         addEntity(new SuzanneMonkey(new Vector3f(15,5,15)));
    }

    @Override
    public void update(){
        super.update();
        cooker.cook(this);
    }

}
