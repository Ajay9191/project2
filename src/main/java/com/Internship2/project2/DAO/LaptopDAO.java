package com.Internship2.project2.DAO;

import com.Internship2.project2.entity.Laptop;
import com.Internship2.project2.entity.Laptop;

import java.util.List;

public interface LaptopDAO {
    public void add(Laptop laptop);
    public Laptop findById(int id);
    public Laptop findByIEMI(long iemi);
    public void update(int id);
    public void remove(int id);
    public List<Laptop> fetchAll();

}
