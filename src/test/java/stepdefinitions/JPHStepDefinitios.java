package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import utilities.ConfigReader;

public class JPHStepDefinitios {

    String url = "";
    Response actualResponse;
    JsonPath actualResponseJsonPath;
    JSONObject reqBodyJSON=new JSONObject();

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

    @Then("kullanici POST request yapabilmek icin {string},{string},{double} {double} degerleri ile reqBody olusturur")
    public void kullanici_post_request_yapabilmek_icin_degerleri_ile_req_body_olusturur(String title, String body, Double userId, Double id) {

        reqBodyJSON.put("title",title);
        reqBodyJSON.put("body",body);
        reqBodyJSON.put("userId",userId);
        reqBodyJSON.put("id",id);
    }

    @Then("kullanici POST request yaparak response degerlerini kaydeder")
    public void kullaniciPOSTRequestYaparakResponseDegerleriniKaydeder() {
        actualResponse=RestAssured.given().contentType(ContentType.JSON).when().body(reqBodyJSON.toString()).put(url);
    }

    @Then("kullanici {string} isimli header degerinin {string} oldugunu kontrol eder")
    public void kullaniciIsimliHeaderDegerininOldugunuKontrolEder(String headerAttribute, String headerValue) {
        Assertions.assertEquals(headerValue,actualResponse.getHeader(headerAttribute));
    }

    @Then("kullanici userId degerinin {int} oldugunu kontrol eder")
    public void kullaniciUserIdDegerininOldugunuKontrolEder(int userId) {
        Assertions.assertEquals(userId,actualResponseJsonPath.getInt("userId"));

    }


}