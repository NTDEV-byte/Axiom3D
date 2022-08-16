package core.utils.shaders;

import core.utils.FileLoader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class Shader implements IShader{

        private int id;

        public Shader(String vertexPath,String fragmentPath){
            id = createShaderVFProgram(vertexPath , fragmentPath);
        }

        public Shader(String vertexPath,String geometryPath, String fragmentPath){
            id = createShaderVGFProgram(vertexPath , geometryPath , fragmentPath);
        }

        public Shader(String vertexPath,String tesselationPath,String geometryPath,String fragmentPath){
            id = createShaderVTGFProgram(vertexPath,tesselationPath , geometryPath, fragmentPath);
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

        private int createShaderVFProgram(String vertexPath,String fragmentPath){
            String vertexContent = FileLoader.loadFile(vertexPath);
            String fragmentContent = FileLoader.loadFile(fragmentPath);

            int programID = GL20.glCreateProgram();
            int vertexID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
            int fragmentID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);

            GL20.glShaderSource(vertexID , vertexContent);
            GL20.glCompileShader(vertexID);
            if(GL20.glGetShaderi(vertexID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE){
                System.err.println("Erreur lors de la compilation du vertexShader: "+vertexPath);
            }
            GL20.glShaderSource(fragmentID , fragmentContent);
            GL20.glCompileShader(fragmentID);
            if(GL20.glGetShaderi(fragmentID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE){
                System.err.println("Erreur lors de la compilation du fragmentShader: "+fragmentPath);
            }

            GL20.glAttachShader(programID,vertexID);
            GL20.glAttachShader(programID,fragmentID);

            GL20.glLinkProgram(programID);
            GL20.glValidateProgram(programID);

            GL20.glDeleteShader(vertexID);
            GL20.glDeleteShader(fragmentID);

            return programID;
        }

        private int createShaderVGFProgram(String vertexPath,String geometryPath,String fragmentPath){}

        private int createShaderVTGFProgram(String vertexPath,String tesselationPath,String geometryPath,String fragmentPath){}


}
