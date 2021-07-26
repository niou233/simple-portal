package com.niou.designpatterns.observer.v9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <pre>
 * @ClassName TestFrame.java
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/13 12:53<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/13 	niou		    		新建
 * </pre>
 */
public class TestFrame extends Frame {
    public void launch(){
        Button b = new Button("press me");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button press 1");
            }
        });
        b.addActionListener(new MyActionListener());
        this.add(b);
        this.pack();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        this.setLocation(400, 400);
        this.setSize(200,200);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame().launch();
    }
}

class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button press 2");
    }
}
