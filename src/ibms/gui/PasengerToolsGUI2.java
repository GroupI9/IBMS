/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PasengerToolsGUI2.java
 *
 * Created on 10-May-2012, 15:27:14
 */

package ibms.gui;

import ibms.models.BusStop;
import ibms.wrappers.BusStopInfo;
import javax.swing.JComboBox;
import ibms.pathManager;
/**
 *
 * @author nunnerp0
 */
public class PasengerToolsGUI2 extends javax.swing.JFrame {

    /** Creates new form PasengerToolsGUI2 */
    private boolean loaded = false;
    pathManager paths = new pathManager();

    public PasengerToolsGUI2() {
        initComponents();
        paths.Initialize();
        setToAreas(this.cmbStartArea);
        setToAreas(this.cmbEndArea);
        setBusStops(this.cmbStartArea, this.cmbStartBS);
        setBusStops(this.cmbEndArea, this.cmbEndBS);
        loaded = true;
    }

    private void setToAreas(JComboBox a){
        a.removeAllItems();
        int areas[] = BusStopInfo.getAreas();
        for(int area : areas)
            a.addItem("" + BusStopInfo.getAreaName(area));

    }

    private void setBusStops(JComboBox a, JComboBox b){
        String currentArea = a.getSelectedItem().toString();
        int stops[] = BusStopInfo.getBusStopsInArea(BusStopInfo.findAreaByName(currentArea));
        b.removeAllItems();
        for(int stop : stops)
            b.addItem(new BusStop(stop));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSelection = new javax.swing.JPanel();
        cmbStartArea = new javax.swing.JComboBox();
        cmbEndArea = new javax.swing.JComboBox();
        lblStart = new javax.swing.JLabel();
        lblEnd = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblStop = new javax.swing.JLabel();
        cmbStartBS = new javax.swing.JComboBox();
        cmbEndBS = new javax.swing.JComboBox();
        btnGenerateRoute = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSelection.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Start and End Point"));

        cmbStartArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbStartArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbStartAreaMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbStartAreaMouseClicked(evt);
            }
        });
        cmbStartArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbStartAreaItemStateChanged(evt);
            }
        });
        cmbStartArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStartAreaActionPerformed(evt);
            }
        });
        cmbStartArea.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmbStartAreaInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        cmbStartArea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbStartAreaPropertyChange(evt);
            }
        });

        cmbEndArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEndArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEndAreaActionPerformed(evt);
            }
        });

        lblStart.setText("Start");

        lblEnd.setText("End");

        jLabel1.setText("Area");

        lblStop.setText("Bus Stop");

        cmbStartBS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEndBS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGenerateRoute.setText("Plan Route");
        btnGenerateRoute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerateRouteMouseClicked(evt);
            }
        });
        btnGenerateRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateRouteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSelectionLayout = new javax.swing.GroupLayout(pnlSelection);
        pnlSelection.setLayout(pnlSelectionLayout);
        pnlSelectionLayout.setHorizontalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStart)
                    .addComponent(lblEnd))
                .addGap(9, 9, 9)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(cmbStartArea, 0, 191, Short.MAX_VALUE)
                    .addComponent(cmbEndArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblStop)
                    .addComponent(cmbStartBS, 0, 193, Short.MAX_VALUE)
                    .addComponent(cmbEndBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(pnlSelectionLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(btnGenerateRoute)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        pnlSelectionLayout.setVerticalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectionLayout.createSequentialGroup()
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStartArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStart)
                    .addComponent(cmbStartBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEnd)
                                .addComponent(cmbEndArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbEndBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerateRoute))))
        );

        txtResult.setColumns(20);
        txtResult.setRows(5);
        jScrollPane1.setViewportView(txtResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addComponent(pnlSelection, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pnlSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbStartAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStartAreaActionPerformed
        // TODO add your handling code here:
        if(loaded)
            this.setBusStops(cmbStartArea, cmbStartBS);
    }//GEN-LAST:event_cmbStartAreaActionPerformed

    private void cmbStartAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbStartAreaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbStartAreaMouseClicked

    private void cmbStartAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbStartAreaMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbStartAreaMouseReleased

    private void cmbStartAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbStartAreaItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbStartAreaItemStateChanged

    private void cmbStartAreaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmbStartAreaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStartAreaInputMethodTextChanged

    private void cmbStartAreaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbStartAreaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStartAreaPropertyChange

    private void cmbEndAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEndAreaActionPerformed
        // TODO add your handling code here:
        if(loaded)
            this.setBusStops(cmbEndArea, cmbEndBS);
    }//GEN-LAST:event_cmbEndAreaActionPerformed

    private void btnGenerateRouteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateRouteMouseClicked
        // TODO add your handling code here:
        
        BusStop start = (BusStop) cmbStartBS.getItemAt(cmbStartBS.getSelectedIndex());
        BusStop end = (BusStop) cmbEndBS.getItemAt(cmbStartBS.getSelectedIndex());
        this.txtResult.setText(paths.findPath(start.getId(), end.getId()));
    }//GEN-LAST:event_btnGenerateRouteMouseClicked

    private void btnGenerateRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateRouteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerateRouteActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasengerToolsGUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateRoute;
    private javax.swing.JComboBox cmbEndArea;
    private javax.swing.JComboBox cmbEndBS;
    private javax.swing.JComboBox cmbStartArea;
    private javax.swing.JComboBox cmbStartBS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblStop;
    private javax.swing.JPanel pnlSelection;
    private javax.swing.JTextArea txtResult;
    // End of variables declaration//GEN-END:variables

}
