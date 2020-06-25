package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import support.BrowserCore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsuleiman on 22/06/2020.
 */
public class SearchResultsPage extends BrowserCore {

    @FindBy(css = "ul.product_list .product-name")
    private List<WebElement> productListElement;
    private List<String> productList = new ArrayList<>();

    @FindBy(id = "selectProductSort")
    private WebElement sortByList;

    @FindBy(css=".alert-warning")
    private WebElement errorMessage;


    public SearchResultsPage() {
        super(aDriver);

        PageFactory.initElements(aDriver, this);
    }

    public List<String> getSearchResults() {

        productListElement.forEach(item -> {
            if (item.getAttribute("innerText") != null) {
                productList.add(item.getAttribute("innerText"));

            }

        });
        return productList;
    }

    public SearchResultsPage sortBy(String sortByValue) {
     new Select(sortByList).selectByVisibleText(sortByValue);
        return this;
    }

    public Boolean sortedBy(String sortedByValue) {
        return new Select(sortByList).getFirstSelectedOption()
                .getText().contains(sortedByValue);
    }

    public String searchErrorMessage(){

        return errorMessage.getText();
    }

}
