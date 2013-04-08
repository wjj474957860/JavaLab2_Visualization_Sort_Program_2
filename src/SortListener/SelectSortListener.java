/*
 * “选择排序”按钮的响应，按下按钮可以进行选择排序
 *
 * 作者：吴建杰
 * 学号：20102100035
 */
package SortListener;

import VisualSortMain.VisualSortPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author spy
 */
public class SelectSortListener implements ActionListener {
    VisualSortPanel jp;

    public SelectSortListener(VisualSortPanel jp) {
        this.jp = jp;
    }

    public void actionPerformed(ActionEvent e) {
        new Thread(new Runnable() {

            public void run() {
                jp.SelectSort();
                JOptionPane.showMessageDialog(null , "已成功排序！");
            }
        }).start();
    }
}
