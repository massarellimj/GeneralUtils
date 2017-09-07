package splash;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class SplashScreenMain {

  SplashScreen screen;

  @SuppressWarnings("unused")
public SplashScreenMain() {
    // initialize the splash screen
    splashScreenInit();
    // do something here to simulate the program doing something that
    // is time consuming
    for (int i = 0; i <= 100; i++)
    {
      for (long j=0; j<50000; ++j)
      {
        String poop = " " + (j + i);
      }
      // run either of these two -- not both
      screen.setProgress("Yo " + i, i);  // progress bar with a message
      //screen.setProgress(i);           // progress bar with no message
    }
    splashScreenDestruct();
    System.exit(0);
  }

  private void splashScreenDestruct() {
    screen.setScreenVisible(false);
  }

  private void splashScreenInit() {
    try {
	ImageIcon myImage = new ImageIcon(ImageIO.read(new File("M:\\personal\\prg\\java\\SplashScreenDemo\\splash.gif")));
	screen = new SplashScreen(myImage);
	    screen.setLocationRelativeTo(null);
	    screen.setProgressMax(100);
	    screen.setScreenVisible(true);
    } catch (IOException e) {
	e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    new SplashScreenMain();
  }

}
