package core.utils.shaders;

import core.utils.FileLoader;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

public class Shader implements IShader{

        private int id;
        private Map<String,Integer> uniforms = new HashMap<>();

        private FloatBuffer buffer = FloatBuffer.allocate(4 * 4);

        public Shader(String vertexPath,String fragmentPath){
            id = createShaderVFProgram(vertexPath , fragmentPath);
        }

        public Shader(String vertexPath,String geometryPath, String fragmentPath){
            id = createShaderVGFProgram(vertexPath , geometryPath , fragmentPath);
        }


        @Override
        public void enable() {
            GL20.glUseProgram(id);
        }

        @Override
        public void disable() {
            GL20.glUseProgram(0);
        }

        @Override
        public void loadUniform1i(String name, int value) {
            GL20.glUniform1i(getUniformLocation(name) , value);
        }

        @Override
        public void loadUniform1f(String name, float value) {
            GL20.glUniform1f(getUniformLocation(name) , value);
        }

        @Override
        public void loadUniform2f(String name, Vector2f vec2) {
            GL20.glUniform2f(getUniformLocation(name) , vec2.x , vec2.y);
        }

        @Override
        public void loadUniform3f(String name, Vector3f vec3) {
            GL20.glUniform3f(getUniformLocation(name) , vec3.x , vec3.y , vec3.z);
        }

        @Override
        public void loadUniformMatrix4FV(String name, Matrix4f matrix) {
             matrix.store(buffer);
             buffer.flip();
             GL20.glUniformMatrix4(getUniformLocation(name) , false , buffer);
        }
        private int getUniformLocation(String name){
            if(uniforms.containsKey(name)){
                return uniforms.get(name);
            }
            int uniLocation = GL20.glGetUniformLocation(id , name);
            uniforms.put(name, uniLocation);
            return uniLocation;
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
                System.err.println("Erreur lors de la compilation du Vertex Shader: "+vertexPath);
                System.err.println(GL20.glGetShaderInfoLog(vertexID , 1000));
            }
            GL20.glShaderSource(fragmentID , fragmentContent);
            GL20.glCompileShader(fragmentID);
            if(GL20.glGetShaderi(fragmentID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE){
                System.err.println("Erreur lors de la compilation du Fragment Shader: "+fragmentPath);
                System.err.println(GL20.glGetShaderInfoLog(fragmentID , 1000));
            }

            GL20.glAttachShader(programID,vertexID);
            GL20.glAttachShader(programID,fragmentID);

            GL20.glLinkProgram(programID);
            GL20.glValidateProgram(programID);

            GL20.glDeleteShader(vertexID);
            GL20.glDeleteShader(fragmentID);

            return programID;
        }

        private int createShaderVGFProgram(String vertexPath,String geometryPath,String fragmentPath){

            String vertexContent = FileLoader.loadFile(vertexPath);
            String geometryContent = FileLoader.loadFile(geometryPath);
            String fragmentContent = FileLoader.loadFile(fragmentPath);

            int programID = GL20.glCreateProgram();
            int vertexID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
            int geomID = GL20.glCreateShader(GL32.GL_GEOMETRY_SHADER);
            int fragmentID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);

            GL20.glShaderSource(vertexID , vertexContent);
            GL20.glCompileShader(vertexID);
            if(GL20.glGetShaderi(vertexID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE){
                System.err.println("Erreur lors de la compilation du Vertex Shader: "+vertexPath);
            }

            GL20.glShaderSource(geomID ,geometryContent);
            GL20.glCompileShader(geomID);
            if(GL20.glGetShaderi(geomID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE){
                System.err.println("Erreur lors de la compilation du Geometry Shader: "+geometryPath);
            }

            GL20.glShaderSource(fragmentID , fragmentContent);
            GL20.glCompileShader(fragmentID);
            if(GL20.glGetShaderi(fragmentID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE){
                System.err.println("Erreur lors de la compilation du Fragment Shader: "+fragmentPath);
            }

            GL20.glAttachShader(programID,vertexID);
            GL20.glAttachShader(programID,geomID);
            GL20.glAttachShader(programID,fragmentID);

            GL20.glLinkProgram(programID);
            GL20.glValidateProgram(programID);

            GL20.glDeleteShader(vertexID);
            GL20.glDeleteShader(geomID);
            GL20.glDeleteShader(fragmentID);

            return programID;
        }

}
