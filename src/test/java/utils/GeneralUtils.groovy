package utils

import cucumber.api.DataTable
import org.openqa.selenium.WebDriver

import java.awt.Robot
import java.text.DecimalFormat

class GeneralUtils {

    public static String AmountFormat(Integer amount){
        DecimalFormat formatter = new DecimalFormat("###,###,###.###")
        return formatter.format(amount).toString()
    }
    public static String AddMoneyHeist(String money){
        return "\$" + money
    }
    static Boolean ValidateTexts(DataTable aux, String body) {
        List<Map<String, String>> list = aux.asMaps(String.class, String.class)
        for (int i = 0; i < list.size(); i++) {
            body.contains(list(i).toString());
            println("objetos "+list(i).toString)
        }
        println("Se Acabo")
        return true
    }
    static void ChangeTab(String value){
        Robot movement = new Robot();
    }
    static String RemoveCharacters(String keys){
        String aux = keys;
        aux = aux.replace("[","");
        aux = aux.replace("]","");
        return aux;
    }
}

