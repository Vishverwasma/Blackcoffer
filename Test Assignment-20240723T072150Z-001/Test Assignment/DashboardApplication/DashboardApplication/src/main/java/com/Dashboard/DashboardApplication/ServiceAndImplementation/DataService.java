package com.Dashboard.DashboardApplication.ServiceAndImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dashboard.DashboardApplication.Model.Data;
import com.Dashboard.DashboardApplication.Repository.DataRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public List<Data> getAllData() {
        return dataRepository.findAll();
    }
    
    public List<Data> getDataByYear(int year) {
        return dataRepository.findAll().stream()
            .filter(data -> data.getYear() == year)
            .toList();
    }

    public List<Data> getDataByCountry(String country) {
        return dataRepository.findAll().stream()
            .filter(data -> data.getCountry().equalsIgnoreCase(country))
            .toList();
    }
    public List<Data> getDataByTopics(String topics) {
        return dataRepository.findAll().stream()
            .filter(data -> data.getTopic().equalsIgnoreCase(topics))
            .toList();
    }
    public List<Data> getDataByRegion(String region) {
        return dataRepository.findAll().stream()
            .filter(data -> data.getRegion().equalsIgnoreCase(region))
            .toList();
    }
    public List<Data> getDataByCity(String city) {
        return dataRepository.findAll().stream()
            .filter(data -> data.getCity().equalsIgnoreCase(city))
            .toList();
    }
    public List<Data> getDataByIntensity(int intensity) {
        return dataRepository.findAll().stream()
            .filter(data -> data.getIntensity() == intensity)
            .toList();
    }
    public List<Data> getDataByLikelihood(int likelihood) {
        return dataRepository.findAll().stream()
            .filter(data -> data.getLikelihood() == likelihood)
            .toList();
    }
    public List<Data> getDataByRelevance(int relevance) {
        return dataRepository.findAll().stream()
            .filter(data -> data.getRelevance() == relevance)
            .toList();
    }
    public List<Data> getDataByIntensityRange(int min, int max) {
        return dataRepository.findAll().stream()
                .filter(data -> data.getIntensity() >= min && data.getIntensity() <= max)
                .collect(Collectors.toList());
    }
    public List<Data> getDataByMultipleParams(
            Integer intensity,
            Integer likelihood,
            Integer relevance,
            String country,
            String topic,
            String region,
            String city,
            String sector,
            String pest,
            String source,
            String swot
        ) {
        String intensityStr = intensity == null ? null : intensity.toString();
        String likelihoodStr = likelihood == null ? null : likelihood.toString();
        String relevanceStr = relevance == null ? null : relevance.toString();
            return dataRepository.findAll().stream()
                    .filter(data -> intensityStr == null || intensityStr.equals(data.getIntensity()))
                    .filter(data -> likelihoodStr == null || likelihoodStr.equals(data.getLikelihood()))
                    .filter(data -> relevanceStr == null || relevanceStr.equals(data.getRelevance()))
                .filter(data -> country == null || data.getCountry().equalsIgnoreCase(country))
                .filter(data -> topic == null || data.getTopic().equalsIgnoreCase(topic))
                .filter(data -> region == null || data.getRegion().equalsIgnoreCase(region))
                .filter(data -> city == null || data.getCity().equalsIgnoreCase(city))
                .filter(data -> sector == null || data.getSector().equalsIgnoreCase(sector))
                .filter(data -> pest == null || data.getPest().equalsIgnoreCase(pest))
                .filter(data -> source == null || data.getSource().equalsIgnoreCase(source))
                .filter(data -> swot == null || data.getSwot().equalsIgnoreCase(swot))
                .collect(Collectors.toList());
        }

    public Data createData(Data data) {
        return dataRepository.save(data);
    }

    public Data updateData(Long id, Data data) {
        Optional<Data> existingData = dataRepository.findById(id);
        if (existingData.isPresent()) {
            Data updatedData = existingData.get();
            updatedData.setIntensity(data.getIntensity());
            updatedData.setLikelihood(data.getLikelihood());
            updatedData.setRelevance(data.getRelevance());
            updatedData.setCountry(data.getCountry());
            updatedData.setTopic(data.getTopic());
            updatedData.setRegion(data.getRegion());
            updatedData.setCity(data.getCity());
            updatedData.setSector(data.getSector());
            updatedData.setPest(data.getPest());
            updatedData.setSource(data.getSource());
            updatedData.setSwot(data.getSwot());
            return dataRepository.save(updatedData);
        } else {
            throw new RuntimeException("Data not found with id " + id);
        }
    }

    public void deleteData(Long id) {
        dataRepository.deleteById(id);
    }

}
