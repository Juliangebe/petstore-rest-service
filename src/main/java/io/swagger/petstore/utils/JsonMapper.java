package io.swagger.petstore.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.petstore.models.UserModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

public class JsonMapper {


    public static Map<String, String> jsonStringToMap(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map
                = mapper.readValue(new String(Files.readAllBytes(Paths.get(path))),
                Map.class);

        return map;
    }

    public static String jsonToString(String path) throws IOException {
        return
                new String(Files.readAllBytes(Paths.get(path)));
    }

    public static Object jsonStringToModel(String body, Class className) {

        ObjectMapper mapper = new ObjectMapper();
        Object object = Optional.empty();

        try {

            object = mapper.readValue(body, className);


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }


}

