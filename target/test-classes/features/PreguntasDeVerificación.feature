Feature: Como Test Engineer
  quiero validar los textos de disclaimer informativos
  @tag
  Scenario: 01 - Validacion de textos en intento de validación de identidad
    Given Abrir navegador con la siguiente URL "https://privado.inversionessecurity.cl/login"
    And Buscar botón "PrimerIngreso" de "Primer_ingreso_po" y presionarlo
    And Validar redireccionamiento a "https://privado.inversionessecurity.cl/clavePrimaria/primerIngreso"
    And Esperar "5" segundos
    When Buscar botón "CheckreCaptcha" de "Login_access_po" y presionarlo
    And Buscar botón "Continuar" de "Login_access_po" y presionarlo
    Then Close Browser

    Scenario: 02 - Ingreso de datos a Paso 1
      Given Abrir navegador con la siguiente URL "https://privado.inversionessecurity.cl/clavePrimaria/primerIngreso"
      And Ingreso los datos para llegar al Paso 1
      Then Close Browser


