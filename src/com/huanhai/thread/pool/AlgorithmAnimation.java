package com.huanhai.thread.pool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Semaphore;

public class AlgorithmAnimation {
    public static void main(String[] args) {
        JFrame frame = new AnimationFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class AnimationFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;
    private static final int VALUES_LENGTH = 30;

    public AnimationFrame() {
        ArrayPanel panel = new ArrayPanel();
        add(panel, BorderLayout.CENTER);
        Double[] values = new Double[VALUES_LENGTH];
        final Sorter sorter = new Sorter(values, panel);
        JButton runBotton = new JButton("Run");
        runBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.setRun();
            }
        });
        JButton stepBotton = new JButton("Step");
        stepBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.setStep();
            }
        });
        JPanel buttons = new JPanel();
        buttons.add(runBotton);
        buttons.add(stepBotton);
        add(buttons, BorderLayout.NORTH);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        for (int i = 0; i < values.length; i++) {
            values[i] = new Double(Math.random());
            Thread t = new Thread(sorter);
            t.start();
        }
    }
}

class Sorter implements Runnable {
    private Double[] values;
    private ArrayPanel panel;
    private Semaphore gate;
    private static final int DELAY = 100;
    private boolean run;

    public Sorter(Double[] values, ArrayPanel panel) {
        this.values = values;
        this.panel = panel;
        this.gate = new Semaphore(1);
        this.run = false;
    }

    public void setRun() {
        this.run = true;
        gate.release();
    }

    public void setStep() {
        this.run = false;
        gate.release();
    }

    @Override
    public void run() {
        Comparator<Double> comp = new Comparator<Double>() {
            @Override
            public int compare(Double i1, Double i2) {
                panel.setValues(values, i1, i2);
                try {
                    if (run) {
                        Thread.sleep(DELAY);

                    } else {
                        gate.acquire();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return i1.compareTo(i2);
            }

        };
        Arrays.sort(values, comp);
        this.panel.setValues(values, null, null);
    }
}

class ArrayPanel extends JPanel {
    private Double marked1;
    private Double marked2;
    private Double[] values;
    @Override
    public void paintComponent(Graphics g) {
        if (this.values == null) {
            return;
        }
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth() / this.values.length;
        for (int i = 0; i < this.values.length; i++) {
            double height = this.values[i] * getHeight();
            Rectangle2D bar = new Rectangle2D.Double(width * i, 0, width, height);
            if (values[i] == this.marked1 || values[2] == marked2) {
                g2.fill(bar);
            } else {
                g2.draw(bar);
            }
        }
    }

    public void setValues(Double[] values, Double marked1, Double marked2) {
        this.values = values;
        this.marked1 = marked1;
        this.marked2 = marked2;
        repaint();
    }
}
