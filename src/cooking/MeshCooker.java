package cooking;

import core.scene.Scene;
import core.utils.vaos.Vertex;
import core.utils.vaos.VertexArray;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import timers.DelayedTask;

import java.util.ArrayList;
import java.util.List;
public class MeshCooker {

        private static final int LEFT_MOUSE_BUTTON = 0;

        private static final int RIGHT_MOUSE_BUTTON = 1;
        private static final int MIDDLE_MOUSE_BUTTON = 2;

        private int vertexIndex = 0;
        private List<Vertex> mesh = new ArrayList<>();
        private List<Integer> indices = new ArrayList<>();

        private DelayedTask waiter;

        public void cook(Scene scene){
            if(waiter == null){
                waiter = new DelayedTask(0.125) { // minTime in second's before adding another vertex
                    @Override
                    public void taskLogic() {
                        MeshCooker.this.meshCreation(scene);
                        //System.out.println("Running !");
                    }
                };
            }
            waiter.run();
        }
        private void meshCreation(Scene scene){
           this.addVertices();
           this.sendCookedMeshToScene(scene);
        }
        private void addVertices(){
            if(Keyboard.isKeyDown(Keyboard.KEY_1)){
                mesh.add(new Vertex(vertexIndex,new Vector3f((float) Math.random() * 20.0f, (float) Math.random() * 10.0f,  (float) Math.random() * 20.0f),new Vector2f(0.0f,0.0f) , new Vector3f(0f,0f,0f)));
                indices.add(vertexIndex);
                vertexIndex++;
            }
        }
        private void sendCookedMeshToScene(Scene scene){
            if(Mouse.isButtonDown(MIDDLE_MOUSE_BUTTON)){
                if(isMeshValid()){
                    scene.addEntity(new CookedMesh(new VertexArray(mesh,indices),new Vector3f((float) (Math.random() * 50), (float) (Math.random() * 50),(float) (Math.random() * 50))));
                }
                else{
                    System.err.println("The Mesh is invalid !");
                }
            }
        }
        private void clearCurrentMeshData(){
            mesh.clear();
            indices.clear();
            vertexIndex = 0;
        }
        private boolean isMeshValid(){
            return mesh.size() > 0 && indices.size() > 0;
        }
}
