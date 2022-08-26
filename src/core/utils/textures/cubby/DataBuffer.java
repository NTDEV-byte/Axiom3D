package core.utils.textures.cubby;

import core.utils.BuffersHelper;

import java.nio.IntBuffer;

public class DataBuffer {

    private int width;
    private int height;
    private IntBuffer data;


    public DataBuffer(int width, int height,int pixels[]) {
        this.width = width;
        this.height = height;
        this.data = BuffersHelper.createIntBuffer(pixels);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public IntBuffer getData() {
        return data;
    }
}
