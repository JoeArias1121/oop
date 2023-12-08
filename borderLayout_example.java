import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
public class borderLayout_example extends JFrame {
    ShapeView view;
    String size;
    ShapeModel model;

    //Constructor
    public borderLayout_example(){
        model = new ShapeModel();
        view = new ShapeView(model);
        defaultShape();

        view.getEllipseButton().addActionListener(new ShapeChangeListener("Ellipse"));
        view.getRectangleButton().addActionListener(new ShapeChangeListener("Rectangle"));
        view.getTriangleButton().addActionListener(new ShapeChangeListener("Triangle"));

        view.getYellowButton().addActionListener(new ColorChangeListener(Color.YELLOW));
        view.getBlueButton().addActionListener(new ColorChangeListener(Color.BLUE));
        view.getRedButton().addActionListener(new ColorChangeListener(Color.RED));

        view.getSizeSlider().addChangeListener(new SizeChangeListener());
    }

    public void defaultShape(){
        model.setShape("Recangle");
        model.setSize(100);
        model.setFillColor(Color.RED);
        
    }

    class SizeChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int size = view.getSizeSlider().getValue();
            model.setSize(size);
            updateShapePanel();
        }
    }

    private void updateShapePanel() {
        view.getShapePanel().repaint();
    }

    class ColorChangeListener implements ActionListener {
        private Color color;

        public ColorChangeListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setFillColor(color);
            updateShapePanel();
        }
    }

    // Inner class for handling shape change events
    class ShapeChangeListener implements ActionListener {
        private String shape;

        public ShapeChangeListener(String shape) {
            this.shape = shape;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setShape(shape);
            updateShapePanel();
        }
    }


public static void main(String[] args){
    SwingUtilities.invokeLater(() -> {
        borderLayout_example l = new borderLayout_example();
    });
}


// these are for shapes

public class Rectangle extends ShapeComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getFillColor());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}

public class Ellipse extends ShapeComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getFillColor());
        g.fillOval(0, 0, getWidth(), getHeight());
    }
}

public class Triangle extends ShapeComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getFillColor());
        int[] xPoints = {getWidth() / 2, 0, getWidth()};
        int[] yPoints = {0, getHeight(), getHeight()};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}

public class ShapeComponent extends JPanel {
    private Color fillColor = Color.RED; // Default fill color

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        repaint();
    }

}
}
