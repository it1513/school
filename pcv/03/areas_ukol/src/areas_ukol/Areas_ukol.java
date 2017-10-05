/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areas_ukol;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author student
 */
public class Areas_ukol {
    
    Scanner sc = new Scanner(System.in, "UTF-8");
    enum Options {
        S, R, T, C, X;
    }
    
    float readNumber(String text){
      float input = -1;
      do{
          try{
              System.out.print(text +": ");
              input = sc.nextFloat();
              if(input<0){
                  System.out.println("cislo nemi byt zaporne");
              }
          }catch (InputMismatchException e){
              System.out.println("nespravne zadane cislo");
          }
          sc.nextLine();
      }while(input<0);
        return input;
    }
    
    double getSquareArea(float a){
        return Math.pow(a, 2);
    }
    double getObdelnikArea(float a , float b){
        return a*b;
    }
    
    void menu(){
        String optChar = "";
        do{
            System.out.println("vypocet plochy geometrickych utvaru");
            System.out.println("S = ctverec, R = obdelnik, T = trojuhelnik, "
                   + "C = kruh, X = konec");
            System.out.print("Zadej volbu: ");
            optChar = sc.nextLine();
            try{
                Options option = Options.valueOf(optChar.toUpperCase());
                switch (option) {
                  case S: System.out.println("Čtverec");
                          float ctverecA = this.readNumber("Zadej stranu a");
                          System.out.printf("plocha ctverce o strane %.2f je %.3f", 
                                  ctverecA, this.getSquareArea(ctverecA));
                          System.out.println();
                          break;
                  case R: System.out.println("Obdélník");
                          float obdelnikA = this.readNumber("zadej stranu a");
                          float obdelnikB = this.readNumber("zadej stranu b");
                          System.out.printf("obsah obdelniku o stranach %.2f a %.2f je %.3f",obdelnikA,obdelnikB,this.getObdelnikArea(obdelnikA,obdelnikB));
                          break;
                  case T: System.out.println("Trojúhelník");
                          break;
                  case C: System.out.println("Kruh");
                          break;
              }
            }catch(Exception e){
                System.out.println("Chybna volba");
            }
        }while(!optChar.equalsIgnoreCase("X"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
