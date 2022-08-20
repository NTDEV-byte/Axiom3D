package core;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;


public class Window {

        public static final int WIDTH = 1280;
        public static final int HEIGHT = 720;
        public static final int MAX_FPS = 120;
        public static final String TITLE = "Axiom3D";

        private Window(){}

        public static void createWindow(){
                try {
                        Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
                        Display.create(new PixelFormat() , new ContextAttribs(3,3));
                } catch (LWJGLException e) {
                        throw new RuntimeException(e);
                }
                Display.setTitle(TITLE);
        }

        public static void update(){
                Display.update();
                limitFPS(MAX_FPS);
        }

        public static boolean isCloseRequested(){
                return Display
                        .isCloseRequested();
        }

        private static void limitFPS(int maxFPS){
                Display.sync(maxFPS);
        }

        public static double getElapsedTime(){ // the elapsed time between two frames
                return delta;
        }

}
