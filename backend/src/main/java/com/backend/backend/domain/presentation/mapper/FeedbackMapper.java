package com.backend.backend.domain.presentation.mapper;

import com.backend.backend.domain.presentation.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FeedbackMapper {

    List<Feedback> findAll();
    Feedback findById(@Param("id") Long id);
    Feedback findByPresentationId(@Param("presentationId") Long presentationId);
    int insert(Feedback feedback);
    int update(Feedback feedback);
    int delete(@Param("id") Long id);
}
