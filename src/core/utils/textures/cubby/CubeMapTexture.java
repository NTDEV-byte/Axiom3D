package core.utils.textures.cubby;

import core.utils.textures.Texture;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class CubeMapTexture extends Texture {


    public CubeMapTexture(String resources[]) {
        this.id = createCubeMap(resources);
    }


    private int createCubeMap(String resources[]){

        int id = GL11.glGenTextures();
        GL11.glBindTexture(GL13.GL_TEXTURE_CUBE_MAP,id);
        GL11.glTexParameteri(GL13.GL_TEXTURE_CUBE_MAP,GL11.GL_TEXTURE_MIN_FILTER,GL11.GL_LINEAR);
        GL11.glTexParameteri(GL13.GL_TEXTURE_CUBE_MAP,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_LINEAR);

        for(int i = 0; i < resources.length; i++){
            DataBuffer buffer = loadIMGAndStoreAsBuffer("resources/textures/cubemaps/"+resources[i]);
            GL11.glTexImage2D(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_X + i,0,GL11.GL_RGBA,buffer.getWidth(),buffer.getHeight(),0,GL11.GL_RGBA,GL11.GL_UNSIGNED_BYTE,buffer.getData());
        }

        GL11.glBindTexture(GL13.GL_TEXTURE_CUBE_MAP,0);

        return id;
    }


    private DataBuffer loadIMGAndStoreAsBuffer(String path){
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(path));
            int width = image.getWidth();
            int height = image.getHeight();
            int pixels[] = new int[width * height];
            image.getRGB(0,0,width,height,pixels,0,width);

            int swizzleRGB[] = new int[width * height];

            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                    int pixel = pixels[x + y * width];
                    int a = (pixel & 0xff000000) >> 24;
                    int r = (pixel & 0xff0000) >> 16;
                    int g = (pixel & 0xff00) >> 8;
                    int b = (pixel & 0xff);

                    swizzleRGB[x + y * width] = (a << 24) | (b << 16) | (g << 8) | r;
                }
            }

            return new DataBuffer(width,height,swizzleRGB);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
