package org.example.models;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    public void startGrocery() {
        int choice;

        do {
            System.out.println("Yapılmasını istediğiniş işlemi seçin. (0.Çıkış 1.Ekleme 2.Çıkarma");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;

                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
            }
        }
        while (choice != 0);
        scanner.close();
    }

    public static void removeItems(String itemsToRemove) {
        String[] splitItems = itemsToRemove.split(",");
        for(String item: splitItems){
            item = item.trim();
            if(!checkItemIsInList(item)){
                System.out.println("Seçilen item listede mevcut değil " + item);
            } else {
                groceryList.remove(item);
            }
        }
    }


    public static void addItems(String itemsToAdd) {
        String[] splitItems = itemsToAdd.split(",");
        for(String item: splitItems){
            item = item.trim();
            if(checkItemIsInList(item)){
                System.out.println("Seçilen item listede mevcut " + item);
            } else {
                groceryList.add(item);
            }
        }
    }

    public static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);
    }


    public static void printSorted() {
        sortItems();
        System.out.println("Mevcut Pazar Listesi: ");
        for (String item: groceryList) {
            System.out.println(item);
        }
    }

    public static void sortItems() {
        Collections.sort(groceryList);
    }

}
