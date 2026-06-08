package com.pageobjectmanager;

import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchPage;
import com.utility.FileReaderManager;

public class PageObjectManager {

    private LoginPage loginpage;
    private FileReaderManager fileReaderManager;
    private static PageObjectManager pageObjectManager;
    private SearchPage searchPage;

    public LoginPage getLoginPage() {
        if (loginpage == null) {
            loginpage = new LoginPage();
        }
        return loginpage;
    }
    public FileReaderManager getFileReaderManager() {
        if (fileReaderManager == null) {
            fileReaderManager = new FileReaderManager();
        }
        return fileReaderManager;
    }
    public static PageObjectManager getPageObjectManager() {
        if(pageObjectManager == null) {
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }
    public SearchPage getSearchPage() {
        if(searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }
}
