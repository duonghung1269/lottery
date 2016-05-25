/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lottery.gui;

import com.lottery.exception.LotteryException;
import com.lottery.model.Buyer;
import com.lottery.model.DrawResult;
import com.lottery.model.Ticket;
import com.lottery.model.TicketTable;
import com.lottery.service.BuyerService;
import com.lottery.service.DrawResultService;
import com.lottery.service.TicketTableService;
import com.lottery.util.LotteryUtils;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private Set<TicketTable> checkWinnersTicketTables = new HashSet<>();
    private static final int NO_NUMBER_PER_ROW = 10;
    private List<JLabel> lbNumbers = new ArrayList<>();
    private int totalDrawedNumbers = 0;
    private boolean isGameRunning = false;
    private Date drawDate = new Date();
    
//    private JLabel lbDrawDate;
//    private JFormattedTextField tfDrawDate;
//    private JLabel lbRound;
//    private JComboBox cbbRound;
    
    @Autowired
    private BuyerService buyerService;

    @Autowired
    private TicketTableService ticketTableService;
    
    @Autowired
    private DrawResultService drawResultService;

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
        
        WinnerTableModel model = new WinnerTableModel();
        model.setData(winTicketTables);
        tblWinners.setModel(model);
        
        WinnerTableModel checkWinnerModel = new WinnerTableModel();
        checkWinnerModel.setData(checkWinnersTicketTables);
        tblCheckWinners.setModel(checkWinnerModel);
        
        // set default date to next day
        Date today = new Date();
        try {
            ftfBuyStartDate.setText(LotteryUtils.getDateStr(LotteryUtils.getNextDate(today)));
        } catch (ParseException ex) {
            LOGGER.error("Can parse date to string: " + today);
        }
        
        resetGame();
//        pnStart.setLayout(new GridBagLayout());
//        pnStart.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//        DateFormat format = new SimpleDateFormat("yyyy--MMMM--dd");
//        GridBagConstraints pnStartConstraint = new GridBagConstraints();
//        pnStartConstraint.fill = GridBagConstraints.HORIZONTAL;
//        
//        lbDrawDate = new JLabel("Date");
//        pnStartConstraint.gridx = 0;
//        pnStartConstraint.gridy = 0;
//        pnStart.add(lbDrawDate, pnStartConstraint);
//                        
//        tfDrawDate = new JFormattedTextField(format);
          
//        pnStartConstraint.gridx = 1;
//        pnStartConstraint.gridy = 0;
//        pnStart.add(tfDrawDate, pnStartConstraint);
    }

    private void resetGame() {        
        setPanelEnabled(pnInput, false);
        setPanelEnabled(pnSettings, true);
        
        isGameRunning = false;
        inputNumbers.clear();
        totalDrawedNumbers = 0;
        checkCanAddNumber();
        checkUndoable();                       
        
        winTicketTables.clear();
        refreshWinnerTable();
        lbNumbers.clear();
        dbTicketTables.clear();
        ballNumbersPanel.removeAll();
        ballNumbersPanel.revalidate();
        ballNumbersPanel.repaint();
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
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ftfBuyStartDate = new javax.swing.JFormattedTextField();
        tfBuyerIc = new javax.swing.JTextField();
        tfBuyerName = new javax.swing.JTextField();
        btnBuyTicket = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ballNumbersPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWinners = new javax.swing.JTable();
        pnSettings = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ftfDrawDate = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cbbRound = new javax.swing.JComboBox<String>();
        btnStart = new javax.swing.JButton();
        btnReplay = new javax.swing.JButton();
        pnInput = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnUndo = new javax.swing.JButton();
        btnAddNumber = new javax.swing.JButton();
        inputNumberTf = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbCheckRound = new javax.swing.JComboBox();
        ftfDrawedDate = new javax.swing.JFormattedTextField();
        btnCheckWinners = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCheckWinners = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buyer Information"));

        jLabel1.setText("Name");

        jLabel2.setText("IC No.");

        jLabel6.setText("Start Date");

        ftfBuyStartDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        ftfBuyStartDate.setToolTipText("dd/MM/yyyy");

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftfBuyStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBuyTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfBuyerName)
                            .addComponent(tfBuyerIc, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBuyerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfBuyerIc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ftfBuyStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnBuyTicket))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnBuyTicket.getAccessibleContext().setAccessibleName("btnBuyTicket");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(486, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(602, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Ticket", jPanel8);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Check Winner"));

        ballNumbersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ball Numbers"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Winners"));

        tblWinners.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblWinners);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnSettings.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));

        jLabel3.setText("Date");

        ftfDrawDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        ftfDrawDate.setToolTipText("dd/MM/yyyy");

        jLabel4.setText("Round");

        cbbRound.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));

        btnStart.setLabel("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnReplay.setText("Replay");
        btnReplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSettingsLayout = new javax.swing.GroupLayout(pnSettings);
        pnSettings.setLayout(pnSettingsLayout);
        pnSettingsLayout.setHorizontalGroup(
            pnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(pnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSettingsLayout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(18, 18, 18)
                        .addComponent(btnReplay, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfDrawDate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(587, Short.MAX_VALUE))
        );
        pnSettingsLayout.setVerticalGroup(
            pnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSettingsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ftfDrawDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(btnReplay)))
        );

        pnInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));

        jLabel5.setText("Number");

        btnUndo.setLabel("Undo");
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        btnAddNumber.setText("Add");
        btnAddNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNumberActionPerformed(evt);
            }
        });

        inputNumberTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputNumberTfKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnInputLayout = new javax.swing.GroupLayout(pnInput);
        pnInput.setLayout(pnInputLayout);
        pnInputLayout.setHorizontalGroup(
            pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(24, 24, 24)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnInputLayout.createSequentialGroup()
                        .addComponent(btnAddNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUndo))
                    .addComponent(inputNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        pnInputLayout.setVerticalGroup(
            pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputNumberTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNumber)
                    .addComponent(btnUndo))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ballNumbersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ballNumbersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Draw", jPanel2);

        jPanel5.setToolTipText("dd/MM/yyyy");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Query"));

        jLabel9.setText("Drawed Date");

        jLabel10.setText("Round");

        cbbCheckRound.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));

        ftfDrawedDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        ftfDrawedDate.setToolTipText("dd/MM/yyyy");

        btnCheckWinners.setText("Check");
        btnCheckWinners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckWinnersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCheckWinners)
                    .addComponent(ftfDrawedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbCheckRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ftfDrawedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbCheckRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(btnCheckWinners)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Winners"));

        tblCheckWinners.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCheckWinners);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Winner", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2))
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("Winner");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        tfBuyerName.setText("");
        tfBuyerIc.setText("");
        tfBuyerName.requestFocusInWindow();
        ftfBuyStartDate.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBuyTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyTicketActionPerformed
        if (StringUtils.isBlank(tfBuyerName.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Buyer name is blank!");
            tfBuyerName.requestFocusInWindow();
            return;
        }
        
        if (StringUtils.isBlank(ftfBuyStartDate.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Start date is invalid (dd/MM/yyyy)!");
            ftfBuyStartDate.requestFocusInWindow();
            return;
        }
        
        Date startDate = null;
        
        try {
            startDate = LotteryUtils.getDate(ftfBuyStartDate.getText().trim());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Start date is invalid (dd/MM/yyyy)!");
            ftfBuyStartDate.requestFocusInWindow();
            LOGGER.error(ex);
            return;
        }
        
        Date targetDate = LotteryUtils.getTargetDate(startDate);
        
        Date today = new Date();
        if (today.after(startDate)) {
            JOptionPane.showMessageDialog(this, "Start date must be greater than today!");
            tfBuyerName.requestFocusInWindow();
            return;
        }
        
        int dialogResult = JOptionPane.showConfirmDialog (this, "Would You Like to generate ticket for: " + tfBuyerName.getText() + "?","Warning", JOptionPane.YES_OPTION);
        if(dialogResult == JOptionPane.NO_OPTION){
            return;
        }
        
//        Date today = new Date();
//        Date startDate = LotteryUtils.getNextDate(today);

//        int startDay = LotteryUtils.getDayOfMonth(startDate);
//        int maxDayOfMonth = LotteryUtils.getLastDayOfMonth(startDate);
//
//        buyerService.getAll();

        Buyer buyer = new Buyer();
        buyer.setName(tfBuyerName.getText().trim());
        buyer.setIc(tfBuyerIc.getText().trim());        

        List<String> linesBallsDb = new ArrayList<>();
        List<Ticket> newTickets = new ArrayList<>();
        Date queryDate = startDate;
        
        
        int count = 0;
        try {
//            for (int dayOfMonth = startDay; dayOfMonth <= maxDayOfMonth; dayOfMonth++) {
            for (; queryDate.before(targetDate); ) {

                List<TicketTable> ticketTables = ticketTableService.getByDate(queryDate);
                linesBallsDb = LotteryUtils.getAllLinesBalls(ticketTables);
                Ticket newTicket = LotteryUtils.generateTicket(linesBallsDb, queryDate, count++);
                newTicket.setBuyer(buyer);
                newTickets.add(newTicket);
                queryDate = LotteryUtils.getNextDate(queryDate);

            }
            
            
            
            buyer.setTickets(newTickets);
            
            LotteryUtils.generatePhysicalTicket(buyer, System.currentTimeMillis() + "_" + buyer.getName() + ".xls");
            
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


    private void btnAddNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNumberActionPerformed
        try {
            Integer number = Integer.parseInt(inputNumberTf.getText());
            if (inputNumbers.contains(number)) {
                JOptionPane.showMessageDialog(this, "Number has already existed!");
                return;
            }
            
            if (number > LotteryUtils.MAX_BALL_VALUE || number < LotteryUtils.MIN_BALL_VALUE) {
                JOptionPane.showMessageDialog(this, "Invalid range (" + LotteryUtils.MIN_BALL_VALUE + " - " + LotteryUtils.MAX_BALL_VALUE + ")!");
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
            int row = numberOfInput / NO_NUMBER_PER_ROW;
            int col = numberOfInput % NO_NUMBER_PER_ROW;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = col;
            c.gridy = row;                  
            c.weightx = 0.5;            
            ballNumbersPanel.add(numberLbl, c);
            lbNumbers.add(numberLbl);
            inputNumbers.add(number);
            
            ballNumbersPanel.revalidate();
            ballNumbersPanel.repaint();
            
            inputNumberTf.setText("");
            inputNumberTf.requestFocusInWindow();
            
//            // check if has winner
//            Date today = LotteryUtils.getNextDate(new Date());
//            if (dbTicketTables.isEmpty()) {
//                dbTicketTables = ticketTableService.getByDate(today);
//            }
            
            totalDrawedNumbers++;
            checkCanAddNumber();
            
            if (inputNumbers.size() < LotteryUtils.MAX_BALLS_PER_LINE) {
                return;
            }
            
            winTicketTables.addAll(LotteryUtils.getWinnerByLine(dbTicketTables, inputNumbers));
            
            if (winTicketTables.size() > 0) {                                                
                // update table list view
                refreshWinnerTable();
//                JOptionPane.showMessageDialog(this, "Number of winner: " + winTicketTables.size());
            }
            
            // check if has full table, then stop game
            if (totalDrawedNumbers >= (LotteryUtils.MAX_BALLS_PER_LINE * LotteryUtils.NO_LINES_PER_TABLE)) {
                Iterator<TicketTable> iter = winTicketTables.iterator();
                while (iter.hasNext()) {
                    TicketTable tmp = iter.next();
                    if (tmp.getWinType() == TicketTable.FULL_TABLE) {
                        String winnerMessage = "Congratulation!!" 
                                             + "\nName: " + tmp.getTicket().getBuyer().getName()
                                             + "\nS/N : " + tmp.getTicket().getSerialNumber();
                        JOptionPane.showMessageDialog(this, winnerMessage, "Full table winner!!", JOptionPane.INFORMATION_MESSAGE);
                        
                        // save draw results, update ticket_table winner
                        DrawResult drawResult = new DrawResult();
                        drawResult.setDrawDate(LotteryUtils.getDate(ftfDrawDate.getText().trim()));
                        drawResult.setDrawBalls(StringUtils.join(inputNumbers, LotteryUtils.BALLS_SEPARATOR));
                        drawResult.setRound(Byte.parseByte((String) cbbRound.getSelectedItem()));
                        
                        drawResultService.updateWinner(drawResult, winTicketTables);
                        restartGame();
                        
                        return;
                    }
                }
            }
            
        } catch (NumberFormatException ex) {
            LOGGER.error("Invalid number!: ", ex);
            JOptionPane.showMessageDialog(this, "Invalid number!");
        } catch (ParseException ex) {
            LOGGER.error("Cant parse date", ex);
            JOptionPane.showMessageDialog(this, "Cant save result!");
        }
        
    }//GEN-LAST:event_btnAddNumberActionPerformed

    private void refreshWinnerTable() {
        WinnerTableModel model = (WinnerTableModel) tblWinners.getModel();
        model.setData(winTicketTables);
        model.fireTableDataChanged();
    }
    
    private void refreshCheckWinnerTable() {
        WinnerTableModel model = (WinnerTableModel) tblCheckWinners.getModel();
        model.setData(checkWinnersTicketTables);
        model.fireTableDataChanged();
    }
    
    private void checkUndoable() {
        if (totalDrawedNumbers == 0) {
            btnUndo.setEnabled(false);
        } else {
            btnUndo.setEnabled(true);
        }
    }
    
    private void checkCanAddNumber() {
        if (!isGameRunning) {
            btnAddNumber.setEnabled(false);
            return;
        }
        
        if (totalDrawedNumbers >= LotteryUtils.MAX_BALL_VALUE) {
            btnAddNumber.setEnabled(false);
        } else {
            btnAddNumber.setEnabled(true);
        }
    }
    
    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
//        int totalDrawedNumbers = inputNumbers.size();
        if (totalDrawedNumbers == 0) {
            return;
        }
        
        inputNumbers.remove(totalDrawedNumbers - 1); // remove last number
        JLabel lastAddedLabel = lbNumbers.get(totalDrawedNumbers - 1);
        ballNumbersPanel.remove(lastAddedLabel);
        lbNumbers.remove(lastAddedLabel);
        
        ballNumbersPanel.revalidate();
        ballNumbersPanel.repaint();
        
        checkUndoable();
    }//GEN-LAST:event_btnUndoActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try {
            drawDate = LotteryUtils.getDate(ftfDrawDate.getText().trim());
            byte round = Byte.parseByte((String) cbbRound.getSelectedItem());
            
            DrawResult existedDrawResult = drawResultService.findBy(drawDate, round);
            if (existedDrawResult != null) {
                JOptionPane.showMessageDialog(this, "Already drawed on " + ftfDrawDate.getText().trim() + " for round " + round);
                return;
            }
            
            dbTicketTables = ticketTableService.getByDate(drawDate);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format: dd/MM/yyyy");
            ftfDrawDate.requestFocusInWindow();
            return;
        }
//        if (dbTicketTables.isEmpty()) {
//            dbTicketTables = ticketTableService.getByDate(today);
//        }
        
        Date today = LotteryUtils.getDateWithoutTime(new Date());

        if (drawDate.before(today)) {
            JOptionPane.showMessageDialog(this, "Draw date must be greater or equal than today!");
            ftfDrawDate.requestFocusInWindow();
            return;
        }

        setPanelEnabled(pnSettings, false);
        btnReplay.setEnabled(true);
        setPanelEnabled(pnInput, true);        
        isGameRunning = true;
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnReplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplayActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog (this, "Are you sure to restart the game?","Warning", JOptionPane.NO_OPTION);
        if(dialogResult == JOptionPane.NO_OPTION){
            return;
        }
        restartGame();
    }//GEN-LAST:event_btnReplayActionPerformed

    private void inputNumberTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNumberTfKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAddNumberActionPerformed(null);
        }
    }//GEN-LAST:event_inputNumberTfKeyPressed

    private void btnCheckWinnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckWinnersActionPerformed
        checkWinnersTicketTables.clear();
        Date drawedDate;
        try {
            drawedDate = LotteryUtils.getDate(ftfDrawedDate.getText().trim());
            byte round = Byte.parseByte((String) cbbCheckRound.getSelectedItem());
            checkWinnersTicketTables.addAll(ticketTableService.getWinners(drawedDate, round, TicketTable.FULL_TABLE));
            refreshCheckWinnerTable();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format: dd/MM/yyyy");
            ftfDrawedDate.requestFocusInWindow();
        }
        
    }//GEN-LAST:event_btnCheckWinnersActionPerformed

    private void restartGame() {
        resetGame();
    }
    
    private void gameOver() {
//        pnSettings
//        pnInput.setEnabled(false);
        isGameRunning = false;
    }
    
    private void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);
        

        for(int i = 0; i < panel.getComponents().length; i++) {
            JComponent component = (JComponent) panel.getComponents()[i];
            if(component.getClass().getName() == "javax.swing.JPanel") {
                setPanelEnabled((JPanel) component, isEnabled);
            }

            component.setEnabled(isEnabled);
        }
    }
    
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
    private javax.swing.JButton btnAddNumber;
    private javax.swing.JButton btnBuyTicket;
    private javax.swing.JButton btnCheckWinners;
    private javax.swing.JButton btnReplay;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnUndo;
    private javax.swing.JComboBox cbbCheckRound;
    private javax.swing.JComboBox<String> cbbRound;
    private javax.swing.JFormattedTextField ftfBuyStartDate;
    private javax.swing.JFormattedTextField ftfDrawDate;
    private javax.swing.JFormattedTextField ftfDrawedDate;
    private javax.swing.JTextField inputNumberTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel pnInput;
    private javax.swing.JPanel pnSettings;
    private javax.swing.JTable tblCheckWinners;
    private javax.swing.JTable tblWinners;
    private javax.swing.JTextField tfBuyerIc;
    private javax.swing.JTextField tfBuyerName;
    // End of variables declaration//GEN-END:variables
}
