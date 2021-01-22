package com.r0b3rth4ns3n.CommunityWiki.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Entry implements Serializable {

    @Id
    private String entryId;

    @OneToMany(mappedBy="entry") //fetch type?
    private List<Content> content;

    // constructor
    public Entry() {
        this.entryId = UUID.randomUUID().toString();
        this.content = new ArrayList<>();
    }

    public Entry(Content content) {
        this();
        this.content.add(content);
    }

    // override
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

    // get
    public String getEntryId() {
        return entryId;
    }

    public Content getContent() {
        return content.get(0);
    }

    // set
    public void addContent(Content content) {
        this.content.add(content);
    }

}
