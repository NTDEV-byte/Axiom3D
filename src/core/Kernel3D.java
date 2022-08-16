package core;

import org.lwjgl.opengl.GL11;

public class Kernel3D implements IProgram ,Runnable{

    private boolean running;
    private Thread thread;

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
        GL11.glClearColor(1.0f , 1.0f , 1.0f , 1.0f);
    }
    private void update(){
        Window.update();
        if(Window.isCloseRequested()){
             stop();
        }
    }
    private void render(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    public static void main(String args[]){
         Kernel3D kernel = new Kernel3D();
         kernel.start();
    }

}
