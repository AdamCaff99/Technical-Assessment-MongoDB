import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    private static ObjectMapper  objectMapper= getObjectMapper();

    private static ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    public static JsonNode parse(String json) throws JsonProcessingException {
        return objectMapper.readTree(json);
    }
}
