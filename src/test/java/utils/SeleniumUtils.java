package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;


public class SeleniumUtils {

    public WebDriver driver;
    public EnvironmentsVariables env = new EnvironmentsVariables();
    private static ChromeDriverService service;

    public void OpenBrowser(String url)throws Exception {
        env.ReadJSONProperties();
        driver = new ChromeDriver();
        driver.get(url);
    }
    public void maximizeBrowser(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, java.util.concurrent.TimeUnit.SECONDS);
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
        assert path.contains(value);
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
        Thread.sleep(2000);
        return name;
    }
}
