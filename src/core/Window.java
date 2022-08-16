package core;

import org.lwjgl.Sys;

import javax.swing.*;

public class Window {

        public static final int WIDTH = 1280;
        public static final int HEIGHT = 720;
        public static final int MAX_FPS = 120;
        public static final String TITLE = "Kernel3D";

        private static double lastTime = getTimeInMS();
        private static double now;
        private static double delta;

        private Window(){}

        public static void createWindow(){


        }


        private static double update(){}

        private static double getTimeInMS(){
                return Sys.getTime() * 1000 / Sys.getTimerResolution();
        }

        private static void activateTimer(){

        }

        private static double limitFPS(int maxFPS){

        }



}
