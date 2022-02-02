package stepDefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class HepsiburadaSteps {

    WebDriver driver;

    //launch hepsiburada.com
    @Given("I launch chrome browser")
    public void i_launch_chrome_browser()
    {
        System.setProperty("webdriver.chrome.driver", "C://Users//tr1d5056//Downloads/chromedriver.exe");
        driver=new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", "C://Users//tr1d5056//Downloads/geckodriver.exe");
//        driver = new FirefoxDriver();
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I open HepsiBurada home page")
    public void i_open_hepsi_burada_home_page()
    {
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();

    }

    @Then("I verify that logo is present on page")
    public void i_verify_that_logo_is_present_on_page()
    {
        boolean status =  driver.findElement(By.className("sf-OldHeader-2I4tx")).isDisplayed();
        Assert.assertEquals(true, status);
    }

    //login as a registered user
    @When("user mouse hover Giriş Yap veya Üye ol")
    public void user_mouse_hover_giriş_yap_veya_üye_ol() {
        Actions action = new Actions(driver);
        WebElement dropdown = driver.findElement(By.id("myAccount"));
        action.moveToElement(dropdown).build().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("user clicks on Giriş Yap")
    public void user_clicks_on_giriş_yap() {
        driver.findElement(By.id("login")).click();
    }

    @Then("{string} should be display")
    public void should_be_display(String string) {
        String ineedhelp = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/span")).getText();
        Assert.assertEquals("Yardıma ihtiyacım var",ineedhelp);
    }

    @When("User enters e-mail as {string}")
    public void user_enters_e_mail_as(String email) {
        driver.findElement(By.name("username")).sendKeys("sample@gmail.com");
    }

    @When("click on Giriş Yap")
    public void click_on_giriş_yap() {
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("Title should be {string}")
    public void title_should_be(String string) {
        String hosgeldiniz = driver.findElement(By.className("_8EhOpLNSY8WDom_J4mL6Y")).getText();
        Assert.assertEquals("Hoş geldiniz", hosgeldiniz);
    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
        driver.findElement(By.id("txtPassword")).sendKeys("samplepassword");
    }

    @When("User click on Giriş Yap")
    public void user_click_on_giriş_yap() {
        driver.findElement(By.id("btnEmailSelect")).click();
    }

    @Then("Login button should be {string}")
    public void login_button_should_be(String string) {
        String hesabim = driver.findElement(By.className("sf-OldMyAccount-PhY-T")).getText();
        Assert.assertEquals("Hesabım",hesabim);
    }

    //search for product and filter price range

    @Given("I launch hepsiburada.com")
    public void i_launch_hepsiburada_com() {
        String url =driver.getCurrentUrl();
        Assert.assertEquals("hepsiburada.com",url);
    }
    @When("I search for {string}")
    public void i_search_for(String string) {
        driver.findElement(By.className("desktopOldAutosuggestTheme-input")).sendKeys("cep telefonu");
    }
    @When("click on search button")
    public void click_on_search_button() {
        driver.findElement(By.className("SearchBoxOld-buttonContainer")).click();
    }
    @Then("filter response should be {string}")
    public void filter_response_should_be(String result) {
        String ceptelefonu = driver.findElement(By.className("searchResultSummaryBar-bold")).getText();
        Assert.assertEquals("cep telefonu",ceptelefonu);
    }
    @When("I set price range between {int} and {int}")
    public void i_set_price_range_between_and(Integer int1, Integer int2) {
        driver.findElement(By.xpath("//*[@id=\"fiyat\"]/div/div/div/div/div[1]/div/div[1]/input")).sendKeys("3000");
        driver.findElement(By.xpath("//*[@id=\"fiyat\"]/div/div/div/div/div[1]/div/div[2]/input")).sendKeys("5000");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @When("click on approve button")
    public void click_on_approve_button() {
        driver.findElement(By.xpath("//*[@id=\"fiyat\"]/div/div/div/div/div[1]/button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Then("selected filters should be {int}-{int}")
    public void selected_filters_should_be(Integer int1, Integer int2) {
        String range = driver.findElement(By.xpath("//*[@id=\"appliedVerticalFilterBar\"]/div/div/div[2]/div/div/div/div[1]/label")).getText();
        Assert.assertEquals("3000 - 5000 TL",range);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    }
    @When("I click on product")
    public void i_click_on_product() {
        driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[6]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div/ul[1]/li[19]/div/a/div[2]/div[1]/div[1]")).click();
        // driver.get("https://www.hepsiburada.com/huawei-p40-lite-128-gb-huawei-turkiye-garantili-p-HBV00000SXPMU");
        //locaterlar ile ürüne ulaşamadığım ve senaryoyu devam ettirmek istediğim için ürün bağlantısı ile devam ettim
        //driver.findElement(By.cssSelector("#i0 > div > a > div.moria-ProductCard-btfZRp.gcRGwd.saal8c4qwr9 > div.moria-ProductCard-jmtwOA.cDGz.svt3a0wue7q > div.moria-ProductCard-bwbOzc.bhiVbH.ssxmumagnbf > div:nth-child(3)")).click();
        //driver.findElement(By.xpath("//*[@id=\"i21\"]")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[6]/div[2]/div[2]/div[2]/div//div/div/div/div/div/div/ul/li[21]")).click();
    }

    @Then("product detail page is present")
    public void product_detail_page_is_present() {
        String sepet = driver.findElement(By.id("addToCart")).getText();
        Assert.assertEquals("Sepete Ekle",sepet);
    }

    @When("I click on all sellers")
    public void i_click_on_all_sellers() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[2]/div[2]/div/div[1]/a")).click();
    }
    @When("I click on Satıcı sorter twice")
    public void i_click_on_satıcı_sorter_twice() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"merchant-list\"]/tbody/tr[1]/td[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"merchant-list\"]/tbody/tr[1]/td[2]/a")).click();
    }
    @When("I click on Sepete Ekle button")
    public void i_click_on_sepete_ekle_button() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"merchant-list\"]/tbody/tr[3]/td[4]/form/button")).click();
    }
    @When("I click on close button at  repair pack panel")
    public void i_click_on_close_button_at_repair_pack_panel() {
        driver.findElement(By.xpath("//*[@id=\"pcwrapper\"]/div/i")).click();
    }
    @When("I click on Sepetim button")
    public void i_click_on_sepetim_button() {
        driver.findElement(By.id("shoppingCart")).click();
    }
    @Then("I verify true product at basket")
    public void i_verify_true_product_at_basket() {
        String product = driver.findElement(By.className("product_name_3Lh3t")).getText();
        Assert.assertEquals("Oppo A54 128 GB (Oppo Türkiye Garantili)",product);
    }
}