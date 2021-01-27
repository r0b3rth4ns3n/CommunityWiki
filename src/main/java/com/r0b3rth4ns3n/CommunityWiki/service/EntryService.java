package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.entity.Content;
import com.r0b3rth4ns3n.CommunityWiki.entity.Entry;
import com.r0b3rth4ns3n.CommunityWiki.entity.User;
import com.r0b3rth4ns3n.CommunityWiki.repository.ContentRepository;
import com.r0b3rth4ns3n.CommunityWiki.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepo;

    @Autowired
    private ContentRepository contentRepo;

    @Autowired
    private UserService userService;

    // new
    public String newEntry(Content content, String username) {
        // new
        Entry entry = entryRepo.save(new Entry());
        // set missing content
        content.setUser(userService.find_user(username));

        content.setEntry(entry);

        entry.addContent(content);

        System.out.println(content.getEntry().getEntryId());

        // save
        contentRepo.save(content);

        return entry.getEntryId();
    }

    // edit
    public void editEntry(String entryId, Content content,String username) {
        Entry entry = entryRepo.findById(entryId).get();
        content.setUser(userService.find_user(username));
        content.setEntry(entry);
        entry.addContent(content);
        contentRepo.save(content);
        entryRepo.save(entry);
    }

    public void save(Content c) {
        contentRepo.save(c);
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

    public Iterable<Entry> search(String s) {
        Set<Entry> entries = new HashSet<>();
        for(Content content :  contentRepo.findByTitleContainingOrTextContaining(s,s)) {
            entries.add(content.getEntry());
        }
        return entries;
    }

}
