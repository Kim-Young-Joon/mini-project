package com.soongsil.graduateproject.repository;

import com.soongsil.graduateproject.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
