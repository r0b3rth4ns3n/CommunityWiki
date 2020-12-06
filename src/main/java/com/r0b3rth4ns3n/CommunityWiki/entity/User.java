package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String userID;
    private String pseudonym;
    private String password;
    @OneToMany(mappedBy="user")
    private List<Content> content;
    @OneToMany
    private List<Feedback> feedback;

    public User() {

    }

    public User(String pseudonym, String password) {
        this.pseudonym = pseudonym;
        this.password = password;
        this.content = new ArrayList<>();
        this.feedback = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (this.getClass()!=o.getClass()) return false;
        final User other = (User) o;
        return Objects.equals(this.userID,other.userID);
    }

    @Override
    public int hashCode() {
        if (this.userID==null) return 0;
        return this.userID.hashCode();
    }

}
