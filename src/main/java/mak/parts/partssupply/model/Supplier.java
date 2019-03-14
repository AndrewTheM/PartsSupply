package mak.parts.partssupply.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

// 01.03.2019       класс Поставщик
// Developed by Andrey

@Document
public class Supplier {
    @Id
    private String id;
    private String code;        // код поставщика
    private String name;        // название поставщика
    private String address;     // юридический адрес
    private String phone;       // телефон

    public Supplier() {
    }

    public Supplier(String code, String name, String address, String phone) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Supplier(String id, String code, String name, String address, String phone) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return getId() == supplier.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
