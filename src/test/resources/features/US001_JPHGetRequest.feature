Feature: US001 JPH Get Request

  # https://jsonplaceholder.typicode.com/posts/44 endpointine
  # bir GET request gonderdigimizde donen response’un
  # status code’unun 200 olduğunu,
  # content type degerinin "application/json; charset=utf-8 " ve
  # “title” degerinin “optio dolor molestias sit” oldugunu test edin

      Scenario: Kullanici GET request yaparak sonuclarini karsilastirir

            Given kullanici "jPHBaseUrl" adresini kullanir
            Then kullanici path paramatresi olarak "posts/11" girer
            Then kullanici GET request yaparak response degerlerini kaydeder
            And kullanici statusCode degerinin 200 oldugunu kontrol eder
            Then kullanici contentType degerinin "application/json; charset=utf-8" oldugunu kontrol eder
            Then kullanici response degerini jsonpath olarak kaydeder
            Then kullanici responsedaki id degerinin 11 oldugunu kontrol eder
            Then kullanici responsedaki "title" degerinin "et ea vero quia laudantium autem" oldugunu kontrol eder