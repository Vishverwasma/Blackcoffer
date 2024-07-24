package com.Dashboard.DashboardApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Dashboard.DashboardApplication.Model.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
    List<Data> findByYear(int year);
    List<Data> findByCountryIgnoreCase(String country);
    List<Data> findByTopicIgnoreCase(String topic);  // Corrected method name
    List<Data> findByRegionIgnoreCase(String region);
    List<Data> findByCityIgnoreCase(String city);
    List<Data> findByIntensity(int intensity);
    List<Data> findByIntensityBetween(int min, int max);
    List<Data> findByLikelihood(int likelihood);
    List<Data> findByRelevance(int relevance);
}
