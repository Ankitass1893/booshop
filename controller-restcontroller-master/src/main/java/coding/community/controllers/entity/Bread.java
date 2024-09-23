package coding.community.controllers.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bread {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private float price;

    public Bread(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Bread() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
