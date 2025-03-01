package stepdefs;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import pageObjects.Acciones_po;
import utils.GeneralUtils;
import utils.SqlConnector;
import utils.RestUtils;
import utils.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class StepDefinitions {
    public static RestUtils restUtils = new RestUtils();
    public SeleniumUtils sel = new SeleniumUtils();
    public SqlConnector sql = new SqlConnector();
    public static GeneralUtils gu = new GeneralUtils();
    public String ScenarioName= "";
    public String featureName = "";
    private String uri;
    public String orderFolio ="";

    private static String token = null;

    @Before
    public void beforehook(Scenario scenario){
        featureName = scenario.getId().split(";")[0];
        ScenarioName = scenario.getName();
    }

    @Then("^Close Browser$")
    public void closeBrowserInstance(){
        sel.CloseBrowser();
    }
    @Given("^Abrir el navegador en la pagina de login$")
    public void abrir_el_navegador_en_la_pagina_de_login()throws Throwable{
        //sel.SetProperties();
        sel.OpenBrowser(System.getProperty("PortalUrl"));
        sel.maximizeBrowser();
    }
    @And("^Abrir navegador con la siguiente URL \"([^\"]*)\"$")
    public void OpenBrowser(String url)throws Throwable{
        //sel.SetProperties();
        uri =url;
        sel.OpenBrowser(url);
        sel.maximizeBrowser();
    }
    @When("^Esperar \"([^\"]*)\" segundos$")
    public void WaitNSeconds(int n)throws Throwable{
        //token = gu.RemoveCharacters(restUtils.giveToken().headers.get("Invsec-Token").toString());
        //println(token)
        Thread.sleep(n*1000);
    }
    @And("^La pagina deberia tener los siguientes textos$")
    public void ValidateInnerText(DataTable dt)throws Throwable{
        boolean res=false;
        List<Map<String, String>> aux = dt.asMaps(String.class, String.class);
        for(int i = 0; i<aux.size();i++){
            res = sel.containsValueInXPath(aux.get(i).get("xpath"),aux.get(i).get("text").toString().trim());
        }
        Thread.sleep(1000);
        assert res;
    }
    @Given("^Buscar boton \"([^\"]*)\" de \"([^\"]*)\" y presionarlo$")
    public void buscar_boton_de_y_presionarlo(String buttonName, String POName) throws Throwable{
        sel.clickButtonInXPath(sel.GetXpathByName(buttonName,POName));
        Thread.sleep(7000);
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @And("^Validar Url contiene \"([^\"]*)\" extension$")
    public void ValidateUrl(String path){
        assert sel.GetCurrentURL().equalsIgnoreCase(uri+path);
    }
    @And("^Validar redireccionamiento a \"([^\"]*)\"$")
    public void ValidateRedirect(String ruta){
        //sql.ExecuteQueryDB("*","[FIX].[dbo].[PBA_Spoot]","Codigo_Ingreso = '{00002AA9-510A-462C-A569-8B33B143D328}'");
        assert sel.GetCurrentURL().equalsIgnoreCase(ruta);
    }
    @Given("^Ingresar el Rut de Usuario \"([^\"]*)\" al formulario$")
    public void RutLogin(String value)throws Throwable{
        sel.sendValuesXpath(sel.GetXpathByName("Ingreso_rut", "Login_access_po"),value);
        Thread.sleep(2000);
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @Given("^Ingresar la contrasena de Usuario \"([^\"]*)\" al formulario$")
    public void PasswordLogin(String value)throws Throwable{
        sel.sendValuesXpath(sel.GetXpathByName("Password_rut","Login_access_po"),value);
        Thread.sleep(2000);
    }
    @And("^Escribir \"([^\"]*)\" en el campo \"([^\"]*)\"$")
    public void SendValueToObject(String value, String field)throws Throwable{
        sel.sendValuesXpath(sel.GetXpathByName(field, "MainPage_po"),value);
    }
    @And("^El producto tiene \"([^\"]*)\" como nombre en xpath \"([^\\\"]*)\"$")
    public void ValidateText(String value, String xpath)throws Throwable{
        assert sel.containsValueInXPath(sel.GetXpathByName(xpath,"MainPage_po"),value);
    }
    //Steps shortcuts
    @And("^Ingreso los datos para llegar al Paso 1$")
    public void FirstStepValidations()throws Throwable{
        sel.sendValuesXpath(sel.GetXpathByName("Ingreso_rut","Login_access_po"),"173523947");
        //Bypass to Recaptcha
        sel.clickButtonInXPath(sel.GetXpathByName("Continuar","Primer_ingreso_po"));
        //assert sel.GetCurrentURL().equalsIgnoreCase("/security-public/first.html")
    }
    @And("^Escribir \"([^\"]*)\" en el campo \"([^\"]*)\" de formulario$")
    public void WriteFields(String value, String field)throws Throwable{
        sel.sendValuesXpath(sel.GetXpathByName(field, "Primer_ingreso_po"),value);
    }
    @And("^Seleccionar fecha \"([^\"]*)\" en campo \"([^\"]*)\"$")
    public void SelectInDropDown(String date, String path)throws Throwable{
        sel.SetAttribute(sel.GetXpathByName(path,"Primer_ingreso_po"), date);
        //sel.WriteElement(date, path);
    }
    @And("^Validar que boton \"([^\"]*)\" de \"([^\"]*)\" se encuentre activo$")
    public void ValidateButtonStatus(String buttonname, String pageobject)throws Throwable{
        assert !sel.getClass(buttonname, pageobject).equalsIgnoreCase("o-btn o-btn--primary js-change_step o-btn--disable");
    }
    @And("^Validar BreadCrumb en paso \"([^\"]*)\"$")
    public void BreadCrumbStatus(String status)throws Throwable{
       assert  sel.ValidateBreadCrumb(status).equalsIgnoreCase("c-steps__item is-current");
    }
    @When("^Se validan los textos en \"([^\"]*)\"$")
    public void se_validan_los_textos_en(String nameObject)throws Throwable{
       assert sel.validateValueinXPath(sel.GetXpathByName(nameObject,"Wizard_po")).equals(sel.ReadTexts("completa_datos_personales", nameObject));
        Thread.sleep(3000);
    }
    @And("^Ejecutar Reinicio de Wizard$")
    public void ReiniciarWizard()throws Throwable{
        restUtils.SendDeleteWizard();
        //assert aux.getBody().equals("{\n" +
          //      "    \"Mensaje\": \"Estados eliminados con éxito\"\n" +
            //    "}");
    }
    @And("^Validar el texto desplegado en \"([^\"]*)\"$")
    public void Validar_Texto_desplegado(String PO)throws Throwable{
        assert sel.validateValueinXPath(sel.GetXpathByName(PO,"Primer_ingreso_po")).equals(sel.ReadTexts("Clave_primaria", PO));
    }

    @And("^Ingresar Rut \"([^\"]*)\" al formulario$")
    public void LlenarRutFormulario(String field)throws Throwable{
        sel.sendValuesXpath(sel.GetXpathByName("Rut_primer_ingreso", "Primer_ingreso_po"),field);
        Thread.sleep(2000);
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @And("^Ingresar preguntas de seguridad con respuesta \"([^\"]*)\"$")
    public void SecurityQuestions(){
        System.out.println("respondiendo preguntas de seguridad");
    }
    @And("^Click en no soy un robot$")
    public void ClickOnRecaptcha()throws Throwable{
        //sel.clickButtonInXPath(sel.GetXpathByName("Recaptcha","Primer_ingreso_po"));
        //gu.clickOnRecaptcha();
        System.out.println("Voy por aca recaptcha");
        sel.RecaptchaBypass(sel.GetXpathByName("IframeXpath","Primer_ingreso_po"),sel.GetXpathByName("checkboxRecaptcha","Primer_ingreso_po"));
        System.out.println("Voy por aca recaptcha2");
        sel.takeScreenshot(ScenarioName, featureName);
        Thread.sleep(15000);
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @And("^Esperar a que boton \"([^\"]*)\" se active y hacer click$")
    public void WaitButtonRed(String button)throws Exception{
        Thread.sleep(7000);
        //assert sel.getClass(sel.GetXpathByName(button,"Primer_ingreso_po"),"Primer_ingreso_po").equalsIgnoreCase("ng-touched ng-dirty ng-valid");
        sel.clickButtonInXPath(sel.GetXpathByName(button,"Primer_ingreso_po"));
    }
    @And("^Seleccionar \"([^\"]*)\" en dropdown de \"([^\"]*)\" de formulario$")
    public void SelectDropdown(String state, String component)throws Throwable{
        sel.SelectDrowdown(sel.GetXpathByName(component, "Primer_ingreso_po"), state);

    }
    @And("^Seleccionar \"([^\"]*)\" accion a comprar$")
    public void SelectAction(String value)throws Throwable{
        sel.clickButtonInXPath(sel.GetXpathByName("AccionesDropDown","Acciones_po"));
        sel.sendValuesXpath(sel.GetXpathByName("AccionesDropDown", "Acciones_po"),value);
        sel.clickButtonInXPath(sel.GetXpathByName(value,"Acciones_po"));
        Thread.sleep(3000);
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @And("^Hacer Scroll hasta \"([^\"]*)\"$")
    public void ScrollTo(String value)throws Throwable{
        sel.Scrolling(sel.GetXpathByName(value,"Acciones_po"));
        Thread.sleep(2500);
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @Then("^Visualizar Precio de Acción \"([^\"]*)\"$")
    public void actionPrize(String value)throws Throwable{
        Thread.sleep(3000);
        assert value.equalsIgnoreCase(sel.validateValueinXPath(sel.GetXpathByName("PrecioAccion","Acciones_po")));
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @And("^Comprar \"([^\"]*)\" acciones$")
    public void AddActions(String amount)throws Throwable {
        float aux = gu.StringToFloat(sel.getTexts(sel.GetXpathByName("PrecioAccion", "Acciones_po")));
        float _amount = gu.StringToFloat(amount);
        int acciones = (int) gu.Multiplier(aux, _amount);
        String _acciones = Integer.toString(acciones);
        sel.sendValuesXpath(sel.GetXpathByName("AccionesAcomprar", "Acciones_po"), amount);
        sel.takeScreenshot(ScenarioName, featureName);
        assert gu.RemoveDollarChar(sel.GetInputValue(sel.GetXpathByName("MontoAcomprar", "Acciones_po"))).equalsIgnoreCase(_acciones);
        sel.Scrolling(sel.GetXpathByName("CheckboxCondiciones", "Acciones_po"));
        sel.clickButtonInXPath(sel.GetXpathByName("CheckboxCondiciones", "Acciones_po"));
        sel.takeScreenshot(ScenarioName, featureName);
        sel.clickButtonInXPath(sel.GetXpathByName("BotonAceptar", "Acciones_po"));
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @And("^Seleccionar forma de pago \"([^\"]*)\"$")
    public void PaymentMethodSelect(String text)throws Throwable{
        sel.SelectDrowdown(sel.GetXpathByName("FormaDePagoDropDown", "Acciones_po"),text);
        Thread.sleep(7000);
        sel.Scrolling(sel.GetXpathByName("AceptoCheckBox","Acciones_po"));
        Thread.sleep(2000);
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @And("^Validar Monto de gastos operacionales$")
    public void CalculateAmount(DataTable dt)throws Throwable{
        List<Map<String, String>> list =dt.asMaps(String.class, String.class);
        for(int i = 0; i<list.size();i++){
           String value =  sel.validateValueinXPath(sel.GetXpathByName(list.get(i).get("key"),"Acciones_po"));
           assert gu.RemoveDollarChar(value).equalsIgnoreCase(list.get(i).get("value"));
        }
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @And("^Validar Accion visible en Mis Movimientos$")
    public void MyActions()throws Throwable{
        String numero = sel.validateValueinXPath(sel.GetXpathByName("NumeroSolicitud","Acciones_po"));
        sel.clickButtonInXPath(sel.GetXpathByName("MisMovimientos", "Acciones_po"));
        Thread.sleep(3500);
        sel.clickButtonInXPath(sel.GetXpathByName("MisOrdenes","Acciones_po"));

        String aux = sel.validateValueinXPath(sel.GetXpathByName("FolioAccion","Acciones_po"));
        orderFolio = aux;
        assert sel.validateValueinXPath(sel.GetXpathByName("InstrumentoAccion","Acciones_po")).contains("FEPASA");
        assert aux.equalsIgnoreCase(numero);


    }
    @And("^Iniciar Sesion en Escritorio Comercial$")
    public void LoginSECO(){

    }
    @And("^Filtrar Acciones por \"([^\"]*)\"$")
    public void FilterActions(){

    }
    @And("^Validar el Estado de la accion$")
    public void ActionStatus(){

    }
    @And("^Anular Orden de compra$")
    public void CancellationAction()throws Throwable{
        sel.clickButtonInXPath(sel.GetXpathByName("AnularOrden", "Acciones_po"));
        Thread.sleep(3500);
        sel.takeScreenshot(ScenarioName, featureName);
        sel.clickButtonInXPath(sel.GetXpathByName("ContinuarAnulacion","Acciones_po"));
        Thread.sleep(2000);
        sel.takeScreenshot(ScenarioName, featureName);
    }
    @And("^Validar Orden anulada$")
    public void ValidateOrder()throws Throwable{
        sel.clickButtonInXPath(sel.GetXpathByName("CerrarPopupAnulacion", "Acciones_po"));
        Thread.sleep(2000);
        sel.clickButtonInXPath(sel.GetXpathByName("OrdenesAnuladas","Acciones_po"));
        Thread.sleep(3500);
        sel.takeScreenshot(ScenarioName, featureName);
        assert sel.validateValueinXPath(sel.GetXpathByName("OrdenAnuladaFolio","Acciones_po")).equalsIgnoreCase(orderFolio);
    }
}
