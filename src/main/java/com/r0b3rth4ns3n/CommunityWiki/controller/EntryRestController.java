package com.r0b3rth4ns3n.CommunityWiki.controller;

import com.r0b3rth4ns3n.CommunityWiki.dto.ContentDTO;
import com.r0b3rth4ns3n.CommunityWiki.entity.Content;
import com.r0b3rth4ns3n.CommunityWiki.entity.Coordinates;
import com.r0b3rth4ns3n.CommunityWiki.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class EntryRestController {

    @Autowired
    private EntryService entryService;

    @PostMapping("/api/entries")
    public String n_e_w(@RequestBody ContentDTO contentDTO, Principal principal) {
        // new content
        Content content = new Content();
        // set title
        content.setTitle(contentDTO.getName());
        // in the real world the address should be converted to coordinates -> google maps api -> too much for this project though -> use fixed coordinates instead
        content.setCoordinates(new Coordinates(49.002395,12.096254));
        // set text
        content.setText("website: " +  contentDTO.getWebsite() + System.lineSeparator() + "phone: " + contentDTO.getPhone());
        // pass to entry service and return id of new entry
        return entryService.newEntry(content,principal.getName());
    }

}
