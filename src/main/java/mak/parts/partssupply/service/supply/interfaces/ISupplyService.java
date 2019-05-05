package mak.parts.partssupply.service.supply.interfaces;

import mak.parts.partssupply.model.Supply;

import java.time.LocalDate;
import java.util.List;

public interface ISupplyService {
    Supply create(Supply supply);
    Supply get(String id);
    Supply update(Supply supply);
    void delete(String id);
    List<Supply> getAll();

    double getTotalExpense();
    double getExpenseOfDate(LocalDate date);
    double getExpenseBetween(LocalDate startDate, LocalDate endDate);

    List<Supply> findBySupplier(String supplierName);
    List<Supply> findByPart(String partName);
    List<Supply> findByAmount(int amount);
    List<Supply> findByDate(String date);
}
