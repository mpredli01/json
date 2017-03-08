package org.redlich.json.jsonp;

import org.redlich.json.Publication;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import javax.json.JsonPointer;

public class Application {

    public static final String JSON_FILE = "publications.json";

    public static void main(String[] args) {
        Application application = new Application();
        Publication publications = new Publication();

        run("Parser",application::parserDemo);
        run("Factory Parser",application::factoryParserDemo);
        run("JsonPointer",application::pointerDemo);
        }

    private void parserDemo() {
        try {
            InputStream fis = new FileInputStream(JSON_FILE);
            JsonParser parser = Json.createParser(fis);
            while(parser.hasNext()) {
                JsonParser.Event event = parser.next();
                switch(event) {
                    case START_ARRAY:
                    case END_ARRAY:
                    case START_OBJECT:
                    case END_OBJECT:
                    case VALUE_FALSE:
                    case VALUE_NULL:
                    case VALUE_TRUE:
                        System.out.println(event.toString());
                        break;
                    case KEY_NAME:
                        System.out.print(event.toString() + " " + parser.getString() + " - ");
                        break;
                    case VALUE_STRING:
                    case VALUE_NUMBER:
                        System.out.println(event.toString() + " " + parser.getString());
                        break;
                    }
                }
            fis.close();
            }
        catch(FileNotFoundException exception) {
            exception.printStackTrace();
            }
        catch(IOException exception) {
            exception.printStackTrace();
            }
        }

    private void factoryParserDemo() {
        try {
            InputStream fis = new FileInputStream(JSON_FILE);
            JsonParserFactory factory = Json.createParserFactory(null);
            JsonParser parser = factory.createParser(fis);

            while(parser.hasNext()) {
                JsonParser.Event event = parser.next();
                switch(event) {
                    case KEY_NAME: {
                        System.out.print(parser.getString() + ": ");
                        break;
                        }
                    case VALUE_STRING: {
                        System.out.println(parser.getString());
                        break;
                        }
                    }
                }
            fis.close();
            }
        catch(FileNotFoundException exception) {
            exception.printStackTrace();
            }
        catch(IOException exception) {
            exception.printStackTrace();
            }
        }

    private void pointerDemo() {
        try {
            InputStream fis = new FileInputStream(JSON_FILE);
            JsonReader jsonReader = Json.createReader(fis);
            JsonArray jsonArray = jsonReader.readArray();

            for(int i = 0;i < jsonArray.size();++i) {
                JsonPointer pointer = Json.createPointer("/" + i + "/publication");
                JsonValue publication = pointer.getValue(jsonArray);
                System.out.println(i + ": " + publication);
                }
            fis.close();
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
