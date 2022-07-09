package lecture06.ME04TeamworkProjects;

public class TeamMember {
    private String name;
    private String role = "member";

    public TeamMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}