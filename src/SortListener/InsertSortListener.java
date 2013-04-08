/*
 * “插入排序”按钮的响应，按下按钮即可进行插入排序
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
public class InsertSortListener implements ActionListener {

    VisualSortPanel jp;

    public InsertSortListener(VisualSortPanel jp) {
        this.jp = jp;
    }

    public void actionPerformed(ActionEvent e) {
        new Thread(new Runnable() {

            public void run() {
                jp.InsertSort();
                JOptionPane.showMessageDialog(null , "已成功排序！");
            }
        }).start();
    }
}
