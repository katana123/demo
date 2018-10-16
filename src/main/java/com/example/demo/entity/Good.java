package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "t_good")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Good implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer num;
//    @OneToMany(mappedBy = "good", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private Set<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

//    public Set<Order> getOrders() {
//        return orders;
//    }
//
//    @JsonBackReference
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public Good() {
        super();
    }
}
