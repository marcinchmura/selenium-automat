import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CloudServicesTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void CloudServicesTest() {

        driver.navigate().to("https://app.bluealert.pl/ba/form/formularz-testowy");

        String pageTitle = driver.getTitle();
        WebElement firstName = driver.findElement(By.name("first_name"));
        WebElement lastName = driver.findElement(By.name("last_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement phone = driver.findElement(By.name("phone"));
        WebElement pesel = driver.findElement(By.name("pesel"));
        WebElement id_number = driver.findElement(By.name("id_numer"));
        WebElement date = driver.findElement(By.name("date"));
        WebElement formButtonNext = driver.findElement(By.id("form_button_next"));

        firstName.sendKeys("Jan");
        lastName.sendKeys("Kowalski");
        email.sendKeys("jan.kowalski@gmail.com");
        phone.sendKeys("715715715");
        pesel.sendKeys("78092790743");
        id_number.sendKeys("AMJ244308");
        date.sendKeys("1978-09-27");
        id_number.click();
        formButtonNext.click();
        WebElement consents = driver.findElement(By.id("fieldgroup_zgoda"));

        assertEquals(pageTitle, "Formularz testowy");
        assertTrue(consents.isDisplayed());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
