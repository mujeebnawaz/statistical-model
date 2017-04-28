/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NormalDistribution;

//gets the important classes
import javax.swing.JTextField; 
import java.util.ArrayList;  
import javax.swing.JComboBox;


/**
 *
 * @author Toothless
 */
public class DataFilter {
    /* Creating an instance of ArrayList to store all the errors caused by user */
    private static ArrayList errorList = new ArrayList(); 
   

    public boolean isDouble(JTextField text) { //method defination, returns boolean, accept argument of type JTextField
        /*
            Method to check if a check field can be parsed and used as a Double data type.
        */
        if (!("").equals(text.getText())) { // checks if the JTextField is empty or not
            try { 
                Double.parseDouble(text.getText()); // tries to parse the JTextField
                return true;  // returns true if JTextField can be parsed as double
            } catch (Exception e) { //catching global exception
                return false;   // returns false if JTextField cannot be parsed as double
            }
        } else {
            return false; // returns false if JTextField is empty
        }
    }

    public boolean validateData(ArrayList dataObject) { //method defination, returns boolean, accept argument of type ArrayList
       
        /*
            Method takes an argument of type ArrayList, which contains all of the 
            input fields. Method then validates and verifies all the inputs collectively
            and then reports the user if anything is incorrect, before running the actual program.
        */
        //Unpacking user inputs dataObject and assigns values to new variables
        
        JTextField meanValue = (JTextField) dataObject.get(0);
        JTextField sdValue = (JTextField) dataObject.get(1);
        JTextField xValue1 = (JTextField) dataObject.get(2);
        JTextField xValue2 = (JTextField) dataObject.get(3);
        JTextField zTableStart = (JTextField) dataObject.get(4);
        JTextField zTableEnd = (JTextField) dataObject.get(5);
        JComboBox numericalMethod = (JComboBox) dataObject.get(6);
        JComboBox areaType = (JComboBox) dataObject.get(7);
        
        //Local variables to be used on runtime, to validate the inputs
        double sdParsed; 
        double meanParsed;
        double startPoint = 0;
        double endPoint = 0;
        if (!isDouble(meanValue)) {     //checks if Mean input is not a valid Decimal or Integer
            errorList.add("Wrong Mean Input. "); //adds an error message to errorList (ArrayList)
        } 
        if (!isDouble(sdValue)) {       //checks if Standard Deviation input is not a valid Decimal or Integer
            errorList.add("Wrong Standard Deviation Input"); //adds an error message to errorList (ArrayList)
        }
        else if (Double.parseDouble(sdValue.getText()) <= 0) { //checks if Standard Deviation is greater than zero
            errorList.add("Standard Deviation cannot be negative"); //adds an error message to errorList (ArrayList)
        } 
        else if (isDouble(meanValue) && isDouble(sdValue)) { //checks if Mean AND SD are decimals or integers
            //process a scale for the x axis i.e. start and end points of the graph to perform further validations
            sdParsed = Double.parseDouble(sdValue.getText()); 
            meanParsed = Double.parseDouble(meanValue.getText());
            double distance = (4 * sdParsed); //calculates the magnitude of the scale for four standard deviations
            endPoint = distance + meanParsed; //calculates end point by adding calculated magnitude to mean.
            startPoint = meanParsed - (4 * sdParsed); //calculates startpoint by subtracting the magnitude from mean
        }       
        if(numericalMethod.getSelectedIndex() == 0){ //checks if user has not selected any numerical method
            errorList.add("Please select a numerical method"); //adds an error message to errorList
        }
        if(!isDouble(zTableStart)){ //checks if user has inputted a non-decimal value for starting point of Z-Table
            errorList.add("Incorrect start point for z"); //adds an error message to errorList
        }
        else if (!isDouble(zTableEnd)){ //checks if user has inputted a non-decimal value for ending point of Z-Table
            errorList.add("Incorrect end point for z"); //adds an error message to errorList
        }
        else if(zTableStart.getText() == "" || zTableEnd.getText() == ""){ //checks if the start or end point for the Z-Table is empty
            errorList.add("Z-Table start or end cannot be empty"); //adds an error message to errorList
        }
        else if(Double.parseDouble(zTableEnd.getText()) <= Double.parseDouble(zTableStart.getText()) ){ // checks if end point for z table is lesser than or equals to start point
            errorList.add("Invalid range for Standard normal distribution table \nStart cannot be greater than end");
        }
        //checks if z table range lies between -3.99 to 3.99
        else if(Double.parseDouble(zTableStart.getText()) < (-3.99) || Double.parseDouble(zTableStart.getText()) > (3.99)){ 
            errorList.add("Standard normal distribution start cannot be lesser than -3.99 or greater than 3.99");
        }
        else if(Double.parseDouble(zTableEnd.getText()) < (-3.99) || Double.parseDouble(zTableEnd.getText()) > (3.99)){ 
            errorList.add("Standard normal distribution end cannot be lesser than -3.99 or greater than 3.99");
        }
        switch(areaType.getSelectedIndex()){ //gets the selected area type by users and performs multiple checks on it
            case 0: // checks if user has selected nothing
                errorList.add("Please Select an area type");
                break;
            case 1: // checks if user has selected the first option
                if(!isDouble(xValue1)){ //checks if the inputted x value is decimal
                    errorList.add("Please input a correct value for X1");
                }
                //checks if the x value does not lie within the bell curve
                else if(!(Double.parseDouble(xValue1.getText()) <= endPoint) || !(Double.parseDouble(xValue1.getText()) >= startPoint)){
                    errorList.add("Please insert a value \nbetween "+startPoint+" - "+endPoint+" for X1");
                }
                break;
            case 2: //checks if the user has selected the second option
                if(!isDouble(xValue1)){ // checks if the inputted x values is decimal
                    errorList.add("Please input value for X1");
                }
                  //checks if the x value does not lie within the bell curve
                else if(!(Double.parseDouble(xValue1.getText()) <= endPoint) || !(Double.parseDouble(xValue1.getText()) >= startPoint)){
                    errorList.add("Please insert a value \nbetween "+startPoint+" - "+endPoint+" for X1");
                }
                break;
            case 3: //checks if the user has selected the third option 
                if(!isDouble(xValue1) || !isDouble(xValue2)){ // checks if first and second x values are not decimals
                    errorList.add("Please input a Value for X1 AND X2");
                }
                //checks if the first and last value of x does not lie within the bell curve
                else if(!(Double.parseDouble(xValue1.getText()) <= endPoint) || !(Double.parseDouble(xValue1.getText()) >= startPoint)){
                     if(!(Double.parseDouble(xValue2.getText()) <= endPoint) || !(Double.parseDouble(xValue2.getText()) >= startPoint)){
                        errorList.add("Please insert a value \nbetween "+startPoint+" - "+endPoint+" for X1 and X2");
                    }
                }
                //checks if the the first x value is greater than second x value
                else if((Double.parseDouble(xValue1.getText())) > (Double.parseDouble(xValue2.getText()))){
                    errorList.add("X1 cannot be greater than X2");
                }
                break;
            case 4: //checks if the user has selected the fourh option
                if(!isDouble(xValue1) || !isDouble(xValue2)){ // checks if first and second x values are not decimals
                    errorList.add("Please input a Value for X1 AND X2");
                }
                //checks if the first and last value of x does not lie within the bell curve
                else if(!(Double.parseDouble(xValue1.getText()) <= endPoint) || !(Double.parseDouble(xValue1.getText()) >= startPoint)){
                     if(!(Double.parseDouble(xValue2.getText()) <= endPoint) || !(Double.parseDouble(xValue2.getText()) >= startPoint)){
                        errorList.add("Please insert a value \nbetween "+startPoint+" - "+endPoint+" for X1 and X2");
                    }
                }
                  //checks if the the first x value is greater than second x value
                else if((Double.parseDouble(xValue1.getText())) > (Double.parseDouble(xValue2.getText()))){
                    errorList.add("X1 cannot be greater than X2");
                }
                break;
        }
        return errorList.isEmpty();        //returns true or false depending on the errorList
    }
    
    public ArrayList getErrors(){ //getter method for errorList, returns an ArrayList
        return errorList;
    }
    public void emptyErrors(){ //reset method for errorList, removes all elements from errorList
        errorList.removeAll(errorList);
    }
    
}

