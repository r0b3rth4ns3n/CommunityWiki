package com.r0b3rth4ns3n.CommunityWiki.controller;

import com.r0b3rth4ns3n.CommunityWiki.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private EntryService entryService;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("test",entryService.getAll());
        return "index";
    }

}
