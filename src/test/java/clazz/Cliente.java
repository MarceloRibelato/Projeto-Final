package clazz;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

import java.util.List;

public record Cliente(
        String nome,
        String phone,
        String idade,
        List<Endereco> enderecos
)

{
    public JSONObject getJson() {
        return new JSONObject(new Gson().toJson(this));
    }

    public String getXml() {
        return XML.toString(getJson());
    }
}
