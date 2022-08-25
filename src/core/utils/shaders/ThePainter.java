package core.utils.shaders;

import core.scene.Scene;
import core.scene.entity.Entity;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ThePainter {

        private Scene scene;
        private ShaderType type;

        public ThePainter(Scene scene) {
            this.scene = scene;
        }

        public void update(){
            this.listenForChange();
            this.applyChange();
        }

        private void listenForChange(){
            if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD1)){
                this.type = ShaderType.POSITIONS;
            }

            if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2)){
                this.type = ShaderType.UVS;
            }

            if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD3)){
                this.type = ShaderType.NORMALS;
            }

            if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)){
                this.type = ShaderType.RAW;
            }

            if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD5)){
                this.type = ShaderType.RAW_WITH_SOURCE_LIGHT;
            }

            if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)){
                this.type = ShaderType.TEXTURED;
            }

            if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7)){
                this.type = ShaderType.TEXTURED_WITH_SOURCE_LIGHT;
            }
        }

        private Shader createOne(){
            switch (type){
                case POSITIONS:
                    return new Shader("" , "");

                case UVS:
                    return new Shader("" , "");

                case NORMALS:
                    return new Shader("" , "");

                case RAW:
                    return new Shader("" , "");

                case RAW_WITH_SOURCE_LIGHT:
                    return new Shader("" , "");

                case TEXTURED:
                    return new Shader("" , "");

                case TEXTURED_WITH_SOURCE_LIGHT:
                    return new Shader("" , "");
            }

            return new Shader("" , "");

        }
        private void applyChange(){
            List<Entity> items = scene.getEntities();
            for(Entity e : items){
                e.setShader(createOne());
            }
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
