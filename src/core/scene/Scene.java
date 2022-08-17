package core.scene;

import core.scene.camera.Camera;
import core.scene.camera.FirstCamera;
import core.scene.entity.Entity;
import core.scene.entity.IEntity;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene implements IScene {

    public static final Vector3f X_AXIS = new Vector3f(1,0,0);
    public static final Vector3f Y_AXIS = new Vector3f(0,1,0);
    public static final Vector3f Z_AXIS = new Vector3f(0,0,1);

    public static final Matrix4f PROJECTION_MATRIX  = null;
    public static final Camera MAIN_CAMERA = new FirstCamera(new Vector3f(0,0,0));
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
    }
    @Override
    public void render() {
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).render();
        }
    }

}
