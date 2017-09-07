/**
 * 
 */
package util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import io.FileUtils;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class IconUtils {
    public static final String TAG = "IconUtils";
    
    private static final String ICON_DIR = "M:/personal/prg/java/GeneralUtils/res/icons/";
    private static final String SUFFIX = ".png";
    
    public static Icon getIconForFile(File file) throws IOException {
	File iconFile = new File(ICON_DIR + FileUtils.getExtension(file) + SUFFIX);
	return new ImageIcon(ImageIO.read(iconFile).getScaledInstance(30, 30, 0));
    }
    
    enum FileType {
	PDF("pdf"),
	TXT("txt"),
	XLSX("xlsx"),
	PNG("png"),
	JPEG("jpeg"),
	JPG("jpeg"),
	TIFF("tiff"),
	BMP("bmp"),
	DXF("dxf"),
	DWG("dwg");
	
	private transient String filename;
	
	FileType(String filename) {
	    this.filename = filename;
	}
	
	@Override
	public String toString() {
	    return filename;
	}
    }
    
    public static void main(String[] args) {
	JFrame f = new JFrame();
	f.setSize(200, 200);
	f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	try {
	    f.getContentPane().add(new JLabel(getIconForFile(new File("M:/ref.txt"))), "Center");
	} catch (IOException e) {
	    e.printStackTrace();
	}
	f.setVisible(true);
    }
}
