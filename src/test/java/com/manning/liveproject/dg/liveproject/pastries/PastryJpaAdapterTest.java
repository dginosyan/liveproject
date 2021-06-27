package com.manning.liveproject.dg.liveproject.pastries;

import domain.pastries.PastryDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PastryJpaAdapterTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PastryRepository pastryRepository;

    private PastryJpaAdapter pastryJpaAdapter;

    @BeforeEach void setup() {
        this.pastryJpaAdapter = new PastryJpaAdapter(pastryRepository);
    }

    @Test
    @DisplayName("returns data from the database")
    void returnsDataFromDatabase() {
        String expectedTitle = "Victoria Sponge1";
        saveTestItem(expectedTitle, 5.55);

        List<PastryDto> items = pastryJpaAdapter.getPastries();
        org.assertj.core.api.Assertions.assertThat(items).anyMatch(item -> expectedTitle.equals(item.getTitle()));
    }

    private void saveTestItem(String title, double price) {
        Pastry pastryEntity = new Pastry();
        pastryEntity.setAbbr("test-item-1" + title);
        pastryEntity.setTitle(title);
        pastryEntity.setPrice(price);

        testEntityManager.persist(pastryEntity);
    }

}