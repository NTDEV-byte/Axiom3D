package core.scene.entity;

public interface IEntity {

            // behaviour in 3D Space

            public void update();
            public void render();
            public void rotate(float pitch,float yaw,float roll);
            public void move(float dx,float dy,float dz);


}
