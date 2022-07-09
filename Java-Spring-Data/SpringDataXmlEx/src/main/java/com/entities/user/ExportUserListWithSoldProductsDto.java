package com.entities.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportUserListWithSoldProductsDto {

    @XmlElement(name = "user")
    private List<ExportUserWithSoldProductsDto> users;

    public ExportUserListWithSoldProductsDto() {
    }

    public ExportUserListWithSoldProductsDto(List<ExportUserWithSoldProductsDto> users) {
        this.users = users;
    }

    public List<ExportUserWithSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<ExportUserWithSoldProductsDto> users) {
        this.users = users;
    }
}
