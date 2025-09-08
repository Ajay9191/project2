package com.Internship2.project2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop_tab")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lap_id")
    private int Id;
    @Column(name = "lap_name")
    private String name;
    private Long iemi;
    private String processor;
    private int ram;
    private String storage;

    public Laptop(){}

    public Laptop(String name, Long iemi, String processor, int ram, String storage) {
        this.name = name;
        this.iemi = iemi;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIemi() {
        return iemi;
    }

    public void setIemi(Long iemi) {
        this.iemi = iemi;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", iemi=" + iemi +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", storage='" + storage + '\'' +
            '}';
    }
}