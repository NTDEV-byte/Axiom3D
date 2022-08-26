package shapes.d3;

import core.scene.Scene;
import core.scene.entity.Entity;
import core.utils.ModelLoader;
import core.utils.shaders.Shader;
import core.utils.textures.Texture;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Vector3f;

public class Tree extends Entity {


    private static VertexArray mesh = ModelLoader.loadModel("resources/models/tree.obj");
    private static Texture texture = new Texture("resources/textures/tree.png");

    public Tree(Vector3f position){
        super(mesh,new Shader("resources/shaders/global/light/lightVS.glsl" ,"resources/shaders/global/light/lightFS.glsl"),position,texture, (float) (Math.random() * 100));
    }


    @Override
    public void update() {
        super.loadModelMatrix();
        super.loadViewMatrix(Scene.MAIN_CAMERA);
        super.loadSourceLight(Scene.SUN_LIGHT);
    }
}
