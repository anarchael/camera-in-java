package fr.funecirce.testcamera.entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import fr.funecirce.testcamera.Board;
import fr.funecirce.testcamera.GameObject;


public class Player extends GameObject implements KeyListener {

    private final Set<Integer> pressedKeys = new HashSet<>();
    private boolean isDashing = false;
    private float velocity = 1;

    public Player(int x, int y) {
        super(x, y, Board.TILE_SIZE, Board.TILE_SIZE);
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(pos.x, pos.y, Board.TILE_SIZE, Board.TILE_SIZE);
    }

    @Override
    public void tick() {
        dash();
        move();
        checkPos();
    }

    private void dash() {
        System.out.println(velocity);
        if(pressedKeys.contains(KeyEvent.VK_SHIFT) && !isDashing && velocity < 1.2) {
            velocity = 5;
            isDashing = true;
        }
        if(velocity > 1.2) {
            velocity -= 0.2f;
        }
    }

    private void move() {
        if (pressedKeys.contains(KeyEvent.VK_Z)) pos.translate(0, (int)(-5*velocity));
        if (pressedKeys.contains(KeyEvent.VK_S)) pos.translate(0, (int)(5*velocity));
        if (pressedKeys.contains(KeyEvent.VK_Q)) pos.translate((int)(-5*velocity), 0);
        if (pressedKeys.contains(KeyEvent.VK_D)) pos.translate((int)(5*velocity), 0);
    }

    private void checkPos() {
        if(pos.x < 0) {
            pos.x = 0;
        } else if (pos.x+Board.TILE_SIZE > Board.STAGE_SIZE.width) {
             pos.x = Board.STAGE_SIZE.width-50;
        }
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y+Board.TILE_SIZE > Board.STAGE_SIZE.height) {
            pos.y = Board.STAGE_SIZE.height-Board.TILE_SIZE;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys.add(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(e.getKeyCode() == KeyEvent.VK_SHIFT) isDashing = false;

        pressedKeys.remove(key);
    }


}
