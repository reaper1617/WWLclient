package com.gerasimchuk.entities;


import com.gerasimchuk.enums.OrderStatus;


import java.util.Set;

public class Order {
    private int id;
    private String personalNumber;
    private String description;
    private String date;
    private OrderStatus status;
//    private Truck assignedTruck;
//    private Set<Cargo> cargosInOrder;

    public Order() {
    }

    public Order(String personalNumber,
                 String description,
                 String date,
                 OrderStatus status) {
        this.personalNumber = personalNumber;
        this.description = description;
        this.date = date;
        this.status = status;
//        this.assignedTruck = assignedTruck;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

//    public Truck getAssignedTruck() {
//        return assignedTruck;
//    }
//
//    public void setAssignedTruck(Truck assignedTruck) {
//        this.assignedTruck = assignedTruck;
//    }
//
//    public Set<Cargo> getCargosInOrder() {
//        return cargosInOrder;
//    }
//
//    public void setCargosInOrder(Set<Cargo> cargosInOrder) {
//        this.cargosInOrder = cargosInOrder;
//    }


}
