package pageObjects;

public class Acciones_po {

    public Acciones_po(){

    }

    public String Comprar(){
        return "/html/body/app-root/app-actions/main/div/div[2]/div[1]/app-submenu/div/div[2]/nav/ul/li[1]/ul/li[3]/a";
    }
    public String AccionesDropDown(){
        return "//*[@id=\"step1\"]/div[2]/div/div/app-ac-select/div/input";
    }
    public String FEPASA(){
        return "//*[@id=\"step1\"]/div[2]/div/div/app-ac-select/div/div/div[93]";

    }
    public String MontoAComprar(){
        return "//*[@id=\"result\"]/div[1]/div[3]/div/input";
    }
    public String PrecioAccion(){
        return "//*[@id=\"result\"]/div[2]/div[1]/div[4]/div/table/tbody/tr/td/span";
    }
}
