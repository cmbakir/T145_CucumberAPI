package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import utilities.ConfigReader;

public class JPHStepDefinitios {

    String url = "";
    Response actualResponse;
    JsonPath actualResponseJsonPath;

    @Given("kullanici {string} adresini kullanir")
    public void kullaniciAdresiniKullanir(String ConfigBaseUrl) {
        url += ConfigReader.getProperty(ConfigBaseUrl);
    }

    @Then("kullanici path paramatresi olarak {string} girer")
    public void kullaniciPathParamatresiOlarakGirer(String pathParams) {
        url = url + "/" + pathParams;

    }

    @Then("kullanici GET request yaparak response degerlerini kaydeder")
    public void kullaniciGETRequestYaparakResponseDegerleriniKaydeder() {
        actualResponse= RestAssured.given().when().get(url);

    }

    @And("kullanici statusCode degerinin {int} oldugunu kontrol eder")
    public void kullaniciStatusCodeDegerininOldugunuKontrolEder(int expStatusCode) {
        Assertions.assertEquals(expStatusCode,actualResponse.getStatusCode());

    }

    @Then("kullanici contentType degerinin {string} oldugunu kontrol eder")
    public void kullaniciContentTypeDegerininOldugunuKontrolEder(String expContentType) {
        Assertions.assertEquals(expContentType,actualResponse.getContentType());
    }

    @Then("kullanici response degerini jsonpath olarak kaydeder")
    public void kullaniciResponseDegeriniJsonpathOlarakKaydeder() {
        actualResponseJsonPath=actualResponse.jsonPath();
    }

    @Then("kullanici responsedaki id degerinin {int} oldugunu kontrol eder")
    public void kullaniciResponsedakiIdDegerininOldugunuKontrolEder(int expIdValue) {
        Assertions.assertEquals(expIdValue,actualResponseJsonPath.getInt("id"));
    }

    @Then("kullanici responsedaki {string} degerinin {string} oldugunu kontrol eder")
    public void kullaniciResponsedakiDegerininOldugunuKontrolEder(String expKey, String expValue) {
        Assertions.assertEquals(expValue,actualResponseJsonPath.getString(expKey));
    }

    @Then("kullanici POST request yapabilmek icin {string},{string}{double}{double} degerleri ile reqBody olusturur")
    public void kullaniciPOSTRequestYapabilmekIcinDegerleriIleReqBodyOlusturur(String arg0, String arg1, int arg2, int arg3) {

    }

    @Then("kullanici POST request yaparak response degerlerini kaydeder")
    public void kullaniciPOSTRequestYaparakResponseDegerleriniKaydeder() {

    }

    @Then("kullanici {string} isimli header degerinin {string} oldugunu kontrol eder")
    public void kullaniciIsimliHeaderDegerininOldugunuKontrolEder(String arg0, String arg1) {

    }

    @Then("kullanici userId degerinin {int} oldugunu kontrol eder")
    public void kullaniciUserIdDegerininOldugunuKontrolEder(int arg0) {
    }
}