package com.entities.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ImportUserListDto {

    @XmlElement(name = "user")
    List<ImportUserDto> users;

    public ImportUserListDto() {
    }

    public List<ImportUserDto> getUsers() {
        return users;
    }
}
