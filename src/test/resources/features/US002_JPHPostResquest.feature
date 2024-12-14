#    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
#    PUT request yolladigimizda donen response’in
#    status kodunun 200, content type’inin “application/json; charset=utf-8”,
#    Connection header degerinin “keep-alive”
#    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

#   Request Body                      Expected Data :
#   {                                     {
#    "title": "Ahmet",                      "title": "Ahmet",
#    "body": "Merhaba",                     "body": "Merhaba",
#    "userId": 10,                          "userId": 10,
#    "id": 70                               "id": 70
#   }                                     }
Feature: US002 PUT Request

  Scenario: PUT Request yaparak donen responstaki degerlerin
  beklenen degerlerle karsilastirmasi

    Given kullanici "jPHBaseUrl" adresini kullanir
    Then kullanici path paramatresi olarak "posts/70" girer
    Then kullanici POST request yapabilmek icin "Ahmet","Merhaba",10 70 degerleri ile reqBody olusturur
    Then kullanici POST request yaparak response degerlerini kaydeder
    Then kullanici statusCode degerinin 200 oldugunu kontrol eder
    Then kullanici contentType degerinin "application/json; charset=utf-8" oldugunu kontrol eder
    Then kullanici "Connection" isimli header degerinin "keep-alive" oldugunu kontrol eder
    Then kullanici response degerini jsonpath olarak kaydeder
    Then kullanici responsedaki id degerinin 70 oldugunu kontrol eder
    Then kullanici userId degerinin 10 oldugunu kontrol eder
    Then kullanici responsedaki "title" degerinin "Ahmet" oldugunu kontrol eder
    Then kullanici responsedaki "body" degerinin "Merhaba" oldugunu kontrol eder