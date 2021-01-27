package com.r0b3rth4ns3n.CommunityWiki.controller;

import com.r0b3rth4ns3n.CommunityWiki.entity.Content;
import com.r0b3rth4ns3n.CommunityWiki.entity.Entry;
import com.r0b3rth4ns3n.CommunityWiki.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class EntryController {

    @Autowired
    private EntryService entryService;

    @RequestMapping("/entry")
    public String e_n_t_r_y(Model model, @RequestParam("id") String entryId) {
        model.addAttribute(entryService.findEntry(entryId));
        return "entry";
    }

    @RequestMapping("/new")
    public String n_e_w(Model model) {
        Content c = new Content();
        c.setEntry(new Entry());
        model.addAttribute(c);
        return "content";
    }

    @RequestMapping("/improve")
    public String e_d_i_t(Model model, @RequestParam("id") String contentId) {
        model.addAttribute(entryService.findContent(contentId));
        return "content";
    }

    @RequestMapping("/save")
    public String s_a_v_e(@RequestParam("id") String entryId, @ModelAttribute("content") Content content, Principal principal) {
        if(entryService.existsEntry(entryId)) {
            entryService.editEntry(entryId,content,principal.getName());
        }
        else entryService.newEntry(content, principal.getName());

        System.out.println(entryId);
        System.out.println(content.getTitle());
        System.out.println(content.getCoordinates().getLatitude());
        System.out.println(content.getCoordinates().getLongitude());
        System.out.println(content.getText());

        return "forward:/";
    }

}
