package core.utils.vaos;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.nio.Buffer;
import java.util.List;

public class VertexBufferObject {

        private float positions[];
        private float uvs[];
        private float normals[];
        private Vertex axiom;
        private List<Vertex> vertices;
        private List<Buffer> buffers;

        public VertexBufferObject(List<Vertex> vertices){
                this.vertices = vertices;
                this.prepareVBO();
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
