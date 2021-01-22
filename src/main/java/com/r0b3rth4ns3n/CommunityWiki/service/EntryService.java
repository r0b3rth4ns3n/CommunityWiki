package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.entity.Content;
import com.r0b3rth4ns3n.CommunityWiki.entity.Entry;
import com.r0b3rth4ns3n.CommunityWiki.repository.ContentRepository;
import com.r0b3rth4ns3n.CommunityWiki.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepo;

    @Autowired
    private ContentRepository contentRepo;

    @Autowired
    private UserService userService;

    // new
    public void newEntry(Content content, String username) {
        // new
        Entry entry = new Entry();
        entryRepo.save(entry);
        // set missing content
        content.setUser(userService.find_user(username));
        content.setEntry(entry);
        entry.addContent(content);
        // save
        contentRepo.save(content);
        entryRepo.save(entry);

    }

    // edit
    public void edit_entry(Content content) {
        System.out.println("edit");
    }

    // find
    public Entry findEntry(String id) {
        return entryRepo.findById(id).orElse(null);
    }

    public Content findContent(String id) {
        return contentRepo.findById(id).orElse(null);
    }

    // exists
    public boolean existsEntry(String id) {
        return entryRepo.existsById(id);
    }

    public boolean existsContent(String id) {
        return contentRepo.existsById(id);
    }

    // get all
    public Iterable<Entry> getAll() {
        Iterable<Entry> entries;
        entries = entryRepo.findAll();
        return entries;
    }

}
