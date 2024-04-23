package project.ch01;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LabelExample2 extends Frame implements ActionListener {
  private static final long serialVersionUID = 1L;
  JTextField tf;
  JLabel l;
  JButton b;

  LabelExample2() {
    tf = new JTextField();
    tf.setBounds(50, 50, 150, 20);
    l = new JLabel("Enter domain name");
    l.setBounds(50, 100, 250, 20);
    b = new JButton("Find IP");
    b.setBounds(50, 150, 95, 30);
    b.addActionListener(this);
    add(b);
    add(tf);
    add(l);
    setSize(400, 400);
    setLayout(null);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    try {
      String host = tf.getText();
      String ip = java.net.InetAddress.getByName(host).getHostAddress();
      l.setText("IP of " + host + " is: " + ip);
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }

  public static void main(String[] args) {
    new LabelExample2();
  }
}
