package provider;

import model.Loop;
import repository.LoopRepository;

import java.util.List;

public class LoopProvider {

    public List<Loop> getLoops() {
        LoopRepository loopRepository = new LoopRepository();
        return loopRepository.getLoopList();
    }
}
