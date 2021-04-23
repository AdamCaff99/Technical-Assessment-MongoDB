import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;



public class JsonFlattener {

    private final Map<String, JsonNode> json = new LinkedHashMap<>(64);
    private final JsonNode root;


    JsonFlattener(JsonNode root) throws JsonProcessingException {
        this.root = root;
        /*ObjectMapper mapper = new ObjectMapper();
        System.out.println("testing1");
        this.root = mapper.readTree(input);
        System.out.println("testing2");*/

    }

    public Map<String, JsonNode> flatten() {
        process(root, "", 0);
        return json;
    }

    private void process(JsonNode node, String prefix, int depth) {
        if (node.isObject()) {
            ObjectNode object = (ObjectNode) node;
            object.fields().forEachRemaining(entry -> {
                if(depth==0){
                    process(entry.getValue(), entry.getKey(), depth+1);
                }
                else {
                    System.out.println(depth);
                    process(entry.getValue(), prefix + "." + entry.getKey(), depth + 1);
                }
            });
        } else {
            json.put(prefix, node);
        }
    }

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("C:\\Users\\adamc\\Desktop\\College\\3rd year\\Test-Maven\\src\\test.json");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonFile);
        Map<String, JsonNode> map = new JsonFlattener(root).flatten();

        System.out.println("Use key-value pairs:");
        map.forEach(
                (k, v) -> {
                    System.out.println(k + " => " + v);
                });
    }
}
