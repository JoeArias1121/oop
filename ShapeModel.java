import java.awt.Color;

    class ShapeModel {
        private String shape;
        private Color fillColor;
        private int size;

        public ShapeModel(){
            
        }
    
        public String getShape() {
            return shape;
        }
    
        public void setShape(String shape) {
            this.shape = shape;
        }
    
        public Color getFillColor() {
            return fillColor;
        }
    
        public void setFillColor(Color fillColor) {
            this.fillColor = fillColor;
        }
    
        public int getSize() {
            return size;
        }
    
        public void setSize(int size) {
            this.size = size;
        }
}
enum ShapeType {
    ELLIPSE, TRIANGLE, RECTANGLE
}