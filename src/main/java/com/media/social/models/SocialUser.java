package com.media.social.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @OneToOne
    @JoinColumn(name="social_profile_id")
    private SocialProfile socialProfile;

    @OneToMany  //Since one user can have multiple posts so List of Post
    private List<Post> posts=new ArrayList<>();
}
