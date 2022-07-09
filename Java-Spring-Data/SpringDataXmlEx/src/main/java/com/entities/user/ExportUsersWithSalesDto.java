package com.entities.user;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportUsersWithSalesDto {

    @XmlAttribute
    private int count;

    @XmlElement (name = "user")
//    @XmlElementWrapper (name = "users")
    private List<ExportUserListWithProductNamePriceDto> users;

    public ExportUsersWithSalesDto() {
    }

    public ExportUsersWithSalesDto(int count, List<ExportUserListWithProductNamePriceDto> users) {
        this.count = count;
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ExportUserListWithProductNamePriceDto> getUsers() {
        return users;
    }

    public void setUsers(List<ExportUserListWithProductNamePriceDto> users) {
        this.users = users;
    }
}
