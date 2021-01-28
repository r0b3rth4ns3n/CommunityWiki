package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Content implements Serializable {

    @Id
    private String contentId;

    private String title;

    private Coordinates coordinates;

    @Lob
    private String text;

    @OneToMany(mappedBy="content")
    private final List<Feedback> feedback;

    @ManyToOne
    private User user;

    @ManyToOne
    private Entry entry;

    // constructor
    public Content() {
        this.contentId = UUID.randomUUID().toString();
        this.feedback = new ArrayList<>();
        this.entry = new Entry();
    }

    // overrides
    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (this.getClass()!=o.getClass()) return false;
        final Content other = (Content) o;
        return Objects.equals(this.contentId,other.contentId);
    }

    @Override
    public int hashCode() {
        if (this.contentId==null) return 0;
        return this.contentId.hashCode();
    }

    // new
    public void newContentId() {
        this.contentId = UUID.randomUUID().toString();
    }

    // get
    public String getContentId() {
        return this.contentId;
    }

    public String getTitle() {
        return this.title;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String getText() {
        return this.text;
    }

    public User getUser() {
        return this.user;
    }

    public Entry getEntry() {
        return this.entry;
    }

    // add
    public void addFeedback(Feedback feedback) {
        this.feedback.add(feedback);
    }

    // set
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    // compute
    public int computeFeedback() {
        int sum = 0;
        for (Feedback feedback : this.feedback) sum += feedback.getValue();
        return sum;
    }

}
