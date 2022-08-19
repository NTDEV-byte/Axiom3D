package light;

import org.lwjgl.util.vector.Vector3f;

public class Light {

        private Vector3f position;
        private Vector3f color;
        private float ambient;
        private float intensity;
        private float reflectivity;

        public Light(Vector3f position, Vector3f color) {
                this.position = position;
                this.color = color;
        }

        public Vector3f getPosition() {
                return position;
        }

        public Vector3f getColor() {
                return color;
        }

        public float getAmbient() {
                return ambient;
        }

        public float getIntensity() {
                return intensity;
        }

        public float getReflectivity() {
                return reflectivity;
        }
}
