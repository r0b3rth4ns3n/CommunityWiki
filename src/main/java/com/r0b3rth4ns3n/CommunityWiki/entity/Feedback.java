package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Feedback implements Serializable {

    @Id
    private final String feedbackId;

    @Enumerated(EnumType.STRING)
    private Vote vote;

    @ManyToOne
    private Content content;

    // constructors
    public Feedback() {
        this.feedbackId = UUID.randomUUID().toString();
    }

    public Feedback(Vote vote, Content content) {
        this();
        this.vote = vote;
        this.content = content;
    }

    // overrides
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
    public int getValue() {
        return this.vote.getValue();
    }

}
