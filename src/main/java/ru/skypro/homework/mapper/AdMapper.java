package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.Ad;
import ru.skypro.homework.entity.AdEntity;

@Mapper
public interface AdMapper {

    AdMapper INSTANCE = Mappers.getMapper(AdMapper.class);

    @Mapping(source = "author.pk", target = "author")
    Ad adToAdDTO(AdEntity adEntity);

    @Mapping(source = "author", target = "author.pk")
    @Mapping(target = "description", ignore = true)
    AdEntity adDTOToAd(Ad adDTO);
}