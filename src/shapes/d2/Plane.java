package shapes.d2;

import abstraction.ICraftedByHand;
import core.scene.Scene;
import core.scene.entity.Entity;
import core.utils.shaders.Shader;
import core.utils.vaos.Vertex;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Entity implements ICraftedByHand {


    private int size = 800;
    private int verticesCounter = 128;

    public Plane(Vector3f position) {
        this.mesh = this.craftMesh();
        this.shader = new Shader("resources/shaders/global/raw/rawVS.glsl" , "resources/shaders/global/raw/rawFS.glsl");
        this.position = position;
        this.initDefault();
    }

    public Plane(int size,int verticesCounter,Vector3f position){
        this.size = size;
        this.verticesCounter = verticesCounter;
        this.mesh = this.craftMesh();
        this.shader = new Shader("resources/shaders/global/raw/rawVS.glsl" , "resources/shaders/global/raw/rawFS.glsl");
        this.position = position;
        this.initDefault();
    }

    @Override
    public void update() {
        super.loadModelMatrix();
        super.loadViewMatrix(Scene.MAIN_CAMERA);
    }

    @Override
    public VertexArray craftMesh() {
        List<Vertex> vertices = new ArrayList<Vertex>();
        List<Integer> indices = new ArrayList<>();

        int vertexIndex = 0;
        for(int z = 0; z < verticesCounter; z++){
            for(int x = 0; x < verticesCounter; x++){

                float vertexPX = (((float)x / (float)(verticesCounter  - 1))) * size;
                float vertexPY = 0.0f;
                float vertexPZ = (((float)z / (float)(verticesCounter  - 1))) * size;

                float vertexUVX = (((float)x / (float)(verticesCounter  - 1)));
                float vertexUVY = (((float)z / (float)(verticesCounter  - 1)));

                float vertexNormalX = 0.01f;
                float vertexNormalY = 0.01f;
                float vertexNormalZ = 0.02f;
                vertices.add(new Vertex(vertexIndex,new Vector3f(vertexPX,vertexPY,vertexPZ) , new Vector2f(vertexUVX,vertexUVY) , new Vector3f(vertexNormalX,vertexNormalY,vertexNormalZ)));
                vertexIndex++;
            }
        }

        // face collections
        for(int z = 0; z < verticesCounter - 1; z++){
            for(int x = 0; x < verticesCounter - 1; x++){

                int topLeftVertex = (x + z * verticesCounter);
                int topRightVertex = topLeftVertex + 1;
                int bottomLeftVertex = (x + (z + 1) * verticesCounter);
                int bottomRightVertex = bottomLeftVertex + 1;

                indices.add(topLeftVertex);
                indices.add(bottomLeftVertex);
                indices.add(topRightVertex);

                indices.add(topRightVertex);
                indices.add(bottomLeftVertex);
                indices.add(bottomRightVertex);

            }
        }

        return new VertexArray(vertices, indices);
    }
}
