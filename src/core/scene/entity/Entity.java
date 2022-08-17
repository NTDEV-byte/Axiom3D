package core.scene.entity;

import core.scene.camera.ICamera;
import core.utils.shaders.Shader;
import core.utils.textures.Texture;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public abstract class Entity implements IEntity {


    protected VertexArray mesh;
    protected Shader shader;
    protected Texture texture;

    protected Vector3f position;
    protected Vector3f rotation;
    protected Vector3f scale;

    protected Matrix4f modelMatrix;


    public Entity(VertexArray mesh, Shader shader, Vector3f position) {
        this.mesh = mesh;
        this.shader = shader;
        this.position = position;
    }

    public Entity(VertexArray mesh, Shader shader, Vector3f position, float scalar) {
        this(mesh,shader,position);
        this.scale = new Vector3f(scalar,scalar,scalar);
    }

    public Entity(VertexArray mesh, Shader shader, Vector3f position,Texture texture) {
        this.mesh = mesh;
        this.shader = shader;
        this.position = position;
        this.texture = texture;
    }
    public Entity(VertexArray mesh, Shader shader,Vector3f position,Texture texture,float scalar) {
        this(mesh,shader,position,texture);
        this.scale = new Vector3f(scalar,scalar,scalar);
    }

    // init
    private void initDefault(){}
    private void initScaled(){}


    // entity related behaviour
    protected abstract void update();

    @Override
    public void render() {

    }

    @Override
    public void rotate(int pitch, int yaw, int roll) {

    }

    @Override
    public void move(int dx, int dy, int dz) {

    }

    // shader data loading

    protected void loadModelMatrix(){}

    protected void loadViewMatrix(ICamera camera){}

    protected void loadProjectionMatrix(){}
}
