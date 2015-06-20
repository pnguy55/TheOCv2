package theocv2;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Images {
    JLabel label;
    ImageIcon icon;
    
    public Images(String path) {
        this.icon = createImageIcon(path);
        this.label = new JLabel(this.icon);
    }
    
    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Images.class.getResource(path);
        if (imgURL != null) {
            System.out.println("Picture loaded.");
            return new ImageIcon(imgURL);
        }
        else {
            System.out.println("Could not find file path: "+path);
            return null;
        }
    }
    
}
