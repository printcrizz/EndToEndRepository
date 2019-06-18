package pageObjects;

public class Primer_ingreso_po {

    public Primer_ingreso_po(){

    }

    public String Rut(){
        return "//*[@id=\"rut\"]";
    }
    public String PrimerIngreso(){
        return "//*[@id=\"block-inversiones-big-banner\"]/div/div/div/form/div/div/div/div[4]/div[1]/a";
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
        return "//*[@id=\"step1\"]/div/div[1]/div[2]/div/div/input";
    }
    public String NumeroDeSerieCedula() {
        return "//*[@id=\"step1\"]/div/div[1]/div[2]/div/div/input";
    }
    public String FechaDeNacimiento() {
        return "//*[@id=\"step1\"]/div/div[1]/div[2]/div/div/input";
    }
    public String ContinuarStep2() {
        return "//*[@id=\"step1\"]/div/div[3]/div[1]/a";
    }
}