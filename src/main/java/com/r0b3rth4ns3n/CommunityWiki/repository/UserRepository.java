package com.r0b3rth4ns3n.CommunityWiki.repository;

import com.r0b3rth4ns3n.CommunityWiki.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

}
