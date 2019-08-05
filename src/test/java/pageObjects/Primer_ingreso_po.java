package pageObjects;

public class Primer_ingreso_po {

    public Primer_ingreso_po(){

    }

    public String Rut(){
        return "//*[@id=\"rut\"]";
    }
    public String Primer_Ingreso(){
        return "//*[@id=\"block-inversiones-big-banner\"]/div/div/div/form/div/div/div/div[4]/div[1]/a";
    }
    public String Crear_clave_de_acceso(){
        return "/html/body/app-root/app-primarykey/main/div/div/div/app-first-entry/div/div/section/div/div[2]/container-element/div/app-informationtext/div[1]/p";
    }
    public String Rut_primer_ingreso(){
        return "/html/body/app-root/app-primarykey/main/div/div/div/app-first-entry/div/div/section/div/div[2]/container-element/div/app-validaterut/form/div[1]/wizard-input[1]/div/input";
    }
    public String Recaptcha(){
        return "//*[@id=\"recaptcha-anchor\"]";
    }
    public String Continuar(){
        return "//*[@id=\"step1\"]/div/form/div[3]/div[1]/button";
    }
    public String NombresInput(){
        return "//*[@id=\"step1\"]/div/div[1]/div[1]/div/div/input";
    }
    public String ApellidoPaterno() {
        return "//*[@id=\"step1\"]/div/div[1]/div[2]/div/div/input";
    }
    public String ApellidoMaterno() {
        return "//*[@id=\"step1\"]/div/div[1]/div[3]/div/div/input";
    }
    public String NumeroDeSerieCedula() {
        return "//*[@id=\"step1\"]/div/div[1]/div[5]/div/div/input";
    }
    public String FechaDeNacimiento() {
        return "//*[@id=\"date\"]";
    }
    public String ContinuarStep2() {
        return "//*[@id=\"step1\"]/div/div[3]/div[1]/a";
    }
    public String FormatoCedula(){
        return "//*[@id=\"o-alert__step2\"]/p[2]/strong";
    }
    public String IconClose(){
        return "//*[@id=\"o-alert__step2\"]/a/i";
    }
    public String Continuar_step_2(){
        return "/html/body/app-root/app-primarykey/main/div/div/div/app-first-entry/div/div/section/div/div[2]/container-element/div/app-informationtext/div[2]/div/wizard-button/button";
    }
    //class="o-btn o-btn--primary js-change_step o-btn--disable"
    //o-btn o-btn--primary js-change_step
}