import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class ShapeView extends JFrame {
    private JButton ellipseButton, rectangleButton, triangleButton;
    private JButton yellowButton, blueButton, redButton;
    public ShapeModel model;
    public ShapePanel shapePanel;
    public JPanel sliderPanel;
    public JSlider sizeSlider;

    public ShapeView(ShapeModel model){
        this.model = model;
        shapePanel = new ShapePanel(model);
        setTitle("Border Layout Example");
        setLayout(new BorderLayout(20, 5));
        setSize(600,600);

        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        redButton = new JButton( "RED");
        blueButton = new JButton( "BLUE");
        yellowButton = new JButton( "YELLOW");
        triangleButton = new JButton( "TRIANGLE");
        ellipseButton = new JButton( "ELLIPSE");
        rectangleButton = new JButton( "RECTANGLE");

        //attempting to add borderlayout while making use of gridlayout and JPanel

        JPanel west = new JPanel(new GridLayout(3,1,0,10));
        west.add(redButton);
        west.add(blueButton);
        west.add(yellowButton);
        add(west, BorderLayout.WEST);

        JPanel east = new JPanel(new GridLayout(3,1,0,10));
        
        east.add(triangleButton);
        east.add(ellipseButton);
        east.add(rectangleButton);
        add(east, BorderLayout.EAST);

        add(shapePanel, BorderLayout.CENTER);

        //this is for slider

        sizeSlider = new JSlider(JSlider.HORIZONTAL, 10, 200, 100);
        super.add(sizeSlider, BorderLayout.SOUTH);

        //to show window and exit
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
        this.setSize(500,500);
    }

    public void removeCenter(){
        shapePanel.removeAll();
        //add(new Rectangle());
        shapePanel.revalidate();
        shapePanel.repaint();
    }
    public JSlider getSizeSlider(){
        return sizeSlider;
    }

    public JPanel getShapePanel(){
        return shapePanel;
    }
    public JButton getEllipseButton() {
        return ellipseButton;
    }

    public JButton getRectangleButton() {
        return rectangleButton;
    }

    public JButton getTriangleButton() {
        return triangleButton;
    }

    public JButton getYellowButton() {
        return yellowButton;
    }

    public JButton getBlueButton() {
        return blueButton;
    }

    public JButton getRedButton() {
        return redButton;
    }
}

class ShapePanel extends JPanel {
    public ShapeModel model;

    public ShapePanel(ShapeModel model) {
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = model.getSize();
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        g.setColor(model.getFillColor());

        switch (model.getShape()) {
            case "Ellipse":
                g.fillOval(x, y, size, size);
                break;
            case "Rectangle":
                g.fillRect(x, y, size, size);
                break;
            case "Triangle":
                int[] xPoints = {x, x + size / 2, x + size};
                int[] yPoints = {y + size, y, y + size};
                g.fillPolygon(xPoints, yPoints, 3);
                break;
        }
    }
}
enum ShapeType {
    Ellipse, TRIANGLE, Rectangle
}

