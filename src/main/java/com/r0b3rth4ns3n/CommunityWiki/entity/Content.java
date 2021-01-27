package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
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
    @Lob // better?
    private String text;
    //@Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime timestamp;
    @OneToMany(mappedBy="content")
    private List<Feedback> feedback;
    @ManyToOne
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Entry entry;

    // constructor
    public Content() {
        this.contentId = UUID.randomUUID().toString();
        this.feedback = new ArrayList<>();
    }

    // override
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

    // get
    public String getContentId() {
        return contentId;
    }

    public String getTitle() {
        return title;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getText() {
        return text;
    }

    public int getFeedback() {
        int sum = 0;
        for(Feedback f : feedback) {
            if(f.getVote() == Vote.UPVOTE) sum++;
            else sum --;
        }
        return sum;
    }

    public User getUser() {
        return user;
    }

    public Entry getEntry() {
        return entry;
    }

    // set

    public void addFeedback(Feedback feedback) {
        this.feedback.add(feedback);
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

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
}
