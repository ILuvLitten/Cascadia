import java.awt.*;
import javax.swing.*;

public class CascadiaWindow extends JFrame{
  private static final int WIDTH = 1200;
  private static final int HEIGHT = 480;

  public CascadiaWindow(String framename)
  {
    super(framename);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH,HEIGHT);
    add(new CascadiaMainPanel());
    setVisible(true);
  }
}