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

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("entries",entryService.getAll());
        return "index";
    }

    @RequestMapping("/new")
    public String n_e_w(Model model) {
        model.addAttribute(new Content());
        return "content";
    }

    @RequestMapping("/improve")
    public String e_d_i_t(Model model, @RequestParam("id") String entryId) {
        Entry entry = entryService.findEntry(entryId);
        model.addAttribute(entry.getContent());
        return "content";
    }

    @RequestMapping("/save")
    public String s_a_v_e(@RequestParam("id") String contentId, @ModelAttribute("content") Content content, Principal principal) {
        if(entryService.existsContent(contentId)) entryService.edit_entry(content);
        else entryService.newEntry(content, principal.getName());

        System.out.println(contentId);
        System.out.println(content.getTitle());
        System.out.println(content.getCoordinates().getLatitude());
        System.out.println(content.getCoordinates().getLongitude());
        System.out.println(content.getText());

        return "index";
    }

}
