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

/*trida human*/
public class human {
    /*vlastni vypoctovy typ */
    public enum Sex{
        MAN,WOMAN
    }

    private String name;
    private int age = 20;
    private int weight = 70;
    private float height = (float) 1.80;
    private Sex sex = Sex.MAN;
    
    /*metody tridy human*/
    
    /*konstruktor tridy human*/
    public human(String jmeno){
        this.name = jmeno;
    }
    
    public human(String jmeno, int age, Sex sex){
        this.name = jmeno;
        this.setAge(age);
        this.setSex(sex);
    }    
    
    /* getters a setters*/
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int age){
       if(age > 0 && age < 130){
            this.age = age;
       } 
        
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public void setWeight(int weight){   
            this.weight = weight; 
        
    }
    
    public float getHeight(){
        return this.height;
    }
    
    public void setHeight(float height){   
            this.height = height; 
        
    }
    
    public Sex getSex(){
        return sex;
    }
    
    public void setSex(Sex sex){   
            this.sex = sex; 
        
    }
    
    public double getBMI(){
        return Math.round(this.weight/Math.pow(this.height,2)*100.0)/100.0;
    }
    
    public String toString(){
        String output = "My name is " + this.name +"\n";
        output += "i am "+ this.getSex() + "\n";
        output += "age: "+ this.getAge() + "\n";
        output += "height: " + this.getHeight() + "m\n";
        output += "weight: " + this.getWeight() + "\n";
        output += "BMI: "+ this.getBMI()+"\n";
        
        
        return output ;
    }
}
