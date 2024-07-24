package com.Dashboard.DashboardApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Dashboard.DashboardApplication.Model.Data;
import com.Dashboard.DashboardApplication.ServiceAndImplementation.DataService;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/all")
    public List<Data> getAllData() {
        return dataService.getAllData();
    }
    @GetMapping("/year")
    public List<Data> getDataByYear(@RequestParam int year) {
        return dataService.getDataByYear(year);
    }
    @GetMapping("/country")
    public List<Data> getDataByCountry(@RequestParam String country) {
        return dataService.getDataByCountry(country);
    }
    @GetMapping("/topics")
    public List<Data> getDataByTopics(@RequestParam String topics) {
        return dataService.getDataByTopics(topics);
    }
    @GetMapping("/region")
    public List<Data> getDataByRegion(@RequestParam String region) {
        return dataService.getDataByRegion(region);
    }
    @GetMapping("/city")
    public List<Data> getDataByCity(@RequestParam String city) {
        return dataService.getDataByCity(city);
    }
    @GetMapping("/intensity")
    public List<Data> getDataByIntensity(@RequestParam int intensity) {
        return dataService.getDataByIntensity(intensity);
    }

    @GetMapping("/intensity/range")
    public List<Data> getDataByIntensityRange(@RequestParam int min, @RequestParam int max) {
        return dataService.getDataByIntensityRange(min, max);
    }
    @GetMapping("/likelihood")
    public List<Data> getDataByLikelihood(@RequestParam int likelihood) {
        return dataService.getDataByLikelihood(likelihood);
    }
    @GetMapping("/relevance")
    public List<Data> getDataByRelevance(@RequestParam int relevance) {
        return dataService.getDataByRelevance(relevance);
    }
    @GetMapping("/filter")
    public List<Data> getDataByMultipleParams(
        @RequestParam(required = false) Integer intensity,
        @RequestParam(required = false) Integer likelihood,
        @RequestParam(required = false) Integer relevance,
        @RequestParam(required = false) String country,
        @RequestParam(required = false) String topic,
        @RequestParam(required = false) String region,
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String sector,
        @RequestParam(required = false) String pest,
        @RequestParam(required = false) String source,
        @RequestParam(required = false) String swot
    ) {
        return dataService.getDataByMultipleParams(intensity, likelihood, relevance, country, topic, region, city, sector, pest, source, swot);
    }
    
    @PostMapping
    public ResponseEntity<Data> createData(@RequestBody Data data) {
        Data createdData = dataService.createData(data);
        return ResponseEntity.ok(createdData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Data> updateData(@PathVariable Long id, @RequestBody Data data) {
        Data updatedData = dataService.updateData(id, data);
        return ResponseEntity.ok(updatedData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        dataService.deleteData(id);
        return ResponseEntity.noContent().build();
    }
}



/*
 * 
1. Get All Data
Endpoint: GET /api/data/all
2. Get Data by Year
Endpoint: GET /api/data/year?year={year}
3. Get Data by Country
Endpoint: GET /api/data/country?country={country}
4. Get Data by Topic
Endpoint: GET /api/data/topics?topics={topics}
5. Get Data by Region
Endpoint: GET /api/data/region?region={region}
6. Get Data by City
Endpoint: GET /api/data/city?city={city}
7. Get Data by Intensity
Endpoint: GET /api/data/intensity?intensity={intensity}
8. Get Data by Intensity Range
Endpoint: GET /api/data/intensity/range?min={min}&max={max}
9. Get Data by Likelihood
Endpoint: GET /api/data/likelihood?likelihood={likelihood}
10. Get Data by Relevance
Endpoint: GET /api/data/relevance?relevance={relevance}
11. Get Data by Multiple Filters
Endpoint: GET /api/data/filter?intensity={intensity}&likelihood={likelihood}&relevance={relevance}&country={country}&topic={topic}&region={region}&city={city}&sector={sector}&pest={pest}&source={source}&swot={swot}
12. Create Data
Endpoint: POST /api/data
13. Update Data
Endpoint: PUT /api/data/{id}
14. Delete Data
Endpoint: DELETE /api/data/{id}
*
*Endpoint: POST /api/data
{
  "year": 2021,
  "country": "USA",
  "topics": "Health",
  "region": "North America",
  "city": "New York",
  "intensity": 5,
  "likelihood": 3,
  "relevance": 4,
  "sector": "Healthcare",
  "pest": "Political",
  "source": "WHO",
  "swot": "Strength"
}

*
*
*Endpoint: PUT /api/data/{id}
{
  "year": 2021,
  "country": "USA",
  "topics": "Health",
  "region": "North America",
  "city": "New York",
  "intensity": 5,
  "likelihood": 3,
  "relevance": 4,
  "sector": "Healthcare",
  "pest": "Political",
  "source": "WHO",
  "swot": "Strength"
}

*
*/