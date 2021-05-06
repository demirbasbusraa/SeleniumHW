package MyTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Test2 {

	public WebDriver driver;
  
    @Before
    public void setupDriver(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\PC\\Desktop\\SeleniumHW\\geckodriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void TestSearch(){

        WebElement searchBox = driver.findElement(By.id("searchData"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.className("searchBtn")).click();

        driver.findElement(By.xpath(".//*[@class='pagination']/a[2]")).click();
        driver.findElement(By.xpath(".//*[@id='p-369374378']/div[1]/a[1]")).click();

        WebElement price= driver.findElement(By.xpath(".//*[@class='newPrice']/ins[1]"));
        String textPrice1= price.getText();

        WebElement quantityBox = driver.findElement(By.id("quantity"));
        quantityBox.click();
        quantityBox.clear();
        quantityBox.sendKeys("1");

        WebElement btnBasket = driver.findElement(By.className("btnAddBasket"));
        btnBasket.click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("iconBasket")).click();

        WebElement basketPrice = driver.findElement(By.className("price"));
        String textPrice2 = basketPrice.getText();
        if(textPrice1.compareTo(textPrice2) > 0){

            WebElement quantityBasket = driver.findElement(By.id("quantity_126686985817"));
            quantityBasket.click();
            quantityBasket.clear();
            quantityBasket.sendKeys("1");
            driver.findElement(By.className("spinnerUp")).click();
        }
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("removeProd")).click();
    }
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}
