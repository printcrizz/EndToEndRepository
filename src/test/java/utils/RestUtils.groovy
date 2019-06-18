package utils

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest
import cucumber.api.DataTable
import gherkin.formatter.model.DataTableRow
import groovy.json.JsonParser
import groovy.json.JsonSlurper
import groovy.text.GStringTemplateEngine
import groovy.text.SimpleTemplateEngine
import groovy.text.StreamingTemplateEngine
import javafx.beans.binding.SetBinding
import org.apache.groovy.json.internal.JsonFastParser

import java.util.Map;
import java.util.Map.Entry;

class RestUtils {

    Unirest rest = new Unirest();
public HttpResponse<JsonNode> giveToken()throws Exception{
    HttpResponse<JsonNode> response = Unirest.post("https://eservices.inversionessecurity.cl/api/website/auth/login")
            .header("Content-Type", "application/json; charset=UTF-8")
            .header("Invsec-Channel", "1")
            .header("Invsec-Version", "1")
            .header("Host", "eservices.inversionessecurity.cl")
            .body("{\"idCliente\":\"12485766-k\", \"clave\":\"1234asdf\" }")
            .asJson();
    return response;
}

    public HttpResponse<JsonNode> sendFirstRequest(String tokenName, DataTable rut) throws Exception{
        HttpResponse<JsonNode> response = rest.post("https://api.sandbox.connect.fif.tech/sso/oauth2/v2/token")
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic 204972971540932329514:BIvHPipZOOSLOO2smaBhP_Y8SY2UOZZhwsb6eVeKJQvi")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "57496bba-8331-45ff-a6cf-83a6ae42ce11")
                .body(ReadTemplateToJson(tokenName, rut)).asJson();
        return response;
    }

    public HttpResponse<JsonNode> sendRequest(String bearer, String template, DataTable data) throws Exception{
        HttpResponse<JsonNode> response = rest.post("https://api.sandbox.connect.fif.tech/checkout/payments")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+bearer+"")
                .header("Cache-Control", "no-cache")
                .header("Postman-Token", "89d2e0fa-a13f-477a-a45b-785e9f783a54")
                .body(ReadTemplateToJson(template, data)).asJson()
        return response;
    }

    private static String ReadTemplateToJson(String templateName, DataTable dt) throws Throwable{
        File fileContents = new File("src/test/resources/templates/"+templateName)
        def binding = createBinding(dt)
        GStringTemplateEngine templateEngine = new GStringTemplateEngine()
        def template = templateEngine.createTemplate(fileContents)
        def response = template.make(binding.variables)

        return response;
    }
    private static Binding createBinding(DataTable aux) {
        List<Map<String, String>> list = aux.asMaps(String.class, String.class)
        def newBind = new Binding()
        for (int i = 0; i < list.size(); i++) {
           newBind.setVariable(list.get(i).get("Key"),list.get(i).get("Value").toString())
        }
        println("BINDINGS_FINAL: "+newBind.getVariables())
        return newBind
    }

 }



