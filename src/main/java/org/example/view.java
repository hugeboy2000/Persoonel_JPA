package org.example;

import org.example.entity.Personnel;
import org.example.service.PersonnelService;

import java.util.Scanner;

public class view {
    public static void main(String[] args) {
        System.out.println("****************Welcome to JPA************************");
        System.out.println("1)creat\n2)read\n3)update\n4)delete\nfindByID");
        System.out.println("please enter the number:");
        Scanner sc = new Scanner(System.in);
        Personnel personnel = new Personnel();
        try {
            int n;
            do {
                n = sc.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("******************************");
                        int number = sc.nextInt();
                        for (int i = 0; i < number; i++) {
                            System.out.println("enter the first name->");
                            String firstname = sc.next();
                            personnel.setFirstName(firstname);
                            System.out.println("persist the first name");
                            System.out.println("******************************");
                        }
                        for (int i = 0; i < number; i++) {
                            System.out.println("enter the last name->");
                            String lastName = sc.next();
                            personnel.setLastName(lastName);
                            System.out.println("persist the last name");
                            System.out.println("******************************");
                        }
                        PersonnelService.create(personnel);
                        System.out.println("create successfully");
                        break;
                    case 2:
                        System.out.println("******************************");
                        PersonnelService.findAll();
                        System.out.println(personnel);
                        break;
                    case 3:
                        System.out.println("******************************");
                        System.out.println("enter the id of personnel");
                        int number2 = sc.nextInt();
                        System.out.println("enter the first name");
                        String str = sc.next();
                        personnel.setFirstName(str);
                        System.out.println("*******************************");
                        System.out.println("enter the last name");
                        String str1 = sc.next();
                        personnel.setLastName(str1);
                        PersonnelService.updateQuery((long) number2);
                        System.out.println("update successfully(::");
                        break;
                    case 4:
                        System.out.println("******************************");
                        System.out.println("enter the id of personnel");
                        int number3 = sc.nextInt();
                        PersonnelService.deleteByID((long) number3);
                        System.out.println("delete successfully(::");
                        break;
                    case 5:
                        System.out.println("******************************");
                        System.out.println("enter the id of personnel");
                        int number4 = sc.nextInt();
                        PersonnelService.findById((long) number4);
                        System.out.println("find successfully(::");
                        System.out.println("******************************");
                        break;
                }
            } while (n == 6);
        } catch (Exception e) {
            System.out.println("Wrong number");

        }


    }}
