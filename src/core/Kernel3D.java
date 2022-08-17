package core;


import core.scene.Scene;
import org.lwjgl.opengl.GL11;
import scenes.DefaultScene;


public class Kernel3D implements IProgram {
    private boolean running;
    private Thread thread;
    private Scene scene;



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
        scene = new DefaultScene();
    }
    private void update(){
        Window.update();
        if(Window.isCloseRequested()){
             stop();
        }
        scene.update();
    }
    private void render(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        scene.render();
    }

    public static void main(String args[]){
         Kernel3D kernel = new Kernel3D();
         kernel.start();
    }

}
