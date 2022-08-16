package core.utils.shaders;

public class Shader implements IShader{

        private int id;

        public Shader(){

        }

        @Override
        public void enable() {

        }

        @Override
        public void disable() {

        }

        @Override
        public void loadUniform1i(String name, int value) {

        }

        @Override
        public void loadUniform1f(String name, int value) {

        }

        @Override
        public void loadUniform2f(String name, int value) {

        }

        @Override
        public void loadUniform3f(String name, int value) {

        }

        @Override
        public void loadUniformMatrix4FV(String name, int value) {

        }

        private int getUniformLocation(String name){
            return -1;
        }

        private void createShaderVFProgram(String vertexPath,String fragmentPath){}

        private void createShaderVGFProgram(String vertexPath,String geometryPath,String fragmentPath){}

        private void createShaderVTGFProgram(String vertexPath,String tesselationPath,String geometryPath,String fragmentPath){}


}
