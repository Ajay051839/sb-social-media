package com.media.social.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToMany(mappedBy = "socialGroups")
    Set<SocialUser> socialUsers=new HashSet<>();
    // After Hashcode error below method implemented
    @Override
    public int hashCode(){
        return Objects.hash(Id);
    }
}
