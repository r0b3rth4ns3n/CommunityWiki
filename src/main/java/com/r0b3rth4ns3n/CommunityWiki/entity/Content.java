package com.r0b3rth4ns3n.CommunityWiki.entity;

import java.time.OffsetDateTime;
import java.util.List;

public class Content {
    private String contentId;
    private String title;
    private Coordinates coordinates;
    private String text;
    private OffsetDateTime timestamp;
    private List<Feedback> feedback;
    private User user;
    private Entry entry;
}
