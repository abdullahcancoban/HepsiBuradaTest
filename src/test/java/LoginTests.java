import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sayfalar.AnaSayfa;
import sayfalar.GirisYapSayfasi;

import javax.swing.*;
import java.time.Duration;


public class LoginTests {
    private WebDriver driver;
    private AnaSayfa anaSayfa;
    private GirisYapSayfasi girisYapSayfasi;

    @BeforeEach
    void setup() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        anaSayfa = new AnaSayfa(driver);
        girisYapSayfasi= new GirisYapSayfasi(driver);
        driver.get("https://www.hepsiburada.com");
    }



    @Test
    void hepsiburadaLoginTesti() {
        anaSayfa.elementGozukeneKadarBekle(anaSayfa.hesabim);
        anaSayfa.tusaBas(anaSayfa.hesabim);
        anaSayfa.elementTiklanabilirOlanaKadarBekle(anaSayfa.girisYap);
        anaSayfa.tusaBas(anaSayfa.girisYap);

        girisYapSayfasi.elementGozukeneKadarBekle(girisYapSayfasi.emailAdresi);
        girisYapSayfasi.alanaYaziYaz(girisYapSayfasi.emailAdresi,"seleniumotomasyonu@gmail.com");
        girisYapSayfasi.elementGozukeneKadarBekle(girisYapSayfasi.girisYapTusu);
        girisYapSayfasi.tusaBas(girisYapSayfasi.girisYapTusu);

    }

    @Test
    void urunAramaTesti() {
        //anaSayfa.elementTiklanabilirOlanaKadarBekleCss(anaSayfa.urunArama);
        //anaSayfa.tusaBasCss(anaSayfa.urunArama);
        anaSayfa.elementGozukeneKadarBekleCss(anaSayfa.urunArama);
        anaSayfa.alanaYaziYazCss(anaSayfa.urunArama,"araba");
        anaSayfa.klavyeTusunaBas(anaSayfa.urunArama, Keys.ENTER);

    }
    @AfterEach
    void tearDown(){

        driver.close();
    }
}