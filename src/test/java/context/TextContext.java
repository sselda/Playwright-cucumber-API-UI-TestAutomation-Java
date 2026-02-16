package context;

public class TextContext {

    private String createdUserEmail;
    private String token;

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


}
