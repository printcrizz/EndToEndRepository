@compra
Feature: Compra de acciones

  Background: Inicio de sesion y extraccion de wizard
    Given Abrir el navegador en la pagina de login
    And Ejecutar Reinicio de Wizard
    And Ingresar el Rut de Usuario "12485766k" al formulario
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    When Buscar boton "LoginButton" de "Login_access_po" y presionarlo
    And Esperar "10" segundos
    And Buscar boton "CompletarDespues" de "Wizard_po" y presionarlo

  Scenario: 01 - Validación precio de acciones en Web
    When Buscar boton "Productos" de "MainPage_po" y presionarlo
    And Buscar boton "Acciones" de "MainPage_po" y presionarlo
    And Buscar boton "Comprar" de "Acciones_po" y presionarlo
    And Esperar "35" segundos
    And Hacer Scroll hasta "AccionesDropDown"
    And Seleccionar "FEPASA" accion a comprar
    Then Visualizar Precio de Acción "5,80"



