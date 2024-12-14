
Feature: Nöbetçi Eczaneler

  Scenario: Kırıkkale ili MErkez ilçedeki nöbetçi eczaneleri yazdırma

    * kullanici "collectApiUrl" adresine gider
    * kullanici path parametresi olarak "health/dutyPharmacy" olarak ekler
    * kullanici query parametleri olarak il olarak "Kırıkkale" ilce olarak "Merkez" girer
      #https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale&ilce=Merkez
    * kullanici gonderdigi requeste karsilik donen response'u kaydeder
    * kullanici donen cevabi yazdirir