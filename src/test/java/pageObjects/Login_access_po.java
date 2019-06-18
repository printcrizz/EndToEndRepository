package pageObjects;

public class Login_access_po {

    public Login_access_po(){

    }

    public String Ingreso_rut(){
        return "//*[@id=\"rut\"]";
    }
    public String Password_rut(){
        return "//*[@id=\"password\"]";
    }
    public String LoginButton(){
        return "//*[@id=\"block-inversiones-big-banner\"]/div/div/div/form/div/div/div/div[3]/button";
    }
    public String PrimerIngreso(){
        return "//*[@id=\"block-inversiones-big-banner\"]/div/div/div/form/div/div/div/div[4]/div[1]/a";
    }
    public String CheckreCaptcha(){
        return "//*[@id=\"recaptcha-anchor\"]/div[1]";
    }

}
