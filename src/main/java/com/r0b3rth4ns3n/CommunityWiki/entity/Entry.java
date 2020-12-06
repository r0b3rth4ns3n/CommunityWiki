package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Entry implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String entryId;
    @OneToMany(mappedBy="entry")
    private List<Content> content;

    public Entry() {

    }

    public Entry(String title, Coordinates coordinates, String text, OffsetDateTime timestamp, User user) {
        this.content = new ArrayList<>();
        this.content.add(new Content(title,coordinates,text,timestamp,user,this));
    }

    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (this.getClass()!=o.getClass()) return false;
        final Entry other = (Entry) o;
        return Objects.equals(this.entryId,other.entryId);
    }

    @Override
    public int hashCode() {
        if (this.entryId==null) return 0;
        return this.entryId.hashCode();
    }

}
