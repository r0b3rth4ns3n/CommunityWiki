package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Feedback implements Serializable {

    @Id
    private String feedbackId;

    @Enumerated(EnumType.STRING)
    private Vote vote;

    private String comment;

    @ManyToOne
    private Content content;

    public Feedback() {
        this.feedbackId = UUID.randomUUID().toString();
    }

    public Feedback(Vote vote, String comment, Content content) {
        this.vote = vote;
        this.comment = comment;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (this.getClass()!=o.getClass()) return false;
        final Feedback other = (Feedback) o;
        return Objects.equals(this.feedbackId,other.feedbackId);
    }

    @Override
    public int hashCode() {
        if (this.feedbackId==null) return 0;
        return this.feedbackId.hashCode();
    }

    // get
    public Vote getVote() {
        return vote;
    }

    // set
    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public void setContent(Content content) {
        this.content = content;
    }

}
