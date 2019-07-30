package pageObjects;

public class Wizard_po {

    public Wizard_po(){

    }

    public String DatosPersonales(){
        return "/html/body/app-root/app-header/app-wizard/app-wizard-modal-container/p-dialog/div/div[2]/app-dinamico-form/div/app-index/div/div/div[1]";
    }
    public String NormasTexto(){
        return "/html/body/app-root/app-header/app-wizard/app-wizard-modal-container/p-dialog/div/div[2]/app-dinamico-form/div/div/form/div[2]/div[1]/p";
    }
    public String FirmaDigital(){
        return "/html/body/app-root/app-header/app-wizard/app-wizard-modal-container/p-dialog/div/div[2]/app-dinamico-form/div/div/form/div[2]/div[2]/div/div/div";
    }
    public String USPerson(){
        return "/html/body/app-root/app-header/app-wizard/app-wizard-modal-container/p-dialog/div/div[2]/app-dinamico-form/div/div/form/div[2]/div[3]/div/div[2]/p";
    }
    public String CompletarDatos(){
        return "//*[@id=\"submitter\"]";
    }
    public String DatosPersonalesHeader(){
        return "/html/body/app-root/app-header/app-wizard/app-wizard-modal-container[3]/p-dialog/div/div[1]/span";
    }
    public String Continuar(){
        return "//*[@id=\"submitter\"]";
    }
    public String DireccionParticular(){
        return "/html/body/app-root/app-header/app-wizard/app-wizard-modal-container[7]/p-dialog/div/div[2]/app-dinamico-form/div/h4";
    }
    public String PoseeRut(){
        return "//*[@id=\"container-empleadornacional\"]/div/div/label/span";
    }
    public String NoEsChileno(){
        return "//*[@id=\"container-empleadornacional\"]/div/div/app-radio/div/div[2]";
    }
    public String SiEsChileno(){
        return "//*[@id=\"container-empleadornacional\"]/div/div/app-radio/div/div[1]";
    }
    public String Rut_id_tributario(){
        return "//*[@id=\"container-rutempleador\"]/div/div/label/span";
    }
    public String NumeroFiscalID(){
        return "//*[@id=\"container-idempleadorextranjero\"]/div/div/label/span";
    }
    public String RutEmpleador(){
        return "//*[@id=\"container-rutempleador\"]/div/div/label";
    }
    public String TipoTrabajador(){
        return "//*[@id=\"codigoTipoTrabajador\"]";
    }
    public String DatosLaborales(){
        return "/html/body/app-root/app-header/app-wizard/app-wizard-modal-container[17]/p-dialog/div/div[2]/app-dinamico-form/div/h4";
    }
}
