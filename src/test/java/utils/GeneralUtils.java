package utils;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;

import java.awt.Robot;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class GeneralUtils {

    public GeneralUtils(){

    }

    public static String AmountFormat(Integer amount){
        DecimalFormat formatter = new DecimalFormat("###,###,###.###");
        return formatter.format(amount).toString();
    }
    public static String AddMoneyHeist(String money){
        return "$" + money;
    }
    static Boolean ValidateTexts(DataTable aux, String body) {
        List<Map<String, String>> list = aux.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            body.contains(list.get(i).toString());
            System.out.println("objetos "+list.get(i).toString());
        }
        return true;
    }
    //static void ChangeTab(String value){
      //  Robot movement = new Robot();
    //}
    static String RemoveCharacters(String keys){
        String aux = keys;
        aux = aux.replace("[","");
        aux = aux.replace("]","");
        return aux;
    }
    public String CreateTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        return timestamp.toString();
    }
}

