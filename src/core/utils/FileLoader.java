package core.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {


            private FileLoader(){}

            public static String loadFile(String fileName){

                StringBuilder builder = new StringBuilder();
                String line;

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));

                    while((line = reader.readLine()) != null){
                        builder.append(line).append("\n");
                    }

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
                    return new String(builder);
            }
}
