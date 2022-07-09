package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.stream.Collectors;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<Astronaut> selectedAstronauts = astronauts.stream()
                .filter(e->e.getOxygen()>0)
                .collect(Collectors.toList());

        for (Astronaut astronaut : selectedAstronauts) {
            while (astronaut.canBreath() && planet.getItems().iterator().hasNext()){
                String currentItem = planet.getItems().iterator().next();
                astronaut.getBag().getItems().add(currentItem);
                planet.getItems().remove(currentItem);
                astronaut.breath();
            }

        }
    }
}
