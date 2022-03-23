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
            // if (armsB){
            // // g.drawLine(300, 175, 450, 175); // arms
            // g.drawLine(x-75, y-225, x+75, y-225);
            // } 
            // if (headB){
            //     // g.drawOval(325, 25, 100, 100); // head
            // g.drawOval(x-50, y-375, 100, 100); 
            // }

            // if (eyesB) {
            // // g.drawOval(345, 50, 20, 20); // left eye
            // g.drawOval(x-30, y-350, 20, 20); // left eye
            // // g.drawOval(385, 50, 20, 20); // right eye
            // g.drawOval(x+10, y-350, 20, 20); // right eye
            // }
            // // g.drawLine(365, 80, 385, 80); // nose
            // // g.drawLine(365, 80, 375, 95);
            // // g.drawLine(385, 80, 375, 95);
            // if (noseB) {
            // g.drawLine(x-10, y-320, x+10, y-320); //nose
            // g.drawLine(x-10, y-320, x, y-305);
            // g.drawLine(x+10, y-320, x, y-305);
            // }
            // // g.drawLine(355, 100, 375, 115); // mouth
            // // g.drawLine(375, 115, 395, 100);
            // g.drawLine(x-20, y-300, x, y-285); // mouth
            // g.drawLine(x, y-285, x+20, y-300);

            //
            if (armsB){
                // g.drawLine(300, 175, 450, 175); // arms
                g.drawLine(x-15*size, y-45*size, x+15*size, y-45*size);
                } 
                if (headB){
                    // g.drawOval(325, 25, 100, 100); // head
                g.drawOval(x-10*size, y-75*size, 20*size, 20*size); 
                }
    
                if (eyesB) {
                // g.drawOval(345, 50, 20, 20); // left eye
                g.drawOval(x-6*size, y-70*size, 4*size, 4*size); // left eye
                // g.drawOval(385, 50, 20, 20); // right eye
                g.drawOval(x+2*size, y-70*size, 4*size, 4*size); // right eye
                }
                // g.drawLine(365, 80, 385, 80); // nose
                // g.drawLine(365, 80, 375, 95);
                // g.drawLine(385, 80, 375, 95);
                if (noseB) {
                g.drawLine(x-2*size, y-64*size, x+2*size, y-64*size); //nose
                g.drawLine(x-2*size, y-64*size, x, y-61*size);
                g.drawLine(x+2*size, y-64*size, x, y-61*size);
                }
                // g.drawLine(355, 100, 375, 115); // mouth
                // g.drawLine(375, 115, 395, 100);
                g.drawLine(x-4*size, y-60*size, x, y-57*size); // mouth
                g.drawLine(x, y-57*size, x+4*size, y-60*size);
                if (backboneB) {
                    // g.drawLine(375, 125, 375, 300); // body 
                    g.drawLine(x, y-55*size, x, y-20*size); // body
                }
                    // g.drawLine(375, 300, 300, 400); // left leg
                g.drawLine(x, y-20*size, x-15*size, y); // left leg
                g.drawLine(x, y-20*size, x+15*size, y); // right leg
        // if (size == 2) {
        //     if (backboneB) {
        //     // g.drawLine(375, 125, 375, 300); // body 
        //     g.drawLine(x, y-275, x, y-100); // body
        //     }
        //     // g.drawLine(375, 300, 300, 400); // left leg
        //     g.drawLine(x, y-100, x-75, y); // left leg
        //     g.drawLine(x, y-100, x+75, y); // right leg
        // }
        // else if (size == 1) {
        //     if (backboneB) {
        //         g.drawLine(x, y-275, x, y-125); // body
        //         }
        //                         g.drawLine(x, y-125, x-75, y-25); // left leg
        //         g.drawLine(x, y-125, x+75, y-25); // right leg
                
        // }
        // else if (size == 0) {
        //     if (backboneB) {
        //         g.drawLine(x, y-275, x, y-150); // body
        //         }

        //         g.drawLine(x, y-150, x-75, y-50); // left leg
        //         g.drawLine(x, y-150, x+75, y-50); // right leg
                
        // }
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
        x -= 10;
        repaint();
    }
    public void moveRight() {
        if (x > 1000){
            x = 1; repaint(); return;
        }   
        x += 10;
        repaint();
    }
    public void moveReset() {
        x = initialX;
        repaint();
    }

    
}
