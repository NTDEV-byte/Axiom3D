package plugins.timers;

import org.lwjgl.Sys;

public class Timer {

        private static double lastTime = getTimeInMS();
        private static double now;
        private static double delta;

        private Timer(){}


        public static void activateTimer(){
                now = getTimeInMS();
                delta = (now - lastTime) / 1000; // delta is in second's
                lastTime = now;
        }


        private static double getTimeInMS(){
                return Sys.getTime() * 1000 / Sys.getTimerResolution();
        }

        public static double getElapsedTime(){return delta;}



}
