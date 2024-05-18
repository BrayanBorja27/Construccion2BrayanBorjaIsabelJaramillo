package tdea.construccion2.appVeterinary.Controller.request;

import org.antlr.v4.runtime.misc.NotNull;

public class CreateUserRequest {

    private String fullName;
    private String id;

    private String userName;
    private String password;
    private String role;
    public CreateUserRequest() {}
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
