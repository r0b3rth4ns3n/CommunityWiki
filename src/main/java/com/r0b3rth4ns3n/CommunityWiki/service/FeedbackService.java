package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.entity.Content;
import com.r0b3rth4ns3n.CommunityWiki.entity.Feedback;
import com.r0b3rth4ns3n.CommunityWiki.entity.User;
import com.r0b3rth4ns3n.CommunityWiki.entity.Vote;
import com.r0b3rth4ns3n.CommunityWiki.repository.FeedbackRepository;
import org.aspectj.weaver.ConcreteTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private EntryService entryService;

    public void upvote(String contentId, String username) {
        Feedback f = new Feedback();
        Content c = entryService.findContent(contentId);
        User u = userService.find_user(username);

        f.setVote(Vote.UPVOTE);
        f.setContent(c);

        u.addFeedback(f);

        c.addFeedback(f);

        feedbackRepo.save(f);
        userService.save(u);
        entryService.save(c);
    }
}
