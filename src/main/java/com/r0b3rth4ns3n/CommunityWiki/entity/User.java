package com.r0b3rth4ns3n.CommunityWiki.entity;

import java.util.List;

public class User {
    private String userID;
    private String pseudonym;
    private String password;
    private List<Content> content;
    private List<Feedback> feedback;
}
