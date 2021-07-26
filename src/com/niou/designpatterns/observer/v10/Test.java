package com.niou.designpatterns.observer.v10;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * @ClassName Test.java
 * </pre>
 *
 * @author niou<br>
 * <b>mail</b> 2922564446@qq.com<br>
 * <b>date</b> 2021/07/13 13:10<br>
 * @version 1.0.0
 * <pre>
 * 修改记录
 *  版本号		修订日期		修改人		bug编号		修改内容
 *  1.0.0		2021/07/13 	niou		    		新建
 * </pre>
 */
public class Test {
    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new MyActionListener());
        button.addActionListener(new MyActionListener2());
        button.buttonPressed();
    }
}

class Button {
    List<ActionListener> list = new ArrayList<>();
    public void addActionListener(ActionListener listener){
        this.list.add(listener);
    }
    public void buttonPressed(){
        ActionEvent event = new ActionEvent();
        for (ActionListener listener :list){
            listener.actionPerformed(event);
        }
    }
}

class ActionEvent {
    long when;
    Object source;

    public long getWhen() {
        return when;
    }

    public void setWhen(long when) {
        this.when = when;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
interface ActionListener {
    public void actionPerformed(ActionEvent event);
}
class MyActionListener implements  ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("listener1 button press 1");
    }
}

class MyActionListener2 implements  ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("listener2 button press 1");
    }
}