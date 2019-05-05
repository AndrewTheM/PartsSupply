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
import java.util.stream.Collectors;

@Service
public class SupplierServiceMongoImpl implements ISupplierService {

    @Autowired
    private SupplierRepository repository;

    @PostConstruct
    private void init() {
        List<Supplier> suppliers = new ArrayList<>(
                Arrays.asList(
                    new Supplier("794", "Part Inc.", "Киев, ул. Франка, 7", "+380662537612"),
                    new Supplier("123", "АвтоМобі", "Львов, ул. Шевченка, 63", "+380993465317"),
                    new Supplier("586", "Michelin Ukraine", "Киев, ул. Котляревского, 1", "+380503127129"),
                    new Supplier("069", "Запаска", "Харьков, ул. Шиллера, 15", "+380673264876"),
                    new Supplier("341", "4Auto", "Черновцы, ул. Главная, 223", "+380952345785")
                )
        );
        if (repository.count() < suppliers.size())
            repository.saveAll(suppliers);
    }

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

    @Override
    public Supplier getAt(int index) {
        return this.getAll().get(index);
    }

    @Override
    public List<Supplier> findByCode(String code) {
        return this.getAll().stream()
                .filter(supplier -> supplier.getCode().contains(code))
                .collect(Collectors.toList());
    }

    @Override
    public List<Supplier> findByName(String name) {
        return this.getAll().stream()
                .filter(supplier -> supplier.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Supplier> findByAddress(String address) {
        return this.getAll().stream()
                .filter(supplier -> supplier.getAddress().contains(address))
                .collect(Collectors.toList());
    }

    @Override
    public List<Supplier> findByPhone(String phone) {
        return this.getAll().stream()
                .filter(supplier -> supplier.getPhone().contains(phone))
                .collect(Collectors.toList());
    }
}
