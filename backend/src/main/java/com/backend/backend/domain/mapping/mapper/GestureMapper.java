package com.backend.backend.domain.mapping.mapper;

import com.backend.backend.domain.mapping.entity.Gesture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GestureMapper {

    List<Gesture> findAll();
    Gesture findById(@Param("id") Long id);
    Gesture findByCode(@Param("code") String code);
    int insert(Gesture gesture);
    int update(Gesture gesture);
    int delete(@Param("id") Long id);
}
