package com.r0b3rth4ns3n.CommunityWiki.controller;

import com.r0b3rth4ns3n.CommunityWiki.service.EntryService;
import com.r0b3rth4ns3n.CommunityWiki.service.ExternalContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @Autowired
    private ExternalContentService externalContentService;

    @Autowired
    private EntryService entryService;

    @RequestMapping("/")
    public String i_n_d_e_x(Model model) {
        model.addAttribute("advertisement",externalContentService.getAdvertisement());
        model.addAttribute("entries",entryService.getAllEntries());
        return "index";
    }

    @RequestMapping("/search")
    public String s_e_a_r_c_h(Model model, @ModelAttribute("query") String query) {
        model.addAttribute("advertisement",externalContentService.getAdvertisement());
        model.addAttribute("entries",entryService.search(query));
        return "index";
    }

}
