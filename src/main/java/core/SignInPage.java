package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.BrowserCore;

import static core.HomePage.HOME_PAGE;

/**
 * Created by zsuleiman on 22/06/2020.
 */
public class SignInPage extends BrowserCore {

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signIn;


    @FindBy(css=".alert-danger")
    private WebElement errorMessage;

    private final String LOGIN_PAGE_URL=HOME_PAGE+"/index.php?controller=authentication";

   public SignInPage(){

       super(aDriver);
       PageFactory.initElements(aDriver,this);

   }



   public SignInPage goToSignInPage(){

       aDriver.navigate().to(LOGIN_PAGE_URL);

       return this;

   }



   public SignInPage setEmailAddress(String email){

       emailAddress.clear();
       emailAddress.sendKeys(email);
       return this;
   }


   public SignInPage setPassword(String userPassword){


       password.clear();
       password.sendKeys(userPassword);

       return this;
   }

   public SignInPage signIn(){

       signIn.click();
       return this;
   }


   public Boolean signedIn(){


       return aDriver.getTitle().contains("My account");

   }

   public String errorMessage(){

       return errorMessage.getText();
   }

}
