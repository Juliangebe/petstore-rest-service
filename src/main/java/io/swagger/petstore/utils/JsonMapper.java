package io.swagger.petstore.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

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
        //jsonJavaRootObject = new Gson().fromJson(petBody, HashMap.class);
    }


}
