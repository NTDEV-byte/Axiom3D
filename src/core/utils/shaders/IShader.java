package core.utils.shaders;

public interface IShader {

    public void enable();

    public void disable();

    public void loadUniform1i(String name,int value);

    public void loadUniform1f(String name,int value);

    public void loadUniform2f(String name,int value);

    public void loadUniform3f(String name,int value);

    public void loadUniformMatrix4FV(String name,int value);
}
