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
  @smoke
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
    Then Validar Accion visible en Mis Movimientos

  #Ignorado por ausencia de servicio de cargo de saldo en cuenta TBD
  @Ignore
  Scenario: 02 - Compra exitosa de acciones con Saldo en cuenta
    When Buscar boton "Productos" de "MainPage_po" y presionarlo
    And Buscar boton "Acciones" de "MainPage_po" y presionarlo
    And Buscar boton "Comprar" de "Acciones_po" y presionarlo
    And Esperar "35" segundos
    And Seleccionar "FEPASA" accion a comprar
    Then Visualizar Precio de Acción "5,80"
    And Seleccionar forma de pago "Saldo disponible en caja"
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
    Then Validar Accion visible en Mis Movimientos

    Scenario: 03 - Busqueda y validación de acciones en Escritorio Comercial
      
    Scenario: 04 - Busqueda y validación de acciones en Monitor Bolsa
      When Buscar boton "Productos" de "MainPage_po" y presionarlo
      And Buscar boton "Acciones" de "MainPage_po" y presionarlo
      And Buscar boton "Comprar" de "Acciones_po" y presionarlo
      And Esperar "35" segundos
      And Seleccionar "FEPASA" accion a comprar
      Then Visualizar Precio de Acción "5,80"
      And Seleccionar forma de pago "Saldo disponible en Línea de Inversión"
      And Comprar "100" acciones
      And Buscar boton "BotonContinuar" de "Acciones_po" y presionarlo
      And Buscar boton "Confirmar" de "Acciones_po" y presionarlo
      Then Validar Accion visible en Mis Acciones
      And Abrir navegador con la siguiente URL "http://escritoriocomercialdev1.inversionessecurity.cl/"
      And Iniciar Sesion en Escritorio Comercial
      And Buscar boton "InformeDeOperaciones" de "MainPage_po" y presionarlo
      And Filtrar Acciones por "FEPASA"
      And Validar el Estado de la accion
  @smoke
  Scenario: 05 - Compra y anulacion de orden
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
    Then Validar Accion visible en Mis Movimientos
    And Anular Orden de compra
    And Validar Orden anulada





