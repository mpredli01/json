package org.redlich.json.jackson;

import org.redlich.json.Publication;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class Application {

    public static final String JSON_FILE = "publications.json";

    public static void main(String[] args) {
        Application application = new Application();
        Publication publication = new Publication();

        run("Parser",application::parserDemo);
        }

    private void parserDemo() {
        try {
            Reader reader = new FileReader(JSON_FILE);
            JsonParser jsonParser = new JsonFactory().createParser(reader);
            while(!jsonParser.isClosed()){
                JsonToken jsonToken = jsonParser.nextToken();
                System.out.println("jsonToken: " + jsonToken + ": " + jsonParser.getCurrentName() + ": " + jsonParser.getValueAsString());
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
