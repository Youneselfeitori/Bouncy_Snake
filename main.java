/*
/Created by: Younes Elfeitori and Peter Zhu
/ICS4u final project
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class main extends JPanel implements ActionListener {

    //Constants
    public static final int SCALE = 50;
    public static final int WIDTH = 30;
    public static final int HEIGHT = 20;
    public static final int SPEED = 10;
    public static String NAME = "Bouncy Snake";

    //Objects
    Apple a = new Apple((int) (Math.random()*WIDTH),(int) (Math.random()*HEIGHT));
    Snake s = new Snake(10, 10, 9, 10);
    Timer t = new Timer(1000/SPEED, this);

    //Start
    public main(){
        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    //Graphic
    public void paint(Graphics g){
        //Background color
        g.setColor(color(192, 192, 192));
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
        //Comment next line to remove the grid
       g.setColor(color(255, 216, 0));

        for(int xx = 0; xx <= WIDTH*SCALE; xx+=SCALE){
            g.drawLine(xx, 0, xx, HEIGHT*SCALE);
        }
        for(int yy = 0; yy <= HEIGHT*SCALE; yy+=SCALE){
            g.drawLine(0, yy, WIDTH*SCALE, yy);
        }

        //Snake color
        for(int d = 0; d < s.length; d++){
            g.setColor(color(65, 168, 21));
            g.fillRect(s.snakeX[d]*SCALE+1, s.snakeY[d]*SCALE+1, SCALE-1, SCALE-1);
        }

        //Apple color
        g.setColor(color(255, 0, 0));
        g.fillRect(a.posX*SCALE+1, a.posY*SCALE+1, SCALE-1, SCALE-1);
    }
    public Color color(int red,int green,int blue){
        return new Color (red, green, blue);
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setTitle(NAME);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH*SCALE+7, HEIGHT*SCALE+30);
        f.setLocationRelativeTo(null);
        f.add(new main());
        f.setVisible(true);
    }
    //Eating of apple
    public void actionPerformed(ActionEvent arg0){
        s.move();
        if((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)){
            a.setRandomPosition();
            s.length++;
        }
        for(int k = 1; k < s.length; k++){
            if((s.snakeX[k] == a.posX) & (s.snakeY[k] == a.posY)){
                a.setRandomPosition();
            }
        }

        repaint();
    }
    //Controls (Keyboard arrows)
    private class Keyboard extends KeyAdapter{
        public void keyPressed(KeyEvent kEvt) {
            int key = kEvt.getKeyCode();
            if((key == KeyEvent.VK_RIGHT) & s.position != 2) s.position = 0;
            if((key == KeyEvent.VK_DOWN) & s.position != 3) s.position = 1;
            if((key == KeyEvent.VK_LEFT) & s.position != 0) s.position = 2;
            if((key == KeyEvent.VK_UP) & s.position != 1) s.position = 3;
        }
    }
}
