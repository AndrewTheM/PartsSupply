package mak.parts.partssupply.controller;

import mak.parts.partssupply.form.SupplyForm;
import mak.parts.partssupply.model.Part;
import mak.parts.partssupply.model.Supplier;
import mak.parts.partssupply.model.Supply;
import mak.parts.partssupply.service.part.impls.PartServiceMongoImpl;
import mak.parts.partssupply.service.supplier.impls.SupplierServiceMongoImpl;
import mak.parts.partssupply.service.supply.impls.SupplyServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/supply")
public class SupplyController {

    @Autowired
    private SupplyServiceMongoImpl supplyService;

    @Autowired
    private SupplierServiceMongoImpl supplierService;

    @Autowired
    private PartServiceMongoImpl partService;

    @RequestMapping("/list")
    public List<Supply> getAllSupplies() {
        return supplyService.getAll();
    }

    @RequestMapping("/create/{supplierId}/{partId}/{amount}/{date}")
    public Supply createSupply(@PathVariable("supplierId") String supplierId, @PathVariable("partId") String partId,
                               @PathVariable("amount") int amount, @PathVariable("date") String date){
        Supplier supplier = supplierService.get(supplierId);
        Part part = partService.get(partId);
        return supplyService.create(new Supply(supplier, part, amount, date));
    }

    @PostMapping("/create")
    public Supply createSupplyPost(@RequestBody SupplyForm supplyForm) {
        Supplier supplier = supplierService.get(supplyForm.getSupplier());
        Part part = partService.get(supplyForm.getPart());
        Supply supply = new Supply(supplier, part, supplyForm.getAmount(), supplyForm.getDate());
        return supplyService.create(supply);
    }

    @RequestMapping("/edit/{id}/{supplierId}/{partId}/{amount}/{date}")
    public Supply editSupply(@PathVariable("id") String id, @PathVariable("supplierId") String supplierId,
                             @PathVariable("partId") String partId, @PathVariable("amount") int amount,
                             @PathVariable("date") String date) {
        Supplier supplier = supplierService.get(supplierId);
        Part part = partService.get(partId);
        return supplyService.update(new Supply(id, supplier, part, amount, date));
    }

    @PostMapping("/edit")
    public Supply editSupplyPost(@RequestBody SupplyForm supplyForm) {
        Supplier supplier = supplierService.get(supplyForm.getSupplier());
        Part part = partService.get(supplyForm.getPart());
        Supply supply = new Supply(supplier, part, supplyForm.getAmount(), supplyForm.getDate());
        return supplyService.update(supply);
    }

    @RequestMapping("/delete/{id}")
    public void deleteSupply(@PathVariable("id") String id) {
        supplyService.delete(id);
    }
}
