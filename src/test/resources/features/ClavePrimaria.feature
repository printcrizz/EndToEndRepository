Feature: Clave Primaria
  primer ingreso, cliente enrolado en otro canal y validaciones
  @claves
  Scenario: 01 - Clave primaria primer ingreso - login satisfactorio
    Given Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Validar el texto desplegado en "Crear_clave_de_acceso"
    And Buscar boton "Continuar_step_2" de "Primer_ingreso_po" y presionarlo
   And Ingresar Rut "12485766k" al formulario
   #And Click en no soy un robot
   # And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
   # And Ingresar la contrasena de Usuario "1234asdf" al formulario
   # And Ingresar la contrasena de Usuario "1234asdf" al formulario
   # And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
   # And Seleccionar 3 Preguntas de Seguridad (TBD)
   # And Se validan los textos en "ActivacionCodigoEmailtext"
   # And Escribir "CodigoMock" en el campo "IngresarCodigo" de formulario
   # And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
   # Then Se validan los textos en "ClaveActivada"

  Scenario: - Clave primaria - contraseña mal ingresada

  Scenario: - Clave primaria - numero de serie mal ingresado

  Scenario: - Clave primaria - nombre incorrecto o mal ingresado

  Scenario: - Clave primaria - error en fecha de nacimiento
    @Ignore
  Scenario: - Clave primaria - bloqueado por multiples intentos

  Scenario: 02 - Clave primaria - cliente enrolado en otro canal
    Given Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Se validan los textos en "CrearClaveDeAcceso"
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    When Ingresar el Rut de Usuario "12485766k" al formulario
    And Click en no soy un robot
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    Then Se validan los textos en "UsuarioEnOtroCanalText"

  Scenario: 03 - Clave unica

  Scenario: 04 - Creación de clave con usuario ya ingresado (segundo ingreso)
    Given Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Se validan los textos en "CrearClaveDeAcceso"
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    When Ingresar el Rut de Usuario "12485766k" al formulario
    And Click en no soy un robot
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    And Seleccionar 3 Preguntas de Seguridad (TBD)
    And Se validan los textos en "ActivacionCodigoEmailtext"
    And Escribir "CodigoMock" en el campo "IngresarCodigo" de formulario
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    Then Se validan los textos en "ClaveActivada"
    And Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Se validan los textos en "CrearClaveDeAcceso"
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    When Ingresar el Rut de Usuario "12485766k" al formulario
    And Click en no soy un robot
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    Then Se validan los textos en "UsuarioYaIngresado"

