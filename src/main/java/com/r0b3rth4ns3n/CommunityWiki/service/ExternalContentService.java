package com.r0b3rth4ns3n.CommunityWiki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import de.othr.doj34392.entity.dto.AdvertisementResponseDTO;

@Service
public class ExternalContentService {

    @Autowired
    private RestTemplate restTemplate;

    public String getAdvertisement() {
        try {
            return restTemplate.getForObject("http://im-codd.oth-regensburg.de:8919/advertisements?tag=",AdvertisementResponseDTO.class).getImageUri();
        } catch (Exception e) {
            System.out.println("could not get advertisement");
            return "";
        }
    }

}
