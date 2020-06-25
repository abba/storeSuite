package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import core.SearchPage;
import core.SearchResultsPage;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by zsuleiman on 23/06/2020.
 */
public class SearchSteps {

    private SearchPage searchPage = new SearchPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();


    @Given("^User search for \"([^\"]*)\"$")
    public void userSearchFor(String searchKeyword) throws Throwable {

        searchPage.search(searchKeyword).submitSearch();


    }

    @Then("^relevant search results should be returned$")
    public void relevantSearchResultsShouldBeReturned() throws Throwable {

        assertThat(searchResultsPage.getSearchResults(), hasItems());
    }

    @Then("^No results should be returned$")
    public void noResultsShouldBeReturned() throws Throwable {

        assertThat(searchResultsPage.getSearchResults().isEmpty(), is(true));


    }

    @Then("^Message \"([^\"]*)\" should be displayed$")
    public void messageShouldBeDisplayed(String errorMessage) throws Throwable {
        assertThat(searchResultsPage.searchErrorMessage(), containsString(errorMessage));
    }

    @Given("^Sort By \"([^\"]*)\"$")
    public void userSortBy(String sortBy) throws Throwable {
        searchResultsPage.sortBy(sortBy);
    }

    @Then("^Result should be Sorted By \"([^\"]*)\"$")
    public void resultShouldBeSortedBy(String sortedBy) throws Throwable {

        assertThat(searchResultsPage.sortedBy(sortedBy), is(true));

    }
}
