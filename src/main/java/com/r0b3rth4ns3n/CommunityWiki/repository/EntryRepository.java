package com.r0b3rth4ns3n.CommunityWiki.repository;

import com.r0b3rth4ns3n.CommunityWiki.entity.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry,String> {

}
