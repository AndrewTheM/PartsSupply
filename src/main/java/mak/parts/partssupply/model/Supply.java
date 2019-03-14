package mak.parts.partssupply.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

// 01.03.2019       класс Поставка
// Developed by Andrey

@Document
public class Supply {
    @Id
    private String id;
    private Supplier supplier;      // поставщик
    private Part part;              // поставленная деталь
    private int amount;             // количество деталей
    private String date;         // дата поставки

    public Supply() {
    }

    public Supply(Supplier supplier, Part part, int amount, String date) {
        this.supplier = supplier;
        this.part = part;
        this.amount = amount;
        this.date = date;
    }

    public Supply(String id, Supplier supplier, Part part, int amount, String date) {
        this.id = id;
        this.supplier = supplier;
        this.part = part;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", part=" + part +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supply supply = (Supply) o;
        return getId() == supply.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
