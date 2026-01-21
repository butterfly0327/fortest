package com.backend.backend.domain.presentation.mapper;

import com.backend.backend.domain.presentation.entity.PresentationAudio;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PresentationAudioMapper {

    List<PresentationAudio> findAll();
    PresentationAudio findById(@Param("id") Long id);
    List<PresentationAudio> findByPresentationId(@Param("presentationId") Long presentationId);
    PresentationAudio findLatestByPresentationId(@Param("presentationId") Long presentationId);
    int insert(PresentationAudio presentationAudio);
    int update(PresentationAudio presentationAudio);
    int delete(@Param("id") Long id);
}
