package org.graduatework.service.impl;

import lombok.RequiredArgsConstructor;
import org.graduatework.dto.AttractionDto;
import org.graduatework.dto.ReviewDto;
import org.graduatework.entity.Attraction;
import org.graduatework.entity.Review;
import org.graduatework.enums.AttractionFields;
import org.graduatework.enums.Category;
import org.graduatework.repository.AttractionRepository;
import org.graduatework.repository.AttractionRepositoryOwn;
import org.graduatework.service.AttractionService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttractionServiceImpl implements AttractionService {
    private final AttractionRepository attractionRepository;
    private final AttractionRepositoryOwn attractionRepositoryOwn;
    Map<AttractionFields, Object> fieldsMap;

    @Override
    public List<Attraction> getAttractionsByLongitudeAndLatitude(Double longitude, Double latitude) {
        fieldsMap = new HashMap<>();
        fieldsMap.put(AttractionFields.LONGITUDE, longitude);
        fieldsMap.put(AttractionFields.LATITUDE, latitude);
        return attractionRepositoryOwn.getAttractionsByCriteria(fieldsMap);
    }

    @Override
    public List<Attraction> getAttractionsByLongitudeAndLatitudeAndCategory(Double longitude, Double latitude, String category) {
        fieldsMap = new HashMap<>();
        fieldsMap.put(AttractionFields.LONGITUDE, longitude);
        fieldsMap.put(AttractionFields.LATITUDE, latitude);
        fieldsMap.put(AttractionFields.CATEGORY, convertCategory(category));
        return attractionRepositoryOwn.getAttractionsByCriteria(fieldsMap);
    }

    @Override
    public List<Attraction> getAttractionsByLongitudeAndLatitudeAndMiddleRate(Double longitude, Double latitude, Double midRate) {
        fieldsMap = new HashMap<>();
        fieldsMap.put(AttractionFields.LONGITUDE, longitude);
        fieldsMap.put(AttractionFields.LATITUDE, latitude);
        fieldsMap.put(AttractionFields.MIDDLERATE, midRate);
        return attractionRepositoryOwn.getAttractionsByCriteria(fieldsMap);
    }

    @Override
    public List<Attraction> getAttractionsByCityAndCategory(String city, String category) {
        fieldsMap = new HashMap<>();
        fieldsMap.put(AttractionFields.CITY, city);
        fieldsMap.put(AttractionFields.CATEGORY, convertCategory(category));
        return attractionRepositoryOwn.getAttractionsByCriteria(fieldsMap);
    }

    @Override
    public List<Attraction> getAttractionsByCityAndMiddleRate(String city, Double midRate) {
        fieldsMap = new HashMap<>();
        fieldsMap.put(AttractionFields.CITY, city);
        fieldsMap.put(AttractionFields.MIDDLERATE, midRate);
        return attractionRepositoryOwn.getAttractionsByCriteria(fieldsMap);
    }

    @Override
    public List<Object> getInformationAndMiddleRate(String attraction) {
        return attractionRepository.getInformationAndMiddleRate(attraction);
    }

    @Override
    public List<Attraction> getAttractionByCityName(String city) {
        fieldsMap = new HashMap<>();
        fieldsMap.put(AttractionFields.CITY, city);
        return attractionRepositoryOwn.getAttractionsByCriteria(fieldsMap);
    }

    @Override
    public List<Attraction> showAllAttractions() {
        return attractionRepository.findAll();
    }

    @Override
    public void setReview(String attraction, Integer rate, String review) {
        Attraction attr = new Attraction();
        for (Attraction a : showAllAttractions()) {
            if (a.getName().equals(attraction)) attr = a;
        }
        Review rev = new Review(rate, review);
        rev.setAttraction(attr);
        attr.getReviewList().add(rev);
        attr.setMidRate();
        attractionRepository.save(attr);
    }

    @Override
    public Attraction addNewAttraction(Attraction attraction) {
        attractionRepository.saveAndFlush(attraction);
        return attraction;
    }

    @Override
    public AttractionDto updateAttraction(AttractionDto attractionDto) {
        return null;
    }

    @Override
    public List<AttractionDto> createAttractionList(List<Attraction> attractions) {
        return null;
    }

    @Override
    public List<ReviewDto> showReviewList(String attraction) {
        return null;
    }

    Category convertCategory(String category) {
        Category categoryEnum = null;
        if ("military".equals(category)) {
            categoryEnum = Category.MILITARY;
        } else if ("culture".equals(category)) {
            categoryEnum = Category.CULTURE;
        } else if ("religious".equals(category)) {
            categoryEnum = Category.RELIGIOUS;
        } else if ("historical".equals(category)) {
            categoryEnum = Category.HISTORICAL;
        } else if ("nature".equals(category)) {
            categoryEnum = Category.NATURE;
        }
        return categoryEnum;
    }
}
