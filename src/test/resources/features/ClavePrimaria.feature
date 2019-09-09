Feature: Clave Primaria
  primer ingreso, cliente enrolado en otro canal y validaciones
  @claves
  Scenario: 01 - Clave primaria primer ingreso - login satisfactorio
    Given Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Validar el texto desplegado en "Crear_clave_de_acceso"
    And Buscar boton "Continuar_step_2" de "Primer_ingreso_po" y presionarlo
    And Ingresar Rut "173523947" al formulario
    And Click en no soy un robot
    And Esperar a que boton "Continuar_disabled" se active y hacer click
    And Escribir "Cristian Enrique" en el campo "NombresInput" de formulario
    And Escribir "Aravena" en el campo "ApellidoPaterno" de formulario
    And Escribir "Vergara" en el campo "ApellidoMaterno" de formulario
    And Seleccionar "Soltero (a)" en dropdown de "EstadoCivil" de formulario
    And Escribir "512393200" en el campo "NumeroDeSerieCedula" de formulario
    And Esperar "5" segundos
    And Validar el texto desplegado en "errorCedula"
    And Escribir "02/05/1990" en el campo "FechaDeNacimiento" de formulario
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    And Ingresar preguntas de seguridad con respuesta "naranja"
    And Se validan los textos en "ActivacionCodigoEmailtext"
    And Escribir "CodigoMock" en el campo "IngresarCodigo" de formulario
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    Then Se validan los textos en "ClaveActivada"

  Scenario: 02 -Clave primaria - contraseña mal ingresada
    Given Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Validar el texto desplegado en "Crear_clave_de_acceso"
    And Buscar boton "Continuar_step_2" de "Primer_ingreso_po" y presionarlo
    And Ingresar Rut "173523947" al formulario
    And Click en no soy un robot
    And Esperar a que boton "Continuar_disabled" se active y hacer click
    And Escribir "123-123" en el campo "ContrasenaInput" de formulario
    Then Se validan los textos en "PasswordCampoInvalido"

    @Ignore
  Scenario: 03 - Clave primaria - numero de serie mal ingresado
    Given Abrir el navegador en la pagina de login
    When Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Validar el texto desplegado en "Crear_clave_de_acceso"
    And Buscar boton "Continuar_step_2" de "Primer_ingreso_po" y presionarlo
    And Ingresar Rut "173523947" al formulario
    And Click en no soy un robot
    And Esperar a que boton "Continuar_disabled" se active y hacer click
    And Escribir "123123" en el campo "ContrasenaInput" de formulario
    And Escribir "123123" en el campo "ContrasenaInput2" de formulario
    And Ingresar preguntas de seguridad con respuesta "naranja"

    @Ignore
  Scenario: 04 - Clave primaria - nombre incorrecto o mal ingresado
    Given Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Validar el texto desplegado en "Crear_clave_de_acceso"
    And Buscar boton "Continuar_step_2" de "Primer_ingreso_po" y presionarlo
    And Ingresar Rut "173523947" al formulario
    And Click en no soy un robot
    And Esperar a que boton "Continuar_disabled" se active y hacer click
    And Escribir "Cristian Henrique" en el campo "NombresInput" de formulario
    And Escribir "Aravena" en el campo "ApellidoPaterno" de formulario
    And Escribir "Vergara" en el campo "ApellidoMaterno" de formulario
    And Seleccionar "Soltero (a)" en dropdown de "EstadoCivil" de formulario
    And Escribir "512393200" en el campo "NumeroDeSerieCedula" de formulario
    And Esperar "5" segundos
    And Validar el texto desplegado en "ErrorDatosNombre"

   @Ignore
  Scenario: 05 - Clave primaria - error en fecha de nacimiento
    Given Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Validar el texto desplegado en "Crear_clave_de_acceso"
    And Buscar boton "Continuar_step_2" de "Primer_ingreso_po" y presionarlo
    And Ingresar Rut "173523947" al formulario
    And Click en no soy un robot
    And Esperar a que boton "Continuar_disabled" se active y hacer click
    And Escribir "Cristian Enrique" en el campo "NombresInput" de formulario
    And Escribir "Aravena" en el campo "ApellidoPaterno" de formulario
    And Escribir "Vergara" en el campo "ApellidoMaterno" de formulario
    And Seleccionar "Soltero (a)" en dropdown de "EstadoCivil" de formulario
    And Escribir "512393200" en el campo "NumeroDeSerieCedula" de formulario
    And Esperar "5" segundos
    And Escribir "02/05/1990" en el campo "FechaDeNacimiento" de formulario
    And Validar el texto desplegado en "ErrorDatosFechaNacimiento"


  @Ignore
  Scenario: 06 - Clave primaria - bloqueado por multiples intentos
    #TBD se debe consumir el servicio de preguntas de equifax de forma simultanea
  #no automatizable aun

  Scenario: 07 - Clave primaria - cliente enrolado en otro canal
    Given Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Se validan los textos en "CrearClaveDeAcceso"
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    When Ingresar el Rut de Usuario "12485766k" al formulario
    And Click en no soy un robot
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    Then Se validan los textos en "UsuarioEnOtroCanalText"

  Scenario: 08 - Clave unica codigo activacion incorrecto
    Given Abrir el navegador en la pagina de login
    And Buscar boton "Primer_Ingreso" de "Primer_ingreso_po" y presionarlo
    And Validar el texto desplegado en "Crear_clave_de_acceso"
    And Buscar boton "Continuar_step_2" de "Primer_ingreso_po" y presionarlo
    And Ingresar Rut "173523947" al formulario
    And Click en no soy un robot
    And Esperar a que boton "Continuar_disabled" se active y hacer click
    And Escribir "Cristian Enrique" en el campo "NombresInput" de formulario
    And Escribir "Aravena" en el campo "ApellidoPaterno" de formulario
    And Escribir "Vergara" en el campo "ApellidoMaterno" de formulario
    And Seleccionar "Soltero (a)" en dropdown de "EstadoCivil" de formulario
    And Escribir "512393200" en el campo "NumeroDeSerieCedula" de formulario
    And Esperar "5" segundos
    And Validar el texto desplegado en "errorCedula"
    And Escribir "02/05/1990" en el campo "FechaDeNacimiento" de formulario
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    And Ingresar la contrasena de Usuario "1234asdf" al formulario
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    And Ingresar preguntas de seguridad con respuesta "naranja"
    And Se validan los textos en "ActivacionCodigoEmailtext"
    And Escribir "CodigoMockFalso" en el campo "IngresarCodigo" de formulario
    And Buscar boton "Continuar" de "Primer_ingreso_po" y presionarlo
    Then Se validan los textos en "TextoCodigoActivacionIncorrecto"


  Scenario: 09 - Creación de clave con usuario ya ingresado (segundo ingreso)
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
    And Ingresar preguntas de seguridad con respuesta "naranja"
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

