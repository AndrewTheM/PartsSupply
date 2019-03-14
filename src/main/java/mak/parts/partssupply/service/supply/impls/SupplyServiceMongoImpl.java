package mak.parts.partssupply.service.supply.impls;

import mak.parts.partssupply.model.Supply;
import mak.parts.partssupply.repository.SupplyRepository;
import mak.parts.partssupply.service.supply.interfaces.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SupplyServiceMongoImpl implements ISupplyService {

    @Autowired
    private SupplyRepository repository;

    @PostConstruct
    private void init() {
        List<Supply> supplies = new ArrayList<>(
                Arrays.asList(
                    //new Supply("25567", "Bolt", "Instruments", 25.75, "Obichniy bolt")
                )
        );
        repository.saveAll(supplies);
    }

    public Supply create(Supply supply) {
        return repository.save(supply);
    }

    public Supply get(String id) {
        return repository.findById(id).orElse(null);
    }

    public Supply update(Supply supply) {
        return repository.save(supply);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Supply> getAll() {
        return repository.findAll();
    }
}
