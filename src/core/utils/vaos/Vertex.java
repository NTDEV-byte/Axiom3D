package core.utils.vaos;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Vertex {

        private Vector3f position;
        private Vector2f uvs;
        private Vector3f normal;

        public Vertex(Vector3f position) {
                this.position = position;
        }
        public Vertex(Vector3f position, Vector2f uvs) {
                this(position);
                this.uvs = uvs;
        }

        public Vertex(Vector3f position, Vector2f uvs, Vector3f normal) {
                this(position,uvs);
                this.normal = normal;
        }


        public Vector3f getPosition() {
                return position;
        }

        public void setPosition(Vector3f position) {
                this.position = position;
        }

        public Vector2f getUvs() {
                return uvs;
        }

        public void setUvs(Vector2f uvs) {
                this.uvs = uvs;
        }

        public Vector3f getNormal() {
                return normal;
        }

        public void setNormal(Vector3f normal) {
                this.normal = normal;
        }
}
