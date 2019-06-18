Feature: Validaciones en Login
  Se espera un correcto login desde distintos urls
  @tagg
  Scenario: 01 - login desde inversionesSecurity.cl
    Given Abrir navegador con la siguiente URL "https://www.inversionessecurity.cl/"
    And Esperar "5" segundos
    When Buscar botón "Login" de "MainPage_po" y presionarlo
    Then Validar redireccionamiento a "https://privado.inversionessecurity.cl/login"
    And Ingresar el Rut de Usuario "12485766k" al formulario
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    When Buscar botón "LoginButton" de "MainPage_po" y presionarlo
    And Close Browser

