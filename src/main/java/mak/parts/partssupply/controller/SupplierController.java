package mak.parts.partssupply.controller;

import mak.parts.partssupply.model.Supplier;
import mak.parts.partssupply.service.supplier.impls.SupplierServiceMySQLImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierServiceMySQLImpl supplierService;

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
    public Supplier editSupplier(@PathVariable("id") Integer id, @PathVariable("code") String code,
                                 @PathVariable("name") String name, @PathVariable("address") String address,
                                 @PathVariable("phone") String phone) {
        return supplierService.update(new Supplier(id, code, name, address, phone));
    }

    @PostMapping("/edit")
    public Supplier editSupplierPost(@RequestBody Supplier supplier) {
        return supplierService.update(supplier);
    }

    @RequestMapping("/delete/{id}")
    public void deleteSupplier(@PathVariable("id") Integer id) {
        supplierService.delete(id);
    }

    @RequestMapping("/find/{field}/{value}")
    public List<Supplier> findSuppliers(@PathVariable("field") String field, @PathVariable("value") String value) {
        List<Supplier> result = null;
        switch (field) {
            case "code": result = supplierService.findByCode(value); break;
            case "name": result = supplierService.findByName(value); break;
            case "address": result = supplierService.findByAddress(value); break;
            case "phone": result = supplierService.findByPhone(value); break;
        }
        return result;
    }
}
