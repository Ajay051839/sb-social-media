package com.media.social;

import com.media.social.models.Post;
import com.media.social.models.SocialGroup;
import com.media.social.models.SocialProfile;
import com.media.social.models.SocialUser;
import com.media.social.repositories.PostRepository;
import com.media.social.repositories.SocialGroupRepository;
import com.media.social.repositories.SocialProfileRepository;
import com.media.social.repositories.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    private final SocialUserRepository socialUserRepository;
    private final SocialGroupRepository socialGroupRepository;
    private final SocialProfileRepository socialProfileRepository;
    private final PostRepository postRepository;
    //constructor
    public DataInitializer(SocialUserRepository socialUserRepository, SocialGroupRepository socialGroupRepository, SocialProfileRepository socialProfileRepository, PostRepository postRepository) {
        this.socialUserRepository = socialUserRepository;
        this.socialGroupRepository = socialGroupRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.postRepository = postRepository;
    }
    @Bean
    public CommandLineRunner initializeData(){
        return (args -> {
            SocialUser user1=new SocialUser();
            SocialUser user2=new SocialUser();
            SocialUser user3=new SocialUser();

            //Save users to Database
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            //Create Some groups
            SocialGroup group1=new SocialGroup();
            SocialGroup group2=new SocialGroup();

            //Bidirectional mapping in Users<-->Groups
            //in my code-But in your mapping, SocialGroup.socialUsers is the inverse side
            // because it uses mappedBy. The owning side is SocialUser.java:
            user1.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group1);

            user3.getSocialGroups().add(group2);
            user2.getSocialGroups().add(group2);

            //Associate group with users
            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            //Associate group with users
            group2.getSocialUsers().add(user3);
            group2.getSocialUsers().add(user2);

            //Save groups to database
            socialGroupRepository.save(group1);
            socialGroupRepository.save(group2);

            //Save users back to the Database to update Associations
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);


            user3.getSocialGroups().add(group2);
            user2.getSocialGroups().add(group2);
            socialGroupRepository.save(group2);

            Post post1=new Post();
            Post post2=new Post();
            Post post3=new Post();
            //Associate posts with users
            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            //save posts to the database
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            //Create some Social profiles
            SocialProfile profile1=new SocialProfile();
            SocialProfile profile2=new SocialProfile();
            SocialProfile profile3=new SocialProfile();

            //Associate profile with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            //Save profiles to the database
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);

        });
    }
}
