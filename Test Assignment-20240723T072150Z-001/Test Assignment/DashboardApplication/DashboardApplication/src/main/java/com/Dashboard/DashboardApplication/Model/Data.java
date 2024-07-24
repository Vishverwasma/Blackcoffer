package com.Dashboard.DashboardApplication.Model;

import jakarta.persistence.*;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int intensity;
    private int likelihood;
    private int relevance;
    private int year;
    private String country;
    private String topic;
    private String region;
    private String city;
    private double cityLng;
    private double cityLat;
    private String sector;
    private String pest;
    private String source;
    private String swot;

    public Data() {
        super();
    }

    public Data(Long id, int intensity, int likelihood, int relevance, int year, String country,
                String topic, String region, String city, String sector, String pest, String source, String swot) {
        super();
        this.id = id;
        this.intensity = intensity;
        this.likelihood = likelihood;
        this.relevance = relevance;
        this.year = year;
        this.country = country;
        this.topic = topic;
        this.region = region;
        this.city = city;
        this.sector = sector;
        this.pest = pest;
        this.source = source;
        this.swot = swot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getLikelihood() {
        return likelihood;
    }

    public void setLikelihood(int likelihood) {
        this.likelihood = likelihood;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getPest() {
        return pest;
    }

    public void setPest(String pest) {
        this.pest = pest;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSwot() {
        return swot;
    }

    public void setSwot(String swot) {
        this.swot = swot;
    }
}
