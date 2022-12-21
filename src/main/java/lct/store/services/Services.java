package lct.store.services;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Scanner;

import lct.store.models.Keyboard;
import lct.store.models.Laptop;

public class Services {
   public static void showMenuServices(LinkedList<Laptop> laptopList, LinkedList<Keyboard> keyboardList) {
      System.out.print("This is a program for manage store\n");
      System.out.print("Data in file example_data.json were loaded automaticly\n");
      System.out.print("Choose what do you want to do with these action below\n");
      System.out.print("1. Find product\n");
      System.out.print("2. Exit\n");
      try (Scanner sc = new Scanner(System.in)) {
         int choose = sc.nextInt();
         switch (choose) {
            case 1:
               System.out.print("Choose kind of product\n");
               System.out.print("1. Laptop\n");
               System.out.print("2. Keyboard\n");
               choose = sc.nextInt();
               switch (choose) {
                  case 1:
                     Laptop laptopClass = new Laptop();
                     System.out.print("Choose kind of component\n");
                     String[] kindofcomponentlaptoplist = laptopClass.showKindOFComponent();
                     for (int i = 0; i < kindofcomponentlaptoplist.length; i++) {
                        System.out.print(i + 1 + ". " + kindofcomponentlaptoplist[i] + "\n");
                     }
                     choose = sc.nextInt();
                     String methodlaptoptoget = "get" + kindofcomponentlaptoplist[choose - 1];
                     Method methodlaptop;
                     LinkedList<Laptop> laptoplistchoice = new LinkedList<Laptop>();
                     try {
                        methodlaptop = laptopClass.getClass().getMethod(methodlaptoptoget, (Class<?>[]) null);
                        try {
                           for (int i = 0; i < laptopList.size(); i++) {
                              laptoplistchoice.add(laptopList.get(0));
                              System.out.print(i + 1 + ". " + methodlaptop.invoke(laptopList.get(i)) + "\n");
                           }
                        } catch (Exception e) {
                           e.printStackTrace();
                        }
                     } catch (SecurityException e) {
                        e.printStackTrace();
                     } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                     }
                     ;
                     while (true) {
                        choose = sc.nextInt();
                        if (choose <= laptopList.size() && choose >= 1) {
                           System.out.print("1. Sell\n");
                           System.out.print("2. Import\n");
                           int chooseAction = sc.nextInt();
                           switch (chooseAction) {
                              case 1:
                                 while (true) {
                                    System.out.print(
                                          "Current amount:" + laptoplistchoice.get(choose - 1).getAmount() + "\n");
                                    System.out.print("Input amount:");
                                    long sellAmount = sc.nextLong();
                                    if (sellAmount > laptoplistchoice.get(choose - 1).getAmount())
                                       continue;
                                    laptoplistchoice.get(choose - 1).sellProduct(sellAmount);
                                    System.out.print(
                                          "Total:" + laptoplistchoice.get(choose - 1).getPrice() * sellAmount + "\n");
                                    System.out.print(
                                          "Current amount:" + laptoplistchoice.get(choose - 1).getAmount() + "\n");
                                    break;
                                 }
                                 ;
                                 break;
                              case 2:
                                 while (true) {
                                    System.out.print(
                                          "Current amount:" + laptoplistchoice.get(choose - 1).getAmount() + "\n");
                                    System.out.print("Input amount:");
                                    long importAmount = sc.nextLong();
                                    if (importAmount > laptoplistchoice.get(choose - 1).getAmount())
                                       continue;
                                    laptoplistchoice.get(choose - 1).importProduct(importAmount);
                                    System.out.print(
                                          "Current amount:" + laptoplistchoice.get(choose - 1).getAmount() + "\n");
                                    break;
                                 }
                                 break;
                              default:
                                 break;
                           }
                           break;
                        }
                     }
                     break;
                  case 2:
                     Keyboard keyboardclass = new Keyboard();
                     System.out.print("Choose kind of component\n");
                     String[] kindofcomponentkeyboardlist = keyboardclass.showKindOFComponent();
                     for (int i = 0; i < kindofcomponentkeyboardlist.length; i++) {
                        System.out.print(i + 1 + ". " + kindofcomponentkeyboardlist[i] + "\n");
                     }
                     choose = sc.nextInt();
                     String methodkeyboardtoget = "get" + kindofcomponentkeyboardlist[choose - 1];
                     Method methodkeyboard;
                     try {
                        methodkeyboard = keyboardclass.getClass().getMethod(methodkeyboardtoget, (Class<?>[]) null);
                        try {
                           for (int i = 0; i < keyboardList.size(); i++) {
                              System.out.print(i + 1 + ". " + methodkeyboard.invoke(keyboardList.get(i)) + "\n");
                           }
                        } catch (Exception e) {
                           e.printStackTrace();
                        }
                     } catch (SecurityException e) {
                        e.printStackTrace();
                     } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                     }
                     ;
                     break;
                  default:
                     break;
               }
               break;
            case 2:
               while (true) {
                  choose = sc.nextInt();
                  if (choose <= keyboardList.size() && choose >= 1) {
                     System.out.print("1. Sell\n");
                     System.out.print("2. Import\n");
                     int chooseAction = sc.nextInt();
                     switch (chooseAction) {
                        case 1:
                           while (true) {
                              System.out.print("Current amount:" + keyboardList.get(choose - 1).getAmount() + "\n");
                              System.out.print("Input amount:");
                              long sellAmount = sc.nextLong();
                              if (sellAmount > keyboardList.get(choose - 1).getAmount())
                                 continue;
                              keyboardList.get(choose - 1).sellProduct(sellAmount);
                              System.out
                                    .print("Total:" + keyboardList.get(choose - 1).getPrice() * sellAmount + "\n");
                              System.out.print("Current amount:" + keyboardList.get(choose - 1).getAmount() + "\n");
                              break;
                           }
                           ;
                           break;
                        case 2:
                           while (true) {
                              System.out.print("Current amount:" + keyboardList.get(choose - 1).getAmount() + "\n");
                              System.out.print("Input amount:");
                              long importAmount = sc.nextLong();
                              if (importAmount > keyboardList.get(choose - 1).getAmount())
                                 continue;
                              keyboardList.get(choose - 1).importProduct(importAmount);
                              System.out.print("Current amount:" + keyboardList.get(choose - 1).getAmount() + "\n");
                              break;
                           }
                           break;
                        default:
                           break;
                     }
                     break;
                  }
               }
               break;
            default:
               break;
         }
      }
   }
}