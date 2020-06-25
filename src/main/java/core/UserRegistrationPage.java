package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import support.BrowserCore;
import support.RandomData;

/**
 * Created by zsuleiman on 22/06/2020.
 */
public class UserRegistrationPage extends BrowserCore {

    @FindBy(id="customer_firstname")
    private WebElement firstName;
    @FindBy(id="customer_lastname")
    private WebElement lastName;
    @FindBy(id="passwd")
    private WebElement password;
    @FindBy(id="address1")
    private WebElement address;
    @FindBy(id="city")
    private WebElement city;
    @FindBy(id="id_state")
    private WebElement state;
    @FindBy(id="postcode")
    private WebElement zipCode;
    @FindBy(id="phone_mobile")
    private WebElement mobilePhone;
    @FindBy(id="submitAccount")
    private WebElement registerButton;
    @FindBy(id="email_create")
    private WebElement emailAddressCreate;
    @FindBy(id="SubmitCreate")
    private WebElement createAnAccount;
    private static RandomData randomData = new RandomData();
    private static String email = randomData.randomEmail();



    public UserRegistrationPage(){

        super(aDriver);

        PageFactory.initElements(aDriver,this);

    }


    public UserRegistrationPage gotoUserRegistrationPage(){

        new SignInPage().goToSignInPage();
        emailAddressCreate.clear();
        emailAddressCreate.sendKeys(email);
        System.out.println("Email :"+email);
        createAnAccount.click();

        return this;
    }

    public UserRegistrationPage setFirstName(){

        firstName.clear();
        firstName.sendKeys(randomData.firstName());

       return this;
    }

    public UserRegistrationPage setLastName(){

       lastName.clear();
       lastName.sendKeys(randomData.firstName());

        return this;
    }

    public UserRegistrationPage setPassword(){

        password.clear();
        password.sendKeys("abcd1234");
        return this;
    }

    public UserRegistrationPage setAddress(){

        address.clear();
        address.sendKeys(randomData.address());
        return this;
    }

    public UserRegistrationPage setCity(){

        city.clear();
        city.sendKeys(randomData.address());
        return this;
    }

    public UserRegistrationPage setState(){

        new Select(state).selectByIndex(1);

        return this;
    }

    public UserRegistrationPage setZipCode(){

        zipCode.clear();
        zipCode.sendKeys(randomData.zipCode());
        return this;
    }

    public UserRegistrationPage setMobilePhone(){

        mobilePhone.clear();
        mobilePhone.sendKeys(randomData.mobilePhone());
        return this;
    }


    public UserRegistrationPage register(){

        registerButton.click();
        return this;
    }

    public Boolean registeredSuccessfully(){


        return aDriver.getTitle().contains("My account");

    }


}
