package plugins.timers;

import abstraction.IDelayedTask;

public abstract class DelayedTask implements IDelayedTask,Runnable {

        private double bucket;
        private double minWaitValue;

        public DelayedTask(double minWaitValueInS){
            this.minWaitValue = minWaitValueInS;
        }

        @Override
        public void run(){
            if(isMinDelayReached()){
                this.taskLogic();
                this.reset();
            }
        }
        private boolean isMinDelayReached(){
             bucket += Timer.getElapsedTime();
             if(bucket >= minWaitValue){
                 return true;
             }
             return false;
        }

        private void reset(){
            bucket = 0;
        }

}
