package com.r0b3rth4ns3n.CommunityWiki.controller;

import com.r0b3rth4ns3n.CommunityWiki.entity.Content;
import com.r0b3rth4ns3n.CommunityWiki.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class EntryController {

    @Autowired
    private EntryService entryService;

    @RequestMapping("/entry/{entryId}")
    public String e_n_t_r_y(Model model, @PathVariable("entryId") String entryId) {
        model.addAttribute(entryService.findEntry(entryId));
        return "entry";
    }

    @RequestMapping("/new")
    public String n_e_w(Model model) {
        model.addAttribute(new Content());
        return "content";
    }

    @RequestMapping("/improve/{entryId}/{contentId}")
    public String i_m_p_r_o_v_e(Model model, @PathVariable("entryId") String entryId, @PathVariable("contentId") String contentId) {
        model.addAttribute(entryService.findContent(contentId));
        return "content";
    }

    @RequestMapping("/save/{entryId}")
    public String s_a_v_e(@PathVariable("entryId") String entryId, @ModelAttribute("content") Content content, Principal principal) {
        if (entryService.existsEntry(entryId)) entryId = entryService.improveEntry(entryId,content,principal.getName());
        else entryId = entryService.newEntry(content,principal.getName());
        return "forward:/entry/" + entryId;
    }

}
