package core;

import org.openqa.selenium.support.PageFactory;
import support.BrowserCore;

/**
 * Created by zsuleiman on 22/06/2020.
 */
public class HomePage extends BrowserCore {


    public static final String HOME_PAGE = "http://automationpractice.com";


    public HomePage() {

        super(aDriver);

        PageFactory.initElements(aDriver, this);
    }


    public HomePage gotoHomePage() {

        aDriver.navigate().to(HOME_PAGE);


        return new HomePage();
    }


    public String pageTitle() {

        String pageTitle = aDriver.getTitle();

        return pageTitle;
    }




}