package provider;

import model.Zone;
import repository.ZoneRepository;

public class ZoneProvider {
    public Zone getZoneInfoById(String zoneId) {
        ZoneRepository zoneRepository = new ZoneRepository();
        return zoneRepository.getZoneInfoById(zoneId);
    }
}
