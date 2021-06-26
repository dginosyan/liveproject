package com.manning.liveproject.dg.liveproject.pastries;

import domain.pastries.PastryDto;
import domain.pastries.PastryPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastryJpaAdapter implements PastryPersistencePort {

    private PastryRepository pastryRepository;

    PastryJpaAdapter(PastryRepository pastryRepository) {
        this.pastryRepository = pastryRepository;
    }

    @Override
    public List<PastryDto> getPastries() {
        List<Pastry> pastryList = this.pastryRepository.findAll();
        return PastryMapper.INSTANCE.pastryListToPastryDtoList(pastryList);
    }
}
