package fr.funecirce.testcamera;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import fr.funecirce.testcamera.entities.Player;



public class Board extends JPanel implements ActionListener {

    public final static int TILE_SIZE = 50;
    public final static int ROWS = 15;
    public final static int COLUMNS = 19;
    public final static Dimension SCREEN_SIZE = new Dimension(18*TILE_SIZE, 12*TILE_SIZE);
    public final static Dimension STAGE_SIZE = new Dimension(COLUMNS*TILE_SIZE, ROWS*TILE_SIZE);

    private final int TICK_RATE = 20;

    public final Player player;
    public final Player player2;

    public final ArrayList<GameObject> players = new ArrayList<>();

    private final Timer timer;
    private final Camera camera;

    public Board() {
        player = new Player(5, 6);
        player2 = new Player(0,0);

        players.add(player);
        players.add(player2);

        timer = new Timer(TICK_RATE, this);
        camera = new Camera(1f, player);

        setBackground(new Color(232,232,232));

        setPreferredSize(SCREEN_SIZE);

        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        
        camera.init(g);
        checkers(g);
        g.setColor(Color.RED);
        camera.draw(g, player);
        
    }

    public void checkers(Graphics g) {
        for (int i = 0; i<Board.ROWS; i++) {
            for (int j = 0; j< Board.COLUMNS; j++) {
                if((j+i)%2 == 0){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*Board.TILE_SIZE, i*Board.TILE_SIZE, Board.TILE_SIZE, Board.TILE_SIZE);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.tick();
        camera.tick(player);
        repaint();
    }

}
