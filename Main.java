/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NormalDistribution;

/**
 *
 * @author Toothless
 */
public class Main {
    static Front frontEnd; //Class Variable, to store instance of Front Class
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main mainClass = new Main(); // instantiating main class 
       
    }
    public Main(){
       frontEnd = new Front(); // Creating an instance of Front Class and storing it to frondEnd
       frontEnd.setVisible(true); //setting the intergface to true
    }
    
}
