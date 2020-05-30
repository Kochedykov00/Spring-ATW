package com.example.myfirstspringproject.repositories;

import com.example.myfirstspringproject.models.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
