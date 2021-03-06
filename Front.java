 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NormalDistribution;

import static NormalDistribution.Compute.getGraph;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Toothless
 */
public class Front extends javax.swing.JFrame {
    private int tabHeight;
    private int tabWidth;
     
    /**
     * Creates new form Front
     */
    public Front() {
        initComponents();
        jPanel3.setVisible(false);
        hideErrorsElements();
        hideResults();
        this.setSize(800, 720);
        tabHeight = 423;
        tabWidth = 814;
    }
    public void pasteGraph(ChartPanel chartPanel){
        graphPanel.removeAll();
        graphPanel.add(chartPanel);
        graphPanel.setSize(tabWidth-35,tabHeight-50);
        chartPanel.setPreferredSize(new java.awt.Dimension(tabWidth-35,tabHeight-50));
        chartPanel.setVisible(true);
        graphPanel.setVisible(true);
    }
    public void pasteTable(){
        zTable.removeAll();
        JTable zRawTable = new JTable(Compute.generatedRows,Compute.colHeaderArray);
        zRawTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane tablePane = new JScrollPane(zRawTable);
        tablePane.setSize(tabWidth-35,tabHeight-45);
        tablePane.setVisible(true);
        zTable.add(tablePane);
        zTable.setSize(tabWidth-35,tabHeight-45);
        zTable.setVisible(true);  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        meanValue = new javax.swing.JTextField();
        x2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        x1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sdValue = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        zTableEnd = new javax.swing.JTextField();
        zTableStart = new javax.swing.JTextField();
        numericalMethod = new javax.swing.JComboBox<>();
        areaType = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        results = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        errors = new javax.swing.JTextArea();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        resultPane = new javax.swing.JTabbedPane();
        graphPanel = new javax.swing.JPanel();
        zTable = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Statistical Model - Generator");
        setResizable(false);

        jLabel5.setText("Statistical Model - Generator");

        jLabel1.setText("Input Mean: ");

        jLabel4.setText("X2 (Optional): ");

        jButton3.setText("Compute");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        meanValue.setColumns(3);
        meanValue.setToolTipText("");
        meanValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meanValueActionPerformed(evt);
            }
        });

        x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x2ActionPerformed(evt);
            }
        });

        jLabel3.setText("X1: ");

        x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Input Standard Deviation: ");

        sdValue.setToolTipText("");
        sdValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdValueActionPerformed(evt);
            }
        });

        jLabel6.setText("Z-Table Start:");

        jLabel7.setText("Z-Table End:");

        zTableEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zTableEndActionPerformed(evt);
            }
        });

        zTableStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zTableStartActionPerformed(evt);
            }
        });

        numericalMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Numerical Method --", "Trapezoidal Rule", "Rectengular Rule" }));
        numericalMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericalMethodActionPerformed(evt);
            }
        });

        areaType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Area Type --", "Above X1", "Below X1", "Above X1 AND Below X2", "Below X1 AND Above X2" }));
        areaType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator6)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(meanValue)
                                    .addComponent(x1)
                                    .addComponent(x2))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(6, 6, 6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(zTableStart, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(zTableEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(sdValue)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel5)))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numericalMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(areaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meanValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(sdValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(zTableStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(x2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(zTableEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numericalMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        meanValue.getAccessibleContext().setAccessibleName("");

        results.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        errors.setColumns(20);
        errors.setForeground(new java.awt.Color(255, 0, 0));
        errors.setRows(5);
        jScrollPane1.setViewportView(errors);

        results.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 50, 270, 192));
        results.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, 761, 16));

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Please correct the following errors.");
        results.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel9.setText("jLabel9");
        results.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel10.setText("jLabel10");
        results.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel11.setText("jLabel11");
        results.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        resultPane.addTab("Normal Distribution Graph", graphPanel);

        javax.swing.GroupLayout zTableLayout = new javax.swing.GroupLayout(zTable);
        zTable.setLayout(zTableLayout);
        zTableLayout.setHorizontalGroup(
            zTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        zTableLayout.setVerticalGroup(
            zTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        resultPane.addTab("Z-Table", zTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(resultPane, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(resultPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(127, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(results, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(results, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(559, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(266, 266, 266)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meanValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meanValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meanValueActionPerformed

    private void sdValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdValueActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void numericalMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numericalMethodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numericalMethodActionPerformed

    private void areaTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaTypeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ArrayList packedObject = packObject();
        DataFilter dataFilter = new DataFilter();  
        if(dataFilter.validateData(packedObject)){
           hideErrorsElements();  
           Compute.setMean(Double.parseDouble(meanValue.getText()));
           Compute.setSd(Double.parseDouble(sdValue.getText()));
           Compute.setAreaType(areaType.getSelectedIndex());
           Compute.setNumericalMethod(numericalMethod.getSelectedIndex());
           Compute.setZStart(Double.parseDouble(zTableStart.getText()));
           Compute.setZEnd(Double.parseDouble(zTableEnd.getText()));
           Compute.setX1(Double.parseDouble(x1.getText()));
           if(dataFilter.isDouble(x2)){
                Compute.setX2(Double.parseDouble(x2.getText()));
           }
           errors.setText("");
           Compute processorInit = new Compute();
           processorInit.getGraph(processorInit.getMean(),processorInit.getSd());  
           processorInit.getTable();
           this.pasteTable();
           showResults(processorInit.getSelectedArea());
        }
        else{
            hideResults();
            showErrorsElements();
            showErrors(dataFilter.getErrors().listIterator());
            dataFilter.emptyErrors();
        }
       
       
    }//GEN-LAST:event_jButton3ActionPerformed
    private void showErrors(ListIterator errorArray){
       if(!("").equals(errors.getText())){
           errors.setText("");
       }
       while(errorArray.hasNext()){
           errors.append(errorArray.next().toString()+"\n");
       }
       
       
    }
    private void showResults(double area){
        resultPane.setSelectedIndex(0);
        resultPane.setVisible(true);
        jSeparator8.setVisible(true);
        jLabel9.setText("Results");
        jLabel10.setText("Numerical Method: "+numericalMethod.getSelectedItem().toString());
        jLabel11.setText("Calculated Area: "+Math.round(area*10000.0000)/10000.0000);
        jLabel9.setVisible(true);
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jPanel3.setVisible(true);
    }
    private void hideResults(){
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jSeparator8.setVisible(false);
    }
    private void showErrorsElements(){
        jScrollPane1.setVisible(true);
        jSeparator8.setVisible(true);
        jLabel8.setVisible(true);
    }
    private void hideErrorsElements(){
        jSeparator8.setVisible(false);
        jScrollPane1.setVisible(false);
        jLabel8.setVisible(false);
    }
    private void x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x1ActionPerformed

    private void x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x2ActionPerformed

    private void zTableEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zTableEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zTableEndActionPerformed

    private void zTableStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zTableStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zTableStartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Front.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Front().setVisible(true);
            }
        });
    }
public ArrayList packObject(){
    ArrayList inputDataObject = new ArrayList();
    Front fE = Main.frontEnd; //fE = Front End Data Object
    inputDataObject.add(fE.meanValue);
    inputDataObject.add(fE.sdValue);
    inputDataObject.add(fE.x1);
    inputDataObject.add(fE.x2);
    inputDataObject.add(fE.zTableStart);
    inputDataObject.add(fE.zTableEnd);
    inputDataObject.add(fE.numericalMethod);
    inputDataObject.add(fE.areaType);
    return inputDataObject;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> areaType;
    private javax.swing.JTextArea errors;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField meanValue;
    private javax.swing.JComboBox<String> numericalMethod;
    private javax.swing.JTabbedPane resultPane;
    private javax.swing.JPanel results;
    private javax.swing.JTextField sdValue;
    private javax.swing.JTextField x1;
    private javax.swing.JTextField x2;
    private javax.swing.JPanel zTable;
    private javax.swing.JTextField zTableEnd;
    private javax.swing.JTextField zTableStart;
    // End of variables declaration//GEN-END:variables
}

