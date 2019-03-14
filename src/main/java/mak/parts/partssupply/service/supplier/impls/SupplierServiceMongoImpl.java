package mak.parts.partssupply.service.supplier.impls;

import mak.parts.partssupply.model.Supplier;
import mak.parts.partssupply.repository.SupplierRepository;
import mak.parts.partssupply.service.supply.interfaces.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SupplierServiceMongoImpl implements ISupplyService {

    @Autowired
    private SupplierRepository repository;

    @PostConstruct
    private void init() {
        List<Supplier> suppliers = new ArrayList<>(
                Arrays.asList(
                    new Supplier("193", "Detail Inc.", "Ukraine, Kyiv", "+380662537612")
                )
        );
        repository.saveAll(suppliers);
    }

    public Supplier create(Supplier supplier) {
        return repository.save(supplier);
    }

    public Supplier get(String id) {
        return repository.findById(id).orElse(null);
    }

    public Supplier update(Supplier supplier) {
        return repository.save(supplier);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Supplier> getAll() {
        return repository.findAll();
    }
}
