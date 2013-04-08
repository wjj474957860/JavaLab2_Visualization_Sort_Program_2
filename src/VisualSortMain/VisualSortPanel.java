/*
 * 这个类是创建显示数据的画板JPanel
 * 并实现数组中两个数据显色交换的效果
 * 还有实现3种排序算法：分别是冒泡排序、插入排序和选择排序
 * 方便调用对应的算法进行排序
 *
 * 作者：吴建杰
 * 学号：20102100035
 */
package VisualSortMain;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VisualSortPanel extends JPanel {

    public int Y = 100;
    public int x[], y[], a[];
    public int DISTANCE = 10;
    public Color color[];
    public int delay = 1000 / 60;
    public int p, q;
    public int cnt, tx, ty;
    public Timer timer0, timer1, timer2, timer3;

    //构造函数初始化
    public VisualSortPanel() {
        a = new int[10];                      //存储10个整型数据的数组
        x = new int[10];                      //每个数据显示的横坐标的数组
        y = new int[10];                      //每个数据显示的纵坐标的数组
        color = new Color[10];
        for (int i = 0; i < 10; i++) {
            x[i] = i * 80 + 20;
            y[i] = Y;
            color[i] = Color.red;            //每个数据为红色
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, getWidth(), getHeight());
        g2d.setFont(new Font("", Font.BOLD, 20));                //粗字体

        for (int i = 0; i < a.length; i++) {
            g2d.setColor(color[i]);
            g2d.drawString(a[i] + "", x[i], y[i]);                     //将红色的数据显示在面板上
        }
    }

    //交换并移动数据
    void makeMove() {

        timer0 = new Timer(300, new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                cnt++;
                if (color[p] == Color.red) {
                    color[p] = Color.blue;
                } else {
                    color[p] = Color.red;
                }
                if (color[q] == Color.red) {
                    color[q] = Color.blue;
                } else {
                    color[q] = Color.red;
                }
                repaint();
                if (cnt == 6) {
                    timer0.stop();
                }
            }
        });
        cnt = 0;
        timer0.start();
        while (timer0.isRunning());

        timer1 = new Timer(delay, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                y[p] += DISTANCE;
                y[q] -= DISTANCE;
                repaint();
                if (y[p] == ty) {
                    timer1.stop();
                }
            }
        });
        ty = Y + 20;
        timer1.start();
        while (timer1.isRunning());

        tx = x[q];
        timer2 = new Timer(delay, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                x[p] += DISTANCE;
                x[q] -= DISTANCE;
                repaint();
                if (x[p] == tx) {
                    timer2.stop();
                }
            }
        });
        timer2.start();
        while (timer2.isRunning());

        ty = Y;
        timer3 = new Timer(delay, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                y[q] += DISTANCE;
                y[p] -= DISTANCE;
                repaint();
                if (y[p] == ty) {
                    timer3.stop();
                }
            }
        });
        timer3.start();
        while (timer3.isRunning());
    }

    void swap(int i, int j) {
        int tmp;
        p = i;
        q = j;
        color[i] = Color.blue;
        color[j] = Color.blue;
        makeMove();
        color[i] = Color.red;
        color[j] = Color.red;
        //repaint();
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
        repaint();
    }

    //冒泡排序的实现
    public void BubbleSort() {
        int i, j, n = a.length;
        for (i = 0; i < n - 1; ++i) {
            for (j = n - 1; j > i; --j) {
                if (a[j] < a[j - 1]) {
                    this.swap(j - 1, j);
                }
            }
        }
    }

    //插入排序的实现
    public void InsertSort() {
        int in = a.length;
        for (int i = 1; i < in; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    this.swap(j - 1, j);
                }
            }
        }
    }

    //选择排序的实现
    public void SelectSort() {
        int se = a.length;
        for (int i = 0; i < se; i++) {
            //设置一个变量用以存储最小值下标
            int minId = i;
            for (int j = i + 1; j <= se - 1; j++) {

                if (a[minId] > a[j]) {
                    minId = j;
                }
            }
            if (minId != i) {
                this.swap(i,minId);
            }
        }
    }
}
