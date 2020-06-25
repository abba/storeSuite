package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.BrowserCore;

/**
 * Created by zsuleiman on 24/06/2020.
 */
public class SearchPage extends BrowserCore {

    @FindBy(id = "search_query_top")
    private WebElement searchBox;
    @FindBy(name = "submit_search")
    private WebElement searchButton;

    public SearchPage() {
        super(aDriver);

        PageFactory.initElements(aDriver,this);
    }


    public SearchPage search(String searchKeyword) {

        searchBox.clear();
        searchBox.sendKeys(searchKeyword);
       return this;
    }

    public SearchResultsPage submitSearch(){

        searchButton.submit();
        return new SearchResultsPage();
    }

}
