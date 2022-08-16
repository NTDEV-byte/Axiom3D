package core.utils.shaders;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public interface IShader {

    public void enable();

    public void disable();

    public void loadUniform1i(String name,int value);

    public void loadUniform1f(String name,float value);

    public void loadUniform2f(String name, Vector2f vec2);

    public void loadUniform3f(String name, Vector3f vec3);

    public void loadUniformMatrix4FV(String name, Matrix4f matrix);
}
