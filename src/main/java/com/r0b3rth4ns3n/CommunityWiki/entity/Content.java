package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String contentId;
    private String title;
    private Coordinates coordinates;
    private String text;
    //@Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime timestamp;
    @OneToMany(mappedBy="content")
    private List<Feedback> feedback;
    @ManyToOne
    private User user;
    @ManyToOne
    private Entry entry;

    public Content() {

    }

    public Content(String title, Coordinates coordinates, String text, OffsetDateTime timestamp, User user, Entry entry) {
        this.title = title;
        this.coordinates = coordinates;
        this.text = text;
        this.timestamp = timestamp;
        this.feedback = new ArrayList<>();
        this.user = user;
        this.entry = entry;
    }

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

}
