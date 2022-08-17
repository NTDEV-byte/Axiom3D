package core.scene.camera;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class FirstCamera extends Camera {

    private float sensitivity = 0.2f;
    private float rotationSpeed = 0.2f;
    private float moveSpeed = 0.2f;

    protected FirstCamera(Vector3f position) {
        super(position);
    }

    @Override
    protected void keyBoardInput() {
        if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
                position.z -= moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
                position.x += moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
               position.z += moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
                position.x -= moveSpeed;
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
                position.y += moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
                position.y -= moveSpeed;
        }
    }

    @Override
    protected void mouseInput() {
        if(Mouse.isButtonDown(0)){

        }
        if(Mouse.isButtonDown(1)){

        }
    }




}
