/*
 * This source file was generated by the Gradle 'init' task
 */
package fr.funecirce.testcamera;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            initWindow();
        });
    }

    public static void initWindow() {
        JFrame f = new JFrame();
        Board board = new Board();
        f.setTitle("Test Caméra");

        f.add(board);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.addKeyListener(board.player);

        f.pack();

        f.setVisible(true);
    }

}
