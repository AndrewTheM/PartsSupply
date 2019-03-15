package mak.parts.partssupply.service.supplier.impls;

import mak.parts.partssupply.model.Supplier;
import mak.parts.partssupply.repository.SupplierRepository;
import mak.parts.partssupply.service.supplier.interfaces.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SupplierServiceMongoImpl implements ISupplierService {

    @Autowired
    private SupplierRepository repository;
    /*
    @PostConstruct
    private void init() {
        List<Supplier> suppliers = new ArrayList<>(
                Arrays.asList(
                    new Supplier("193", "Detail Inc.", "Ukraine, Kyiv", "+380662537612")
                )
        );
        repository.saveAll(suppliers);
    }
    */
    @Override
    public Supplier create(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Supplier get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Supplier> getAll() {
        return repository.findAll();
    }
}
