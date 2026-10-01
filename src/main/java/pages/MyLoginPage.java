package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MyLoginPage {
    private Page page;

    public MyLoginPage(Page page) {
        this.page = page;
    }

    public void navigateToUrl(String url) {
        page.navigate(url);
    }

    public void enterUsername(String username) {
        page.getByLabel("Email").fill(username); // uses label instead of ID
    }

    public void enterPassword(String password) {
        page.getByLabel("Password").fill(password); // uses label instead of ID
    }

    public void clickLoginButton() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
        // ✅ Wait until navigation completes

    }

    public boolean isOnEventPage() {
        // Wait for the element to appear before checking
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Browse Events →")).waitFor();
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Browse Events →")).isVisible();
    }

}
