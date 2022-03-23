import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;

import javax.swing.JComponent;

public class StickFigure extends JComponent{

    int x, y, initialX, size;
    boolean noseB = true, eyesB = true , armsB = true, backboneB = true, headB = true;

    public StickFigure(int baseX, int baseY) {
        x = baseX;
        y = baseY;
        initialX = x;
        this.setSize(8);
        this.setPreferredSize(new Dimension(1000, 750));
    } 

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (armsB){
            g.drawLine(x-15*size, y-45*size, x+15*size, y-45*size);
        } 
        if (headB){
            g.drawOval(x-10*size, y-75*size, 20*size, 20*size); 
        }

        if (eyesB) {
            g.drawOval(x-6*size, y-70*size, 4*size, 4*size); // left eye
            g.drawOval(x+2*size, y-70*size, 4*size, 4*size); // right eye
        }
            
        if (noseB) {
            g.drawLine(x-2*size, y-64*size, x+2*size, y-64*size); //nose
            g.drawLine(x-2*size, y-64*size, x, y-61*size);
            g.drawLine(x+2*size, y-64*size, x, y-61*size);
        }
        g.drawLine(x-4*size, y-60*size, x, y-57*size); // mouth
        g.drawLine(x, y-57*size, x+4*size, y-60*size);
        if (backboneB) {
            g.drawLine(x, y-55*size, x, y-20*size); // body
        }
        g.drawLine(x, y-20*size, x-15*size, y); // left leg
        g.drawLine(x, y-20*size, x+15*size, y); // right leg
    }

    public void setNoseB(boolean noseB) {
        this.noseB = noseB;
    }
    public void setArmsB(boolean armsB) {
        this.armsB = armsB;
    }
    public void setEyesB(boolean eyesB) {
        this.eyesB = eyesB;
    }
    public void setBackboneB(boolean backboneB) {
        this.backboneB = backboneB;
    }
    public void setHeadB(boolean headB) {
        this.headB = headB;
    }

    public void setSize(int i) {
        this.size = i;
        repaint();
    }

    public void colorPicker(Color a) {
        this.setForeground(a);
        repaint();
    }

    public void moveLeft() {
        if (x < 0 ){
            x = 999; repaint(); return;
        }
        x -= 1;
        repaint();
    }
    public void moveRight() {
        if (x > 1000){
            x = 1; repaint(); return;
        }   
        x += 1;
        repaint();
    }


    
}
