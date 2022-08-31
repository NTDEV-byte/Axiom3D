package scenes.models;

import core.scene.Scene;
import core.scene.entity.Entity;
import core.utils.ModelLoader;
import core.utils.shaders.Shader;
import core.utils.textures.Texture;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Vector3f;

public class AlmightyPenguin extends Entity {

    private static VertexArray mesh = ModelLoader.loadModel("resources/models/penguin.obj");
    private static Texture texture = new Texture("resources/textures/penguin.png");

    public AlmightyPenguin(Vector3f position) {
        super(mesh, new Shader("resources/shaders/global/light/lightVS.glsl" , "resources/shaders/global/light/lightFS.glsl"), position,texture,150f);
    }

    @Override
    public void update() {
        super.loadModelMatrix();
        super.loadViewMatrix(Scene.MAIN_CAMERA);
        super.loadSourceLight(Scene.SUN_LIGHT);
    }
}
