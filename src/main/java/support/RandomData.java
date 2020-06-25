package support;

import com.github.javafaker.Faker;

import java.util.Random;

/**
 * Created by zsuleiman on 23/06/2020.
 */
public class RandomData {

    private Faker fakeDetails = new Faker();


    public String firstName() {

        return fakeDetails.name().firstName();

    }

    public String lastName() {

        return fakeDetails.name().lastName();

    }

    public String address() {


        return fakeDetails.address().streetAddress();

    }

    public String city(){

        return fakeDetails.address().city();
    }

    public String zipCode (){

        return "00000";
    }


    public String state(){


        return fakeDetails.address().state();
    }


    public String mobilePhone(){

        return fakeDetails.phoneNumber().cellPhone();

    }

    public String randomEmail() {

        Integer randomNumber = new Random().nextInt(1000);

        return "usertest" + randomNumber + "@test.com";
    }

}
