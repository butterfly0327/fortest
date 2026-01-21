package com.backend.backend.domain.presentation.mapper;

import com.backend.backend.domain.presentation.entity.Presentation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PresentationMapper {

    List<Presentation> findAll();
    Presentation findById(@Param("id") Long id);
    List<Presentation> findByAccountId(@Param("accountId") Long accountId);
    int insert(Presentation presentation);
    int update(Presentation presentation);
    int delete(@Param("id") Long id);
}
