package com.media.social.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SocialGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToMany(mappedBy = "socialGroups")
    Set<SocialUser> socialUsers=new HashSet<>();
}
