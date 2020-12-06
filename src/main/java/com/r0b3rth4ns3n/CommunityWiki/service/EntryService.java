package com.r0b3rth4ns3n.CommunityWiki.service;

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
}
