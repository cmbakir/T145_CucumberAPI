package stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.ConfigReader;
import static io.restassured.RestAssured.given;

public class CollectApiStepDefinitions {
    String url="";
    Response response;
    @When("kullanici {string} adresine gider")
    public void kullaniciAdresineGider(String baseUrl) {
        url+= ConfigReader.getProperty(baseUrl);
    }

    @When("kullanici path parametresi olarak {string} olarak ekler")
    public void kullaniciPathParametresiOlarakOlarakEkler(String pathparam) {
        url=url+"/"+pathparam;
    }

    @When("kullanici query parametleri olarak il olarak {string} ilce olarak {string} girer")
    public void kullaniciQueryParametleriOlarakIlOlarakIlceOlarakGirer(String qparam1, String qparam2) {
        url=url+"?"+"il="+qparam1+"&ilce="+qparam2;
    }

    @When("kullanici gonderdigi requeste karsilik donen response'u kaydeder")
    public void kullaniciGonderdigiRequesteKarsilikDonenResponseUKaydeder() {

        response=given().when().header("authorization","apikey 2Fy6uHa0vZjMvzzsj1Ha0L:6tbX8uhsLW0bcFqQuiSUzY").get(url);

    }

    @When("kullanici donen cevabi yazdirir")
    public void kullaniciDonenCevabiYazdirir() {
        response.prettyPrint();
    }
}