package core.utils.vaos;

public interface IVao {

        public void enable();
        public void disable();
        public void paint();
        public void paint(int paintMode);
        public void render();
        public int getTotalVertices();
}
