import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class baseClass {
    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://automationexercise.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        WebElement card = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]"));

        //Instantiating Actions class
        Actions actions = new Actions(driver);

        //Hovering on main menu
        actions.moveToElement(card);

        // Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a"));

        //To mouseover on sub menu
        actions.moveToElement(subMenu);

        //build()- used to compile all the actions into a single step
        actions.click().build().perform();

        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a")).click();

        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();

        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a")).click();
        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("Test");

        String emailDomain = "@gmail.com"; // Replace with your desired email domain

        // Generate a timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());

        // Create the email address
        String email = "user" + timestamp + emailDomain;

        System.out.println("Generated email: " + email);

        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"uniform-id_gender1\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Abc@2023");

        Select selectDate = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        selectDate.selectByVisibleText("15");

        Select selectMonth = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        selectMonth.selectByVisibleText("April");

        Select selectYear = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        selectYear.selectByVisibleText("2021");

        driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();
        driver.findElement(By.id("first_name")).sendKeys("Demo");
        driver.findElement(By.id("last_name")).sendKeys("Test");
        driver.findElement(By.id("company")).sendKeys("Testing Company");
        driver.findElement(By.name("address1")).sendKeys("123 Main Street,P.O. Box 456,ABC Company");

        Select selectCountry = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
        selectCountry.selectByVisibleText("India");

        driver.findElement(By.id("state")).sendKeys("Maharashtra");
        driver.findElement(By.id("city")).sendKeys("Mumbai");
        driver.findElement(By.id("zipcode")).sendKeys("400057");
        driver.findElement(By.id("mobile_number")).sendKeys("02224928857");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
        Thread.sleep(5000);

        // Find the list item element you want to select
        WebElement listItem = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));

        // Click on the list item to select it
        listItem.click();
        driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();

        // Find the unordered list element
        WebElement deliveryAddress = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]"));

        // Find all list items within the unordered list
        List<WebElement> liElements = deliveryAddress.findElements(By.tagName("li"));

        // Iterate through the list items and print their text
        String deliveryAddressvalue = null;
        for (WebElement liElement : liElements) {
            deliveryAddressvalue = liElement.getText();
            System.out.println(deliveryAddressvalue);
        }


        WebElement ulElement = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]"));

        // Find all list items within the unordered list
        List<WebElement> liElementslist = ulElement.findElements(By.tagName("li"));


        String randomName = generateRandomName();
        String randomCardNumber = generateRandomCardNumber();
        String randomCVC = generateRandomCVC();
        String randomExpiration = generateRandomMonth();
        String randomExpirationYear = generateRandomYear();

        System.out.println("Random Name: " + randomName);
        System.out.println("Random Card Number: " + randomCardNumber);
        System.out.println("Random CVC: " + randomCVC);
        System.out.println("Random Expiration Month: " + randomExpiration);
        System.out.println("Random Expiration Year: " + randomExpiration);

        // Iterate through the list items and print their text
        String addressInvoice = null;
        for (WebElement liElement : liElementslist) {
            addressInvoice = liElement.getText();
            System.out.println(addressInvoice);
        }
            System.out.println("Success!!");
            driver.findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea")).sendKeys(" Please give me this orginal product, Thanks");
            driver.findElement(By.className("check_out")).click();
            Thread.sleep(1000);
            driver.findElement(By.name("name_on_card")).sendKeys(randomName);
            driver.findElement(By.name("card_number")).sendKeys(randomCardNumber);
            driver.findElement(By.name("cvc")).sendKeys(randomCVC);
            driver.findElement(By.name("expiry_month")).sendKeys(randomExpiration);
            driver.findElement(By.name("expiry_year")).sendKeys(randomExpirationYear);
            driver.findElement(By.id("submit")).click();
            driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
            driver.quit();
    }
    public static String generateRandomName() {
        String[] firstNames = {"John", "Emma", "Michael", "Olivia", "James", "Sophia"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Taylor", "Wilson", "Davis"};

        Random random = new Random();
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];

        return firstName + " " + lastName;
    }

    public static String generateRandomCardNumber() {
        Random random = new Random();
        long cardNumber = 4000000000000000L + random.nextInt(900000000);
        return String.valueOf(cardNumber);
    }

    public static String generateRandomCVC() {
        Random random = new Random();
        int cvc = 100 + random.nextInt(900);
        return String.valueOf(cvc);
    }

    public static String generateRandomMonth() {
        Random random = new Random();
        int month = 1 + random.nextInt(12);
        return String.valueOf(month);
    }
    public  static String generateRandomYear(){
        Random random = new Random();
        int year = 2023 + random.nextInt(5);
        return String.valueOf(year);
    }
}
