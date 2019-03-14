package mak.parts.partssupply.controller;

import mak.parts.partssupply.form.SupplyForm;
import mak.parts.partssupply.model.Supply;
import mak.parts.partssupply.service.supply.impls.SupplyServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/supply")
public class SupplyController {

    @Autowired
    private SupplyServiceMongoImpl supplyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String supplyList(Model model) {
        model.addAttribute("supplies", supplyService.getAll());
        return "supplyList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createSupply(Model model){
        SupplyForm supplyForm = new SupplyForm();
        model.addAttribute("supplyForm", supplyForm);
        return "createSupply";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createSupply(Model model, @ModelAttribute("supplyForm") SupplyForm supplyForm) {
        supplyService.create(new Supply(supplyForm.getSupplier(), supplyForm.getPart(),
                                supplyForm.getAmount(), supplyForm.getDate()));
        model.addAttribute("supplies", supplyService.getAll());
        return "supplyList";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editSupply(Model model, @PathVariable("id") String id) {
        Supply supply = supplyService.get(id);
        SupplyForm supplyForm = new SupplyForm();
        supplyForm.setSupplier(supply.getSupplier());
        supplyForm.setPart(supply.getPart());
        supplyForm.setAmount(supply.getAmount());
        supplyForm.setDate(supply.getDate());
        model.addAttribute("supplyForm", supplyForm);
        return "editSupply";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editSupply(Model model, @PathVariable("id") String id,
                               @ModelAttribute("supplyForm") SupplyForm supplyForm) {
        Supply supply = supplyService.get(id);
        supply.setSupplier(supplyForm.getSupplier());
        supply.setPart(supplyForm.getPart());
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
