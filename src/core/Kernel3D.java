package core;

import core.utils.shaders.Shader;
import core.utils.vaos.Vertex;
import core.utils.vaos.VertexArray;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import java.util.Arrays;

public class Kernel3D implements IProgram ,Runnable{

    private boolean running;
    private Thread thread;
    private VertexArray mesh;
    private Shader shader;

    private Matrix4f modelMatrix = new Matrix4f();
    private float angle = 0.0f;

    @Override
    public void start() {
        running = true;
        thread = new Thread(this, "Kernel3D - Thread");
        thread.start();
    }
    @Override
    public void stop() {
        running = false;
    }
    @Override
    public void run() {
        this.initialize();
        while(running){
            update();
            render();
        }
    }
    private void initialize(){
        Window.createWindow();
        GL11.glClearColor(0 , 0.0f , 0 , 1.0f);
        shader = new Shader("resources/shaders/basicVS.glsl" , "resources/shaders/basicFS.glsl");

        this.mesh = new VertexArray(Arrays.asList(new Vertex[]{
                new Vertex(new Vector3f(-0.5f , 0.5f , 0.0f)),
                new Vertex(new Vector3f( 0.5f , 0.5f , 0.0f)),
                new Vertex(new Vector3f(-0.5f , -0.5f , 0.0f)),
                new Vertex(new Vector3f( 0.5f , -0.5f , 0.0f)),
        }) , Arrays.asList(new Integer[]{
                0,1,2,
                2,1,3
        }));
    }
    private void update(){
        Window.update();
        if(Window.isCloseRequested()){
             stop();
        }
        angle+=0.01f;

        modelMatrix.setIdentity();
        modelMatrix.scale(new Vector3f(angle,angle,angle));
        shader.enable();
        shader.loadUniformMatrix4FV("modelMatrix" , modelMatrix);
        shader.disable();
    }
    private void render(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        shader.enable();
        mesh.render();
        shader.enable();
    }

    public static void main(String args[]){
         Kernel3D kernel = new Kernel3D();
         kernel.start();
    }

}
