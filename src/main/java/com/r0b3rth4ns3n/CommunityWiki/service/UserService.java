package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
}
