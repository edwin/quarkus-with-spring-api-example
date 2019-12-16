package com.edw.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <pre>
 *     com.edw.entity.User
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 16 Des 2019 11:56
 */
@Entity
@Table(name = "T_USER")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    private String username;
    private String passwd;

    public User(String id, String username, String passwd) {
        this.id = id;
        this.username = username;
        this.passwd = passwd;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
