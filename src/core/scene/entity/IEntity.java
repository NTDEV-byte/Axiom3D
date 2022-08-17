package core.scene.entity;

public interface IEntity {

            // behaviour in 3D Space

            public void render();
            public void rotate(int pitch,int yaw,int roll);
            public void move(int dx,int dy,int dz);


}
