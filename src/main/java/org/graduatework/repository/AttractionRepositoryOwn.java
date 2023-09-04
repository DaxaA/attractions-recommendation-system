package org.graduatework.repository;

import org.graduatework.entity.Attraction;
import org.graduatework.enums.AttractionFields;

import java.util.List;
import java.util.Map;

public interface AttractionRepositoryOwn {
    List<Attraction> getAttractionsByCriteria(Map<AttractionFields, Object> criteria);
}
