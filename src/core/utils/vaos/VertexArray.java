package core.utils.vaos;

public class VertexArray implements IVao {

    private int vaoID;
    private int vbo,
                tbo,
                nbo;
    private int ibo;
    private int dimension;

    public VertexArray(float positions[],int dimension) {

        this.dimension = dimension;
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public void paint() {

    }

    @Override
    public void render() {

    }

    @Override
    public int getTotalVertices() {
        return 0;
    }
}
