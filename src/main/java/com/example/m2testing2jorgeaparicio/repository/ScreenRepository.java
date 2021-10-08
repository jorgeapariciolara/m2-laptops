package com.example.m2testing2jorgeaparicio.repository;

import com.example.m2testing2jorgeaparicio.entities.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository <Screen, Long> {}
