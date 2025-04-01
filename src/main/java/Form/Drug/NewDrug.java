/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form.Drug;

import DatabaseAccessObject_DAO.Drug_Dao;
import DatabaseAccessObject_Impl.Drug_DaoImpl;
import Dialog.Swal_Notification;
import Enum.TypeInterface;
import Enum.TypeList;
import Enum.TypeNotification;
import Form.List.ListOfObject;
import Model.Drug;
import Model.Employee;
import ViewForm.Main;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class NewDrug extends javax.swing.JPanel {

    private final JPanel main;
    private final Employee employee;
    private final TypeInterface type;
    private Drug drug_target;
    public NewDrug(JPanel main, TypeInterface type, Employee employee) {
        initComponents();
        this.main = main;
        this.type = type;
        this.employee = employee;
        init(type);
    }
    
    public NewDrug(JPanel main, TypeInterface type, Employee employee, Drug drug_target) {
        initComponents();
        this.main = main;
        this.type = type;
        this.employee = employee;
        this.drug_target =drug_target;
        init(type);
    }
    
    private void init(TypeInterface type)
    {
        if(type == TypeInterface.Create)
        {
            TitleForm.setText("Tạo Mới Thuốc");
            txtName.setText("");
            txtQuantity.setText("");
            txtType.setText("");
            txtPrice.setText("");
            txtDescription.setText("");
            btnSave.setText("Tạo Mới");
        }
        if(type == TypeInterface.Edit)
        {
            TitleForm.setText("Chỉnh Sửa Thông Tin Thuốc");
            txtName.setText(this.drug_target.getDrugName());
            txtType.setText(this.drug_target.getDrugType());
            txtQuantity.setText(String.valueOf(this.drug_target.getQuantity()));
            txtDescription.setText(this.drug_target.getDescription());
            txtPrice.setText(String.valueOf(this.drug_target.getPrice()));
            btnSave.setText("Lưu");
        }
    }
    
    private boolean initData()
    {
        Drug drug = new Drug();
        drug.setDrugName(txtName.getText());
        drug.setDrugType(txtType.getText());
        drug.setQuantity(Integer.parseInt(txtQuantity.getText()));
        drug.setPrice(Double.parseDouble(txtPrice.getText()));
        drug.setDescription(txtDescription.getText());
        Drug_Dao drug_Dao = new Drug_DaoImpl();
        
        if(this.type == TypeInterface.Create)
        {
            if(drug_Dao.AddDrug(drug))
            {
                showMessage("Bạn vừa tạo mới dịch vụ thành công", TypeNotification.Success);
                return true;
            }  
            else
            {
                showMessage("Đã xảy ra lỗi", TypeNotification.Error);
            }
            return true;
        }
        else if(this.type == TypeInterface.Edit)
        {
            drug.setID(this.drug_target.getID());
            if(drug_Dao.Update_Drug(drug))
            {
                showMessage("Bạn vừa cập nhật thuốc thành công", TypeNotification.Success);
                return true;
            }  
            else
            {
                showMessage("Đã xảy ra lỗi", TypeNotification.Error);
            }
        }
        return false;
    }
    
    private void showForm(Component com){
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();
    }
    
    private boolean showMessage(String message, TypeNotification type ) {
        Swal_Notification obj = new Swal_Notification(Main.getFrames()[0], true);
        obj.showMessage(message, type);               
        return obj.isOk();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        TitleForm = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSave = new Swing.Button.Button2();

        setForeground(new java.awt.Color(79, 98, 203));
        setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Group 31.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(79, 98, 203));
        jLabel4.setText("Tên Thuốc:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(79, 98, 203));
        jLabel7.setText("Loại Thuốc:");

        txtName.setBackground(new java.awt.Color(238, 245, 255));
        txtName.setColumns(1);
        txtName.setForeground(new java.awt.Color(79, 98, 203));
        txtName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        txtType.setBackground(new java.awt.Color(238, 245, 255));
        txtType.setColumns(1);
        txtType.setForeground(new java.awt.Color(79, 98, 203));
        txtType.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        TitleForm.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        TitleForm.setText("Chỉnh Sửa Hoá Đơn Thuốc");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(79, 98, 203));
        jLabel5.setText("Mô Tả:");

        txtDescription.setBackground(new java.awt.Color(238, 245, 255));
        txtDescription.setColumns(20);
        txtDescription.setForeground(new java.awt.Color(79, 98, 203));
        txtDescription.setRows(5);
        txtDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255)));
        jScrollPane1.setViewportView(txtDescription);

        txtQuantity.setBackground(new java.awt.Color(238, 245, 255));
        txtQuantity.setColumns(1);
        txtQuantity.setForeground(new java.awt.Color(79, 98, 203));
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        txtPrice.setBackground(new java.awt.Color(238, 245, 255));
        txtPrice.setColumns(1);
        txtPrice.setForeground(new java.awt.Color(79, 98, 203));
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(79, 98, 203));
        jLabel6.setText("Số lượng:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(79, 98, 203));
        jLabel8.setText("Giá:");

        btnSave.setText("Lưu");
        btnSave.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        btnSave.setRadius(15);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitleForm, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 120, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(TitleForm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(6, 6, 6)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(initData())
            showForm(new ListOfObject(main, TypeList.Drug, this.employee));
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    showForm(new ListOfObject(main, TypeList.Drug, this.employee));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleForm;
    private Swing.Button.Button2 btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
