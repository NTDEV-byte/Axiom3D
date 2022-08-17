package core.utils.vaos;

import core.utils.BuffersHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class VertexBufferObject {


        private static final int POSITIONS_LOCATION = 0;
        private static final int UVS_LOCATIONS = 1;
        private static final int NORMALS_LOCATIONS = 2;


        private int vbo,tbo,nbo;
        private float positions[];
        private float uvs[];
        private float normals[];
        private Vertex axiom;
        private List<Vertex> vertices;

        public VertexBufferObject(List<Vertex> vertices){
                this.vertices = vertices;
                this.prepareVBO();
                this.createBuffers();
        }

        private void createBuffers(){
                switch (axiom.gimmeInformationAboutYou()) {
                        case Vertex.VERTEX_POSITION_ONLY -> {

                                vbo = GL15.glGenBuffers();
                                GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER , vbo);

                                GL15.glBufferData(GL15.GL_ARRAY_BUFFER, BuffersHelper.createFloatBuffer(positions) , GL15.GL_STATIC_DRAW);
                                GL20.glVertexAttribPointer(POSITIONS_LOCATION,3, GL11.GL_FLOAT,false,0,0);
                                GL20.glEnableVertexAttribArray(POSITIONS_LOCATION);

                        }
                        case Vertex.VERTEX_POSITION_UV -> {

                                vbo = GL15.glGenBuffers();
                                GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER , vbo);

                                GL15.glBufferData(GL15.GL_ARRAY_BUFFER, BuffersHelper.createFloatBuffer(positions) , GL15.GL_STATIC_DRAW);
                                GL20.glVertexAttribPointer(POSITIONS_LOCATION,3, GL11.GL_FLOAT,false,0,0);
                                GL20.glEnableVertexAttribArray(POSITIONS_LOCATION);

                                tbo = GL15.glGenBuffers();
                                GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER , tbo);

                                GL15.glBufferData(GL15.GL_ARRAY_BUFFER, BuffersHelper.createFloatBuffer(uvs) , GL15.GL_STATIC_DRAW);
                                GL20.glVertexAttribPointer(UVS_LOCATIONS,2, GL11.GL_FLOAT,false,0,0);
                                GL20.glEnableVertexAttribArray(UVS_LOCATIONS);
                        }
                        default -> {

                                vbo = GL15.glGenBuffers();
                                GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER , vbo);
                                GL15.glBufferData(GL15.GL_ARRAY_BUFFER, BuffersHelper.createFloatBuffer(positions) , GL15.GL_STATIC_DRAW);
                                GL20.glVertexAttribPointer(POSITIONS_LOCATION,3, GL11.GL_FLOAT,false,0,0);
                                GL20.glEnableVertexAttribArray(POSITIONS_LOCATION);


                                tbo = GL15.glGenBuffers();
                                GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER , tbo);
                                GL15.glBufferData(GL15.GL_ARRAY_BUFFER, BuffersHelper.createFloatBuffer(uvs) , GL15.GL_STATIC_DRAW);
                                GL20.glVertexAttribPointer(UVS_LOCATIONS,2, GL11.GL_FLOAT,false,0,0);
                                GL20.glEnableVertexAttribArray(UVS_LOCATIONS);


                                nbo = GL15.glGenBuffers();
                                GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER , nbo);
                                GL15.glBufferData(GL15.GL_ARRAY_BUFFER, BuffersHelper.createFloatBuffer(normals) , GL15.GL_STATIC_DRAW);
                                GL20.glVertexAttribPointer(NORMALS_LOCATIONS,3, GL11.GL_FLOAT,false,0,0);
                                GL20.glEnableVertexAttribArray(NORMALS_LOCATIONS);
                        }
                }
        }
        private void prepareVBO(){
                if(vertices.size() > 0){
                        this.axiom = vertices.get(0);
                        switch (axiom.gimmeInformationAboutYou()) {
                                case Vertex.VERTEX_POSITION_ONLY -> {
                                        extractVertexInformationOnlyPositions();
                                }
                                case Vertex.VERTEX_POSITION_UV -> {
                                        extractVertexInformationPU();
                                }
                                default -> {
                                        extractVertexInformationPUN();
                                }
                        }
                }
                else {
                        System.err.println("There is no data inside the arrayList !");
                }

        }

        private void extractVertexInformationOnlyPositions(){
                positions = new float[vertices.size() * 3];

                int vertexIndex = 0;

                for(Vertex vertex : vertices){

                        Vector3f position = vertex.getPosition();

                        positions[vertexIndex * 3] = position.x;
                        positions[vertexIndex * 3 + 1] = position.y;
                        positions[vertexIndex * 3 + 2] = position.z;

                        vertexIndex++;
                }
        }

        private void extractVertexInformationPU(){
                positions = new float[vertices.size() * 3];
                uvs = new float[vertices.size() * 2];

                int vertexIndex = 0;

                for(Vertex vertex : vertices){

                        Vector3f position = vertex.getPosition();
                        Vector2f uv = vertex.getUvs();

                        positions[vertexIndex * 3] = position.x;
                        positions[vertexIndex * 3 + 1] = position.y;
                        positions[vertexIndex * 3 + 2] = position.z;

                        uvs[vertexIndex * 2] = uv.x;
                        uvs[vertexIndex * 2 + 1] = uv.y;

                        vertexIndex++;
                }
        }

        private void extractVertexInformationPUN(){
                positions = new float[vertices.size() * 3];
                uvs = new float[vertices.size() * 2];
                normals = new float[vertices.size() * 3];

                int vertexIndex = 0;

                for(Vertex vertex : vertices){

                        Vector3f position = vertex.getPosition();
                        Vector2f uv = vertex.getUvs();
                        Vector3f normal = vertex.getNormal();

                        positions[vertexIndex * 3] = position.x;
                        positions[vertexIndex * 3 + 1] = position.y;
                        positions[vertexIndex * 3 + 2] = position.z;

                        uvs[vertexIndex * 2] = uv.x;
                        uvs[vertexIndex * 2 + 1] = uv.y;

                        normals[vertexIndex * 3] = normal.x;
                        normals[vertexIndex * 3] = normal.y;
                        normals[vertexIndex * 3] = normal.z;

                        vertexIndex++;
                }
        }
}
