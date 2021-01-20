package com.r0b3rth4ns3n.CommunityWiki.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class User implements Serializable, UserDetails {
    @Id
    private String username;
    private String password;
    @OneToMany(mappedBy="user")
    private List<Content> content;
    @OneToMany
    private List<Feedback> feedback;

    public User() {
        // must be random
        username = "r";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.content = new ArrayList<>();
        this.feedback = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (this.getClass()!=o.getClass()) return false;
        final User other = (User) o;
        return Objects.equals(this.username,other.username);
    }

    @Override
    public int hashCode() {
        if (this.username==null) return 0;
        return this.username.hashCode();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
