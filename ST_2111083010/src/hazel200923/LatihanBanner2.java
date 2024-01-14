package hazel200923;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FA506IC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LatihanBanner2 {

    private JFrame frame;
    private JPanel bannerPanel;
    private JLabel bannerLabel1;
    private JLabel bannerLabel2;
    private String bannerText1;
    private String bannerText2;
    private int bannerPosition;
    private Timer timer;

    public LatihanBanner2() {
        frame = new JFrame("Banner Example");
        bannerPanel = new JPanel();
        bannerText1 = "Hazel Adreal";
        bannerText2 = "Hazel Adreal";
        bannerPosition = 0;

        bannerLabel1= new JLabel(bannerText1);
        bannerLabel1.setFont(new Font("Arial", Font.BOLD, 24));

        bannerLabel2= new JLabel(bannerText2);
        bannerLabel2.setFont(new Font("Arial", Font.BOLD, 24));
        
        bannerPanel.setLayout(new GridLayout(2, 1)); // 2 rows, 1 column
        bannerPanel.add(bannerLabel1);
        bannerPanel.add(bannerLabel2);

        frame.add(bannerPanel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBanner();
            }
        });

        timer.start();
    }

    private void moveBanner() {
        bannerPosition++;
        if (bannerPosition > bannerText1.length()) {
            bannerPosition = 0;
        }

       String displayText1 = bannerText1.substring(bannerPosition) + bannerText1.substring(0, bannerPosition);
       String displayText2 = bannerText2.substring(bannerPosition) + bannerText2.substring(0, bannerPosition);
       
       bannerLabel1.setText(displayText1);
       bannerLabel2.setText(displayText2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LatihanBanner2().frame.setVisible(true);
            }
        });
    }
}