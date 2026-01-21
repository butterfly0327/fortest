package com.backend.backend.domain.mapping.mapper;

import com.backend.backend.domain.mapping.entity.Mapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MappingMapper {

    List<Mapping> findAll();
    Mapping findById(@Param("id") Long id);
    List<Mapping> findByAccountId(@Param("accountId") Long accountId);
    Mapping findActiveByAccountId(@Param("accountId") Long accountId);
    int insert(Mapping mapping);
    int update(Mapping mapping);
    int delete(@Param("id") Long id);
}
