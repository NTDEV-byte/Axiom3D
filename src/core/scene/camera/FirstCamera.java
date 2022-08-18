package core.scene.camera;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class FirstCamera extends Camera {

    private float sensitivity = 0.2f;
    private float rotationSpeed = 0.2f;
    private float moveSpeed = 0.2f;

    public FirstCamera(Vector3f position) {
        super(position);
    }

    @Override
    protected void keyBoardInput() {

        float cos = (float)(Math.cos(Math.toRadians(rotation.y)));
        float sin = (float)(Math.sin(Math.toRadians(rotation.y)));

        if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
                position.x += sin * moveSpeed;
                position.z -= cos * moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
                position.x += cos * moveSpeed;
                position.z += sin * moveSpeed;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
                position.x -= sin * moveSpeed;
                position.z += cos * moveSpeed;
            }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
                position.x += cos * moveSpeed;
                position.z -= sin * moveSpeed;
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
              rotation.y += Mouse.getDX() * sensitivity;
        }
        if(Mouse.isButtonDown(1)){
              rotation.x += Mouse.getDY() * sensitivity;
        }
    }

}
