package core.scene;

import core.scene.entity.IEntity;

public interface IScene {

        public void addItemsOnStartScene();
        public void addEntity(IEntity entity);
        public void removeEntity(IEntity entity);
        public void update();
        public void render();

}
