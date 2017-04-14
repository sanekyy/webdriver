package com.spbstu.pageObjects.mantisbt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ihb on 11.04.17.
 */
public interface MySelect extends WebElement {

    default Select getSelect(){
        return new Select(this);
    }
}
