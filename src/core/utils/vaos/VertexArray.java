package core.utils.vaos;

import core.utils.BuffersHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.util.List;

public class VertexArray implements IVao {

    private int vaoID;
    private VertexBufferObject vbos;
    private int totalVertices;

    public VertexArray(List<Vertex> vertices) {
        vaoID = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vaoID);
        vbos = new VertexBufferObject(vertices);
        GL30.glBindVertexArray(0);
        this.totalVertices = vertices.size();
    }

    @Override
    public void enable() {
        GL30.glBindVertexArray(vaoID);
    }
    @Override
    public void disable() {
        GL30.glBindVertexArray(0);
    }
    @Override
    public void paint() {
        GL11.glDrawArrays(GL11.GL_TRIANGLES , 0 , totalVertices);
    }
    @Override
    public void render() {
        enable();
        paint();
        disable();
    }
    @Override
    public int getTotalVertices() {
        return totalVertices;
    }
}
