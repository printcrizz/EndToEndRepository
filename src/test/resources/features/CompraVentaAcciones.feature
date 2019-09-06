@compra
Feature: Compra de acciones

  Background: Inicio de sesion y extraccion de wizard
    Given Abrir el navegador en la pagina de login
    And Ejecutar Reinicio de Wizard
    And Ingresar el Rut de Usuario "12485766k" al formulario
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    When Buscar boton "LoginButton" de "Login_access_po" y presionarlo
    And Esperar "10" segundos
    #And Buscar boton "CompletarDespues" de "Wizard_po" y presionarlo

  Scenario: 01 - Compra exitosa de acciones con Saldo disponible en linea
    When Buscar boton "Productos" de "MainPage_po" y presionarlo
    And Buscar boton "Acciones" de "MainPage_po" y presionarlo
    And Buscar boton "Comprar" de "Acciones_po" y presionarlo
    And Esperar "35" segundos
    And Seleccionar "FEPASA" accion a comprar
    Then Visualizar Precio de Acción "5,80"
    And Seleccionar forma de pago "Saldo disponible en Línea de Inversión"
    And Comprar "100" acciones
    And Buscar boton "BotonContinuar" de "Acciones_po" y presionarlo
    And Validar Monto de gastos operacionales
    | key           |value |
    | Comision      | 2    |
    | Derecho       | 0    |
    | IVA           | 228  |
    | Otros         | 1.200 |
    | TotalGastos   | 1.430 |
    And Buscar boton "Confirmar" de "Acciones_po" y presionarlo
    And Validar Monto de gastos operacionales
    | key            |value  |
    | TotalOperacion | 2.010 |



