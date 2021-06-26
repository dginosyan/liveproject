package domain.pastries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PastryDtoTest {

    @Test
    void checkPastryFormattedPrice() {
        PastryDto sut1 = new PastryDto(1L, "abbr1", "Test Pastry 1", 1.6);
        PastryDto sut2 = new PastryDto(2L, "abbr2", "Test Pastry 2", 6);
        PastryDto sut3 = new PastryDto(3L, "abbr3", "Test Pastry 3", 2.9595);
        assertAll(
                () -> assertEquals(sut1.getFormattedPrice(), "1.60"),
                () -> assertEquals(sut2.getFormattedPrice(), "6.00"),
                () -> assertEquals(sut3.getFormattedPrice(), "2.96")
        );
    }

}