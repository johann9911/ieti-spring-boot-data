package org.ada.school.repository;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class UserDocument
{
    @Id
    String id;

    String name;

    @Indexed( unique = true )
    String email;

    String lastName;

    Date createdAt;

    public UserDocument()
    {
    }

    public User update(UserDto user) {
        this.name=user.getName();
        this.lastName=user.getLastName();
        this.email=user.getEmail();
        User userM = new User(user);
        return userM;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
