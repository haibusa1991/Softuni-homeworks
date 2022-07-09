package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && state.getExhibits().iterator().hasNext()) {
                explorer.search();
                String exhibit = state.getExhibits().iterator().next();
                state.getExhibits().remove(exhibit);
                explorer.getSuitcase().getExhibits().add(exhibit);
            }
        }
    }
}