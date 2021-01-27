package com.r0b3rth4ns3n.CommunityWiki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import de.othregensburg.doj34392.entity.dto.AdvertisementResponse;

@Service
public class ExternalContentService {

    @Autowired
    private RestTemplate rest;

    public String getAdvertisement() {

        try {

            AdvertisementResponse response = rest.getForObject("http://im-codd.oth-regensburg.de:8919/advertisements?tag={tag}", AdvertisementResponse.class,"");

            return response.getImageUri();

        } catch (Exception e) {

            System.out.println("could not get advertisement");
            return "";

        }

    }

}