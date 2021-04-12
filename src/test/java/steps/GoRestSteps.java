package steps;

import api.ApiBody;
import api.ApiHeaders;
import api.ApiRequest;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import utils.PropertiesUtils;

import static org.junit.Assert.assertEquals;

public class GoRestSteps extends ApiRequest {

    PropertiesUtils prop = new PropertiesUtils();

    @Dado("que possou gorest token valido")
    public void que_possou_gorest_token_valido() {
        super.headers = ApiHeaders.setHeaderUsers(prop.getProp("gorest_token"));
    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() {
        super.uri = prop.getProp("gorest_uri");
        super.body = ApiBody.gerarBodyDefault();
        super.POST();
    }

    @Entao("o usuario deve ser criado corretamente")
    public void o_usuario_deve_ser_criado_corretamente() {
        assertEquals(super.body.getString("name"), response.jsonPath().getString("data.name"));
    }

    @Entao("o status code do request deve ser {int}")
    public void o_status_code_do_request_deve_ser(int status) {
        assertEquals(status, response.statusCode());
    }

}
