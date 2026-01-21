package com.backend.backend.domain.mapping.mapper;

import com.backend.backend.domain.mapping.entity.Action;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActionMapper {

    List<Action> findAll();
    Action findById(@Param("id") Long id);
    Action findByCode(@Param("code") String code);
    int insert(Action action);
    int update(Action action);
    int delete(@Param("id") Long id);
}
