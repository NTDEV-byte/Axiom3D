package core.utils.textures;

import core.utils.BuffersHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Texture
{

    protected int id;


    public Texture(String texturePath){
        this.id = createTexture(texturePath);
    }
    public void enable(){
        GL11.glBindTexture(GL11.GL_TEXTURE_2D,id);
    }


    private int createTexture(String texturePath){
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(texturePath));
            int width = image.getWidth();
            int height = image.getHeight();
            int pixels[] = new int[width * height];
            image.getRGB(0,0,width,height,pixels,0,width);

            int swizzleRGBAPixels[] = new int[width * height];

            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){

                    int pixel = pixels[x + y * width];
                    int a = (pixel & 0xff000000) >> 24;
                    int r = (pixel & 0xff0000) >> 16;
                    int g = (pixel & 0xff00) >> 8;
                    int b = (pixel & 0xff);

                    swizzleRGBAPixels[x + y * width] = (a << 24) | (b << 16) | (g << 8) | r;
                }
            }

            int textureID = GL11.glGenTextures();
            GL11.glBindTexture(GL11.GL_TEXTURE_2D,textureID);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MIN_FILTER,GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_LINEAR);
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D,0,GL11.GL_RGBA,width,height,0,GL11.GL_RGBA,GL11.GL_UNSIGNED_INT, BuffersHelper.createIntBuffer(swizzleRGBAPixels));
            GL11.glBindTexture(GL11.GL_TEXTURE_2D,0);

            return textureID;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
