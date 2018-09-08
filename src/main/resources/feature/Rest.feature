Feature: Registro Exitoso nopCommerce
  As a client of the store
  I want to register in the platform
  So i can do Login

  @outline
  Scenario Outline: Registro nopCommerce
    Given Ingreso a la pagina de inicio con el navegardor "<browser>"
    When hago el registro con los datos obtenidos de la fuente "<fuente>"
    Then obtengo resultado del registro

    Examples:
      |browser|fuente|
      |0|rest|
     # |0|rest|