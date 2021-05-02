import com.google.gson.*;
import org.json.simple.JSONObject;

import java.util.*;

public class JsonParsing {
    static JsonParser parser = new JsonParser();

    public static HashMap<String, Object> HashMapFromJsonString(String json) {

        JsonObject object = (JsonObject) parser.parse(json);
        Set<Map.Entry<String, JsonElement>> set = object.entrySet();
        Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        while (iterator.hasNext()) {

            Map.Entry<String, JsonElement> entry = iterator.next();
            String key = entry.getKey();
            JsonElement value = entry.getValue();

            if (null != value) {
                if (!value.isJsonPrimitive()) {
                    if (value.isJsonObject()) {
                        JSONObject val = new JSONObject(HashMapFromJsonString(value.toString()));
                        hashMap.put(key, val);
                        System.out.println(key + " " + val);

                    } else if (value.isJsonArray() && value.toString().contains(":")) {

                        List<HashMap<String, Object>> list = new ArrayList<>();
                        JsonArray array = value.getAsJsonArray();
                        if (null != array) {
                            for (JsonElement element : array) {
                                list.add(HashMapFromJsonString(element.toString()));
                            }
                            hashMap.put(key, list);
                            System.out.println(key + " " + list);
                        }
                    } else if (value.isJsonArray() && !value.toString().contains(":")) {
                        hashMap.put(key, value.getAsJsonArray());
                        System.out.println(key + " " + value.getAsJsonArray());
                    }
                } else {
                    hashMap.put(key, value.getAsString());
                    System.out.println(key + " " + value.getAsString());
                }
            }
        }
        return hashMap;
    }
}