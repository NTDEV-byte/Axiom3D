package core.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Buffers {

        private Buffers(){}

        public static ByteBuffer createByteBuffer(byte data[]){

                ByteBuffer bufferData = ByteBuffer.allocateDirect(data.length);
                bufferData.put(data);
                bufferData.flip();

                return bufferData;
        }

        public static IntBuffer createInBuffer(int data[]){

                IntBuffer bufferData = ByteBuffer.allocateDirect(data.length << 4).order(ByteOrder.nativeOrder()).asIntBuffer();
                bufferData.put(data);
                bufferData.flip();

                return bufferData;
        }

        public static FloatBuffer createFloatBuffer(float data[]){

                FloatBuffer bufferData = ByteBuffer.allocateDirect(data.length << 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                bufferData.put(data);
                bufferData.flip();

                return bufferData;
        }

}
