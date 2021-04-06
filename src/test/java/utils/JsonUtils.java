package utils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;


public class JsonUtils {
    private String value;

    public JSONObject updateJsonByKey(JSONObject obj, String keyMain, String newValue) throws Exception {

        Iterator iterator = obj.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();

            if ((obj.optJSONArray(key) == null) && (obj.optJSONObject(key) == null)) {
                if ((key.equals(keyMain))) {
                    obj.put(key, newValue);
                    return obj;
                }
            }

            if (obj.optJSONObject(key) != null) {
                updateJsonByKey(obj.getJSONObject(key), keyMain, newValue);
            }

            if (obj.optJSONArray(key) != null) {
                JSONArray jArray = obj.getJSONArray(key);
                for (int i = 0; i < jArray.length(); i++) {
                    updateJsonByKey(jArray.getJSONObject(i), keyMain, newValue);
                }
            }
        }
        return obj;
    }

    public JSONObject parseJSONFile(String filename) throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/templates/" + filename)));
        return new JSONObject(content);
    }

    public JSONObject setJsonValueByKey(String fileName, Map<String, String> required) throws IOException, JSONException {
        JSONObject json = parseJSONFile("jsonTemplate/" + fileName);
        JSONObject newJson = null;
        for (Map.Entry<String, String> entry : required.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                newJson = updateJsonByKey(json, key, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newJson;
    }

    public String getJsonValueByKey(JSONObject obj, String keyMain) throws JSONException {

        Iterator iterator = obj.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();

            if ((obj.optJSONArray(key) == null) && (obj.optJSONObject(key) == null)) {
                if ((key.equals(keyMain))) {
                    value = obj.get(key).toString();
                }
            }


            if (obj.optJSONObject(key) != null) {
                getJsonValueByKey(obj.getJSONObject(key), keyMain);
            }

            if (obj.optJSONArray(key) != null) {
                JSONArray jArray = obj.getJSONArray(key);
                for (int i = 0; i < jArray.length(); i++) {
                    getJsonValueByKey(jArray.getJSONObject(i), keyMain);
                }
            }
        }
        return value;
    }

    public JSONObject removeValuesByKey(JSONObject body, String reqField) throws JSONException {
        Iterator iterator = body.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();

            if ((body.optJSONArray(key) == null) && (body.optJSONObject(key) == null)) {
                if ((key.equals(reqField))) {
                    body.remove(key);
                    return body;
                }
            }

            if (body.optJSONObject(key) != null) {
                removeValuesByKey(body.getJSONObject(key), reqField);
            }

            if (body.optJSONArray(key) != null) {
                JSONArray jArray = body.getJSONArray(key);
                for (int i = 0; i < jArray.length(); i++) {
                    removeValuesByKey(jArray.getJSONObject(i), reqField);
                }
            }
        }
        return body;
    }
}

