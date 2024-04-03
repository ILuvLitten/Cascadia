import javax.swing.*;
import java.awt.*;

public class Button{
  private int height;
  private int width;
  private Polygon polygon;
  private Color color = Color.BLUE;
  private Color hoverColor = Color.GREEN;
  private Color disabledColor = Color.RED;
  private String text = "";
  private Color textColor = Color.WHITE;
  private int xPos;
  private int yPos;
  private boolean hover = false;
  private boolean disabled = false;
  private boolean hidden = false;

  //Rectangular Button
  public Button(int x, int y, int w, int h){

    xPos = x;
    yPos = y;
    width = w;
    height = h;

    int[] xPoints = new int[4];
    xPoints[0] = x;
    xPoints[1] = x+w;
    xPoints[2] = x;
    xPoints[3] = x+w;

    int[] yPoints = new int[4];
    yPoints[0] = y;
    yPoints[1] = y;
    yPoints[2] = y+h;
    yPoints[3] = y+h;

    polygon = new Polygon(xPoints,yPoints,4);
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

      g.fillPolygon(polygon);

      g.setColor(textColor);
      g.drawString(text, xPos+(width/2),yPos+(height/2));
    }
    
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
}