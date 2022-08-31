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
                    new Vertex(new Vector3f( 1.0f , -1.0f , 1.0f)),

                    new Vertex(new Vector3f(-1.0f , 1.0f , -1.0f)),
                    new Vertex(new Vector3f(-1.0f , -1.0f , -1.0f)),
                    new Vertex(new Vector3f( 1.0f , 1.0f , -1.0f)),
                    new Vertex(new Vector3f( 1.0f , 1.0f , -1.0f)),      // back face
                    new Vertex(new Vector3f( -1.0f , -1.0f , -1.0f)),
                    new Vertex(new Vector3f( 1.0f , -1.0f , -1.0f)),

                    new Vertex(new Vector3f(-1.0f,1.0f,-1.0f)),
                    new Vertex(new Vector3f(-1.0f , -1.0f,-1.0f)),
                    new Vertex(new Vector3f(-1.0f, 1.0f , 1.0f)),       // left face
                    new Vertex(new Vector3f(-1.0f, 1.0f , 1.0f)),
                    new Vertex(new Vector3f(-1.0f, -1.0f , -1.0f)),
                    new Vertex(new Vector3f( -1.0f, -1.0f , 1.0f)),

                    new Vertex(new Vector3f(1.0f,1.0f,-1.0f)),
                    new Vertex(new Vector3f(1.0f , -1.0f,-1.0f)),
                    new Vertex(new Vector3f(1.0f, 1.0f , 1.0f)),       // Right face
                    new Vertex(new Vector3f(1.0f, 1.0f , 1.0f)),
                    new Vertex(new Vector3f(1.0f, -1.0f , -1.0f)),
                    new Vertex(new Vector3f(1.0f, -1.0f , 1.0f)),

                    new Vertex(new Vector3f(-1.0f, 1.0f , -1.0f)),
                    new Vertex(new Vector3f(-1.0f, 1.0f ,  1.0f)),
                    new Vertex(new Vector3f( 1.0f, 1.0f , -1.0f)),      // Top Face
                    new Vertex(new Vector3f( 1.0f, 1.0f , -1.0f)),
                    new Vertex(new Vector3f( -1.0f, 1.0f , 1.0f)),
                    new Vertex(new Vector3f( 1.0f, 1.0f ,  1.0f)),

                    new Vertex(new Vector3f(-1.0f, -1.0f , -1.0f)),
                    new Vertex(new Vector3f(-1.0f, -1.0f ,  1.0f)),
                    new Vertex(new Vector3f( 1.0f, -1.0f , -1.0f)),      // bottom Face
                    new Vertex(new Vector3f( 1.0f, -1.0f , -1.0f)),
                    new Vertex(new Vector3f( -1.0f,-1.0f ,  1.0f)),
                    new Vertex(new Vector3f( 1.0f, -1.0f ,  1.0f)),
            }));
    private static Texture texture = new CubeMapTexture(new String[]{
            "ocean/left.jpg", "ocean/right.jpg",
            "ocean/top.jpg",  "ocean/bottom.jpg",
            "ocean/back.jpg","ocean/front.jpg"
    });

    public CubeMap(Vector3f position){
        super(mesh,new Shader("resources/shaders/cubemap/cubemapVS.glsl"  , "resources/shaders/cubemap/cubemapFS.glsl") , position,texture,1000f - 1.0f);
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
