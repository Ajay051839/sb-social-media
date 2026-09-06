package com.media.social.services;

import com.media.social.models.SocialUser;
import com.media.social.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    @Autowired    //Autowiring SocialUserRepository
    SocialUserRepository socialUserRepository;

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }
}
