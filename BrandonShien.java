
import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; 
           // for DrawingTool

public class BrandonShien implements Polygon{
    private ArrayList <Point2D.Double> myPolygon = new ArrayList<>();

    private SketchPad myPaper;
    private DrawingTool myPencil;

    // constructors
    public BrandonShien() {
        SketchPad myPaper = new SketchPad(500,500);
        DrawingTool myPencil = new DrawingTool(myPaper);
        

    }
    
    
    public String getName(){
        return "Brandon Shien";
    }
    // public methods
    public void add(Point2D.Double aPoint) { 
        
        myPolygon.add(aPoint);

    }

    public void draw() {
        myPaper = new SketchPad(500,500);
        myPencil = new DrawingTool(myPaper);
          for(int i = 0; i < myPolygon.size(); i++)
        {
            myPencil.down();
            myPencil.move(myPolygon.get(i).getX(),myPolygon.get(i).getY());
            myPencil.up();
        }   
        myPencil.down();
            myPencil.move(myPolygon.get(0).getX(),myPolygon.get(0).getY());
            myPencil.up();
    }

    public double perimeter() {
        double perimeter = 0;
        for(int i=1; i< myPolygon.size() ; i++){

            perimeter = perimeter + myPolygon.get(i-1).distance(myPolygon.get(i));
        }
        perimeter += myPolygon.get(myPolygon.size()-1).distance(myPolygon.get(0));
        return perimeter;
    }

    public double area() {
        double value = 0;
        double other = 0;
        for(int i=0; i< myPolygon.size()-1 ; i++){
            value += myPolygon.get(i).getX() * myPolygon.get(i+1).getY();
            other -= myPolygon.get(i).getY() * myPolygon.get(i+1).getX();
            
        }
        value = value + myPolygon.get(myPolygon.size() -1).getX() * myPolygon.get(0).getY();
        other = other - myPolygon.get(myPolygon.size() -1).getY() * myPolygon.get(0).getX();
        return Math.abs(0.5*(value+other));
    }
}

