package core.utils.textures.cubby;

import core.utils.textures.Texture;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import javax.imageio.ImageIO;
import javax.xml.crypto.Data;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class CubeMapTexture extends Texture {



    public CubeMapTexture(String String[]) {

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
