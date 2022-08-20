package cooking;

import core.scene.Scene;
import core.utils.vaos.Vertex;
import core.utils.vaos.VertexArray;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;
public class MeshCooker {
        private static final int LEFT_MOUSE_BUTTON = 0;
        private static final int RIGHT_MOUSE_BUTTON = 1;
        private static final int MIDDLE_MOUSE_BUTTON = 2;

        private int vertexIndex = 0;
        private List<Vertex> mesh = new ArrayList<>();
        private List<Integer> indices = new ArrayList<>();

        public void cook(Scene scene){
            if(Mouse.isButtonDown(LEFT_MOUSE_BUTTON)){
                mesh.add(new Vertex(vertexIndex,new Vector3f((float) Math.random() * 20.0f, (float) Math.random() * 10.0f,  (float) Math.random() * 20.0f),new Vector2f(0.0f,0.0f) , new Vector3f(0f,0f,0f)));
                indices.add(vertexIndex);
                vertexIndex++;
                System.out.println(mesh);
                System.out.println(indices);
            }
            else if(Mouse.isButtonDown(MIDDLE_MOUSE_BUTTON)){
                 scene.addEntity(new CookedMesh(new VertexArray(mesh,indices),new Vector3f(0,15,0)));
                // this.restart();
             }
        }

        private void restart(){
            mesh.clear();
            indices.clear();
            vertexIndex = 0;
        }
}
