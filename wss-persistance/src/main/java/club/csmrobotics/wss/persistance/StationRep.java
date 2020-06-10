package club.csmrobotics.wss.persistance;

import club.csmrobotics.wss.domain.WeatherStation;
import org.springframework.data.repository.CrudRepository;

public interface StationRep extends CrudRepository<WeatherStation, Long> {
}
