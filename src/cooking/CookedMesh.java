package cooking;

import core.scene.Scene;
import core.scene.entity.Entity;
import core.utils.shaders.Shader;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Vector3f;
public class CookedMesh extends Entity {

    public CookedMesh(VertexArray mesh, Vector3f position) {
        super(mesh, new Shader("resources/shaders/global/raw/rawVS.glsl" , "resources/shaders/global/raw/rawFS.glsl"), position);
    }

    @Override
    public void update() {
        super.loadModelMatrix();
        super.loadViewMatrix(Scene.MAIN_CAMERA);
    }

}
