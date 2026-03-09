package context;


import com.microsoft.playwright.Page;

public class TextContext {

    private String createdUserEmail;
    private String token;
    private Page page;

    public String getCreatedUserEmail() {
        return createdUserEmail;
    }

    public void setCreatedUserEmail(String createdUserEmail) {
        this.createdUserEmail = createdUserEmail;
    }

    public void setAuthToken(String token) {
        this.token = token;
    }

    public String getAuthToken() {
        return token;
    }

    public Page getPage(){
        return page;
    }

}
