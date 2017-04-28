package NormalDistribution;

import java.awt.Color;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraphGenerator extends ApplicationFrame {
    //constructor, takes mean, standard deviation area type and values of x1 and x2 to process visuals of graph
    public GraphGenerator(final String title,double mean, double sD,int areaType,double x1,double x2) {   
        super(title); 
        double startPoint = Compute.getStartPoint(); //gets the calculated start point from Compute class
        double endPoint = Compute.getEndPoint();  //gets the calculated end point form Compute class
        //JFree chart normal distribution function to get the bell curve
        Function2D normalDistribution = new NormalDistributionFunction2D(mean,sD); 
        //JFree chart object for creating a dataset
        //instantiating two datasets because of distinct area cases
        XYDataset dataset = DatasetUtilities.sampleFunction2D(normalDistribution, startPoint, endPoint, 100, "P(x)");
        XYDataset datasetTwo = DatasetUtilities.sampleFunction2D(normalDistribution, startPoint, endPoint, 100, "P(x)");
         switch(areaType){ //switch the user selected area type
            /*
                Area types are divided in 4 categories and range or value of freeChart given by user
                has frontEnd corelation with area type and will be tested accordingly.
                1 - >= X1
                2 - <= X1
                3 - >= X1 AND <= X2
                4 - <= X1 AND >= X2
            */
            case 1: //if user has selected the first area type
                datasetTwo = null; //setting datasetTwo to null because it has no use
                XYSeries caseOne = new XYSeries("Area"); //creates an object of type XYSeries for selecting the area
                caseOne.add(x1, 0); //adds the user given point on x axis and sets 0 for y axis
                caseOne.add(endPoint, 0); //adds the endPoint of the graph as the other coordinate for x axis
                ((XYSeriesCollection) dataset).addSeries(caseOne); //adds created series to the dataset
                break; //breaks out of the switch case statements
            case 2: //if user has selected the second area type
                datasetTwo = null; //setting datasetTwo to null because it has no use
                XYSeries caseTwo = new XYSeries("Area"); //creates an object of type XYSeries for selecting the area
                caseTwo.add(startPoint, 0); //adds the first point of area range to start point of the graph
                caseTwo.add(x1, 0); // add the last point of the area range to user given value of x
                ((XYSeriesCollection) dataset).addSeries(caseTwo); //adds created series to the dataset
                break; // breaks out the switch case statements
            case 3: //if user has selected the third area type
                datasetTwo = null; //setting datasetTwo to null because it has no use
                XYSeries caseThree = new XYSeries("Area"); //creates an object of type XYSeries for selecting the area
                caseThree.add(x1, 0); //adds the first point of area range to the first x value given by the user
                caseThree.add(x2, 0); //adds the second point of area range to the secong x value given by the user
                ((XYSeriesCollection) dataset).addSeries(caseThree); // adds the XYSeries to the dataset
                break; //breaks out of the switch case statements 
            case 4: //if user selects the fourth area type
                XYSeries caseFour = new XYSeries("Area"); // creates first XYSeries object for the first dataset
                caseFour.add(startPoint, 0); // sets the first point to the startPoint of the graph
                caseFour.add(x1, 0); // sets the second point to the given value of first x
                ((XYSeriesCollection) dataset).addSeries(caseFour); // adds the series to the first dataset
                XYSeries caseFourN = new XYSeries("Area"); //creates second XYSeries object for the second dataset
                caseFourN.add(x2, 0); //sets the first point of area range to the second x value
                caseFourN.add(endPoint, 0); //sets the second point of area range to the end point of the graph
                ((XYSeriesCollection) datasetTwo).addSeries(caseFourN); //adds the second XYSeries two the second dataset
                break; //breaks out of the loop
        }
        XYDifferenceRenderer rendererObj = new XYDifferenceRenderer(); //creates an object for XYDifferenceRenderer, to render the graph
        rendererObj.setSeriesPaint(1, Color.green); //Defines the color for series
        NumberAxis xAxis = new NumberAxis(null); //instantiates the number axis for x axis (to get a scale)
        NumberAxis yAxis = new NumberAxis(null);    //instantiates the number axis for y axis (to get a scale)
        xAxis.setRange(startPoint,endPoint); //sets the range of the x axis scale determined by the compute class
        xAxis.setLabel("X Values");
        yAxis.setLabel("P(x)");
        XYPlot chart ;  // creates a variable of type XYPlot
        if(datasetTwo != null){ //checks if the dataset two is not null, so that it can render two datasets
            chart = new XYPlot(dataset,xAxis,yAxis,rendererObj);
            chart.setDataset(1, datasetTwo); 
        }
        else{ // if dataset two is null it renders just one default dataset
            chart = new XYPlot(dataset,xAxis,yAxis,rendererObj);
        }
        JFreeChart freeChart = new JFreeChart(chart);    //creates an object of type JFreeChart
        final ChartPanel chartPanel = new ChartPanel(freeChart); // creates an object of chartpanel (JPanel)
        setContentPane(chartPanel);     //sets chartpanel on an opaque JComponent
        chartPanel.setVisible(true);    //sets JPanel based chartPanel to visible
        Front fE = Main.frontEnd;       //gets the Front class object from Main class and assigns it to fE
        fE.pasteGraph(chartPanel);      //calls a method from Front class, while passing in chartpanel
    }
    public static void main(final String[] args,double mean,double sD) {
    }
}


           