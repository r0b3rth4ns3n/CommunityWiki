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
    private final String entryId;

    @OneToMany(mappedBy="entry")
    private final List<Content> content;

    // constructor
    public Entry() {
        this.entryId = UUID.randomUUID().toString();
        this.content = new ArrayList<>();
    }

    // overrides
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

    public Content getTopContent() {
        Content top = this.content.get(0);
        for (Content content : this.content) if (content.computeFeedback() > top.computeFeedback()) top = content;
        return top;
    }

    public List<Content> getAllContent() {
        return this.content;
    }

    // add
    public void addContent(Content content) {
        this.content.add(content);
    }

}
