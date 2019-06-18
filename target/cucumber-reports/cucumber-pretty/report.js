$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Validaciones en Login",
  "description": "Se espera un correcto login desde distintos urls",
  "id": "validaciones-en-login",
  "keyword": "Feature"
});
formatter.before({
  "duration": 110715,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "01 - login desde inversionesSecurity.cl",
  "description": "",
  "id": "validaciones-en-login;01---login-desde-inversionessecurity.cl",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@tagg"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Abrir navegador con la siguiente URL \"https://www.inversionessecurity.cl/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Esperar \"5\" segundos",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Buscar botón \"Login\" de \"MainPage_po\" y presionarlo",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Validar redireccionamiento a \"https://privado.inversionessecurity.cl/login\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Ingresar el Rut de Usuario \"12485766k\" al formulario",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Ingresar la contrasena de Usuario \"1234asdf\" al formulario",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Buscar botón \"LoginButton\" de \"Login_access_po\" y presionarlo",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Close Browser",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.inversionessecurity.cl/",
      "offset": 38
    }
  ],
  "location": "StepDefinitions.OpenBrowser(String)"
});
formatter.result({
  "duration": 3384301220,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 9
    }
  ],
  "location": "StepDefinitions.WaitNSeconds(int)"
});
formatter.result({
  "duration": 5011934498,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Login",
      "offset": 14
    },
    {
      "val": "MainPage_po",
      "offset": 25
    }
  ],
  "location": "StepDefinitions.SearchAndClickButton(String,String)"
});
formatter.result({
  "duration": 10097286689,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://privado.inversionessecurity.cl/login",
      "offset": 30
    }
  ],
  "location": "StepDefinitions.ValidateRedirect(String)"
});
formatter.result({
  "duration": 14295610,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "12485766k",
      "offset": 28
    }
  ],
  "location": "StepDefinitions.RutLogin(String)"
});
formatter.result({
  "duration": 4120806022,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1234asdf",
      "offset": 35
    }
  ],
  "location": "StepDefinitions.PasswordLogin(String)"
});
formatter.result({
  "duration": 4110838397,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LoginButton",
      "offset": 14
    },
    {
      "val": "Login_access_po",
      "offset": 31
    }
  ],
  "location": "StepDefinitions.SearchAndClickButton(String,String)"
});
formatter.result({
  "duration": 2471902338,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.closeBrowserInstance()"
});
formatter.result({
  "duration": 114114605,
  "status": "passed"
});
formatter.after({
  "duration": 116291,
  "status": "passed"
});
});