package mak.parts.partssupply.controller;

import mak.parts.partssupply.model.Supplier;
import mak.parts.partssupply.service.supplier.impls.SupplierServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierServiceMongoImpl supplierService;

    @RequestMapping("/list")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAll();
    }

    @RequestMapping("/create/{code}/{name}/{address}/{phone}")
    public Supplier createSupplier(@PathVariable("code") String code, @PathVariable("name") String name,
                                   @PathVariable("address") String address, @PathVariable("phone") String phone){
        return supplierService.create(new Supplier(code, name, address, phone));
    }

    @PostMapping("/create")
    public Supplier createSupplierPost(@RequestBody Supplier supplier) {
        return supplierService.create(supplier);
    }

    @RequestMapping("/edit/{id}/{code}/{name}/{address}/{phone}")
    public Supplier editSupplier(@PathVariable("id") String id, @PathVariable("code") String code,
                                 @PathVariable("name") String name, @PathVariable("address") String address,
                                 @PathVariable("phone") String phone) {
        return supplierService.update(new Supplier(id, code, name, address, phone));
    }

    @PostMapping("/edit")
    public Supplier editSupplierPost(@RequestBody Supplier supplier) {
        return supplierService.create(supplier);
    }

    @RequestMapping("/delete/{id}")
    public void deleteSupplier(@PathVariable("id") String id) {
        supplierService.delete(id);
    }
}
