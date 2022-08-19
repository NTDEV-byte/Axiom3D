package models;

import core.scene.Scene;
import core.scene.entity.Entity;
import core.utils.ModelLoader;
import core.utils.shaders.Shader;
import core.utils.textures.Texture;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Vector3f;

public class SuzanneMonkey extends Entity {

    private static VertexArray mesh = ModelLoader.loadModel("resources/models/suzanne.obj");
    private static Texture texture = new Texture("resources/textures/models/suzanne.png");

    public SuzanneMonkey(Vector3f position) {
        super(mesh, new Shader("resources/shaders/global/texture/textureVS.glsl" , "resources/shaders/global/texture/textureFS.glsl"), position,texture);
    }

    @Override
    public void update() {
        super.loadModelMatrix();
        super.loadViewMatrix(Scene.MAIN_CAMERA);
    }
}
