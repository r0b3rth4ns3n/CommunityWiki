package com.r0b3rth4ns3n.CommunityWiki.controller;

import com.r0b3rth4ns3n.CommunityWiki.entity.Vote;
import com.r0b3rth4ns3n.CommunityWiki.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("/upvote/{entryId}/{contentId}")
    public String u_p_v_o_t_e(@PathVariable("entryId") String entryId, @PathVariable("contentId") String contentId, Principal principal) {
        feedbackService.vote(contentId,principal.getName(),Vote.UPVOTE);
        return "forward:/entry/" + entryId;
    }

    @RequestMapping("/downvote/{entryId}/{contentId}")
    public String d_o_w_n_v_o_t_e(@PathVariable("entryId") String entryId, @PathVariable("contentId") String contentId, Principal principal) {
        feedbackService.vote(contentId,principal.getName(),Vote.DOWNVOTE);
        return "forward:/entry/" + entryId;
    }

}
