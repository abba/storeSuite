package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static support.BrowserCore.*;

/**
 * Created by zsuleiman on 22/06/2020.
 */
public class Hooks {




    @Before
    public void setUp(){

    setSystemsProperties();
        initialiseDriver();
        aDriver.manage().window().maximize();


    }



    @After
    public void tearDown(Scenario scenario){

        screenShotOnFailure(scenario);
        quiteDriver();

    }

}
