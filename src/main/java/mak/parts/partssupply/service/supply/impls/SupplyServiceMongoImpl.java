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
import java.time.LocalDate;
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
        List<Supply> supplies = new ArrayList<>(
                Arrays.asList(
                    new Supply(supplierService.getAt(4), partService.getAt(7), 13, "2019-03-05"),
                    new Supply(supplierService.getAt(0), partService.getAt(3), 2, "2019-03-28"),
                    new Supply(supplierService.getAt(1), partService.getAt(9), 1, "2019-02-11"),
                    new Supply(supplierService.getAt(1), partService.getAt(0), 9, "2018-10-22"),
                    new Supply(supplierService.getAt(2), partService.getAt(6), 7, "2018-08-01"),
                    new Supply(supplierService.getAt(3), partService.getAt(2), 67, "2019-01-30"),
                    new Supply(supplierService.getAt(0), partService.getAt(8), 3, "2019-02-17"),
                    new Supply(supplierService.getAt(2), partService.getAt(1), 23, "2017-12-26"),
                    new Supply(supplierService.getAt(4), partService.getAt(4), 8, "2017-09-18"),
                    new Supply(supplierService.getAt(2), partService.getAt(5), 1, "2018-04-20")
                )
        );
        if (repository.findAll().size() == 0 || !repository.findAll().get(0).getDate().equals(supplies.get(0).getDate()))
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

    @Override
    public double getTotalIncome() {
        double income = 0;
        for (Supply sup: this.getAll())
            income += sup.getAmount() * sup.getPart().getPrice();
        return income;
    }

    @Override
    public double getIncomeOfDate(LocalDate date) {
        double income = 0;
        for (Supply sup: this.getAll())
            if (sup.getDate().equals(date.toString()))
                income += sup.getAmount() * sup.getPart().getPrice();
        return income;
    }

    @Override
    public double getIncomeBetween(LocalDate startDate, LocalDate endDate) {
        double income = 0;
        for (Supply sup: this.getAll()) {
            CharSequence dateStr = sup.getDate();
            LocalDate date = LocalDate.parse(dateStr);
            if ((date.isAfter(startDate) || date.isEqual(startDate)) &&
                    (date.isBefore(endDate) || date.isEqual(endDate)))
                income += sup.getAmount() * sup.getPart().getPrice();
        }
        return income;
    }
}
