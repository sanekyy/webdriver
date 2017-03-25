package com.sbpstu.webdriver;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by ihb on 25.03.17.
 */
public class AddIssueTest extends Init {


    @Test
    public void test1() throws InterruptedException {

        driver.navigate().to("http://localhost/mantisbt/login_page.php");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("administrator");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("aQmissyy" + Keys.ENTER);

        WebElement reportIssueButton = driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[1]/div/a[1]"));
        reportIssueButton.click();

        Random rand = new Random(System.currentTimeMillis());

        Select categoryId = new Select(driver.findElement(By.id("category_id")));
        categoryId.selectByIndex(Math.abs(rand.nextInt())%categoryId.getOptions().size());

        Select reproducibility = new Select(driver.findElement(By.id("reproducibility")));
        reproducibility.selectByIndex(Math.abs(rand.nextInt())%reproducibility.getOptions().size());

        Select severity = new Select(driver.findElement(By.id("severity")));
        severity.selectByIndex(Math.abs(rand.nextInt())%severity.getOptions().size());

        Select priority = new Select(driver.findElement(By.id("priority")));
        priority.selectByIndex(Math.abs(rand.nextInt())%priority.getOptions().size());

        WebElement profileOpenLink = driver.findElement(By.id("profile_closed_link"));
        try {
            profileOpenLink.click();
        } catch (WebDriverException ignored){

        }

        driver.findElement(By.id("platform"))
                .sendKeys("Intel");

        driver.findElement(By.id("os"))
                .sendKeys("Ubuntu");

        driver.findElement(By.id("os_build"))
                .sendKeys("16.04 LTS");

        Select handlerId = new Select(driver.findElement(By.id("handler_id")));
        handlerId.selectByIndex(Math.abs(rand.nextInt())%handlerId.getOptions().size());

        driver.findElement(By.id("summary"))
                .sendKeys("summary");

        driver.findElement(By.id("description"))
                .sendKeys("description");

        driver.findElement(By.id("steps_to_reproduce"))
                .sendKeys("steps_to_reproduce");

        driver.findElement(By.id("additional_info"))
                .sendKeys("additional_info");

       driver.findElement(By.id("tag_string"))
               .sendKeys("tag_string");


        List<WebElement> radioButtonsList = driver.findElements(By.name("view_state"));
        radioButtonsList.get(Math.abs(rand.nextInt())%radioButtonsList.size())
                .sendKeys(Keys.SPACE);

        driver.findElement(By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[1]/div/table/tbody/tr[14]/td/label/span"))
                .click();

        driver.findElement(By.xpath("//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input"))
                .submit();

        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost/mantisbt/view_all_bug_page.php"));

    }
}
