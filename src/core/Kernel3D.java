package core;

public class Kernel3D implements IProgram ,Runnable{

    private boolean running;
    private Thread thread;


    @Override
    public void start() {}
    @Override
    public void stop() {}

    @Override
    public void run() {
        this.initialize();
        while(running){
            update();
            render();
        }
    }
    private void initialize(){}
    private void update(){}
    private void render(){}



    public static void main(String args[]){

    }

}
