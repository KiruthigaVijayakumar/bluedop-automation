package pages;

import com.microsoft.playwright.Page;

public class LoginPageFinal {

    Page page;

    String username = "input[name='username']";
    String password = "input[name='password']";
    String loginBtn = "button[type='submit']";

    public LoginPageFinal(Page page) {
        this.page = page;
    }

    public void openURL() {
        page.navigate("https://opensource-demo.orangehrmlive.com/");
    }

    public void login(String user, String pass) {
        page.fill(username, user);
        page.fill(password, pass);
        page.click(loginBtn);
    }
}

