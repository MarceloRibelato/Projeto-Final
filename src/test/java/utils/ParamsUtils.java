package utils;

import java.util.HashMap;
import java.util.Map;

public class ParamsUtils {

    static Map<String, String> params = new HashMap<>();

    public static Map<String, String> getParams() {
        params.clear();
        params.put("StrRetorno", "xml");
        params.put("nCdServico", "04510");
        params.put("sCepOrigem", "74371520");
        params.put("sCepDestino", "13175613");
        params.put("nVlPeso", "1.00");
        params.put("nVlComprimento", "36.00");
        params.put("nVlAltura", "18.00");
        params.put("nVlLargura", "12.00");
        return params;
    }

    public static Map<String, String> setParams(Map<String, String> maps) {
        params.clear();
        maps.entrySet().stream().forEach(e -> params.put(e.getKey(), e.getValue()));
        return params;
    }

}
