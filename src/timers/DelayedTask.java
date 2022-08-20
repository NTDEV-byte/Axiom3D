package timers;

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
            }
        }
        private boolean isMinDelayReached(){
             bucket += Timer.getElapsedTime();
             if(bucket >= minWaitValue){
                 bucket = 0;
                 return true;
             }
             return false;
        }

}
