package com.Internship2.project2.DAO.daoIMP;



import com.Internship2.project2.DAO.LaptopDAO;
import com.Internship2.project2.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
public class LaptopDAOImpl implements LaptopDAO {
    private final EntityManager theManager;

    @Autowired
    public LaptopDAOImpl(EntityManager theManager) {
        this.theManager = theManager;
    }


    @Override
    @Transactional
    public void add(Laptop laptop) {
        theManager.persist(laptop);
    }

    @Override
    public Laptop findById(int id) {

        return theManager.find(Laptop.class,id);
    }

    @Override
    public Laptop findByIEMI(long iemi) {
        Query query= theManager.createQuery("select l from Laptop where l.iemi= :iemi");
        query.setParameter("iemi",iemi);
        try{
            Laptop found = (Laptop) query.getSingleResult();
            return found;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public void update(int id) {
        Scanner sc = new Scanner(System.in);
        Laptop foundEmp = theManager.find(Laptop.class,id);
        if (foundEmp==null){
            System.out.println("No such Laptop found");
        }
        else {
            System.out.println("What do want do change(1.name,2.processor,3.RAM,4.ROM) : ");
            switch (sc.nextInt()) {
                case 1: {
                    System.out.println("Enter new name: ");
                    foundEmp.setName(sc.next());
                    break;
                }
                case 2: {
                    System.out.println("Enter new Processor: ");
                    foundEmp.setProcessor(sc.next());
                    break;
                }
                case 3: {
                    System.out.println("Enter new Salary: ");
                    foundEmp.setRam(sc.nextInt());
                    break;
                }
                case 4: {
                    System.out.println("Enter new ROM: ");
                    foundEmp.setStorage(sc.next());
                    break;
                }

            }
        }

    }

    @Override
    @Transactional
    public void remove(int id) {
        Laptop foundLap = theManager.find(Laptop.class,id);
        if (foundLap==null){
            System.out.println("No such Laptop found");
        }else{
            theManager.remove(foundLap);
        }
    }

    @Override
    public List fetchAll() {
        Query query=theManager.createQuery("select l from Laptop l");
        return query.getResultList();
    }
}
