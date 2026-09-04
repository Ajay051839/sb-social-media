package com.media.social.models;

import jakarta.persistence.*;

@Entity
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "socialProfile")    //Non-owning side
    //@JoinColumn(name="social_user") //specify the name of foreign key column (Custom name)
    private SocialUser user;
}
