package steps;

import api.ApiRequest;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import api.ApiHeaders;
import utils.JsonUtils;
import utils.PropertiesUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CrudUsuarioSteps extends ApiRequest {

    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();


    @Dado("que estou logado na api de cadastro")
    public void que_estou_logado_na_api_de_cadastro() throws IOException, JSONException {
        uri = prop.getProp("uri_cadastro") + "login";
        headers = ApiHeaders.setEmptyHeaders();
        body = jsonUtils.parseJSONFile("login.json");
        super.POST();
        token = response.jsonPath().getString("token");
    }

    @Quando("envio um requeste com dados validos")
    public void envio_um_requeste_com_dados_validos() throws IOException, JSONException {
        uri = prop.getProp("uri_cadastro") + "users";
        headers =  ApiHeaders.setHeaderUsers(token);
        body = jsonUtils.parseJSONFile("create_user.json");
        super.POST();
    }

    @Entao("o usuario de ser casdatrado corretamente")
    public void o_usuario_de_ser_casdatrado_corretamente() throws JSONException {
        assertEquals(body.getString("name"), response.jsonPath().getString("name"));
        assertEquals(body.getString("job"), response.jsonPath().getString("job"));
        assertNotNull(response.jsonPath().getString("id"));
    }

    @Entao("o status code da criação de usuário deve ser {int}")
    public void o_status_code_da_criação_de_usuário_deve_ser(Integer int1) {
        assertEquals(HttpStatus.SC_CREATED, response.statusCode());
    }
}
