import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Project4 {
    @Test
    public void TaskCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Index");
        WebElement newButton = driver.findElement(By.xpath("//a[.='Create New']"));
        newButton.click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        WebElement createNewButton1 = driver.findElement(By.xpath("//a[.='Create New']"));
        createNewButton1.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Obama");
        WebElement latstName = driver.findElement(By.xpath("//input[@id='LastName']"));
        latstName.sendKeys("Rank");
        WebElement enrollment = driver.findElement(By.xpath("//label[.='EnrollmentDate']//..//input[@class='form-control text-box single-line']"));
        enrollment.sendKeys("02.24.2022");
        WebElement creatbutton = driver.findElement(By.xpath("//input[@value='Create']"));
        creatbutton.click();
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar.sendKeys("Obama");
        WebElement findBox = driver.findElement(By.xpath("//input[@class='btn ']"));
        findBox.click();
        WebElement validName = driver.findElement(By.xpath("//td[contains(text(),'Obama')]"));
        System.out.println(validName.getText());
        String actualValid = validName.getText();
        String expectedValid = "Obama";
        Assert.assertEquals(actualValid, expectedValid);


    }

    @Test
    public void TaskCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Index");
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar.sendKeys("Dutta");
        WebElement findButton = driver.findElement(By.xpath("//input[@class='btn ']"));
        findButton.click();
        WebElement editButton = driver.findElement(By.xpath("//button[.='EDIT']"));
        editButton.click();
        WebElement changeName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        changeName.clear();
        changeName.sendKeys("Zolushka");
        WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
        saveButton.click();

        WebElement searchBar1 = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar1.sendKeys("Zolushka");
        WebElement findButton1 = driver.findElement(By.xpath("//input[@class='btn ']"));
        findButton1.click();
        WebElement validChangedName = driver.findElement(By.xpath("//td[contains(text(),'Zolushka')]"));
        System.out.println(validChangedName.getText());
        String actualName = validChangedName.getText();
        String expectedName = "Zolushka";
        Assert.assertEquals(actualName, expectedName);
    }

    @Test
    public void TaskCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/Students/Index");
        WebElement newButton = driver.findElement(By.xpath("//a[.='Create New']"));
        newButton.click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        WebElement createNewButton1 = driver.findElement(By.xpath("//a[.='Create New']"));
        createNewButton1.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Shakira");
        WebElement latstName = driver.findElement(By.xpath("//input[@id='LastName']"));
        latstName.sendKeys("TRONTO");
        WebElement enrollment = driver.findElement(By.xpath("//label[.='EnrollmentDate']//..//input[@class='form-control text-box single-line']"));
        enrollment.sendKeys("02.24.2022");
        WebElement creatbutton = driver.findElement(By.xpath("//input[@value='Create']"));
        creatbutton.click();
        driver.get("http://uitestpractice.com/Students/Index");
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar.sendKeys("TRONTO");
        WebElement findButton = driver.findElement(By.xpath("//input[@class='btn ']"));
        findButton.click();
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='DELETE']"));
        deleteButton.click();
        WebElement deleteConfirm = driver.findElement(By.xpath("//input[@value='Delete']"));
        deleteConfirm.click();

        WebElement searchBar2 = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar2.sendKeys("TRONTO");
        WebElement findButton2 = driver.findElement(By.xpath("//input[@class='btn ']"));
        findButton2.click();


        WebElement validChangedName = driver.findElement(By.xpath("//form//.."));
        System.out.println(validChangedName.getText());
        String actualName = validChangedName.getText();
        String expectedName = "There are zero students with this search text Page 0 of 0";
        Assert.assertEquals(actualName, expectedName);
    }

    @Test
    public void TestCase4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/");
        Actions actions = new Actions(driver);
        WebElement whiteBox = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement greyBox = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(whiteBox, greyBox).perform();
        WebElement textValid = driver.findElement(By.xpath("//p[.='Dropped!']"));
        System.out.println(textValid.getText());
        String actualValidation = textValid.getText();
        String expectedValidation = "Dropped!";
        Assert.assertEquals(actualValidation, expectedValidation);


    }

    @Test
    public void TestCase5() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/");
        Actions actions = new Actions(driver);
        WebElement dobleClickButton = driver.findElement(By.xpath("//button[@name='dblClick']"));
        Thread.sleep(2000);
        actions.doubleClick(dobleClickButton);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();


    }

    @Test
    public void TestCase6() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://uitestpractice.com/");
        driver.switchTo().frame("iframe_a");
        WebElement name= driver.findElement(By.xpath("//label[.='Enter your name:']//..//input[@id='name']"));
        name.sendKeys("Milan");
        driver.switchTo().parentFrame();
        WebElement clickUnder= driver.findElement(By.xpath("//a[.='uitestpractice.com']"));
        clickUnder.click();
       // WebElement textValid= driver.findElement(By.xpath("//div[@id='sub-frame-error-details']//strong[.='www.uitestpractice.com']"));
        WebElement seeText= driver.findElement(By.xpath("//div[@id='sub-frame-error']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(seeText);
       // System.out.println(textValid.getText());

    }
}