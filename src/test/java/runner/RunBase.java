package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RunBase {

    static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

   public static WebDriver getDriver(String browser){
        System.setProperty("webdriver.chrome.driver", "C:\\AuthTreinamento\\Drivers\\128.0.6613.86\\chromedriver.exe");

        if(driver !=  null){
            driver.quit();
        }

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "chrome-ci":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                //driver = new FirefoxDriver();
                //break;
                throw new IllegalArgumentException("problema com o geckodriver (encontrando as versões correta)");
            case "edge":
                throw new IllegalArgumentException("Edge ainda não suportado");
            default:
                throw new IllegalArgumentException("Passe um navegador valido");
        }

        if(driver != null){
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }
}
