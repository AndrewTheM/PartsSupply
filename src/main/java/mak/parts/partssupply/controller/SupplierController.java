package mak.parts.partssupply.controller;

import mak.parts.partssupply.form.SupplierForm;
import mak.parts.partssupply.model.Supplier;
import mak.parts.partssupply.service.supplier.impls.SupplierServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierServiceMongoImpl supplierService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String supplierList(Model model) {
        model.addAttribute("suppliers", supplierService.getAll());
        return "supplierList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createSupplier(Model model){
        SupplierForm supplierForm = new SupplierForm();
        model.addAttribute("supplierForm", supplierForm);
        return "createSupplier";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createSupplier(Model model, @ModelAttribute("supplierForm") SupplierForm supplierForm) {
        if (!supplierForm.getCode().isEmpty() && !supplierForm.getName().isEmpty()
                && !supplierForm.getAddress().isEmpty() && !supplierForm.getPhone().isEmpty())
            supplierService.create(new Supplier(supplierForm.getCode(), supplierForm.getName(),
                                    supplierForm.getAddress(), supplierForm.getPhone()));
        model.addAttribute("suppliers", supplierService.getAll());
        return "supplierList";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editSupplier(Model model, @PathVariable("id") String id) {
        Supplier supplier = supplierService.get(id);
        SupplierForm supplierForm = new SupplierForm();
        supplierForm.setCode(supplier.getCode());
        supplierForm.setName(supplier.getName());
        supplierForm.setAddress(supplier.getAddress());
        supplierForm.setPhone(supplier.getPhone());
        model.addAttribute("supplierForm", supplierForm);
        return "editSupplier";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editSupplier(Model model, @PathVariable("id") String id,
                           @ModelAttribute("supplierForm") SupplierForm supplierForm) {
        if (!supplierForm.getCode().isEmpty() && !supplierForm.getName().isEmpty()
                && !supplierForm.getAddress().isEmpty() && !supplierForm.getPhone().isEmpty()) {
            Supplier supplier = supplierService.get(id);
            supplier.setCode(supplierForm.getCode());
            supplier.setName(supplierForm.getName());
            supplier.setAddress(supplierForm.getAddress());
            supplier.setPhone(supplierForm.getPhone());
            supplierService.update(supplier);
        }
        model.addAttribute("suppliers", supplierService.getAll());
        return "supplierList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSupplier(Model model, @PathVariable("id") String id) {
        supplierService.delete(id);
        model.addAttribute("suppliers", supplierService.getAll());
        return "supplierList";
    }
}
