package utils;

import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class SeleniumUtils {

    private static WebDriver driver;
    private EnvironmentsVariables env = new EnvironmentsVariables();
    private GeneralUtils gu = new GeneralUtils();
    private static String FOLDERNAME = "Evidence";
    private String baseUrl;
    private String nodeUrl;
    DesiredCapabilities capability;
    private boolean driver_local ;

    public void setUp()throws Exception{
        SetProperties();
        driver_local = true;
        baseUrl = System.getProperty("PortalUrl");
        nodeUrl = "http://10.242.177.49:4444/wd/hub";
        //nodeUrl = "http://159.203.183.129:4444/wd/hub";
        capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);
        capability.setVersion("69.0.3497.100");
        driver = new RemoteWebDriver(new URL(nodeUrl), capability);

    }

    private void SetProperties()throws Exception{
        env.ReadJSONProperties();
    }
    public String ReadTexts(String name, String object)throws Exception{
        return env.ReadTextsOnWizard(name, object);
    }
    public void OpenBrowser(String url)throws Exception{
        if(!driver_local){
            System.out.println("soy falso");
           // driver = new ChromeDriver();
        }
        driver.get(url);
    }
    public void maximizeBrowser(){
        //driver.manage().timeouts().pageLoadTimeout(30, java.util.concurrent.TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS);
    }
    public void CloseBrowser() {
        driver.close();
    }
    public void changeIFrame(String newIFrame){
        driver.switchTo().frame(newIFrame);
    }
    public String validateValueinXPath(String path)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        return driver.findElement(By.xpath(path)).getText();
    }
    public void clickButtonInXPath(String path)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        driver.findElement(By.xpath(path)).click();
    }
    public void sendValuesXpath(String xpath, String value) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }
    public String validateTextInCss(String css)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        return driver.findElement(By.cssSelector(css)).getText();
    }
    public boolean CompareXpathWithValue(String xpath, String value)throws Throwable{
        return validateValueinXPath(xpath).equals(value);

    }
    public String getCSSColor(String path)throws Throwable{
        Thread.sleep(2000);
        return driver.findElement(By.xpath(path)).getCssValue("background-color");
    }
    //Obtiene la ubicacion de un objeto y retorna la posicion dentro de una matriz o arreglo
    public int getCardLocationInList(String bin, String path){
        int xpath =driver.findElements(By.xpath(path)).size();
        int result= 0;
        if(xpath==1)
            return 0;
        else {
            for (int i = 1; i <= xpath; i++) {
                String pathx = path + "[" + i + "]/strong/small";
                WebDriverWait wait = new WebDriverWait(driver, 3);
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathx)));
                String value = driver.findElement(By.xpath(pathx)).getText();
                if (value.contains(bin)) {
                    result = i;
                }
            }
        }
         return result;
    }
    public boolean containsValueInXPath(String xpath, String value){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String path = driver.findElement(By.xpath(xpath)).getText();
       // assert path.contains(value);
        return path.contains(value);
    }
    //compara 2 imágenes y retorna si son iguales.
    public void containsSameImage(String path, String imageName) throws IOException {
        BufferedImage expectedImage = ImageIO.read(new File("src/test/resources/images/"+imageName));
        WebElement logo = driver.findElement(By.xpath(path));
        String logoSRC = logo.getAttribute("src");

        URL imageURL = new URL(logoSRC);
        BufferedImage saveImage = ImageIO.read(imageURL);
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(saveImage, expectedImage);
        Assert.assertFalse(diff.hasDiff());
    }
    public boolean compareStringsInXpath(String xpath,String value) throws Throwable{
        Thread.sleep(4000);
        String path = driver.findElement(By.xpath(xpath)).getText();
        return value.equals(path);
    }
    public String getTexts(String id){
        return driver.findElement(By.xpath(id)).getText();
    }
    public void Scrolling(String id){
        WebElement element = driver.findElement(By.xpath(id));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public boolean ElementExist(String xpath){
        boolean re=false;
        WebElement aux = driver.findElement(By.xpath(xpath));
        if(aux!=null){
            re = true;
        }
        return re;
    }
    public String GetCurrentURL(){
        return driver.getCurrentUrl();
    }
    public void ChangeTabs(String value){
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.TAB);
        //driver.switchTo().sendKeys(selectLinkOpeninNewTab);
    }
    public String GetXpathByName(String buttonName, String PO)throws Exception{
        String className = "pageObjects."+PO;
        Class<?> innerClass = Class.forName(className); // convert string classname to class
        String methodName = buttonName;
        Object aux = innerClass.newInstance(); // invoke empty constructor
        Method getNameMethod = aux.getClass().getMethod(methodName);
        String name = (String) getNameMethod.invoke(aux); // explicit cast
        //Thread.sleep(2000);
        return name;
    }

    public void SetAttribute(String id, String attribute){
        WebElement element = driver.findElement(By.xpath(id));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('placeholder',"+attribute+" )",element);
    }
    public String getClass(String path,String po)throws Exception{
        return driver.findElement(By.xpath(GetXpathByName(path,po))).getAttribute("class");
    }
    public String ValidateBreadCrumb(String status)throws Exception{
        return getClass(status, "Wizard_po");
    }
    public void takeScreenshot() throws Exception {
        CreateDirectory("evidencias");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(FOLDERNAME+"/screenshot-"+gu.CreateTimeStamp()+".png"));
    }
    private void CreateDirectory(String nameFolder){
        File newFolder = new File(System.getProperty("ScreenshotsDirectory")+"/"+nameFolder);
        FOLDERNAME =newFolder.toString();
        boolean created =  newFolder.mkdirs();
        if(created){
            System.out.println("screenshot tomado en "+FOLDERNAME);
        }else
            System.out.println("screenshot tomado en 2 "+FOLDERNAME);
    }
    public void AfterTest(){
        driver.quit();
    }
}
