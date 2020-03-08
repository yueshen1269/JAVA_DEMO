import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
}

class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval =interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    // 匿名内部类写法
    public void start2(int interval, boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("At the tone, the time is " + new Date());
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }

    // 内部类
    public class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is " + new Date());
            // if(TalkingClock.this.beep)
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
