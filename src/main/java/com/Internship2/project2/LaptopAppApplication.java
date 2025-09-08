package com.Internship2.project2;



import com.Internship2.project2.DAO.LaptopDAO;
import com.Internship2.project2.entity.Laptop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;
@Repository
@SpringBootApplication
public class LaptopAppApplication {
    Scanner sc = new Scanner(System.in);
    public void add(LaptopDAO laptopDAO){

        System.out.println("Enter the Details of Laptop \n Name:");
        String name = sc.next();
        System.out.println("Enter the Processor: ");
        String processor = sc.next();
        System.out.println("Enter the RAM in GB");
        int ram = sc.nextInt();
        System.out.println("Enter the Storage(eg. 1TB/HDD or 250/SSD): ");
        String rom= sc.next();
        System.out.println("Enter the iemi Number: ");
        long iemi = sc.nextLong();

        laptopDAO.add(new Laptop(name,iemi,processor,ram,rom));
        System.out.println("New Laptop added Successfully");
    }

    public void delete(LaptopDAO laptopDAO){
        System.out.println("Enter a laptop Id to which you want to delete: ");
        laptopDAO.remove(sc.nextInt());
    }

    public void findById(LaptopDAO laptopDAO){
        System.out.println("Enter a ID to Find Laptop: ");
        System.out.println(laptopDAO.findById(sc.nextInt()));
    }

    public void findByIEMI(LaptopDAO laptopDAO){
        System.out.println("Enter a ID to Find Laptop: ");
        System.out.println(laptopDAO.findByIEMI(sc.nextLong()));
    }

    public void update(LaptopDAO laptopDAO){
        System.out.println("Enter a ID to Update a Laptop : ");
        laptopDAO.update(sc.nextInt());
    }
    public void fetchAll(LaptopDAO laptopDAO){
        List<Laptop> list= laptopDAO.fetchAll();
        list.stream().forEach((ele)-> System.out.println(ele));
    }


    @Bean
    CommandLineRunner commandLineRunner(LaptopDAO laptopDAO){

        return runner->{

            while(true){
                System.out.println("Select Option to perform the Operation: ");
                System.out.println("1. ADD laptop");
                System.out.println("2. Remove Laptop");
                System.out.println("3. Find a Laptop");
                System.out.println("4. Update a Laptop ");
                System.out.println("5. Exit");
                System.out.println("6. Fetch ALL Laptop: ");

                switch (sc.nextInt()){
                    case 1->{
                        add(laptopDAO);
                    }
                    case 2->{
                        delete(laptopDAO);
                    }
                    case 3->{
                        System.out.println("Enter a option for find BY ID or IEMI Number: ");
                        if (sc.nextInt()==1)
                            findById(laptopDAO);
                        else
                            findByIEMI(laptopDAO);
                    }
                    case 4->{
                        update(laptopDAO);
                    }
                    case 5->{
                        return;
                    }

                    case 6 ->{
                        fetchAll(laptopDAO);
                    }
                    default -> {
                        System.out.println("Please Enter a Correct Option ");
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(LaptopAppApplication.class, args);
    }

}
