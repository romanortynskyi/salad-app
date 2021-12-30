package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.util.List;

public class JsonUtils {
    private static ObjectMapper objectMapper = getObjectMapper();

    private static ObjectMapper getObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        return om;
    }

    public static <A> A parse(String json, Class<A> _class) throws JsonProcessingException {
        JsonNode node = objectMapper.readTree(json);
        return objectMapper.treeToValue(node, _class);
    }

    public static String stringify(Object o) throws JsonProcessingException {
        JsonNode node = objectMapper.valueToTree(o);
        ObjectWriter writer = objectMapper.writer();
        return writer.writeValueAsString(node);
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static <T> List<T> parseList(String json,
                                             Class<T> classOnWhichArrayIsDefined)
            throws IOException {
        JavaType javaType = getCollectionType(List.class, classOnWhichArrayIsDefined);
        List<T> list = (List<T>)objectMapper.readValue(json, javaType);
        return list;
    }

    public static String toJsonArray(List list) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(list);
        return json;
    }

}