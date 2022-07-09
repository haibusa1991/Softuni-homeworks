package JsonEx.entities.user;

import java.util.Set;

public class UsersProductsCountDto {
    private int usersCount;
    private Set<UserProductDto> users;

    public UsersProductsCountDto() {
    }

    public UsersProductsCountDto(int userCount, Set<UserProductDto> users) {
        this.usersCount = userCount;
        this.users = users;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserProductDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserProductDto> users) {
        this.users = users;
    }
}
