package com.r0b3rth4ns3n.CommunityWiki.controller;

import com.r0b3rth4ns3n.CommunityWiki.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("/upvote")
    public String u_p_v_o_t_e(@RequestParam("id") String contentId, Principal principal) {
        feedbackService.upvote(contentId,principal.getName());
        return "forward:/";
    }

}
