package stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import utilities.ConfigReader;

public class ReqResStepDefinitions {
    String url="";
    Response response;
    JsonPath responseJP;
    @When("kullanici {string} adresini baseUrl yapar")
    public void kullaniciAdresiniBaseUrlYapar(String adres) {
        url+= ConfigReader.getProperty(adres);
    }

    @When("kullanici pathparametresi olarak {string} girer")
    public void kullaniciPathparametresiOlarakGirer(String pp) {
        url=url+"/"+pp;

    }

    @When("kullanici GET Request yapar ve response degerini kaydeder")
    public void kullaniciGETRequestYaparVeResponseDegeriniKaydeder() {

        response= RestAssured.given().when().get(url);

    }

    @When("kullanici donen response'un status code degerinin {int} oldugunu test eder")
    public void kullaniciDonenResponseUnStatusCodeDegerininOldugunuTestEder(int statusCode) {

        Assertions.assertEquals(statusCode,response.getStatusCode());

    }

    @When("kullanici {string} isimli header degerinin {string} oldugunu test eder")
    public void kullaniciIsimliHeaderDegerininOldugunuTestEder(String headerAttribute, String headerValue) {

        Assertions.assertEquals(headerValue,response.getHeader(headerAttribute));

    }

    @When("kullanici {string} icindeki {string} degerinin {string} oldugunu test eder")
    public void kullaniciIcindekiDegerininOldugunuTestEder(String obj, String key, String value) {
        Assertions.assertEquals(value,responseJP.getString(obj+"."+key));

    }

    @When("kullanici donen cevabi jsonpath olarak kaydeder.")
    public void kullaniciDonenCevabiJsonpathOlarakKaydeder() {
        responseJP=response.jsonPath();
    }
}