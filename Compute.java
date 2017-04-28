/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NormalDistribution;

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Toothless
 */
public class Compute {
    //private class variables, used for distinct calculations
    private static double meanInput; //stores mean input
    private static double standardDeviation; //stores standard deviation
    private static double x1; //stores x1 value
    private static double x2; //stores x2 value
    private static int numericalMethod; //stores numerical method selected by user
    private static int areaType; //stores area type selected by user
    private static double startPoint; //stores start point of the graph
    private static double endPoint; //stores end point of the graph 
    private static double zTableStart; //stores start point of Z Table 
    private static double zTableEnd; //stores end point of Z Table 
    final private double numberOfStrips = 15.00; //number of strips for calculating area
    private static double areaUnderTheCurve; //area under the curve
    
    public static String[][] generatedRows; //creates two dimensional array for storing row values of z table
    public static String[] colHeaderArray; //creates an array for table header
    public Compute(){ //class constructor
        calculateScale(); //calculates the start and end point
        getArea(); //calculates area based on user inputs
    }
    public static void getGraph(double mean,double sD){ //method for generating graph
        //instantiates graph generator class, while passing mean, sd, area type and values of x
        final GraphGenerator graph = new GraphGenerator("Normal Distribution Graph",mean,sD,areaType,x1,x2);
        graph.pack();     //set sizes 
    } 
    public void getTable(){ //method for calculating table rows and columns, and returning 
       setSd(1); //sets standard deviation to 1
       setMean(0); //sets mean to 0
       DecimalFormat deci = new DecimalFormat("#0.00"); //create an instance of DecimalFormat for formating the decimals
       ArrayList columnHeader = new ArrayList(); //creates an ArrayList for column header
       ArrayList rowHeader = new ArrayList(); //creates an ArrayList for row header
       double zStart =  Math.round(zTableStart * 100.0) / 100.0;  //
       double zEnd = Math.round(zTableEnd * 100.0) / 100.0;
       double startLast = (zStart*100)%10;
       double endLast = (zEnd*100)%10;
       int zStartMid = (int) (zStart*10)%10;
       int zEndMid = (int) (zEnd*10)%10;
       double maxCol;
       if((zStartMid == zEndMid) && ((int) zStart == (int) zEnd)){
            if(startLast > endLast){
                maxCol = (startLast/100);
             }
            else{
                maxCol = (endLast/100);
            }
       }
       else{
           maxCol = 0.09;
       }
       double loopCount = 0.00;
       columnHeader.add("");
       while(loopCount <= (maxCol)){
           columnHeader.add(deci.format(loopCount));
           loopCount += 0.01;
       } 
       while(zStart <= (zEnd+0.1) ){
           rowHeader.add(new DecimalFormat("#0.0").format(zStart));
           zStart += 0.1;
       }
       colHeaderArray = new String[columnHeader.size()];
       for(int colLoop = 0;colLoop < columnHeader.size(); colLoop++){
           colHeaderArray[colLoop] = columnHeader.get(colLoop).toString();
       }
       generatedRows = new String[rowHeader.size()][columnHeader.size()];
      
       for(int rowLoopOuter=0;rowLoopOuter<rowHeader.size();rowLoopOuter++){
           boolean innerFirst = true;
           for(int rowLoopInner = 0; rowLoopInner<columnHeader.size();rowLoopInner++){
               if(innerFirst){
                   generatedRows[rowLoopOuter][rowLoopInner] = rowHeader.get(rowLoopOuter).toString();
                   innerFirst = false;
                   continue;
               }
            double rowCol = (Double.parseDouble(rowHeader.get(rowLoopOuter).toString()))+(Double.parseDouble(columnHeader.get(rowLoopInner).toString()));
            double area;
                if(numericalMethod == 1){
                    area = getTrapezoidalArea(-3.9,Math.round(rowCol*100.0)/100.0);
                }
                else{
                    area = getRectengularArea(-3.9,Math.round(rowCol*100.0)/100.0);
                }
                generatedRows[rowLoopOuter][rowLoopInner] = String.valueOf(Math.round(area*10000.0000)/10000.0000); 
            }
        }
    }
    
    public void getArea(){
        double shadedRegion = 0.00; //initiates a variable for storing the area under the curve based on the user given values
        switch(areaType){ //switch area type selected by user
            //passes the limits to the function based on user selections
            case 1:
                if(numericalMethod == 1){ 
                    shadedRegion = getTrapezoidalArea(x1,endPoint);
                }
                else{
                    shadedRegion = getRectengularArea(x1,endPoint);
                }
                break;
            case 2:
                if(numericalMethod == 1){
                    shadedRegion = getTrapezoidalArea(startPoint,x1);
                }
                else{
                    shadedRegion = getRectengularArea(startPoint,x1);
                }
                break;
            case 3:
                if(numericalMethod == 1){
                   shadedRegion = getTrapezoidalArea(x1,x2);
                }
                else{
                   shadedRegion = getRectengularArea(x1,x2);
                }
                break;
            case 4:
                if(numericalMethod == 1){
                   shadedRegion = getTrapezoidalArea(startPoint,x1)+getTrapezoidalArea(x2,endPoint);
                }
                else{
                   shadedRegion = getRectengularArea(startPoint,x1)+getRectengularArea(x2,endPoint);
                }
                break;
        }
        areaUnderTheCurve = shadedRegion;
    }
    public double getTrapezoidalArea(double limitA,double limitB){    
        double delX = (limitB - limitA)/numberOfStrips;  //calculates delta x
        double halfDelX = delX/2;  //divides delta x by two (according to numerical method)
        double xi = limitA; //assigns limit a to xi 
        double resultSum = 0.00;  //initiates a variable for storing the result of sum
        double xZero = 0.00; //initiates a variable for first value of f(x)
        double xN = 0.00; //initiates a variable for the last value of f(x)
        ArrayList yValues = new ArrayList(); //creates an ArrayList for y values
        boolean firstIteration = true; //sets a boolean flag variable for first iteration of the loop
        for(int strips = 0;strips <= numberOfStrips;strips++){  //for loop, iterates number of strips times
            if(firstIteration == true){ //checks for the first iteration
                xZero = probabilityDensity(xi); //assigns the first f(x) to xZero
                firstIteration = false; //sets first iteration to false
                continue; //continues to second iteration of the loop
            }
            xi = xi+delX; //increments xi (limit A) by delX 
            if(strips == numberOfStrips){ //checks if the last iteration of loop
                xN = probabilityDensity(xi); //assigns the last f(x) to xN
                continue; //continues to the next iteration of the loop, (exits the loop)
            }
            yValues.add(probabilityDensity(xi)); //if not first or last iteration of loop, adds f(x) to the array list
            resultSum = resultSum + Double.parseDouble(yValues.get(strips-1).toString()); //adds all the middle values together
        }
        double areaUnderCurve = halfDelX*(xZero+(2*resultSum)+xN); //calculates final area under the curve
        return areaUnderCurve; //returns area under the curve
    }
    public double getRectengularArea(double limitA,double limitB){ 
        //calculates area using rectengular numerical method, takes in limit a and limit b
        double delX = (limitB - limitA)/numberOfStrips;  //calculates delta x 
        double xi = limitA; //sets a new variable and assign limit A to it 
        double xiHalf = 0.00; //sets a new variable for processing the area
        double functionResult = 0.00; //sets a new variable for storing probability density function results
        double areaUnderCurve = 0.00; //sets a new variable for storing area under the curve
        boolean firstIteration = true; //boolean variable to check for the first iteration of the loop 
        ArrayList xiValues = new ArrayList(); //ArrayList to store y values
        for(int strips = 0; strips <= numberOfStrips; strips++){
            if(firstIteration){
                xiValues.add(xi); //adds the first incremented value to the arraylist
                firstIteration = false; //sets first iteration variable to false after first iteration
                continue; //continues the loop to second iteration
            }
            xi = xi + delX; //increments the value or xi(limit A) by delta x
            xiValues.add(xi); //adds the incremented value to the arraylist
            xiHalf = (Double.parseDouble(xiValues.get(strips-1).toString())+Double.parseDouble(xiValues.get((strips)).toString()))/2;//adds first and previous x values and divides x values by 2 
            functionResult = functionResult + probabilityDensity(xiHalf); //adds and assign probablity density of f(x) at each iteration
        }
        areaUnderCurve = functionResult*delX; //add probablity density and delta x
        return areaUnderCurve; //returns area under the curve
    }
    
    public double probabilityDensity(double xFunctionValue){ //probability density function, takes in x as an argument, returns double
       double fNumerator = 1;  //function numerator
       double fDenominator = standardDeviation*(Math.sqrt((2*Math.PI))); //Function Denominator
       double fPowerNumerator = Math.pow((xFunctionValue-meanInput), 2); //function index numerator
       double fPowerDenominator = 2*(Math.pow(standardDeviation,2)); //function index denominator
       double functionIndex = -(fPowerNumerator/fPowerDenominator); //function index
       double functionResult = (fNumerator/fDenominator)*Math.exp(functionIndex); //whole function
       return functionResult; //returns the function result
    }
    public static void calculateScale(){ //static method for calculating graph start and end point
        double distance = (4*standardDeviation); //calculates magnitude for 4 standard deviations.
        endPoint = distance+meanInput; //Last point of x axis, adds magnitude to mean
        startPoint = meanInput-distance; //first point of x axis, subtracts magnitude from mean 
    }
    
    /*
        Getters And Setters methods for all class private variables
    */
    public static double getStartPoint(){
        return startPoint; // returns start point of the scale of the graph
    }
    public static double getEndPoint(){
        return endPoint; //returns end point of the scale of the graph
    }
    public static void setMean(double mean){
        meanInput = mean; //sets mean 
    }   
    public static void setSd(double sD){
        standardDeviation = sD; //sets the standard deviation
    }
    public static void setX1(double value){
        x1 = value; // sets the value of x1
    }
    public static void setX2(double value){
        x2 = value; //sets the value of x2
    }
    public static void setAreaType(int areaT){
        areaType = areaT; //sets area type given by user
    }
    public static void setNumericalMethod(int numericalM){
        numericalMethod = numericalM; //sets the integration numerical method 
    }
    public static void setZStart(double start){
        zTableStart = start; //sets the start value of z score table
    }
    public static void setZEnd(double end){
        zTableEnd = end; // sets the end value of z score table
    }
    public double getMean(){
        return meanInput; //returns mean value given by user
    }
    public double getSd(){
        return standardDeviation; //returns standard deviation value given by user
    } 
    public double getSelectedArea(){
        return areaUnderTheCurve; //returns calculated area
    }
}
