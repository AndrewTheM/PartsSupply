package mak.parts.partssupply.service.part.impls;

import mak.parts.partssupply.model.Part;
import mak.parts.partssupply.repository.PartRepository;
import mak.parts.partssupply.service.part.interfaces.IPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PartServiceMongoImpl implements IPartService {

    @Autowired
    PartRepository repository;

    @PostConstruct
    private void init() {
        List<Part> parts = new ArrayList<>(
                Arrays.asList(
                        new Part("4524521325", "Поршень", "GF-5462", 30, "Два по цене трёх"),
                        new Part("3245246533", "Водяной насос", "WE-3533", 22, "-"),
                        new Part("9068709926", "Радиатор", "SA-4987", 13, "*Это не магнитола"),
                        new Part("1234178164", "Амортизатор", "JK-1984", 78, "Ароматизатор в подарок"),
                        new Part("8979646484", "Воздушный фильтр", "ST-1289", 123, "Такой воздушный!"),
                        new Part("1827278748", "Рессора", "FU-0091", 32, "-"),
                        new Part("5024712374", "Резонатор", "BJ-4236", 22, "Сделан с любовью в Китае"),
                        new Part("7124218814", "Компрессор", "SA-6853", 57, "-"),
                        new Part("9768648457", "Глушитель", "BJ-3012", 80, "Глушит лучше затычек!"),
                        new Part("4180778939", "Стекло заднее", "CV-0372", 500, "АКЦИЯ! При покупке - стекло переднее со скидкой 50%!")
                )
        );
        if (repository.count() < parts.size())
            repository.saveAll(parts);
    }

    @Override
    public Part create(Part part) {
        return repository.save(part);
    }

    @Override
    public Part get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Part update(Part part) {
        return repository.save(part);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Part> getAll() {
        return repository.findAll();
    }

    @Override
    public Part getAt(int index) {
        return this.getAll().get(index);
    }
}
