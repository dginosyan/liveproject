package domain.pastries;

import java.util.List;

public class PastryServiceImpl implements PastryServicePort {

    PastryPersistencePort pastryPersistencePort;

    public PastryServiceImpl(PastryPersistencePort pastryPersistencePort) {
        this.pastryPersistencePort = pastryPersistencePort;
    }

    @Override
    public List<PastryDto> getPastries() {
        return this.pastryPersistencePort.getPastries();
    }
}
