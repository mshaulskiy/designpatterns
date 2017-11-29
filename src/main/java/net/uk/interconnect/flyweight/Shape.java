package net.uk.interconnect.flyweight;

import java.awt.*;

/**
 * Created by mshaulskiy on 25/01/2017.
 */
public interface Shape {

    public void draw(Graphics g, int x, int y, int width, int height,
                     Color color);
}
