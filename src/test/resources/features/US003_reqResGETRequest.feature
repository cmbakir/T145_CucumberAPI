  # https://reqres.in/api/users/1 adresine bir GET request gönderip
   # status code'unun 200 olduğunu
   # "Server" isimli header değerinin "cloudflare" olduğunu
   # "data" altındaki "first_name" değerinin "George" olduğunu
   # "data" altindaki "last_name" degerinin "Bluth" oldugunu
   # "data" altindaki "email" degerinin "george.bluth@reqres.in" olduğunu
   # "data" altindaki "avatar" degerinin "https://reqres.in/img/faces/1-image.jpg" olduğunu
   # "support" altindaki "url" degerinin "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral" olduğunu
   # "support" altindaki "text" degerinin "Tired of writing endless social media content? Let Content Caddy generate it for you." oldugunu
  # test eder.

  Feature: US003 GET Request

    Scenario: reqres.in users GET Request

      * kullanici "reqressBaseUrl" adresini baseUrl yapar
      * kullanici pathparametresi olarak "users/1" girer
      * kullanici GET Request yapar ve response degerini kaydeder
      * kullanici donen response'un status code degerinin 200 oldugunu test eder
      * kullanici "Server" isimli header degerinin "cloudflare" oldugunu test eder
      * kullanici donen cevabi jsonpath olarak kaydeder.
      * kullanici "data" icindeki "first_name" degerinin "George" oldugunu test eder
      * kullanici "data" icindeki "last_name" degerinin "Bluth" oldugunu test eder
      * kullanici "data" icindeki "email" degerinin "george.bluth@reqres.in" oldugunu test eder
      * kullanici "data" icindeki "avatar" degerinin "https://reqres.in/img/faces/1-image.jpg" oldugunu test eder
      * kullanici "support" icindeki "url" degerinin "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral" oldugunu test eder
      * kullanici "support" icindeki "text" degerinin "Tired of writing endless social media content? Let Content Caddy generate it for you." oldugunu test eder