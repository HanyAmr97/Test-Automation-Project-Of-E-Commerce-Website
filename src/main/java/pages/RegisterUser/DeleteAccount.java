package pages.RegisterUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccount {
    final By deleteBtn = By.xpath("//a[@href='/delete_account']");
    final By accountIsDeleted = By.xpath("//div[@class='col-sm-9 col-sm-offset-1']");
    final By continueBtn = By.xpath("//a[contains(text(),'Continue')]");

    protected WebDriver driver;

    //Constructor for the page
    public DeleteAccount(WebDriver driver) {
        this.driver = driver;
    }

    //Checking the delete account
    public void accountDelete() {
        driver.findElement(deleteBtn).click();
        String str = driver.findElement(accountIsDeleted).getText();
        if (str.contains("account has been successfully created")) {
            System.out.println("Congrats! Your account has been created successfully!");
        } else {
            System.out.println("unfortunately! Your account has been not created!");
        }

        driver.findElement(continueBtn).click();
    }

}
