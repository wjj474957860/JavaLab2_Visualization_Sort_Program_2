/*
 * “输入数据”按钮的响应，用户可输入一定长度的，以空格隔开的整数
 *
 * 作者：吴建杰
 * 学号：20102100035
 */
package InputListener;

import VisualSortMain.VisualSortPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyInputListener implements ActionListener {

    VisualSortPanel p;

    public MyInputListener(VisualSortPanel p) {
        this.p = p;
    }

    public void actionPerformed(ActionEvent e) {
        String sortString = JOptionPane.showInputDialog(this, "输入待排序数字，空格隔开：");
        String[] tmpStr = sortString.split(" ");
        p.a = new int[tmpStr.length];
        p.x = new int[tmpStr.length];
        p.y = new int[tmpStr.length];
        p.color = new Color[tmpStr.length];
        for (int i = 0; i < tmpStr.length; ++i) {
            p.x[i] = i * 80 + 20;
            p.y[i] = p.Y;
            p.color[i] = Color.red;
            p.a[i] = Integer.parseInt(tmpStr[i]);
        }
        p.repaint();
    }
}
