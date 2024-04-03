import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;

public class CascadiaMainPanel extends JPanel implements MouseMotionListener, MouseListener{
  private int currentScreen = 0;
  public CascadiaMainPanel(){
    addMouseMotionListener(this); 
    addMouseListener(this);
  }

  public void paint(Graphics g){
    g.drawLine(23,23,89,89);

  }
  public void mouseDragged(MouseEvent e) {  
    Graphics g=getGraphics();  
    g.setColor(Color.BLUE);  
    g.fillOval(e.getX(),e.getY(),20,20);  
  }  
  public void mouseMoved(MouseEvent e) {} 
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mouseClicked(MouseEvent e) {}

  
}