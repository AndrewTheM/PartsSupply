package mak.parts.partssupply.controller;

import mak.parts.partssupply.form.SupplyForm;
import mak.parts.partssupply.model.Part;
import mak.parts.partssupply.model.Supplier;
import mak.parts.partssupply.model.Supply;
import mak.parts.partssupply.service.part.impls.PartServiceMongoImpl;
import mak.parts.partssupply.service.supplier.impls.SupplierServiceMongoImpl;
import mak.parts.partssupply.service.supply.impls.SupplyServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/supply")
public class SupplyController {

    @Autowired
    private SupplyServiceMongoImpl supplyService;

    @Autowired
    private SupplierServiceMongoImpl supplierService;

    @Autowired
    private PartServiceMongoImpl partService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String supplyList(Model model) {
        model.addAttribute("supplies", supplyService.getAll());
        return "supplyList";
    }

    private void addMavs(Model model) {
        Map<String, String> supplierMavs = supplierService.getAll().stream()
                .collect(Collectors.toMap(Supplier::getId, Supplier::getName));
        Map<String, String> partMavs = partService.getAll().stream()
                .collect(Collectors.toMap(Part::getId, Part::getName));
        model.addAttribute("supplierMavs", supplierMavs);
        model.addAttribute("partMavs", partMavs);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createSupply(Model model){
        SupplyForm supplyForm = new SupplyForm();
        this.addMavs(model);
        model.addAttribute("supplyForm", supplyForm);
        return "createSupply";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createSupply(Model model, @ModelAttribute("supplyForm") SupplyForm supplyForm) {
        Supplier supplier = supplierService.get(supplyForm.getSupplier());
        Part part = partService.get(supplyForm.getPart());
        supplyService.create(new Supply(supplier, part, supplyForm.getAmount(), supplyForm.getDate()));
        model.addAttribute("supplies", supplyService.getAll());
        return "supplyList";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editSupply(Model model, @PathVariable("id") String id) {
        Supply supply = supplyService.get(id);
        SupplyForm supplyForm = new SupplyForm();
        supplyForm.setSupplier(supply.getSupplier().getName());
        supplyForm.setPart(supply.getPart().getName());
        supplyForm.setAmount(supply.getAmount());
        supplyForm.setDate(supply.getDate());
        this.addMavs(model);
        model.addAttribute("supplyForm", supplyForm);
        return "editSupply";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editSupply(Model model, @PathVariable("id") String id,
                               @ModelAttribute("supplyForm") SupplyForm supplyForm) {
        Supply supply = supplyService.get(id);
        Supplier supplier = supplierService.get(supplyForm.getSupplier());
        Part part = partService.get(supplyForm.getPart());
        supply.setSupplier(supplier);
        supply.setPart(part);
        supply.setAmount(supplyForm.getAmount());
        supply.setDate(supplyForm.getDate());
        supplyService.update(supply);
        model.addAttribute("supplies", supplyService.getAll());
        return "supplyList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSupply(Model model, @PathVariable("id") String id) {
        supplyService.delete(id);
        model.addAttribute("supplies", supplyService.getAll());
        return "supplyList";
    }
}
