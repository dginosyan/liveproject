package domain.pastries;

import java.util.List;

public interface PastryPersistencePort {
    List<PastryDto> getPastries();
}
