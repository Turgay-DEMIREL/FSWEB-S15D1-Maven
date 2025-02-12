package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alışveriş listesi programına hoşgeldiniz");
        while (true) {
            System.out.println("0' basarsanız uygulama durur");
            System.out.println("ürün eklemek için 1'e basınız");
            System.out.println("ürün çıkarmak için 2'ye basınız");
            int secenek = scanner.nextInt();
            switch (secenek){
                case 0:
                    System.exit(1);
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String toBeAddedProducts = scanner.nextLine();
                    addItems(toBeAddedProducts);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                   String toBeRemovedProducts = scanner.nextLine();
                   removeItems(toBeRemovedProducts);
                   break;
            }
        }
    }

    public static void addItems(String input){
        String [] productsToAdd = input.split(",");
        for(String product : productsToAdd){
           if(!checkItemIsInList(product))
               groceryList.add(product);
        }
        groceryList.sort(String::compareTo);
    }

    public static void removeItems(String input){
        String [] productsToRemove = input.split(",");

        for (String product:productsToRemove){
            if (checkItemIsInList(product))
                groceryList.remove(product);
        }
        groceryList.sort(String::compareTo);
    }

    public static boolean checkItemIsInList(String product){
        return groceryList.contains(product);
    }

    public static void printSorted(){
        groceryList.sort(String::compareTo);
        System.out.println(groceryList);
    }

}
