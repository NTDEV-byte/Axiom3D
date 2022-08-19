package light;

import org.lwjgl.util.vector.Vector3f;

public class Light {

        private Vector3f position;
        private Vector3f color;
        private float ambient = 0.3f;
        private float intensity = 8f;
        private float reflectivity = 0.01f;

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

        public void setPosition(Vector3f position) {
                this.position = position;
        }

        public void setColor(Vector3f color) {
                this.color = color;
        }

        public void setAmbient(float ambient) {
                this.ambient = ambient;
        }

        public void setIntensity(float intensity) {
                this.intensity = intensity;
        }

        public void setReflectivity(float reflectivity) {
                this.reflectivity = reflectivity;
        }
}
