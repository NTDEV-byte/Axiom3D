package core.utils.vaos;

import core.utils.BuffersHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.util.List;

public class VertexBufferObject {

        private static final int POSITIONS_LOCATION = 0;
        private static final int UVS_LOCATIONS = 1;
        private static final int NORMALS_LOCATIONS = 2;

        private int vbo,tbo,nbo;
        private int ibo;
        private float positions[];
        private float uvs[];
        private float normals[];
        private int indices[];
        private Vertex axiom;
        private List<Vertex> vertices;
        private List<Integer> indicesList;

        public VertexBufferObject(List<Vertex> vertices){
                this.vertices = vertices;
                this.prepareVBO();
                this.createBuffersData();
        }

        // complete vao
        public VertexBufferObject(List<Vertex> vertices,List<Integer> indicesList){
                this.vertices = vertices;
                this.indicesList = indicesList;
                this.prepareVBO();
                this.createBuffersData();
                this.createIndexBufferObject();
        }

        public void bindIbo(){
                GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER,ibo);
        }
        public void unbindIbo(){
                GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER,0);
        }
        private void createIndexBufferObject(){
                indices = new int[indicesList.size()];
                for(int i = 0; i < indices.length; i++){
                         indices[i] = indicesList.get(i);
                }
                ibo = GL15.glGenBuffers();
                GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER , ibo);
                GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, BuffersHelper.createIntBuffer(indices) , GL15.GL_STATIC_DRAW);
        }
        private void createBuffersData(){
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

                for(Vertex vertex : vertices){

                        Vector3f position = vertex.getPosition();
                        Vector2f uv = vertex.getUvs();
                        Vector3f normal = vertex.getNormal();

                        positions[vertex.getVertexIndex() * 3] = position.x;
                        positions[vertex.getVertexIndex() * 3 + 1] = position.y;
                        positions[vertex.getVertexIndex() * 3 + 2] = position.z;

                        uvs[vertex.getVertexIndex() * 2] = uv.x;
                        uvs[vertex.getVertexIndex() * 2 + 1] = 1 - uv.y;

                        normals[vertex.getVertexIndex()  * 3] = normal.x;
                        normals[vertex.getVertexIndex()  * 3 + 1] = normal.y;
                        normals[vertex.getVertexIndex()  * 3 + 2] = normal.z;

                }
        }
}
