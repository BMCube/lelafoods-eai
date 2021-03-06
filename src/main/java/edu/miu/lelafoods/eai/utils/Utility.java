package edu.miu.lelafoods.eai.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility {
    public String cartToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String ObjectToJson = "";
        try {
            ObjectToJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(object.getClass().getSimpleName() + " Object to Json converted: " + ObjectToJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ObjectToJson;
    }
}
