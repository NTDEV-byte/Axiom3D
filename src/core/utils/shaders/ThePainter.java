package core.utils.shaders;

import core.scene.Scene;
import org.lwjgl.input.Keyboard;

public class ThePainter {

        private Scene scene;


        public ThePainter(Scene scene) {
            this.scene = scene;
        }

        public void update(){

        }

        private void listenForChangeAndApply(){

        }

        public enum ShaderType {
              POSITIONS,
              UVS,
              NORMALS,
              RAW,
              RAW_WITH_SOURCE_LIGHT,
              TEXTURED,
              TEXTURED_WITH_SOURCE_LIGHT
        }
}
