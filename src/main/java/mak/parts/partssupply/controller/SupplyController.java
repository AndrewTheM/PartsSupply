package mak.parts.partssupply.controller;

import mak.parts.partssupply.form.SupplyForm;
import mak.parts.partssupply.model.Part;
import mak.parts.partssupply.model.Supplier;
import mak.parts.partssupply.model.Supply;
import mak.parts.partssupply.service.part.impls.PartServiceMySQLImpl;
import mak.parts.partssupply.service.supplier.impls.SupplierServiceMySQLImpl;
import mak.parts.partssupply.service.supply.impls.SupplyServiceMySQLImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/supply")
public class SupplyController {

    @Autowired
    private SupplyServiceMySQLImpl supplyService;

    @Autowired
    private SupplierServiceMySQLImpl supplierService;

    @Autowired
    private PartServiceMySQLImpl partService;

    @RequestMapping("/list")
    public List<Supply> getAllSupplies() {
        return supplyService.getAll();
    }

    @RequestMapping("/create/{supplierId}/{partId}/{amount}/{date}")
    public Supply createSupply(@PathVariable("supplierId") Integer supplierId, @PathVariable("partId") Integer partId,
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
    public Supply editSupply(@PathVariable("id") Integer id, @PathVariable("supplierId") Integer supplierId,
                             @PathVariable("partId") Integer partId, @PathVariable("amount") int amount,
                             @PathVariable("date") String date) {
        Supplier supplier = supplierService.get(supplierId);
        Part part = partService.get(partId);
        return supplyService.update(new Supply(id, supplier, part, amount, date));
    }

    @PostMapping("/edit")
    public Supply editSupplyPost(@RequestBody SupplyForm supplyForm) {
        Supplier supplier = supplierService.get(supplyForm.getSupplier());
        Part part = partService.get(supplyForm.getPart());
        Supply supply = new Supply(supplyForm.getId(), supplier, part, supplyForm.getAmount(), supplyForm.getDate());
        return supplyService.update(supply);
    }

    @RequestMapping("/delete/{id}")
    public void deleteSupply(@PathVariable("id") Integer id) {
        supplyService.delete(id);
    }

    @RequestMapping("/income")
    public double getTotalIncome() {
        return supplyService.getTotalIncome();
    }

    @RequestMapping("income/{date}")
    public double getIncomeOfDate(@PathVariable("date") String incomeDate) {
        LocalDate date = LocalDate.parse(incomeDate);
        return supplyService.getIncomeOfDate(date);
    }

    @RequestMapping("income/from/{firstDate}/to/{secondDate}")
    public double getIncomeBetween(@PathVariable("firstDate") String firstDate, @PathVariable("secondDate") String secondDate) {
        LocalDate date1 = LocalDate.parse(firstDate), date2 = LocalDate.parse(secondDate);
        return supplyService.getIncomeBetween(date1, date2);
    }

    @RequestMapping("/find/{field}/{value}")
    public List<Supply> findSupplies(@PathVariable("field") String field, @PathVariable("value") String value) {
        List<Supply> result = null;
        switch (field) {
            case "supplier": result = supplyService.findBySupplier(value); break;
            case "part": result = supplyService.findByPart(value); break;
            case "amount": result = supplyService.findByAmount(Integer.parseInt(value)); break;
            case "date": result = supplyService.findByDate(value); break;
        }
        return result;
    }
}
