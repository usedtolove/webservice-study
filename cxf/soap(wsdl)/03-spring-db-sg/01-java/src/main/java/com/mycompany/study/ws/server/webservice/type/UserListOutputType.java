package com.mycompany.study.ws.server.webservice.type;

import com.mycompany.study.ws.server.entity.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

//element type & complexType name
@XmlType(name = "UserListOutputType", propOrder = {
    "user"
})
public class UserListOutputType {

    //element name
    @XmlElement(name = "User")
    private List<User> user;

    public List<User> getUser() {
        if (user == null) {
            user = new ArrayList<User>();
        }
        return this.user;
    }

}
