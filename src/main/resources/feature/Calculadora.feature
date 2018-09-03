Feature: Operaciones calculadora consumiendo WS

  As a User
  I want to operate two numbers
  So i got the result



  @outline
  Scenario Outline: Operaciones con dos numeros
    Given las rutas para leer datos y almacenar resultados de la "<operacion>"
    When ingreso los numeros "<numero1>" y "<numero2>" los proceso con la operacion "<operacion>"
    Then obtengo resultado de la "<operacion>"

    Examples:
      |numero1|numero2|operacion|
      |-50|3|suma|
      |100|2|division|