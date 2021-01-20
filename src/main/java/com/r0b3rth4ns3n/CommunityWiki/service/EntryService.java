package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.entity.Entry;
import com.r0b3rth4ns3n.CommunityWiki.repository.ContentRepository;
import com.r0b3rth4ns3n.CommunityWiki.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    @Autowired
    private EntryRepository entryRepo;
    @Autowired
    private ContentRepository contentRepo;

    public Iterable<Entry> getAll() {
        Iterable<Entry> entries;
        entries = entryRepo.findAll();
        return entries;
    }

}
