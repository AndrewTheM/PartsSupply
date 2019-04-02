package mak.parts.partssupply.service.part.interfaces;

import mak.parts.partssupply.model.Part;

import java.util.List;

public interface IPartService {
    Part create(Part part);
    Part get(String id);
    Part update(Part part);
    void delete(String id);
    List<Part> getAll();

    Part getAt(int index);
    List<Part> findByCode(String code);
    List<Part> findByName(String name);
    List<Part> findByType(String type);
    List<Part> findByPrice(double price);
    List<Part> findByAnnotation(String annotation);
}
