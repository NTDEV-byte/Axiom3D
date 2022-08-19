package core.scene;

import core.Window;
import core.scene.camera.Camera;
import core.scene.camera.FirstCamera;
import core.scene.entity.Entity;
import core.scene.entity.IEntity;
import light.Light;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import java.util.ArrayList;
import java.util.List;

public abstract class Scene implements IScene {

    public static final Vector3f X_AXIS = new Vector3f(1,0,0);
    public static final Vector3f Y_AXIS = new Vector3f(0,1,0);
    public static final Vector3f Z_AXIS = new Vector3f(0,0,1);

    public static final Matrix4f PROJECTION_MATRIX  = createPerspectiveProjection(
                                                                               70.0f ,
                                                                                   Window.WIDTH,
                                                                                   Window.HEIGHT,
                                                                             0.1f ,
                                                                              1000.0f);
    public static final Camera MAIN_CAMERA = new FirstCamera(new Vector3f(0,0,0));
    public static final Light SUN_LIGHT = new Light(new Vector3f(0,1000_000_000,0) , new Vector3f(1,1,1));

    protected List<Entity> entities;
    protected Scene(){
        entities = new ArrayList<>();
        this.addItemsOnStartScene();
    }

    protected abstract void addItemsOnStartScene();
    @Override
    public void addEntity(IEntity entity) {
        entities.add((Entity) entity);
    }
    @Override
    public void removeEntity(IEntity entity) {
        entities.remove((Entity) entity);
    }
    @Override
    public void update() {
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).update();
        }
        MAIN_CAMERA.update();
    }
    @Override
    public void render() {
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).render();
        }
    }

    // see http://www.songho.ca/opengl/gl_projectionmatrix.html for more details
    public static Matrix4f createPerspectiveProjection(float fov,float width,float height,float zNear,float zFar){
        float halfFOV = (float)(Math.tan(Math.toRadians(fov / 2f)));
        float aspectRatio = width / height;
        float zRange = zFar - zNear;

        Matrix4f projectionMatrix = new Matrix4f();
        projectionMatrix.setIdentity();
        projectionMatrix.m00 = 1.0f / (halfFOV * aspectRatio);
        projectionMatrix.m11 = 1.0f / halfFOV;
        projectionMatrix.m22 = (-zFar - zNear) / zRange;
        projectionMatrix.m32 = -(2 * zFar * zNear) / zRange;
        projectionMatrix.m23 = -1.0f;

        return projectionMatrix;

    }
}
