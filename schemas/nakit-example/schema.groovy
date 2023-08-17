schema {
  Kontaktni {
    id(String)
    kód(String)
    název {
      cs(String)
      en(String)
    }
    'platnost-od'(String)
    'platnost-do'(String)
    'vlastník-ovm'(String)
    email(String)
    www(String)
    'anglický-název-ovm'(String)
  }
}
