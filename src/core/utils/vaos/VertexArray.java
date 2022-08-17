package core.utils.vaos;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

import java.util.List;

public class VertexArray implements IVao {

    private int vaoID;
    private VertexBufferObject vbos;
    private int totalVertices;
    private boolean usesAIndexBufferObject;

    public VertexArray(List<Vertex> vertices) {
        vaoID = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vaoID);
        vbos = new VertexBufferObject(vertices);
        GL30.glBindVertexArray(0);
        this.totalVertices = vertices.size();
    }
    public VertexArray(List<Vertex> vertices,List<Integer> indicesList) {
        vaoID = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vaoID);
        vbos = new VertexBufferObject(vertices , indicesList);
        GL30.glBindVertexArray(0);
        this.usesAIndexBufferObject = true;
        this.totalVertices = indicesList.size();
    }
    @Override
    public void enable() {
        GL30.glBindVertexArray(vaoID);
        if(usesAIndexBufferObject){
            vbos.bindIbo();
        }
    }
    @Override
    public void disable() {
        GL30.glBindVertexArray(0);
        if(usesAIndexBufferObject){
            vbos.unbindIbo();
        }
    }
    @Override
    public void paint() {
        if(usesAIndexBufferObject){
            GL11.glDrawElements(GL11.GL_TRIANGLES,totalVertices,GL11.GL_UNSIGNED_INT,0);
        }
        else{
            GL11.glDrawArrays(GL11.GL_TRIANGLES , 0 , totalVertices);
        }
    }
    @Override
    public void paint(int paintMode){
        if(usesAIndexBufferObject){
            GL11.glDrawElements(GL11.GL_TRIANGLES,totalVertices,GL11.GL_UNSIGNED_INT,0);
        }
        else{
            GL11.glDrawArrays(paintMode , 0 , totalVertices);
        }

    }
    @Override
    public void render() {
        enable();
        paint();
        disable();
    }
    public void render(int paintMode) {
        if(paintMode == GL11.GL_POINTS){
              GL11.glPointSize(8f);
        }
        enable();
        paint(paintMode);
        disable();
    }
    @Override
    public int getTotalVertices() {
        return totalVertices;
    }
}
