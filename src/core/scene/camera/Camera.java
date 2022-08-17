package core.scene.camera;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;


public class Camera implements ICamera {

    protected Matrix4f viewMatrix;
    protected Vector3f position;
    protected Vector3f rotation;
    protected Vector3f invPosition;

    public Camera(Vector3f position){
        this.position = position;
        this.rotation = new Vector3f();
        this.viewMatrix = new Matrix4f();
        this.invPosition = new Vector3f();
    }

    @Override
    public Matrix4f getEyeSpace() {
        return null;
    }
}
