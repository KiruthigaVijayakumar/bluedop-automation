package pages;

import com.microsoft.playwright.Page;

public class LoginPageFinal {
	
	Page page;

    // Locators
    String username = "#username";
    String password = "input[type='password']";
    String loginBtn = "button[type='submit']";

    public LoginPageFinal(Page page) {
        this.page = page;
    }

    public void openURL() {
        page.navigate("https://app-dev.bluedop.com/");
    }

    public void login(String user, String pass) {
        page.fill(username, user);
        page.fill(password, pass);
        page.click(loginBtn);
    }
}


