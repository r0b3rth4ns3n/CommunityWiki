package com.r0b3rth4ns3n.CommunityWiki.entity;

public enum Vote {

    UPVOTE(+1),
    DOWNVOTE(-1);

    private final int value;

    Vote(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
