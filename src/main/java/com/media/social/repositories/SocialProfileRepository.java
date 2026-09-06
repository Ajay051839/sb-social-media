package com.media.social.repositories;

import com.media.social.models.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepository extends JpaRepository<SocialProfile,Long> {
}
