package org.graduatework.service;

import org.graduatework.dto.AttractionDto;
import org.graduatework.dto.ReviewDto;
import org.graduatework.entity.Attraction;

import java.util.List;

public interface AttractionService {
    List<Attraction> getAttractionsByLongitudeAndLatitude(Double longitude, Double latitude);
    List<Attraction> getAttractionsByLongitudeAndLatitudeAndCategory(Double longitude, Double latitude, String category);
    List<Attraction> getAttractionsByLongitudeAndLatitudeAndMiddleRate(Double longitude, Double latitude, Double middleRate);
    List<Attraction> getAttractionsByCityAndCategory(String city, String category);
    List<Attraction> getAttractionsByCityAndMiddleRate(String city, Double middleRate);
    List<Attraction> getAttractionByCityName(String city);
    List<Object> getInformationAndMiddleRate(String attraction);
    List<Attraction> showAllAttractions();
    List<AttractionDto> createAttractionList(List<Attraction> attractions);
    List<ReviewDto> showReviewList(String attraction);
    void setReview(String attraction, Integer rate, String review);
    Attraction addNewAttraction(Attraction attraction);
    AttractionDto updateAttraction(AttractionDto attractionDto);
}
