package org.redlich.json.gson;

import org.redlich.json.Publication;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import com.google.gson.stream.JsonReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Application {

    public static final String JSON_FILE = "publications.json";

    public static void main(String[] args){
        Application application = new Application();
        Publication publication = new Publication();

        run("Parser",application::parserDemo);
        }

    private void parserDemo() {
        try {
            Reader reader = new FileReader(JSON_FILE);
            JsonParser parser = new JsonParser();
            JsonElement jsonTree = parser.parse(reader);
            if(jsonTree.isJsonObject()) {
                System.out.println("parsing a JsonObject...");
                }
            if(jsonTree.isJsonArray()) {
                JsonArray jsonArray = jsonTree.getAsJsonArray();
                for(int i = 0;i < jsonArray.size();++i) {
                    JsonElement publication = jsonArray.get(i);
                    System.out.println(i + ": " + publication);
                    }
                }
            if(jsonTree.isJsonNull()) {
                System.out.println("parsing a JsonNull...");
                }
            if(jsonTree.isJsonPrimitive()) {
                System.out.println("parsing a JsonPrimitive...");
                }
            reader.close();
            }
        catch(FileNotFoundException exception) {
            exception.printStackTrace();
            }
        catch(IOException exception) {
            exception.printStackTrace();
            }
        }

    private static void run(String name,Runnable method) {
        System.out.println();
        System.out.println("*** " + name + " Demo ***");
        method.run();
        }
    }
