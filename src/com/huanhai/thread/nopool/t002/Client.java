package com.huanhai.thread.nopool.t002;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        JFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

class BallRunnable implements Runnable {
    private Ball ball;
    private Component component;
    private static final int STEPS = 1000;
    private static final int DELAY = 5;

    public BallRunnable(Ball ball, Component component) {
        this.ball = ball;
        this.component = component;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= STEPS; i++) {
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
            System.out.println(ball.getX() + " "+ball.getY());
        } catch (InterruptedException e) {

        }
    }
}

class Ball {
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
    private final static int XSIZE = 15;
    private final static int YSIZE = 15;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(Rectangle2D bounds) {
        y += dy;
        x += dx;
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getMaxY()) {
            x = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}

class BallPanel extends JPanel {
    private List<Ball> balls = new ArrayList<>(16);

    public void add(Ball ball) {
        balls.add(ball);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }
}

class BounceFrame extends JFrame {
    private BallPanel panel;
    public static final int DEFAULT_WIDTN = 450;
    public static final int DEFAULT_HEIGHT = 350;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    public BounceFrame() {
        setSize(DEFAULT_WIDTN, DEFAULT_HEIGHT);
        setTitle("窗口");
        panel = new BallPanel();
        add(panel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });
        addButton(buttonPanel, "Close", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        Ball b = new Ball();
        panel.add(b);
        Runnable r = new BallRunnable(b, panel);
        Thread t = new Thread(r);
        t.start();
    }
}
