package com.backend.backend.domain.mapping.mapper;

import com.backend.backend.domain.mapping.entity.MappingItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MappingItemMapper {

    List<MappingItem> findAll();
    MappingItem findById(@Param("id") Long id);
    List<MappingItem> findByMappingId(@Param("mappingId") Long mappingId);
    int insert(MappingItem mappingItem);
    int update(MappingItem mappingItem);
    int delete(@Param("id") Long id);
    int deleteByMappingId(@Param("mappingId") Long mappingId);
}
