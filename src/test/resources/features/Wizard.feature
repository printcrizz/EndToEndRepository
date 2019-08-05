Feature: Identificador Tributario
  quiero validar el funcionamiento de Identificador Tributario en wizard
  al seleccionar un cliente sin rut chileno

  Background: login de usuario
    Given Abrir el navegador en la pagina de login
    And Ejecutar Reinicio de Wizard
    And Ingresar el Rut de Usuario "12485766k" al formulario
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    When Buscar boton "LoginButton" de "Login_access_po" y presionarlo
    And Esperar "10" segundos
  
  Scenario: 01 - Validar textos legales US Person en Wizard
    When Validar BreadCrumb en paso "DatosPersonales"
    And Se validan los textos en "NormasTexto"
    And Se validan los textos en "FirmaDigital"
    And Se validan los textos en "USPerson"
    Then Close Browser

  @wizard
  Scenario: 02 - Cambio de texto a Rut Chileno al seleccionar cliente con Rut
    When Buscar boton "CompletarDatos" de "Wizard_po" y presionarlo
    And Esperar "5" segundos
    And Se validan los textos en "DatosPersonalesHeader"
    And Buscar boton "Continuar" de "Wizard_po" y presionarlo
    And Buscar boton "Continuar" de "Wizard_po" y presionarlo
    And Se validan los textos en "DireccionParticular"
    And Buscar boton "Continuar" de "Wizard_po" y presionarlo
    And Se validan los textos en "PoseeRut"
    And Buscar boton "SiEsChileno" de "Wizard_po" y presionarlo
    And Se validan los textos en "RutEmpleador"

  @wizard
  Scenario: 03 - Cambio de texto a Identificador tributario al seleccionar no posee rut
    When Buscar boton "CompletarDatos" de "Wizard_po" y presionarlo
    And Esperar "5" segundos
    And Se validan los textos en "DatosPersonalesHeader"
    And Buscar boton "Continuar" de "Wizard_po" y presionarlo
    And Buscar boton "Continuar" de "Wizard_po" y presionarlo
    And Se validan los textos en "DireccionParticular"
    And Buscar boton "Continuar" de "Wizard_po" y presionarlo
    And Se validan los textos en "PoseeRut"
    And Buscar boton "NoEsChileno" de "Wizard_po" y presionarlo
    And Se validan los textos en "NumeroFiscalID"

  @wizard
  Scenario: 04 - Funcionamiento total de Identificador tributario y Rut
    When Buscar boton "CompletarDatos" de "Wizard_po" y presionarlo
    And Esperar "5" segundos
    And Se validan los textos en "DatosPersonalesHeader"
    And Buscar boton "Continuar" de "Wizard_po" y presionarlo
    And Buscar boton "Continuar" de "Wizard_po" y presionarlo
    And Se validan los textos en "DireccionParticular"
    And Buscar boton "Continuar" de "Wizard_po" y presionarlo
    And Se validan los textos en "PoseeRut"
    And Buscar boton "NoEsChileno" de "Wizard_po" y presionarlo
    And Se validan los textos en "NumeroFiscalID"
    And Buscar boton "SiEsChileno" de "Wizard_po" y presionarlo
    And Se validan los textos en "RutEmpleador"
    Then Close Browser

  Scenario: 05 - Cambio de Texto de identificador tributario al clickear usuario no posee rut Chileno
   #Given Inicio Sesión y espero visualizar el Wizard
   #And Presiono continuar hasta visualizar Datos Laborales
   #When Presiono "NO" en posee rut Chileno
   #Then El texto es "Rut Empleador"
   #And Presiono "SI" en posee rut Chileno
   #Then El texto es "Número Fiscal Identificador de Empresa Extranjera"