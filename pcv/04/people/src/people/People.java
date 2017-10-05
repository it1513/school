/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author student
 */
public class People {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        human student = new human("Hugo",18,human.Sex.MAN);
        human studentka = new human("Hilda",17,human.Sex.WOMAN) ;
        
        
        student.setHeight((float) 1.75);
        studentka.setHeight(1.60f);
        
        student.setWeight(78);
        studentka.setWeight(70);
        
        System.out.println(student.toString());
        System.out.println(studentka.toString());
        
    }
    
}
