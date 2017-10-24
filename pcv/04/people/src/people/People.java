/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class People {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        human student = new human("Hugo", 18, human.Sex.MAN);
        student.setWeight(72); 

        human studentka = new human("Hilda", 17, human.Sex.WOMAN);
        studentka.setWeight(55); 
        studentka.setHeight(1.75f); 

        human sportovec = new Hockeyplayer("Jarda",20000);
        sportovec.setAge(45);
        sportovec.setHeight(189);
        sportovec.setWeight(102);
        ((Hockeyplayer) sportovec).setGoals(10);

        List<human> lide = new ArrayList<human>(); 
        lide.add(sportovec);
        lide.add(student);
        lide.add(studentka);
        
        for(human clovek : lide) {
            System.out.println(clovek.toString());
        }
    }
    
}
