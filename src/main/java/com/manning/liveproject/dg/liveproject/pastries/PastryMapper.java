package com.manning.liveproject.dg.liveproject.pastries;

import domain.pastries.PastryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PastryMapper {

    PastryMapper INSTANCE = Mappers.getMapper(PastryMapper.class);

    PastryDto pastryToPastryDto(Pastry pastry);

    Pastry pastryDtoToPastry(PastryDto pastryDto);

    List<PastryDto> pastryListToPastryDtoList(List<Pastry> pastryList);

    List<Pastry> pastryDtoListToPastryList(List<PastryDto> pastryDtoList);

}
