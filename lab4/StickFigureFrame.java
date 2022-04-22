package lab4;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class StickFigureFrame extends JFrame {

    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 1000;

    JPanel controlPanel, vanishPanel, slidePanel, figurePanel, sliderPanel;
    JComponent figure;
    JCheckBox nose, eyes, arms, backbone, head;
    JButton left, right, reset, colorChoose;
    ActionListener listener;
    StickFigure component;
    Timer timer1, timer2;
    ActionListener l1, l2, l3, l4;
    JSlider height;

    public StickFigureFrame() {
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Stick Figure");
        this.setFigure();
        this.createControlPanel();
        
        timer1 = new Timer(3, l1);
        timer2 = new Timer(3, l2);
    }    

    private void setFigure() {
        component = new StickFigure(500, 750);
        figurePanel = new JPanel();
        figurePanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        figurePanel.add(component);
        add(figurePanel, BorderLayout.CENTER);
    }

    
    // CONTROL PANEL
    private void createControlPanel() {
        vanishPanel = setCheckBoxes(); vanishPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        slidePanel = setMoveButtons(); slidePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        sliderPanel = createSlider(); sliderPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        
        controlPanel = new JPanel();
        controlPanel.add(vanishPanel);
        controlPanel.add(slidePanel);
        controlPanel.add(sliderPanel);
        controlPanel.setBackground(Color.RED);
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        add(controlPanel, BorderLayout.SOUTH);
    }

    // SLIDER CREATOR
    public JPanel createSlider() {
        ChangeListener sliderl = new sliderListener();
        height = new JSlider(JSlider.HORIZONTAL, 0, 10, 8);
        height.addChangeListener(sliderl);

        height.setMinorTickSpacing(5);
        height.setMajorTickSpacing(1);
        height.setPaintTicks(true);
        height.setPaintLabels(true);
        JPanel heightPanel = new JPanel();
        heightPanel.setBorder(new TitledBorder(new EtchedBorder(), "Height"));
        heightPanel.add(height);
        return heightPanel;
    }

    public class sliderListener implements ChangeListener {

        public void stateChanged(ChangeEvent e) {
            int size = height.getValue();
            component.setSize(size);
        }
        
    }

    // BUTTON PANEL CREATOR
    public JPanel setMoveButtons() {

        colorChoose = new JButton("Choose color"); colorChoose.setFocusable(false); 
        colorChoose.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        l4 = new buttonColorChooser();
        colorChoose.addActionListener(l4);

        left = new JButton("<-- Move Left    "); left.setFocusable(false);
        left.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        l1 = new buttonLeftListener();
        left.addActionListener(l1);
        
        right = new JButton("    Move Right -->"); right.setFocusable(false);
        right.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        l2 = new buttonRightListener();
        right.addActionListener(l2);

        reset = new JButton("RESET"); reset.setFocusable(false);
        reset.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        l3 = new buttonResetListener();
        reset.addActionListener(l3);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(150, 150));
        // buttonPanel.setBorder(new TitledBorder(new EtchedBorder(), "Movement"));
        buttonPanel.setLayout(new GridLayout(4,1));
        buttonPanel.add(right);
        buttonPanel.add(left);
        buttonPanel.add(reset);
        buttonPanel.add(colorChoose);
        return buttonPanel;
    }


    public class buttonColorChooser implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(component, "Pick a color", Color.BLACK);
            component.colorPicker(color);

        }
    }

    // ACTION LISTENERS
    public class buttonRightListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) { 
            if (timer1.isRunning()) {
                timer1.stop();
            }
            timer2.start();
            component.moveRight();   
        }
    }

    public class buttonLeftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) { 
            if (timer2.isRunning()){
                timer2.stop();
            }
            timer1.start();
            component.moveLeft();  
            }
    }

    public class buttonResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            timer1.stop();
            timer2.stop();
        }
    }

    // CHECK BOXES PANEL CREATOR
    public JPanel setCheckBoxes() {
        nose = new JCheckBox("Nose", true);
        eyes = new JCheckBox("Eyes", true);
        arms = new JCheckBox("Arms", true);
        backbone = new JCheckBox("Backbone", true);
        head = new JCheckBox("Head", true);
        JButton check = new JButton("Apply");
        check.setFocusable(false);
        check.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        listener = new CheckBoxListener();
        check.addActionListener(listener);

        JPanel checkBoxPanel = new JPanel(); 
        checkBoxPanel.setPreferredSize(new Dimension(150, 150));
        checkBoxPanel.setBorder(new TitledBorder(new EtchedBorder(), "Body Parts"));
        checkBoxPanel.setLayout(new GridLayout(6,1));
        checkBoxPanel.add(nose);
        checkBoxPanel.add(eyes);
        checkBoxPanel.add(arms);
        checkBoxPanel.add(backbone);
        checkBoxPanel.add(head);
        checkBoxPanel.add(check);
        return checkBoxPanel;
    }

    public class CheckBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vanisher();
        }
    }

    

    // CHECKBOX FUNCTIONS
    public void vanisher() {
        // vanish body parts
        if (!nose.isSelected()) {
            component.setNoseB(false);
            component.repaint();
        }
        if (nose.isSelected()) {
            component.setNoseB(true);
            component.repaint();
        }
        if (!arms.isSelected()) {
            //kollar gider
            component.setArmsB(false);
            component.repaint();
        }
        if (arms.isSelected()) {
            //kollar gider
            component.setArmsB(true);
            component.repaint();
        }
        if (!eyes.isSelected()) {
            // gözleri sil
            component.setEyesB(false);
            component.repaint();
        }
        if (eyes.isSelected()) {
            // gözleri sil
            component.setEyesB(true);
            component.repaint();
        }
        if (!backbone.isSelected()) {
            component.setBackboneB(false);
            component.repaint();
        }
        if (backbone.isSelected()) {
            component.setBackboneB(true);
            component.repaint();
        }
        if (!head.isSelected()) {
            component.setHeadB(false);
            component.repaint();
        }
        if (head.isSelected()) {
            component.setHeadB(true);
            component.repaint();
        }

        
    }
    
}
