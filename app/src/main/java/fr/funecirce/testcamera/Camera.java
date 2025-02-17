package fr.funecirce.testcamera;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.Collection;

import fr.funecirce.testcamera.entities.Player;


public class Camera extends GameObject {
    
    private int x;
    private int y;
    public boolean drawDebug = false;
    public final float scale;
    private final int offsetX;
    private final int offsetY;
    

    public Camera(float scale, Player reference) {
        super(reference.pos.x, reference.pos.y);
        this.scale = scale;
        offsetX = (int)(Board.SCREEN_SIZE.width/2);
        offsetY = (int)(Board.SCREEN_SIZE.height/2);
        updatePos(reference.pos);
    }

    @Override
    public void draw(Graphics g, GameObject go) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(scale, scale);
        g.setColor(Color.RED);
        go.draw(g2d);
    }

    @Override
    public void draw(Graphics g, Collection<GameObject> gameObjects) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(scale, scale);
        for(GameObject gameObject : gameObjects) {
            gameObject.draw(g2d);
        }
    }

    private void updatePos(Point pos) {
        x = pos.x+Board.TILE_SIZE;
        y = pos.y+Board.TILE_SIZE;
    }

    @Override
    public void tick(GameObject reference) {
        updatePos(reference.pos);
    }

    public void init(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.translate((offsetX-x+Board.TILE_SIZE/2)*scale, (offsetY-y+Board.TILE_SIZE/2)*scale);
    }

}
