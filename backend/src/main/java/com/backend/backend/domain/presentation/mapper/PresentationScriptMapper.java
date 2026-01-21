package com.backend.backend.domain.presentation.mapper;

import com.backend.backend.domain.presentation.entity.PresentationScript;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PresentationScriptMapper {

    List<PresentationScript> findAll();
    PresentationScript findById(@Param("id") Long id);
    List<PresentationScript> findByPresentationId(@Param("presentationId") Long presentationId);
    PresentationScript findLatestByPresentationId(@Param("presentationId") Long presentationId);
    int insert(PresentationScript presentationScript);
    int update(PresentationScript presentationScript);
    int delete(@Param("id") Long id);
}
