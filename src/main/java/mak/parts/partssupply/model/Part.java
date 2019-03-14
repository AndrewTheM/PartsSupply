package mak.parts.partssupply.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

// 01.03.2019       класс Деталь
// Developed by Andrey

@Document
public class Part {
    @Id
    private String id;
    private String code;        // код детали
    private String name;        // название детали
    private String type;        // тип (артикул) детали
    private double price;       // цена детали
    private String annotation;  // заметка к детали

    public Part() {
    }

    public Part(String code, String name, String type, double price, String annotation) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.price = price;
        this.annotation = annotation;
    }

    public Part(String id, String code, String name, String type, double price, String annotation) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.price = price;
        this.annotation = annotation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", annotation='" + annotation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return getId() == part.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
