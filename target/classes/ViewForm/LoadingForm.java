/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewForm;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**
 *
 * @author Thái Đức Hiếu
 */
public class LoadingForm extends javax.swing.JFrame{
    private JLabel labelLoading;
    private JProgressBar progressBar;
       public LoadingForm() {
        initComponents();
        setupLayout();
        setSize(300, 100);
        setLocationRelativeTo(null);
     
    }

    private void initComponents() {
        labelLoading = new JLabel("Loading...", JLabel.CENTER);
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        add(labelLoading, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);
        
    }

public void startLoading() {
    SwingUtilities.invokeLater(() -> {
        setVisible(true);
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setValue(i);
                // Cập nhật nội dung của labelLoading
                labelLoading.setText("Loading... " + i + "%");
            }
            // Giữ nguyên giá trị cuối cùng của progressBar là 100
        }).start();
    });
}

    public void hideLoadingForm() {
        setVisible(false);
    }
      
}
