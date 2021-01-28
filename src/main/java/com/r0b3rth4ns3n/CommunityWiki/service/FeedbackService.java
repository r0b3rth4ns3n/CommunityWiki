package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.entity.Content;
import com.r0b3rth4ns3n.CommunityWiki.entity.Feedback;
import com.r0b3rth4ns3n.CommunityWiki.entity.User;
import com.r0b3rth4ns3n.CommunityWiki.entity.Vote;
import com.r0b3rth4ns3n.CommunityWiki.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private EntryService entryService;

    @Transactional
    public void vote(String contentId, String username, Vote vote) {
        // get actors
        Content content = entryService.findContent(contentId);
        User user = userService.findUser(username);
        // maybe in a future version check at this point if a user already voted
        // new feedback
        Feedback feedback = new Feedback(vote,content);
        // add
        user.addFeedback(feedback);
        content.addFeedback(feedback);
        // save
        feedbackRepo.save(feedback);
        userService.saveUser(user);
        entryService.saveContent(content);
    }

}
