/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.gui;

import com.lottery.exception.LotteryException;
import com.lottery.model.Buyer;
import com.lottery.model.Ticket;
import com.lottery.model.TicketTable;
import com.lottery.service.BuyerService;
import com.lottery.service.TicketTableService;
import com.lottery.util.LotteryUtils;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author duonghung1269
 */
//@ComponentScan()
@Component
//@Configuration
public class MainLotteryForm extends javax.swing.JFrame {

    private static final Logger LOGGER = Logger.getLogger(MainLotteryForm.class);
    
    private List<Integer> inputNumbers = new ArrayList<>();
    private GridBagConstraints c = new GridBagConstraints();
    private List<TicketTable> dbTicketTables = new ArrayList<>();
    private Set<TicketTable> winTicketTables = new HashSet<>();
    
    @Autowired
    private BuyerService buyerService;

    @Autowired
    private TicketTableService ticketTableService;

    /**
     * Creates new form MainLotteryForm
     */
    public MainLotteryForm() {

    }

    public void init() {
        initComponents();
        setTitle("Lottery");
//        ballNumbersPanel.setLayout(new BoxLayout(ballNumbersPanel, BoxLayout.Y_AXIS));
        ballNumbersPanel.setLayout(new GridBagLayout());
        ballNumbersPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//        c.fill = GridBagConstraints.HORIZONTAL;
        
        tfBuyerName.setFocusable(true);
        tfBuyerName.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfBuyerName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfBuyerIc = new javax.swing.JTextField();
        btnBuyTicket = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        inputNumberTf = new javax.swing.JTextField();
        submitInputBtn = new javax.swing.JButton();
        ballNumbersPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buyer Information"));

        jLabel1.setText("Name");

        jLabel2.setText("IC No.");

        btnBuyTicket.setText("Buy");
        btnBuyTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyTicketActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfBuyerName)
                    .addComponent(tfBuyerIc))
                .addContainerGap(573, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBuyerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfBuyerIc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnBuyTicket))
                .addContainerGap(608, Short.MAX_VALUE))
        );

        btnBuyTicket.getAccessibleContext().setAccessibleName("btnBuyTicket");

        jTabbedPane2.addTab("Ticket", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Check Winner"));

        jLabel5.setText("Number");

        submitInputBtn.setText("Add");
        submitInputBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitInputBtnActionPerformed(evt);
            }
        });

        ballNumbersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ball Numbers"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Winners"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(submitInputBtn))
                    .addComponent(ballNumbersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitInputBtn))
                .addGap(33, 33, 33)
                .addComponent(ballNumbersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Draw", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        tfBuyerName.setText("");
        tfBuyerIc.setText("");
        tfBuyerName.requestFocusInWindow();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBuyTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyTicketActionPerformed
        if (StringUtils.isBlank(tfBuyerName.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Buyer name is blank!");
            tfBuyerName.requestFocusInWindow();
            return;
        }
        
        int dialogResult = JOptionPane.showConfirmDialog (this, "Would You Like to generate ticket for: " + tfBuyerName.getText() + "?","Warning", JOptionPane.YES_OPTION);
        if(dialogResult == JOptionPane.NO_OPTION){
            return;
        }
        
        Date today = new Date();
        Date startDate = LotteryUtils.getNextDate(today);

        int startDay = LotteryUtils.getDayOfMonth(startDate);
        int maxDayOfMonth = LotteryUtils.getLastDayOfMonth(startDate);

        buyerService.getAll();

        Buyer buyer = new Buyer();
        buyer.setName(tfBuyerName.getText().trim());
        buyer.setIc(tfBuyerIc.getText().trim());        

        List<String> linesBallsDb = new ArrayList<>();
        List<Ticket> newTickets = new ArrayList<>();
        Date queryDate = startDate;
        try {
            for (int dayOfMonth = startDay; dayOfMonth <= maxDayOfMonth; dayOfMonth++) {

                List<TicketTable> ticketTables = ticketTableService.getByDate(queryDate);
                linesBallsDb = LotteryUtils.getAllLinesBalls(ticketTables);
                Ticket newTicket = LotteryUtils.generateTicket(linesBallsDb, queryDate);
                newTicket.setBuyer(buyer);
                newTickets.add(newTicket);
                queryDate = LotteryUtils.getNextDate(queryDate);

            }
            
            buyer.setTickets(newTickets);
            buyerService.saveOrUpdate(buyer);
            JOptionPane.showMessageDialog(this, "Generate ticket successfully for " + tfBuyerName.getText() + "!");
            
            btnResetActionPerformed(null);
        } catch (LotteryException ex) {
            LOGGER.error("Generate ticket exception: ", ex);
            JOptionPane.showMessageDialog(this, "Please help to try again!");
        } catch (Exception ex2) {
            LOGGER.error("Generate ticket exception: ", ex2);
            JOptionPane.showMessageDialog(this, "Something goes wrong! Please try again or report to administrator!");
        }

    }//GEN-LAST:event_btnBuyTicketActionPerformed


    private void submitInputBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitInputBtnActionPerformed
        try {
            Integer number = Integer.parseInt(inputNumberTf.getText());
            if (inputNumbers.contains(number)) {
                JOptionPane.showMessageDialog(this, "Number has already existed!");
                return;
            }
            
            JLabel numberLbl = new JLabel(number + "");
            numberLbl.setOpaque(true);
            //numberLbl.setMinimumSize(new Dimension(100, 100));
    //        numberLbl.setPreferredSize(new Dimension(400, 100));
    //        numberLbl.setBackground(Color.white);
            numberLbl.setForeground(Color.red);
            setFont(numberLbl.getFont().deriveFont(150f));
            numberLbl.setFont(new Font("Serif", Font.PLAIN, 30));
            
            
            int numberOfInput = inputNumbers.size();
            int row = numberOfInput / 5;
            int col = numberOfInput % 5;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = col;
            c.gridy = row;                  
            c.weightx = 0.5;
            ballNumbersPanel.add(numberLbl, c);
            
            inputNumbers.add(number);
            
            ballNumbersPanel.revalidate();
            ballNumbersPanel.repaint();
            
            inputNumberTf.setText("");
            inputNumberTf.requestFocusInWindow();
            
            // check if has winner
            Date today = LotteryUtils.getNextDate(new Date());
            if (dbTicketTables.isEmpty()) {
                dbTicketTables = ticketTableService.getByDate(today);
            }
            
            if (inputNumbers.size() < 8) {
                return;
            }
            
            winTicketTables.addAll(LotteryUtils.isWinner(dbTicketTables, inputNumbers));
            
            if (winTicketTables.size() > 0) {
                // update table list view
                JOptionPane.showMessageDialog(this, "Number of winner: " + winTicketTables.size());
            }
            
        } catch (NumberFormatException ex) {
            LOGGER.error("Generate ticket exception: ", ex);
            JOptionPane.showMessageDialog(this, "Invalid number!");
        }
        
    }//GEN-LAST:event_submitInputBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainLotteryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainLotteryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainLotteryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainLotteryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

//        String[] contextPaths = new String[]{"/applicationContext.xml"};
//        ApplicationContext context = new ClassPathXmlApplicationContext(contextPaths);
//        MainLotteryForm form = context.getBean(MainLotteryForm.class);  
//        MainLotteryForm form = new MainLotteryForm();
//        form.setVisible(true);
//        form.init();
//        System.out.print(form.buyerService);
//        System.out.print(form.buyerService);
//        System.out.print("");

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String[] contextPaths = new String[]{"/applicationContext.xml"};
                ApplicationContext context = new ClassPathXmlApplicationContext(contextPaths);
                MainLotteryForm form = context.getBean(MainLotteryForm.class);
                form.setVisible(true);
                form.init();
                System.out.print(form.buyerService);
                System.out.print(form.buyerService);
//                new MainLotteryForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ballNumbersPanel;
    private javax.swing.JButton btnBuyTicket;
    private javax.swing.JButton btnReset;
    private javax.swing.JTextField inputNumberTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton submitInputBtn;
    private javax.swing.JTextField tfBuyerIc;
    private javax.swing.JTextField tfBuyerName;
    // End of variables declaration//GEN-END:variables
}
