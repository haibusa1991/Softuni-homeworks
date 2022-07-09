package automapper.entities.user;

public class UserLoginDTO {
    private String email;
    public String password;

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLoginDTO(String loginInfo) {
        String[] tokens = loginInfo.split("\\|");
        this.email = tokens[1];
        this.password = tokens[2];
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
