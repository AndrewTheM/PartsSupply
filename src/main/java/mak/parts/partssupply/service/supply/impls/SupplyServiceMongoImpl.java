package mak.parts.partssupply.service.supply.impls;

import mak.parts.partssupply.model.Part;
import mak.parts.partssupply.model.Supplier;
import mak.parts.partssupply.model.Supply;
import mak.parts.partssupply.repository.SupplyRepository;
import mak.parts.partssupply.service.part.impls.PartServiceMongoImpl;
import mak.parts.partssupply.service.supplier.impls.SupplierServiceMongoImpl;
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

    @Autowired
    private SupplierServiceMongoImpl supplierService;

    @Autowired
    private PartServiceMongoImpl partService;

    @PostConstruct
    private void init() {
        Supplier supplier = supplierService.getAt(0);
        Part part = partService.getAt(0);
        List<Supply> supplies = new ArrayList<>(
                Arrays.asList(
                    new Supply(supplier, part, 25, "2019-03-05")
                )
        );
        repository.saveAll(supplies);
    }

    @Override
    public Supply create(Supply supply) {
        return repository.save(supply);
    }

    @Override
    public Supply get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Supply update(Supply supply) {
        return repository.save(supply);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Supply> getAll() {
        return repository.findAll();
    }
}
