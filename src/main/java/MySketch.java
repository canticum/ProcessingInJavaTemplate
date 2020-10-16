import processing.core.*;

public class MySketch extends PApplet {

    PImage p3Img;

    @Override
    public void settings() {
        
        size(300, 300);
    }

    @Override
    public void setup() {
        
        p3Img = loadImage(getClass().getResource("nctu.png").getFile());
    }

    @Override
    public void draw() {
        
        background(255);
        if (mousePressed) {
            image(p3Img, (width - p3Img.pixelWidth) / 2, (height - p3Img.height) / 2);
        }
    }

    public static void main(String[] args) {

        PApplet.main("MySketch");
    }
}
