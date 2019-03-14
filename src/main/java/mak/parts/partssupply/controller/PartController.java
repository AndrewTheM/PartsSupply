package mak.parts.partssupply.controller;

import mak.parts.partssupply.form.PartForm;
import mak.parts.partssupply.model.Part;
import mak.parts.partssupply.service.part.impls.PartServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/part")
public class PartController {

    @Autowired
    private PartServiceMongoImpl partService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String partList(Model model) {
        model.addAttribute("parts", partService.getAll());
        return "partList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPart(Model model){
        PartForm partForm = new PartForm();
        model.addAttribute("partForm", partForm);
        return "createPart";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPart(Model model, @ModelAttribute("partForm") PartForm partForm) {
        partService.create(new Part(partForm.getCode(), partForm.getName(), partForm.getType(),
                                    partForm.getPrice(), partForm.getAnnotation()));
        model.addAttribute("parts", partService.getAll());
        return "partList";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPart(Model model, @PathVariable("id") String id) {
        Part part = partService.get(id);
        PartForm partForm = new PartForm();
        partForm.setCode(part.getCode());
        partForm.setName(part.getName());
        partForm.setType(part.getType());
        partForm.setPrice(part.getPrice());
        partForm.setAnnotation(part.getAnnotation());
        model.addAttribute("partForm", partForm);
        return "editPart";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editPart(Model model, @PathVariable("id") String id,
                           @ModelAttribute("partForm") PartForm partForm) {
        Part part = partService.get(id);
        part.setCode(partForm.getCode());
        part.setName(partForm.getName());
        part.setType(partForm.getType());
        part.setPrice(partForm.getPrice());
        part.setAnnotation(partForm.getAnnotation());
        partService.update(part);
        model.addAttribute("parts", partService.getAll());
        return "partList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePart(Model model, @PathVariable("id") String id) {
        partService.delete(id);
        model.addAttribute("parts", partService.getAll());
        return "partList";
    }
}
