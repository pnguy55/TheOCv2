import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.JApplet;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.*;
import java.awt.Container;
import java.awt.event.*;
import java.net.URL;
import java.io.*;
import javax.imageio.ImageIO;

public class TheOCv2 extends JApplet {
    private static String text;
    private static JTextField textfield;
    private static JTextArea textarea;
    private static JButton restart;
    private final JScrollPane scrollpane;
    private final Images gameover, youwin;
    private final static String newline = "\n";
    private final static int width = 690;
    private final static int height = 730;
    static Game game;
    
    public TheOCv2(Container cont) {
        cont.setLayout(null);
        game = new Game();
        textfield = new JTextField();
        textarea = new JTextArea();
        restart = new JButton("RESTART");
        gameover = new Images("images\\gameover.png");
        youwin = new Images("images\\youwin.png");
        
        restart.setBackground(Color.BLACK);
        restart.setForeground(Color.WHITE);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.WHITE);
        textarea.setBackground(Color.BLACK);
        textarea.setForeground(Color.WHITE);
        textarea.setEditable(false);
        scrollpane = new JScrollPane(textarea);
        
        textfield.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (game.gamestatus == 0)
                    textEntered();
                if (game.gamestatus == 1)
                    youWin(cont);
                if (game.gamestatus == 2)
                    gameOver(cont);
            }
        });
        restart.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               reset(cont);
           } 
        });
        
        //Sizing the windows and components
        scrollpane.setBounds(20, 20, 640, 620);
        textfield.setBounds(20, 650, 530, 30);
        restart.setBounds(565, 650, 100, 30);
        
        cont.add(scrollpane);
        cont.add(textfield);
        cont.add(restart);
        title();
    }
    
    // Action for textfield
    public void textEntered() {
        text = textfield.getText();
        addTextArea(text);
        addTextArea(game.event(text));
    }
    
    /*
    -Text area manipulation methods
    */
    public static void clearTextArea() {
        textarea.setText("");
        textarea.setCaretPosition(textarea.getDocument().getLength());
    }
    
    public static void addTextArea(String status) {
        textarea.append(status + newline);
        textfield.selectAll();
        textarea.setCaretPosition(textarea.getDocument().getLength());
    }
    
    /*
    -Creates the Gui for the applet
    */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TheOCv2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TheOCv2(frame.getContentPane()));
        
	//Size and display window
	frame.setSize(width, height);
	frame.setVisible(true);
    }
    
    // Title text
    public void title() {
        addTextArea("\n                                                        The OC Chronicles!\n");
        addTextArea(game.welcomescreen.playIntro());
    }
    
    // Game Restart
    public void reset(Container cont) {
        clearTextArea();
        game = new Game();
        textfield.setVisible(true);
        scrollpane.setVisible(true);
        restart.setBounds(565, 650, 100, 30);
        cont.remove(youwin.label);
        cont.remove(gameover.label);
        title();
    }
    
    // Game over screen
    public void gameOver(Container cont) {
        System.out.println("Gameover!");
        textfield.setVisible(false);
        scrollpane.setVisible(false);
        restart.setBounds(width/2-65, (height/4)*3+15, 100, 30);
        gameover.label.setBounds(20, 20, 400, 400);
        gameover.label.setVisible(true);
        cont.add(gameover.label);
    }
    
    public void youWin(Container cont) {
        System.out.println("You win!");
        textfield.setVisible(false);
        scrollpane.setVisible(false);
        restart.setBounds(width/2-65, (height/4)*3+15, 100, 30);
        youwin.label.setBounds(20,20, 400, 400);
        youwin.label.setVisible(true);
        cont.add(youwin.label);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    } 
}
