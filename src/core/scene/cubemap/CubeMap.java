package core.scene.cubemap;

import core.scene.Scene;
import core.scene.entity.Entity;
import core.utils.shaders.Shader;
import core.utils.textures.Texture;
import core.utils.textures.cubby.CubeMapTexture;
import core.utils.vaos.Vertex;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Vector3f;

import java.util.Arrays;

public class CubeMap extends Entity {


    private static VertexArray mesh = new VertexArray(
            Arrays.asList(new Vertex[]{
                    new Vertex(new Vector3f(-1.0f , 1.0f , 1.0f)),
                    new Vertex(new Vector3f(-1.0f , -1.0f , 1.0f)),
                    new Vertex(new Vector3f( 1.0f , 1.0f , 1.0f)),
                    new Vertex(new Vector3f( 1.0f , 1.0f , 1.0f)),      // front face
                    new Vertex(new Vector3f( -1.0f , -1.0f , 1.0f)),
                    new Vertex(new Vector3f( 1.0f , -1.0f , 1.0f))
            }));
    private static Texture texture = new CubeMapTexture(new String[]{
            "ocean/left.jpg", "ocean/right.jpg",
            "ocean/top.jpg",  "ocean/bottom.jpg",
            "ocean/front.jpg","ocean/back.jpg"
    });

    public CubeMap(Vector3f position){
        super(mesh,new Shader("resources/shaders/cubemap/cubemapVS.glsl"  , "resources/shaders/cubemap/cubemapFS.glsl") , position,texture);
    }

    public CubeMap(Vector3f position,String path[]){
        super(mesh,new Shader("resources/shaders/cubemap/cubemapVS.glsl"  , "resources/shaders/cubemap/cubemapFS.glsl") , position , new CubeMapTexture(path));
    }

    @Override
    public void update() {
        super.loadModelMatrix();
        super.loadViewMatrix(Scene.MAIN_CAMERA);
    }

    @Override
    public void render(){
        texture.enable();
        shader.enable();
        mesh.render();
        shader.disable();
        texture.disable();
    }
}
