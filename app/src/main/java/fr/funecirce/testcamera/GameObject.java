package fr.funecirce.testcamera;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Collection;

public class GameObject {

    public final Point pos;

    public GameObject(int x, int y) {
        pos = new Point(x, y);
    }
    public GameObject(int x, int y, int width, int height) {
        pos = new Point(x*width, y*height);
    }

    public void draw(Graphics g){}
    public void draw(Graphics g, GameObject gameObject){}
    public void draw(Graphics g, Collection<GameObject> gameObjects){}

    public void tick(){}
    public void tick(GameObject gameObject){}

}
