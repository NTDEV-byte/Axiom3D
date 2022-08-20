package shapes.d2;

import core.scene.entity.Entity;
import core.utils.shaders.Shader;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Vector3f;

public class Plane extends Entity {

    private static VertexArray mesh;

    public Plane(Vector3f position) {
        super(mesh, new Shader("resources/shaders/global/raw/rawVS.glsl" , "resources/shaders/global/raw/rawFS.glsl"), position);
    }

    @Override
    public void update() {

    }




    private VertexArray generateMesh(){

    }
}
