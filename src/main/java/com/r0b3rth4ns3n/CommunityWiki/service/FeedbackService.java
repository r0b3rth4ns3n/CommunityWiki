package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.entity.Feedback;
import com.r0b3rth4ns3n.CommunityWiki.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepo;
}
