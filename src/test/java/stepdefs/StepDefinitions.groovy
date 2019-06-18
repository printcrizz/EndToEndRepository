package stepdefs;


import cucumber.api.DataTable
import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import utils.GeneralUtils
import utils.MySqlConnector
import utils.RestUtils
import utils.SeleniumUtils

class StepDefinitions {
    public static RestUtils restUtils = new RestUtils()
    public SeleniumUtils sel = new SeleniumUtils()
    public MySqlConnector sql = new MySqlConnector();
    public static GeneralUtils gu = new GeneralUtils();
    private String uri;


    private static String token = null;

    @Then("^Close Browser\$")
    public void closeBrowserInstance(){
        sel.CloseBrowser()
    }
    @And("^Abrir navegador con la siguiente URL \"([^\\\"]*)\"\$")
    void OpenBrowser(String url){
        uri =url
        sel.OpenBrowser(url)
        sel.maximizeBrowser()
    }
    @And("^Esperar \"([^\\\"]*)\" segundos\$")
    static void WaitNSeconds(int n){
        //token = gu.RemoveCharacters(restUtils.giveToken().headers.get("Invsec-Token").toString());
        //println(token)
        Thread.sleep(n*1000)
    }
    @And("^La pagina deberia tener los siguientes textos\$")
    void ValidateInnerText(DataTable dt){
        boolean res=false;
        //List<String> aux = dt.asList(String.class)
        List<Map<String, String>> aux = dt.asMaps(String.class, String.class)
        for(int i = 0; i<aux.size();i++){
            res = sel.containsValueInXPath(aux.get(i).get("xpath"),aux.get(i).get("text").toString().trim())
        }
        Thread.sleep(1000)
        assert res;
    }
    @And("^Buscar botón \"([^\\\"]*)\" de \"([^\\\"]*)\" y presionarlo\$")
    void SearchAndClickButton(String buttonName, String POName){
        sel.clickButtonInXPath(sel.GetXpathByName(buttonName,POName));
        //Thread.sleep(2000)
    }
    @And("^Validar Url contiene \"([^\\\"]*)\" extension\$")
    void ValidateUrl(String path){
        assert sel.GetCurrentURL().equalsIgnoreCase(uri+path);
    }
    @And("^Validar redireccionamiento a \"([^\\\"]*)\"\$")
    void ValidateRedirect(String ruta){
        //sql.ExecuteQueryDB("*","[FIX].[dbo].[PBA_Spoot]","Codigo_Ingreso = '{00002AA9-510A-462C-A569-8B33B143D328}'");
        assert sel.GetCurrentURL().equalsIgnoreCase(ruta)
    }
    @And("^Ingresar el Rut de Usuario \"([^\\\"]*)\" al formulario\$")
    void RutLogin(String value){
        sel.sendValuesXpath(sel.GetXpathByName("Ingreso_rut", "MainPage_po"),value)
        Thread.sleep(2000)
    }
    @And("^Ingresar la contrasena de Usuario \"([^\\\"]*)\" al formulario\$")
    void PasswordLogin(String value){
        sel.sendValuesXpath(sel.GetXpathByName("Password_rut","MainPage_po"),value)
        Thread.sleep(2000)
    }
    @And("^Escribir \"([^\\\"]*)\" en el campo \"([^\\\"]*)\"\$")
    void SendValueToObject(String value, String field){
        sel.sendValuesXpath(sel.GetXpathByName(field, "MainPage_po"),value)
    }
    @And("^El producto tiene \"([^\\\"]*)\" como nombre en xpath \"([^\\\"]*)\"\$")
    void ValidateText(String value, String xpath){
        assert sel.containsValueInXPath(sel.GetXpathByName(xpath,"MainPage_po"),value)
    }

    //Steps breves
    @And("^Ingreso los datos para llegar al Paso 1\$")
    void FirstStepValidations(){
        sel.sendValuesXpath(sel.GetXpathByName("Ingreso_rut","Login_access_po"),"173523947")
        //Bypass to Recaptcha
        sel.clickButtonInXPath(sel.GetXpathByName("Continuar","Primer_ingreso_po"))
        assert sel.GetCurrentURL().equalsIgnoreCase("/security-public/first.html")
    }


}
