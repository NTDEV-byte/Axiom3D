package shapes.d2;

import core.scene.Scene;
import core.scene.entity.Entity;
import core.utils.shaders.Shader;
import core.utils.vaos.Vertex;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Vector3f;

import java.util.Arrays;

public class Triangle extends Entity {

    private static VertexArray mesh = new VertexArray(
            Arrays.asList(new Vertex[]{
                    new Vertex(new Vector3f(-0.5f ,0,0)),
                    new Vertex(new Vector3f( 0.5f ,0,0)),
                    new Vertex(new Vector3f( 0.0f ,0.5f,0)),
            }),
            Arrays.asList(new Integer[]{0,1,2}));

    public Triangle(Vector3f position) {
        super(mesh, new Shader("resources/shaders/raw.glsl" , "resources/shaders/rawFS.glsl"), position);
    }
    @Override
    public void update() {
        super.loadModelMatrix();
        super.loadViewMatrix(Scene.MAIN_CAMERA);
        super.rotate(0.0f,0.1f,0.0f);
    }
}
