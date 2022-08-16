package core.utils;

import java.nio.ByteBuffer;

public class Buffers {

        private Buffers(){}


        public static ByteBuffer createByteBuffer(byte data[]){

                ByteBuffer bufferData = ByteBuffer.allocateDirect(data.length);
                bufferData.put(data);
                bufferData.flip();

                return bufferData;
        }


}
