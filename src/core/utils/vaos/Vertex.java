package core.utils.vaos;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Vertex {

        public static final int VERTEX_POSITION_ONLY = 1;
        public static final int VERTEX_POSITION_UV = 2;
        public static final int VERTEX_INFORMATION_COMPLETE = 3;

        private int vertexIndex;
        private Vector3f position;
        private Vector2f uvs;
        private Vector3f normal;

        private int whatInformationIsStored;

        public Vertex(Vector3f position) {
                this.position = position;
                this.whatInformationIsStored = VERTEX_POSITION_ONLY;
        }
        public Vertex(Vector3f position, Vector2f uvs) {
                this(position);
                this.uvs = uvs;
                this.whatInformationIsStored = VERTEX_POSITION_UV;
        }
        public Vertex(Vector3f position, Vector2f uvs, Vector3f normal) {
                this(position,uvs);
                this.normal = normal;
                this.whatInformationIsStored = VERTEX_INFORMATION_COMPLETE;
        }
        public Vertex(int vertexIndex,Vector3f position, Vector2f uvs, Vector3f normal) {
                this(position,uvs,normal);
                this.vertexIndex = vertexIndex;
        }
        public String toString(){
                return "ID: "+vertexIndex+" position: "+position.toString()+ "uvs: "+uvs.toString()+" normals: "+normal.toString()+" \n";
        }
        public Vector3f getPosition() {
                return position;
        }

        public Vector2f getUvs() {
                return uvs;
        }

        public Vector3f getNormal() {
                return normal;
        }

        public int gimmeInformationAboutYou(){
               return whatInformationIsStored;
        }

        public int getVertexIndex() {
                return vertexIndex;
        }
}
