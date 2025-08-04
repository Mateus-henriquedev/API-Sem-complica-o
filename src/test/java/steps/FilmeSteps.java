package steps;

import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.http.ContentType;
import maps.FilmesMap;
import utils.RestUtils;

public class FilmeSteps {

    @Dado("que tenha um payload de API de filme")
    public void queTenhaUmPayloadDeAPIDeFilme() {
        FilmesMap.initAll();

    }
    @Quando("realizo uma requisicao do tipp POST de Filme")
    public void realizoUmaRequisicaoDoTippPOSTDeFilme() {
        RestUtils.post(FilmesMap.getHeader(),FilmesMap.getFilme(), ContentType.JSON,"filme");

    }
    @Entao("armazeno o id que recebo do response de Filme")
    public void armazenoOIdQueReceboDoResponseDeFilme() {
        FilmesMap.id = RestUtils.getResponse().jsonPath().get("id");

    }
}
