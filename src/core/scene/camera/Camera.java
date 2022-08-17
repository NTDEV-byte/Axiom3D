package core.scene.camera;

import core.scene.Scene;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import static core.scene.Scene.*;


public abstract class Camera implements ICamera {

    protected Matrix4f viewMatrix;
    protected Vector3f position;
    protected Vector3f rotation;
    protected Vector3f invPosition;

    protected Camera(Vector3f position){
        this.position = position;
        this.rotation = new Vector3f();
        this.viewMatrix = new Matrix4f();
        this.invPosition = new Vector3f();
    }
    public void update(){
        this.keyBoardInput();
        this.mouseInput();
    }
    protected abstract void keyBoardInput();
    protected abstract void mouseInput();

    @Override //  let me see through your eyes
    public Matrix4f getEyeSpace() {
        viewMatrix.setIdentity();
        viewMatrix.rotate((float)(Math.toRadians(rotation.x)) , X_AXIS);
        viewMatrix.rotate((float)(Math.toRadians(rotation.y)) , Y_AXIS);
        viewMatrix.rotate((float)(Math.toRadians(rotation.z)) , Z_AXIS);
        invPosition.set(-position.x , -position.y , -position.z);
        viewMatrix.translate(invPosition);
        return viewMatrix;
    }
}
