package mak.parts.partssupply.service.supplier.interfaces;

import mak.parts.partssupply.model.Supplier;

import java.util.List;

public interface ISupplierService {
    Supplier create(Supplier supplier);
    Supplier get(Integer id);
    Supplier update(Supplier supplier);
    void delete(Integer id);
    List<Supplier> getAll();

    Supplier getAt(int index);
    List<Supplier> findByCode(String code);
    List<Supplier> findByName(String name);
    List<Supplier> findByAddress(String address);
    List<Supplier> findByPhone(String phone);
}
