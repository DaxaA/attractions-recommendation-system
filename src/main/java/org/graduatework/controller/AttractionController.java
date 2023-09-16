package org.graduatework.controller;

import org.graduatework.dto.AttractionDto;
import org.graduatework.dto.ReviewDto;
import org.graduatework.entity.Attraction;
import org.graduatework.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attractions")
public class AttractionController {
    public final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public List<AttractionDto> getAll() {
        List<Attraction> attractions = attractionService.showAllAttractions();
        return attractionService.createAttractionList(attractions);
    }

    @GetMapping("/city/{city}")
    public List<AttractionDto> getByCity(@PathVariable String city) {
        List<Attraction> attractions = attractionService.getAttractionByCityName(city);
        return attractionService.createAttractionList(attractions);
    }

    @GetMapping("/near/{longitude}/{latitude}")
    public List<AttractionDto> getByLongitudeAndLatitude(@PathVariable Double latitude, @PathVariable Double longitude) {
        List<Attraction> attractions = attractionService.getAttractionsByLongitudeAndLatitude(latitude, longitude);
        return attractionService.createAttractionList(attractions);
    }

    @GetMapping("/near/{longitude}/{latitude}/category/{category}")
    public List<AttractionDto> getByLongitudeAndLatitudeAndCategory(@PathVariable Double longitude, @PathVariable Double latitude, @PathVariable String category) {
        List<Attraction> attractions = attractionService.getAttractionsByLongitudeAndLatitudeAndCategory(longitude, latitude, category);
        return attractionService.createAttractionList(attractions);
    }

    @GetMapping("/near/{longitude}/{latitude}/rate/{midrate}")
    public List<AttractionDto> getByLongitudeAndLatitudeAndMidrate(@PathVariable Double longitude, @PathVariable Double latitude, @PathVariable Double midrate) {
        List<Attraction> attractions = attractionService.getAttractionsByLongitudeAndLatitudeAndMiddleRate(longitude, latitude, midrate);
        return attractionService.createAttractionList(attractions);
    }

    @GetMapping("/city/{city}/category/{category}")
    public List<AttractionDto> getByCityAndCategory(@PathVariable String city, @PathVariable String category) {
        List<Attraction> attractions = attractionService.getAttractionsByCityAndCategory(city, category);
        return attractionService.createAttractionList(attractions);
    }

    @GetMapping("/city/{city}/rate/{midrate}")
    public List<AttractionDto> getByCityAndMidrate(@PathVariable String city, @PathVariable Double midrate) {
        List<Attraction> attractions = attractionService.getAttractionsByCityAndMiddleRate(city, midrate);
        return attractionService.createAttractionList(attractions);
    }

    @GetMapping("/{attraction}")
    public List<Object> getOnlyInfoAndMidrate(@PathVariable String attraction) {
        return attractionService.getInformationAndMiddleRate(attraction);
    }

    @GetMapping("/{attraction}/reviews")
    public List<ReviewDto> getReviews(@PathVariable String attraction) {
        return attractionService.showReviewList(attraction);
    }

    @PostMapping("/{attraction}/reviews/new/{rate}/{review}")
    public List<ReviewDto> setReviewForAttraction(@PathVariable String attraction, @PathVariable Integer rate, @PathVariable String review) {
        attractionService.setReview(attraction, rate, review);
        return attractionService.showReviewList(attraction);
    }

}
