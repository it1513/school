/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ucitel
 */
public class Areas {

    Scanner sc = new Scanner(System.in, "UTF-8");
    enum Options {
        S, R, T, C, X;
    }

    float readNumber(String text) {
        float input = -1;
        do {
            try {
                System.out.print(text + ": ");
                input = sc.nextFloat();
                if (input < 0) {
                    System.out.println("Číslo nesmí být záporné!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Nesprávně zadané číslo!");
            }
            sc.nextLine();
        } while (input < 0);
        return input;
    }
    
    double getSquareArea(float a) {
        return Math.pow(a, 2);
    }

    double getObdelnikArea(float a , float b){
        return a*b;
    }
    double gettrouhelniikArea(float a , float va){
        return a*va/2;
    }

    double getKruhArea(float r){
        return r*r*Math_PI;
    }
    
    void menu() {
        String optChar = "";
        do {
           System.out.println("Výpočet plochy geometrických útvarů");
           System.out.println("-----------------------------------");
           System.out.println("S = čtverec, R = obdélník, T = trojúhelník, "
                   + "C = kruh, X = konec");
           System.out.print("Zadej volbu: ");
           optChar = sc.nextLine();
           try {
              Options option = Options.valueOf(optChar.toUpperCase());
              switch (option) {
                  case S: System.out.println("Čtverec");
                          float a = this.readNumber("Zadej stranu a");
                          System.out.printf("Plocha čtverce o straně %.2f je %.3f", 
                                  a, this.getSquareArea(a));
                          System.out.println();
                          break;
                  case R: System.out.println("Obdélník");
                          float obdelnikA = this.readNumber("zadej stranu a");
                          float obdelnikB = this.readNumber("zadej stranu b");
                          System.out.printf("obsah obdelniku o stranach %.2f a %.2f je %.3f",obdelnikA,obdelnikB,this.getObdelnikArea(obdelnikA,obdelnikB));
                          break;
                          break;
                  case T: System.out.println("Trojúhelník");
                          float trouhelnikA = this.readNumber("zadej stranu a");
                          float vyskaA = this.readNumber("zadej vysku va");
                          System.out.printf("obsah trojúhelníku o strane %.2f a vysce %.2f je %.3f",trojuhelnikA,vyskaA,this.getTrojuhelnikArea(trojuhelnikA,vyskaA));
                          break;
                  case C: System.out.println("Kruh");
                          float polomer = this.readNumber("zadej polomer");
                          System.out.printf("obsah kruhu o polomeru %.2f je %.3f",polomer,this.getKruhArea(polomer));
                          break;
              }
           } catch (Exception e) {
               System.out.println("Chybná volba");
           }   
        } while (!optChar.equalsIgnoreCase("X"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Areas areas = new Areas();
        //areas.readNumber("Zadej číslo");
        areas.menu();
    }

}
