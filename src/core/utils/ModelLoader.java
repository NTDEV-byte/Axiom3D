package core.utils;

import core.utils.vaos.Vertex;
import core.utils.vaos.VertexArray;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelLoader {

            private ModelLoader(){}
            public static VertexArray loadModel(String path) {

                    List<Vertex> verticesData = new ArrayList<>();

                    List<Vector3f> positions = new ArrayList<>();
                    List<Vector2f> uvs = new ArrayList<>();
                    List<Vector3f> normals = new ArrayList<>();
                    List<Integer> indices = new ArrayList<>();

                    String line;
                    String tokens[];

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(path));

                        while((line = reader.readLine()) !=  null){


                              if(line.startsWith("v ")){
                                  tokens = line.split(" ");
                                  positions.add(new Vector3f(Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2]),Float.parseFloat(tokens[3])));
                              }

                              if(line.startsWith("vt ")){
                                  tokens = line.split(" ");
                                  uvs.add(new Vector2f(Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2])));
                              }

                              if(line.startsWith("vn ")){
                                  tokens = line.split(" ");
                                  normals.add(new Vector3f(Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2]),Float.parseFloat(tokens[3])));
                              }

                              if(line.startsWith("f ")){
                                  break;
                              }
                        }

                        reader = new BufferedReader(new FileReader(path));

                        while((line = reader.readLine()) !=  null){

                                if(!line.startsWith("f ")) continue;

                                tokens = line.split(" ");

                                String vertex1[] = tokens[1].split("/");
                                String vertex2[] = tokens[2].split("/");
                                String vertex3[] = tokens[3].split("/");

                                storeVertexInfo(vertex1,verticesData,positions,uvs,normals,indices);
                                storeVertexInfo(vertex2,verticesData,positions,uvs,normals,indices);
                                storeVertexInfo(vertex3,verticesData,positions,uvs,normals,indices);
                        }

                        return new VertexArray(verticesData,indices);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
            private static void storeVertexInfo(String vertexInfo[],List<Vertex> verticesData,List<Vector3f> positions,List<Vector2f> uvs,List<Vector3f> normals,List<Integer> indices){

                    int vertexIndex  =  Integer.parseInt(vertexInfo[0]) - 1;
                    int textureIndex =  Integer.parseInt(vertexInfo[1]) - 1;
                    int normalIndex  =  Integer.parseInt(vertexInfo[2]) - 1;

                    Vector2f uv = uvs.get(textureIndex);
                    uv.y = uv.y - 1;

                    verticesData.add(new Vertex(vertexIndex,positions.get(vertexIndex) , uvs.get(textureIndex) , normals.get(normalIndex)));
                    indices.add(vertexIndex);
            }

}
