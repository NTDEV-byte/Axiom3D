package core;

import core.scene.Scene;
import org.lwjgl.opengl.GL11;
import scenes.HypnosisTorusScene;
import timers.Timer;

public class Axiom3D implements IProgram {
    private boolean running;
    private Thread thread;
    private Scene scene;

    @Override
    public void start() {
        running = true;
        thread = new Thread(this, "Axiom3D - Thread");
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
        this.initOpenGLConfiguration();
        scene = new HypnosisTorusScene();
    }

    private void initOpenGLConfiguration(){
        GL11.glClearColor(0 , 0.0f , 0.0f , 1.0f);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
    private void update(){
        Window.update();
        Timer.activateTimer();
        if(Window.isCloseRequested()){
             stop();
        }
        scene.update();
    }
    private void render(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        scene.render();
    }
    public static void main(String args[]){
         Axiom3D kernel = new Axiom3D();
         kernel.start();
    }

}
