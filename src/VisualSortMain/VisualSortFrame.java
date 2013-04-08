/*
 * 该程序的主函数
 * 这个类是创建窗口框架，add上前面的JPanel和一些按钮组件
 * 并实现数组中两个数据显色交换的效果
 * 可以选择3种排序算法：分别是冒泡排序、插入排序和选择排序之中一种进行排序
 * 可以由用户来手动输入数据，再进行动态可视化排序。
 *
 * 作者：吴建杰
 * 学号：20102100035
 */

package VisualSortMain;

import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import SortListener.*;
import InputListener.*;
import java.awt.event.ActionListener;

public class VisualSortFrame extends JFrame {

    static String message;
    static String sortString = "";

    public VisualSortFrame(VisualSortPanel jp) {
        super("MyVisualSort");
        Container my_container = getContentPane();
        JButton enterButton = new JButton("                            输入数据                          ");
        JButton manualButton = new JButton("使用说明");
        JButton exitButton = new JButton("退出程序");
        JButton BubbleSortButton = new JButton("          冒泡排序        ");
        JButton InsertSortButton = new JButton("          插入排序        ");
        JButton SelectSortButton = new JButton("          选择排序        ");

        enterButton.addActionListener(new MyInputListener(jp));
        BubbleSortButton.addActionListener(new BubbleSortListener(jp));
        InsertSortButton.addActionListener(new InsertSortListener(jp));
        SelectSortButton.addActionListener(new SelectSortListener(jp));

        JPanel panelSouth = new JPanel();
        panelSouth.add(BubbleSortButton, BorderLayout.EAST);
        panelSouth.add(InsertSortButton,BorderLayout.SOUTH);
        panelSouth.add(SelectSortButton,BorderLayout.NORTH);

        JPanel panelNorth = new JPanel();
        panelNorth.add(enterButton, BorderLayout.CENTER);
        panelNorth.add(manualButton, BorderLayout.EAST);
        panelNorth.add(exitButton,BorderLayout.WEST);
        
        Container c = this.getContentPane();
        c.add(panelSouth, BorderLayout.SOUTH);
        c.add(panelNorth,BorderLayout.NORTH);
        message = new String("Sorting...");
        my_container.add(jp, BorderLayout.CENTER);

        //使用说明的响应
        manualButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null ,"1、按“输入数据”进行输入待排序的整型数据\n2、按“冒泡排序”、“插入排序”、“选择排序”之一进行排序。");
            }
        });

        //退出程序的响应
        exitButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        VisualSortPanel jp = new VisualSortPanel();
        VisualSortFrame app = new VisualSortFrame(jp);

        Random r = new Random();
        for (int i = 0; i < 10; ++i) {
            jp.a[i] = (r.nextInt() % 10000 + 10000) % 10000;
        }

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(830, 450);
        app.setVisible(true);
    }
}
