package core.scene;

import core.scene.entity.Entity;
import core.scene.entity.IEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class Scene implements IScene {
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
