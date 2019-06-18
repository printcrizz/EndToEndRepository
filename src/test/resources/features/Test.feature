Feature: Validaciones en pagina principal
  se espera la construcción correcta del texto en la página web

  Scenario: 01 - Validación de texto en página principal
    Given Abrir navegador con la siguiente URL "http://www.inversionessecurity.cl/"
    And Esperar "5" segundos
    Then La pagina deberia tener los siguientes textos
    | text                                                          | xpath                                                  |
    | La confianza se construye en el tiempo.                       | //*[@id="block-inversiones-big-banner"]                |
    | Inversiones Security, te acompañamos donde estés.             | //*[@id="block-inversiones-big-banner"]                |
    | Servicio                                                      | //*[@id="block-views-home-destacados-block"]           |
    | Nuestra principal tarea es velar por el cumplimiento          | //*[@id="block-views-home-destacados-block"]           |
    | Transparencia                                                 | //*[@id="block-views-home-destacados-block"]           |
    | Más de 30 años de trayectoria en el mercado                   | //*[@id="block-views-home-destacados-block"]           |
    | Suitability                                                   | //*[@id="block-views-home-destacados-block"]           |
    | Porque conocemos a nuestros clientes y estamos cerca de ellos | //*[@id="block-views-home-destacados-block"]           |
    | Conoce los servicios y soluciones pensados para ti            | //*[@id="block-views-3e7b2f600ebe1447ac08d1350d5f1113"]|
    | Administración de fondos                                      | //*[@id="block-views-3e7b2f600ebe1447ac08d1350d5f1113"]|
    | Corretaje Bursátil                                            | //*[@id="block-views-3e7b2f600ebe1447ac08d1350d5f1113"]|
    | Invierte en mercados locales y globales                       | //*[@id="block-views-3e7b2f600ebe1447ac08d1350d5f1113"]|
    | Gestión Patrimonial                                           | //*[@id="block-views-3e7b2f600ebe1447ac08d1350d5f1113"]|
    | Asesoría experta en la estructuración de portafolios          | //*[@id="block-views-3e7b2f600ebe1447ac08d1350d5f1113"]|
    | Securitización                                                | //*[@id="block-views-3e7b2f600ebe1447ac08d1350d5f1113"]|
    | Originación de activos hipotecarios                           | //*[@id="block-views-3e7b2f600ebe1447ac08d1350d5f1113"]|
    | Nuestros Productos de Inversión                               | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Fondos Mutuos                                                 | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Una excelente alternativa para acceder a un portafolio        | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Acciones                                                      | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Accede a todos los instrumentos de renta variable             | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Administración de Cartera                                     | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Administración personalizada de portafolios de inversión      | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Fondos de Inversión Security                                  | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Accede a portafolios especializados de inversión              | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Ahorro Previsional Voluntario                                 | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Empieza hoy mismo a ahorrar para mejorar tu futura pensión    | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Instrumentos de Deuda                                         | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Descubre tu Perfil de Inversionista                           | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Conocer cuál es tu perfil de riesgo orientará de mejor manera | //*[@id="block-views-21eab34dd97f60909051f553f91ceebe"]|
    | Mercados en Línea                                             | //*[@id="block-views-b1aa4d577c2fa0b3767c2b93f0ed6e4f"]|
    | Simula los beneficios tributarios que tendrás con tu APV      | //*[@id="block-views-b1aa4d577c2fa0b3767c2b93f0ed6e4f"]|
    | Aumenta tu Pensión con Inversiones Security                   | //*[@id="block-views-b1aa4d577c2fa0b3767c2b93f0ed6e4f"]|
    And Close Browser


  Scenario Outline: 02 - Validación de redireccionamiento de botones
    Given Abrir navegador con la siguiente URL "https://www.inversionessecurity.cl/"
    When Buscar botón "<BotonInicial>" y presionarlo
    And Buscar botón "<BotonSecundario>" y presionarlo
    Then Validar Url contiene "<Redireccion>" extension
    And Close Browser
    Examples:
    | BotonInicial | BotonSecundario         | Redireccion                            |
    | QuienesSomos | NuestraEmpresa          | quienes-somos/quienes-somos            |
    | QuienesSomos | NuestrosReconocimientos | quienes-somos/nuestros-reconocimientos |
    | QuienesSomos | ValoresYPrincipios      | quienes-somos/valores-y-principios     |
    | QuienesSomos | DirectoriosYEjecutivos  | quienes-somos/gobierno-corporativo     |
    #| QuienesSomos | VisionYMision           | quienes-somos/vision-y-mision          |
    #| ProductosYServicios | FondosMutuos | productos-y-servicios/productos/fondos-mutuos|
    #| ProductosYServicios | FondosDeInversion | productos-y-servicios/productos/fondos-de-inversion |
    #| ProductosYServicios | Acciones | productos-y-servicios/productos/acciones/acciones |
    #| ProductosYServicios | RentaFija | productos-y-servicios/productos/instrumentos-de-deuda/renta-fija|
    #| ProductosYServicios | DolarEuro | productos-y-servicios/productos/moneda-extranjera/dolar-euro|
    #| ProductosYServicios | MercadosInternacionales |productos-y-servicios/productos/mercados-internacionales/security|
    #| ProductosYServicios | AhorroPrevisionalVoluntario | productos-y-servicios/productos/ahorro-provisional-voluntario/apv-fondo-mutuo-security |
    #| ProductosYServicios | AdministracionDeCartera | productos-y-servicios/productos/administracion-de-cartera |
    #| ProductosYServicios | GestionPatrimonial | productos-y-servicios/servicios/gestion-patrimonial |
    #| ProductosYServicios | CorretajeBursatil | productos-y-servicios/servicios/corretaje-bursatil |
    #| ProductosYServicios | AdministracionDeFondos | productos-y-servicios/servicios/administracion-de-fondos |
    #| ProductosYServicios | Securitizacion | productos-y-servicios/servicios/securitizacion |
    #| Research            | DepartamentoDeEstudios | research/departamento-de-estudios |
    #| Research            | Informes | research/informes/informesPortafolios |
    #| ServicioAlCliente   | Contactanos | servicio-al-cliente/contactenos |
    #| ServicioAlCliente   | PatentesAnexos  | servicio-al-cliente/informacion-de-interes/patentes |
    #| ServicioAlCliente   | Sucursales      | servicio-al-cliente/sucursales                      |

  Scenario: 03 - Validación Redireccionamiento a Mercados
    Given Abrir navegador con la siguiente URL "https://www.inversionessecurity.cl/"
    When Buscar botón "Mercados" y presionarlo
    And Close Browser