package com.backend.backend.domain.mapping.mapper;

import com.backend.backend.domain.mapping.entity.MappingValidation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MappingValidationMapper {

    List<MappingValidation> findAll();
    MappingValidation findById(@Param("id") Long id);
    MappingValidation findByMappingId(@Param("mappingId") Long mappingId);
    int insert(MappingValidation mappingValidation);
    int update(MappingValidation mappingValidation);
    int delete(@Param("id") Long id);
}
