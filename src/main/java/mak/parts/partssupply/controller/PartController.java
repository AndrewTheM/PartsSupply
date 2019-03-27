package mak.parts.partssupply.controller;

import mak.parts.partssupply.model.Part;
import mak.parts.partssupply.service.part.impls.PartServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/part")
public class PartController {

    @Autowired
    private PartServiceMongoImpl partService;

    @RequestMapping("/list")
    public List<Part> getAllParts() {
        return partService.getAll();
    }

    @RequestMapping("/create/{code}/{name}/{type}/{price}/{annotation}")
    public Part createPart(@PathVariable("code") String code, @PathVariable("name") String name,
                       @PathVariable("type") String type, @PathVariable("price") double price,
                       @PathVariable("annotation") String annotation){
        return partService.create(new Part(code, name, type, price, annotation));
    }

    @PostMapping("/create")
    public Part createPartPost(@RequestBody Part part) {
        partService.create(part);
        return part;
    }

    @RequestMapping("/edit/{id}/{code}/{name}/{type}/{price}/{annotation}")
    public Part editPart(@PathVariable("id") String id, @PathVariable("code") String code,
                           @PathVariable("name") String name, @PathVariable("type") String type,
                           @PathVariable("price") double price, @PathVariable("annotation") String annotation) {
        return partService.update(new Part(id, code, name, type, price, annotation));
    }

    @PostMapping("/edit")
    public Part editPartPost(@RequestBody Part part) {
        partService.create(part);
        return partService.update(part);
    }

    @RequestMapping("/delete/{id}")
    public void deletePart(Model model, @PathVariable("id") String id) {
        partService.delete(id);
    }
}
