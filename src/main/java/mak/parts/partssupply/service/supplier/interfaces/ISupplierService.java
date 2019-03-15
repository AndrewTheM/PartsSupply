package mak.parts.partssupply.service.supplier.interfaces;

import mak.parts.partssupply.model.Supplier;

import java.util.List;

public interface ISupplierService {
    Supplier create(Supplier supplier);
    Supplier get(String id);
    Supplier update(Supplier supplier);
    void delete(String id);
    List<Supplier> getAll();

    Supplier getAt(int index);
}
