/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whack_a_mole;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.*;
import java.text.*;


/**
 *
 * @author khatri
 */
public class newGame extends javax.swing.JDialog {

    /**
     * Creates new form newGame
     */
    int cHitMole;
    
    int tmeStart;
    int[] moles=new int[9];
    HashMap<Integer, Integer> hMole = new HashMap<Integer, Integer>();
    
    Timer time;
    module m=new module();
    int rand;
    int score=0;
    int[] top=new int[3];
    public newGame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        m.conn();
        
        //Initializa start up
        btnStop.setEnabled(false);
        btnEmail.setEnabled(false);
        txtEmail.setEnabled(false);
        setTopMole();
        time=new Timer(800,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
             {   
                 lblTime.setText("Time: "+tmeStart);
                 //System.out.println(m.gRandom());
                 rand=m.gRandom();
                 switch(rand)
                 {
                     case 1:
                         btnMole1.setBackground(Color.RED);
                         
                     break;
                     case 2:
                         btnMole2.setBackground(Color.RED);
                     break;
                     case 3:
                         btnMole3.setBackground(Color.RED);
                     break;
                     case 4:
                         btnMole4.setBackground(Color.RED);
                     break;
                     case 5:
                         btnMole5.setBackground(Color.RED);
                     break;
                     case 6:
                         btnMole6.setBackground(Color.RED);
                     break;
                     case 7:
                         btnMole7.setBackground(Color.RED);
                     break;
                     case 8:
                         btnMole8.setBackground(Color.RED);
                     break;
                     case 9:
                         btnMole9.setBackground(Color.RED);
                     break;
                 }
                 moleCond(rand);
                 
                 
                 
                 tmeStart-=1;
                 if(tmeStart<0)
                 {
                     time.stop();
                    gameExpried();
                     
                 }
             }

            
        });
        
    }
    private void gameExpried()
    {
        for(int i=0;i<moles.length;i++)
                     {
                         //System.out.println("Mole "+(i+1)+": "+moles[i]);
                        //Most common hits,mole number
                         hMole.put(moles[i],(i+1));
                     }
                    Map<Integer, Integer> map = new HashMap();
                    map.clear();
                    map=module.sortByComparator(hMole);
                    for(Map.Entry top:map.entrySet())
                    {
                        //System.out.println("Key : "+top.getKey()+" Value : "+top.getValue());
                        cHitMole=Integer.parseInt(top.getValue().toString());
                        break;
                    }
                  //  System.out.println("Most Common Hit"+cHitMole);
                     //Insert query goes here
                    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                    Date dateObj = new Date();
                    
                     m.storeGameRecord(txtUser.getText(), txtEmail.getText(), df.format(dateObj).toString(), score, cHitMole);
                     lblTime.setText("Time: ");
                     resetMoles();
                     m.fetchTop3(tbTop3);
                     setTopMole();
                     
                     //reseting Startup
                     btnStart.setEnabled(true);
                     btnStop.setEnabled(false);
                     txtEmail.setEnabled(true);
                     btnEmail.setEnabled(true);
    }
   private void setTopMole()
   {
       //returning Top 3 Moles
        top=m.mostHitMole(top);
       //Setting Top 3 Moles to Buttons
        btnTop1.setText(String.valueOf(top[0]));
        btnTop2.setText(String.valueOf(top[1]));
        btnTop3.setText(String.valueOf(top[2]));
   }
    

    public void moleCond(int mole)
    {
        resetMoles();
        switch(mole)
                 {
                     case 1:
                         btnMole1.setBackground(Color.RED);
                     
                     break;
                     case 2:
                         btnMole2.setBackground(Color.RED);
                     break;
                     case 3:
                         btnMole3.setBackground(Color.RED);
                     break;
                     case 4:
                         btnMole4.setBackground(Color.RED);
                     break;
                     case 5:
                         btnMole5.setBackground(Color.RED);
                     break;
                     case 6:
                         btnMole6.setBackground(Color.RED);
                     break;
                     case 7:
                         btnMole7.setBackground(Color.RED);
                     break;
                     case 8:
                         btnMole8.setBackground(Color.RED);
                     break;
                     case 9:
                         btnMole9.setBackground(Color.RED);
                     break;
                 }
    }
    
    public void resetMoleCount()
    {
        for(int i=0;i<moles.length;i++)
        {
             moles[i]=0;
        }
    }
    
    public void resetMoles()
    {
        btnMole1.setBackground(null);
        btnMole2.setBackground(null);
        btnMole3.setBackground(null);
        btnMole4.setBackground(null);
        btnMole5.setBackground(null);
        btnMole6.setBackground(null);
        btnMole7.setBackground(null);
        btnMole8.setBackground(null);
        btnMole9.setBackground(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUserPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnEmail = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblPoints = new javax.swing.JLabel();
        btnMole1 = new javax.swing.JButton();
        btnMole2 = new javax.swing.JButton();
        btnMole3 = new javax.swing.JButton();
        btnMole4 = new javax.swing.JButton();
        btnMole5 = new javax.swing.JButton();
        btnMole6 = new javax.swing.JButton();
        btnMole7 = new javax.swing.JButton();
        btnMole8 = new javax.swing.JButton();
        btnMole9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTop3 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnTop1 = new javax.swing.JButton();
        btnTop2 = new javax.swing.JButton();
        btnTop3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Play Whack-a-mole Game");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jUserPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("User Information"));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Username :");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Email ID :");

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnEmail.setText("Email Score");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jUserPanelLayout = new javax.swing.GroupLayout(jUserPanel);
        jUserPanel.setLayout(jUserPanelLayout);
        jUserPanelLayout.setHorizontalGroup(
            jUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jUserPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jUserPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(jUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jUserPanelLayout.createSequentialGroup()
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnEmail)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jUserPanelLayout.setVerticalGroup(
            jUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(428, 428, 428))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Play Game"));

        lblTime.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblTime.setText("Time :");

        lblPoints.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPoints.setText("Points :");

        btnMole1.setText("1");
        btnMole1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMole1ActionPerformed(evt);
            }
        });

        btnMole2.setText("2");
        btnMole2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMole2ActionPerformed(evt);
            }
        });

        btnMole3.setText("3");
        btnMole3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMole3ActionPerformed(evt);
            }
        });

        btnMole4.setText("4");
        btnMole4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMole4ActionPerformed(evt);
            }
        });

        btnMole5.setText("5");
        btnMole5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMole5ActionPerformed(evt);
            }
        });

        btnMole6.setText("6");
        btnMole6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMole6ActionPerformed(evt);
            }
        });

        btnMole7.setText("7");
        btnMole7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMole7ActionPerformed(evt);
            }
        });

        btnMole8.setText("8");
        btnMole8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMole8ActionPerformed(evt);
            }
        });

        btnMole9.setText("9");
        btnMole9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMole9ActionPerformed(evt);
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
                        .addComponent(lblPoints)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTime)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnMole7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnMole8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnMole9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMole4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMole1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnMole2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(btnMole3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnMole5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(btnMole6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPoints)
                    .addComponent(lblTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMole1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMole2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMole3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMole4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMole5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMole6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMole7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMole8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMole9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Top 3 Players"));

        tbTop3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Points", "Most Common Hit "
            }
        ));
        jScrollPane1.setViewportView(tbTop3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Top 3 Most Hit Moles"));

        btnTop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTop1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTop1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnTop2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnTop3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTop1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTop2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTop3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        if(txtUser.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please Enter Username");
            txtUser.requestFocus();
        }
        else
        {   
            score=0;
            lblPoints.setText("Points: ");
            resetMoleCount();
            lblTime.setText("Time: ");
            hMole.clear();
            
            tmeStart=20;
            
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
            btnEmail.setEnabled(true);
            
            btnMole1.requestFocus();
            time.start();
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        time.stop();
        gameExpried();
        
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnMole1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMole1ActionPerformed
        // TODO add your handling code here:
        if(btnMole1.getBackground()==Color.RED)
        {
            score+=1;
            lblPoints.setText("Points: "+score);
            moles[0]+=1;
        }
    }//GEN-LAST:event_btnMole1ActionPerformed

    private void btnMole2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMole2ActionPerformed
        // TODO add your handling code here:
        if(btnMole2.getBackground()==Color.RED)
        {
            score+=1;
            lblPoints.setText("Points: "+score);
            moles[1]+=1;
        }
    }//GEN-LAST:event_btnMole2ActionPerformed

    private void btnMole3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMole3ActionPerformed
        // TODO add your handling code here:
        if(btnMole3.getBackground()==Color.RED)
        {
            score+=1;
            lblPoints.setText("Points: "+score);
            moles[2]+=1;
        }
    }//GEN-LAST:event_btnMole3ActionPerformed

    private void btnMole4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMole4ActionPerformed
        // TODO add your handling code here:
        if(btnMole4.getBackground()==Color.RED)
        {
            score+=1;
            lblPoints.setText("Points: "+score);
            moles[3]+=1;
        }
    }//GEN-LAST:event_btnMole4ActionPerformed

    private void btnMole5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMole5ActionPerformed
        // TODO add your handling code here:
        if(btnMole5.getBackground()==Color.RED)
        {
            score+=1;
            lblPoints.setText("Points: "+score);
            moles[4]+=1;
        }
    }//GEN-LAST:event_btnMole5ActionPerformed

    private void btnMole6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMole6ActionPerformed
        // TODO add your handling code here:
        if(btnMole6.getBackground()==Color.RED)
        {
            score+=1;
            lblPoints.setText("Points: "+score);
            moles[5]+=1;
        }
    }//GEN-LAST:event_btnMole6ActionPerformed

    private void btnMole7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMole7ActionPerformed
        // TODO add your handling code here:
        if(btnMole7.getBackground()==Color.RED)
        {
            score+=1;
            lblPoints.setText("Points: "+score);
            moles[6]+=1;
        }
    }//GEN-LAST:event_btnMole7ActionPerformed

    private void btnMole8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMole8ActionPerformed
        // TODO add your handling code here:
        if(btnMole8.getBackground()==Color.RED)
        {
            score+=1;
            lblPoints.setText("Points: "+score);
            moles[7]+=1;
        }
    }//GEN-LAST:event_btnMole8ActionPerformed

    private void btnMole9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMole9ActionPerformed
        // TODO add your handling code here:
        if(btnMole9.getBackground()==Color.RED)
        {
            score+=1;
            lblPoints.setText("Points: "+score);
            moles[8]+=1;
        }
    }//GEN-LAST:event_btnMole9ActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        // TODO add your handling code here:
        
        if(m.validEmail(txtEmail.getText())==false)
        {
            JOptionPane.showMessageDialog(null, "Invalid Email Address","Error",JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
        }
        else
        {
            m.sentMail(txtEmail.getText(), lblPoints.getText());
        }
    }//GEN-LAST:event_btnEmailActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        m.fetchTop3(tbTop3);
    }//GEN-LAST:event_formWindowOpened

    private void btnTop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTop1ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_btnTop1ActionPerformed

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
            java.util.logging.Logger.getLogger(newGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                newGame dialog = new newGame(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnMole1;
    private javax.swing.JButton btnMole2;
    private javax.swing.JButton btnMole3;
    private javax.swing.JButton btnMole4;
    private javax.swing.JButton btnMole5;
    private javax.swing.JButton btnMole6;
    private javax.swing.JButton btnMole7;
    private javax.swing.JButton btnMole8;
    private javax.swing.JButton btnMole9;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnTop1;
    private javax.swing.JButton btnTop2;
    private javax.swing.JButton btnTop3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jUserPanel;
    private javax.swing.JLabel lblPoints;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTable tbTop3;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
