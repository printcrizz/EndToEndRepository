package pageObjects;

public class Acciones_po {

    public Acciones_po(){

    }

    public String Comprar(){
        return "/html/body/app-root/app-actions/main/div/div[2]/div[1]/app-submenu/div/div[2]/nav/ul/li[1]/ul/li[3]/a";
    }
    public String AccionesDropDown(){
        return "//*[@id=\"step1\"]/div[1]/div/div[1]/div/div[1]/div/app-ac-select/div/input";
        //return "//*[@id=\"step1\"]/div[2]/div/div/app-ac-select/div/input";
    }
    public String FEPASA(){
        return "//*[@id=\"step1\"]/div[1]/div/div[1]/div/div[1]/div/app-ac-select/div/div/div[93]";
        //return "//*[@id=\"step1\"]/div[2]/div/div/app-ac-select/div/div/div[93]";

    }
    public String MontoAComprar(){
        return "//*[@id=\"result\"]/div[2]/div[1]/input";
    }
    public String PrecioAccion(){
        return "//*[@id=\"step1\"]/div[2]/div[1]/div/div[3]/div[2]/div/div/div/span";
        //return "//*[@id=\"result\"]/div[2]/div[1]/div[4]/div/table/tbody/tr/td/span";
    }
    public String AceptoCheckBox(){
        return "//*[@id=\"step1\"]/div[3]/form/div[2]/div/span/label";
    }
    public String FormaDePagoDropDown(){
        return "//*[@id=\"step1\"]/div[3]/div/div/div/div/div[1]/select";
    }
    public String AccionesAcomprar(){
        return "//*[@id=\"result\"]/div[2]/div[2]/input";
    }
    public String CheckboxCondiciones(){
        return "//*[@id=\"step1\"]/div[3]/form/div[2]/div/span/label";
    }
    public String BotonContinuar(){
        return "//*[@id=\"next\"]/div/div/button";
    }
    public String BotonAceptar(){
        return "/html/body/app-root/app-actions/main/div/div[2]/div[2]/app-buy-actions/p-dialog/div/div[3]/p-footer/button";
    }
    public String MontoAcomprar(){
        return "//*[@id=\"result\"]/div[2]/div[1]/input";
    }
    public String AceptoTransaccionesText(){
        return "//*[@id=\"step1\"]/div[3]/form/div[2]/div/span/label";
    }

    public String Comision(){
        return "//*[@id=\"step2\"]/div[3]/div[1]/dl/dd";
    }
    public String Derecho(){
        return "//*[@id=\"step2\"]/div[3]/div[2]/dl/dd";
    }
    public String IVA(){
        return "//*[@id=\"step2\"]/div[3]/div[4]/dl/dd";
    }
    public String Otros(){
        return "//*[@id=\"step2\"]/div[3]/div[3]/dl/dd";
    }
    public String TotalGastos(){
        return "//*[@id=\"step2\"]/div[3]/div[5]/dl/dd";
    }
    public String Confirmar(){
        return "//*[@id=\"step2\"]/div[4]/div[2]/div/a[2]";
    }
    public String TotalOperacion(){
        return "//*[@id=\"step3\"]/div[5]/div/dl/dd";
    }
    public String MisMovimientos(){
        return "/html/body/app-root/app-actions/main/div/div[2]/div[1]/app-submenu/div/div[2]/nav/ul/li[1]/ul/li[2]/a";
    }
    public String MisOrdenes(){
        return "/html/body/app-root/app-actions/main/div/div[2]/div[2]/app-my-movements/div[1]/a[2]/span";
    }
    public String NumeroSolicitud(){
        return "//*[@id=\"step3\"]/div[3]/div[7]/dl/dd";
    }
    public String FolioAccion(){
        return "//*[@id=\"tab_03\"]/section/div/div/p-datatable/div/div[1]/table/tbody/tr[1]/td[3]/span";
    }
    public String InstrumentoAccion(){
        return "//*[@id=\"tab_03\"]/section/div/div/p-datatable/div/div[1]/table/tbody/tr[1]/td[5]/span";
    }
    public String AnularOrden(){
        return "//*[@id=\"tab_03\"]/section/div/div/p-datatable/div/div[1]/table/tbody/tr[1]/td[2]/span/a";
    }
    public String ContinuarAnulacion(){
        return "/html/body/app-root/app-actions/main/div/div[2]/div[2]/app-my-movements/p-dialog/div/div[3]/p-footer/button[2]";
    }
    public String OrdenesAnuladas(){
        return "//*[@id=\"tab_02\"]/div[1]/a[2]/span";
    }
    public String OrdenAnuladaFolio(){
        return "//*[@id=\"tab_04\"]/section/div/p-datatable/div/div[1]/table/tbody/tr[1]/td[1]/span";
    }
    public String CerrarPopupAnulacion(){
        return "/html/body/app-root/app-actions/main/div/div[2]/div[2]/app-my-movements/p-dialog/div/div[3]/p-footer/button";
    }


}
