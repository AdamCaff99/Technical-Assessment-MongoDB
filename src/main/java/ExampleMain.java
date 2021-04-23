import com.fasterxml.jackson.databind.JsonNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class ExampleMain {
    public static void main(String[] args) {
        System.out.println("----- ExampleMain started -------");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            String input = "";
            while (true) {
                if ((line = reader.readLine()) != null) {
                    input = input + line;
                } else {
                    //input finishes
                    break;
                }
            }
            System.out.println(input);
            /*Map<String, JsonNode> map = new JsonFlattener(input).flatten();

            System.out.println("Use key-value pairs:");
            map.forEach(
                    (k, v) -> {
                        System.out.println(k + " => " + v);
                    });*/
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
