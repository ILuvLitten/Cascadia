import javax.swing.*;
import java.awt.*;


public class Button{
    private int height;
    private int width;
    private Polygon polygon;
    private int[] polygonXPoints;
    private int[] polygonYPoints;
    private int polygonPoints;
    private Color color = Color.BLUE;
    private Color hoverColor = Color.GREEN;
    private Color disabledColor = Color.RED;
    private Color selectedColor = Color.CYAN;
    private String text = "";
    private Color textColor = Color.WHITE;
    private int xPos;
    private int yPos;
    private boolean hover = false;
    private boolean disabled = false;
    private boolean hidden = false;
    private boolean selected = false;
    private int r = 0;


    //Rectangular Button
    public Button(int x, int y, int w, int h){


        xPos = x;
        yPos = y;
        width = w;
        height = h;


        int[] xPoints = new int[4];
        xPoints[0] = x;
        xPoints[1] = x+w;
        xPoints[2] = x+w;
        xPoints[3] = x;


        int[] yPoints = new int[4];
        yPoints[0] = y;
        yPoints[1] = y;
        yPoints[2] = y+h;
        yPoints[3] = y+h;


        polygon = new Polygon(xPoints,yPoints,4);
        polygonXPoints = xPoints;
        polygonYPoints = yPoints;
        polygonPoints = 4;
    }


    //Hexagonal Button
    public Button(int x, int y, int d){
        int radius = d/2;
        r = radius;
        xPos = x;
        yPos = y;
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];


        int h = (int) ((radius/2) * Math.sqrt(3));
        height = d;
        width = h*2;


        xPoints[0] = x;
        xPoints[1] = x+h;
        xPoints[2] = x+h;
        xPoints[3] = x;
        xPoints[4] = x-h;
        xPoints[5] = x-h;
        for(int i = 0; i < 6; i++) {
            xPoints[i]=xPoints[i]+h;
        }


        yPoints[0] = y + radius;
        yPoints[1] = y + radius/2;
        yPoints[2] = y - radius/2;
        yPoints[3] = y - radius;
        yPoints[4] = y - radius/2;
        yPoints[5] = y + radius/2;
        for(int i = 0; i < 6; i++) {
            yPoints[i]=yPoints[i]+radius;
        }



        polygon = new Polygon(xPoints, yPoints, 6);
        polygonXPoints = xPoints;
        polygonYPoints = yPoints;
        polygonPoints = 6;
    }






    public void paint(Graphics g){
        if(!hidden){
            g.setColor(color);
            if(hover){
                g.setColor(hoverColor);
            }
            if(disabled){
                g.setColor(disabledColor);
            }
            if(selected){
                g.setColor(selectedColor);
            }


            g.fillPolygon(polygon);


            g.setColor(textColor);
            g.drawString(text, xPos+(width/2),yPos+(height/2));
            //g.setColor(Color.BLACK);
            //g.drawString("0,0", xPos,yPos);
        }

    }

    public int[] scale(int[] points, int newMax) {
        int[] newPoints = new int[points.length];
        int start = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++) {
            if(points[i] < start) {
                start = points[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < points.length; i++) {
            points[i] = points[i] - start;
            if(points[i] > max) {
                max = points[i];
            }
        }
        for(int i = 0; i < points.length; i++) {
            double v = ((double)points[i])/max;
            newPoints[i] = (int) (v*newMax+start);
            System.out.println(points[i]+","+newPoints[i]);
        }


        return newPoints;
    }

    public void updatePolygon() {
        polygon = new Polygon(polygonXPoints, polygonYPoints, polygonPoints);
        for(int i:polygonXPoints) {System.out.print(i+",");}
        System.out.println();
        for(int i:polygonYPoints) {System.out.print(i+",");}
        System.out.println();


    }

    public void setWidth(int w) {
        polygonXPoints = scale(polygonXPoints, w);
        width = w;
        updatePolygon();
    }

    public int getWidth() {return width;}

    public void setHeight(int h) {
        polygonYPoints = scale(polygonYPoints, h);
        height = h;
        updatePolygon();
    }

    public int getHeight() {return height;}

    public void setText(String txt) {text = txt;}
    public void setHidden(boolean h) {hidden = h;}
    public boolean getHidden() {return hidden;}
    public boolean getHover() {return hover;}
    public void setDisabled(boolean d) {disabled = d;}
    public boolean getDisabled() {return disabled;}
    public void setSelected(boolean s) {selected = s;}
    public boolean getSelected() {return selected;}
    public int getXPos() {return xPos;}
    public int getYPos() {return yPos;}

    public void update(int w, int h) {
        setWidth(w);
        setHeight(h);
        updatePolygon();
    }



    public boolean mouseMoved(int clickX, int clickY){
        if(polygon.contains(clickX,clickY)){
            hover = true;
            return true;
        }else{
            hover = false;
            return false;
        }
    }

    public int mouseClicked(int clickX, int clickY) {
        if(polygon.contains(clickX,clickY)){
            if(disabled) {return 0;}
            return 1;
        }else{
            return -1;
        }
    }
}