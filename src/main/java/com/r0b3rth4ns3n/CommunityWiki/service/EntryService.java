package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.entity.Content;
import com.r0b3rth4ns3n.CommunityWiki.entity.Entry;
import com.r0b3rth4ns3n.CommunityWiki.entity.User;
import com.r0b3rth4ns3n.CommunityWiki.repository.ContentRepository;
import com.r0b3rth4ns3n.CommunityWiki.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepo;

    @Autowired
    private ContentRepository contentRepo;

    @Autowired
    private UserService userService;

    @Transactional
    public String newEntry(Content content, String username) {
        // new entry
        Entry entry = entryRepo.save(new Entry());
        // get user
        User user = userService.findUser(username);
        // set
        content.setEntry(entry);
        content.setUser(user);
        // add
        entry.addContent(content);
        user.addContent(content);
        // save
        content = contentRepo.save(content);
        user = userService.saveUser(user);
        // return id of entry
        return entry.getEntryId();
    }

    @Transactional
    public String improveEntry(String entryId, Content content, String username) {
        // get
        Entry entry = entryRepo.findById(entryId).get();
        User user = userService.findUser(username);
        // set
        content.newContentId();
        content.setEntry(entry);
        content.setUser(user);
        // add
        entry.addContent(content);
        user.addContent(content);
        // save
        content = contentRepo.save(content);
        user = userService.saveUser(user);
        entry = entryRepo.save(entry);
        // return id of entry
        return entry.getEntryId();
    }

    public Content saveContent(Content content) {
        return contentRepo.save(content);
    }

    public Entry findEntry(String entryId) {
        return entryRepo.findById(entryId).orElse(null);
    }

    public Content findContent(String contentId) {
        return contentRepo.findById(contentId).orElse(null);
    }

    public boolean existsEntry(String entryId) {
        return entryRepo.existsById(entryId);
    }

    public Iterable<Entry> getAllEntries() {
        return entryRepo.findAll();
    }

    public Iterable<Entry> search(String query) {
        Set<Entry> entries = new HashSet<>();
        for (Content content :  contentRepo.findByTitleContainingOrTextContaining(query,query)) {
            entries.add(content.getEntry());
        }
        return entries;
    }

}
