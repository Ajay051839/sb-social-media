package com.media.social.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @OneToOne
    @JoinColumn(name="social_profile_id")
    private SocialProfile socialProfile;

    @OneToMany (mappedBy = "socialUser") //Since one user can have multiple posts so List of Post
    private List<Post> posts=new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="user_group",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="group_id")
    )
    private Set<SocialGroup> socialGroups=new HashSet<>(); //because same user can't join the grp twice

    // After Hashcode error below method implemented
//    2026-09-05T22:16:24.091+05:30  INFO 11964 --- [social] [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
//    Exception in thread "main" java.lang.IllegalStateException: java.lang.StackOverflowError
//    at org.springframework.boot.SpringApplication.handleRunFailure(SpringApplication.java:827)
//    at org.springframework.boot.SpringApplication.run(SpringApplication.java:331)
//    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1365)
//    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1354)
//    at com.media.social.SocialApplication.main(SocialApplication.java:10)

    // After Hashcode error below method implemented
    @Override
    public int hashCode(){
        return Objects.hash(userId);
    }
}
