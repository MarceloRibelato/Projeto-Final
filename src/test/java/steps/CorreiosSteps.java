package steps;

import api.ApiRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import api.ApiHeaders;
import api.ApiParams;
import utils.PropertiesUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CorreiosSteps extends ApiRequest {

    PropertiesUtils prop = new PropertiesUtils();

    @Dado("que possou um token valido")
    public void que_possou_um_token_valido() {
        super.logInfo("Esta Api não requer token");
    }

    @Quando("envio um request com dados validos")
    public void envio_um_request_com_dados_validos() {
        uri = prop.getProp("uri_correios");
        headers = ApiHeaders.setEmptyHeaders();
        params = ApiParams.getParams();
        super.GET();
    }

    @Então("o valor do frete deve ser {string}")
    public void o_valor_do_frete_deve_ser(String valorEsperado) {
        assertEquals(valorEsperado, super.response.xmlPath().get("Servicos.cServico.Valor"),
                "Erro ao calcular Frete!!");
    }

    @E("o status code deve ser {int}")
    public void o_status_code_deve_ser(int statusCodeEsperado) {
        assertEquals(statusCodeEsperado, response.statusCode(), "Falhar ao validar status da reposta.");
    }

    @Quando("envio um request com dados validos datatable")
    public void envio_um_request_com_dados_validos_datatable(DataTable dataTable) {
        uri = prop.getProp("uri_correios");
        headers = ApiHeaders.setEmptyHeaders();
        params = ApiParams.setParams(dataTable.asMaps().get(0));
        super.GET();
    }

    @Quando("envio um request com dados {string}, {string}")
    public void envio_um_request_com_dados(String sCepOrigem, String sCepDestino) {
        uri = prop.getProp("uri_correios");
        headers = ApiHeaders.setEmptyHeaders();
        params = ApiParams.getParams();
        params.put("sCepOrigem", sCepOrigem);
        params.put("sCepDestino", sCepDestino);
        super.GET();
    }

    @Então("ddeve ser exibida a mensagem {string}")
    public void ddeve_ser_exibida_a_mensagem(String expectedMessage) {
        assertEquals(expectedMessage, response.xmlPath().get("Servicos.cServico.MsgErro"), "Erro ao Validar MSG");
    }
}
