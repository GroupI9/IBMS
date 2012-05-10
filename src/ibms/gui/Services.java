/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StartGUI.java
 *
 * Created on 22-Mar-2012, 00:12:18
 */

package ibms.gui;
import ibms.*;
import java.util.*;
import ibms.wrappers.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author nunnerp0
 */
public class Services extends javax.swing.JFrame {

    public static Boolean created = false;
    public static String selectedArea;
    public static String selectedRoute;
    public static String selectedStop;
    //public static int day;
    public static int route = 65;
    public static String area = "216";
    public static int busStopID = 794;

    //public static String[] routes;
    
    /** Creates new form StartGUI */
    public Services() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        routesCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        areasCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        stopsCombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jScrollBar1 = new javax.swing.JScrollBar();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel2.setText("Route");

        routesCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        routesCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                routesComboItemStateChanged(evt);
            }
        });
        routesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routesComboActionPerformed(evt);
            }
        });

        jLabel3.setText("Area");

        areasCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        areasCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                areasComboMouseClicked(evt);
            }
        });
        areasCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                areasComboItemStateChanged(evt);
            }
        });
        areasCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areasComboActionPerformed(evt);
            }
        });

        jLabel4.setText("Bus Stops");

        stopsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        stopsCombo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                stopsComboMouseMoved(evt);
            }
        });
        stopsCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stopsComboItemStateChanged(evt);
            }
        });
        stopsCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stopsComboFocusGained(evt);
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        jButton2.setText("Calculate");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(routesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(areasCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(stopsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areasCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void areasComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areasComboActionPerformed
    // TODO add your handling code here:
        
    }//GEN-LAST:event_areasComboActionPerformed

    private void areasComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_areasComboItemStateChanged
         selectedArea = (String) areasCombo.getSelectedItem();
         area = Integer.toString(BusStopInfo.findAreaByName(selectedArea));
        //System.out.println(area);           
                
        if(created)
          setStops();
    }//GEN-LAST:event_areasComboItemStateChanged

    private void routesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routesComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_routesComboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void routesComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_routesComboItemStateChanged
        selectedRoute = (String) routesCombo.getSelectedItem();

        if(selectedRoute.equals("383"))
            route = 65;
        if(selectedRoute.equals("384"))
            route = 66;
        if(selectedRoute.equals("358"))
            route = 67;
        //System.out.println(" " + route);
    }//GEN-LAST:event_routesComboItemStateChanged

    private void stopsComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stopsComboItemStateChanged
        selectedStop = (String) stopsCombo.getSelectedItem();
        busStopID = BusStopInfo.findBusStop(BusStopInfo.getAreaCode(Integer.parseInt(area)),
                                          selectedStop);
        //System.out.println("BSID: " + busStop);
    }//GEN-LAST:event_stopsComboItemStateChanged

    private void areasComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areasComboMouseClicked
        //
    }//GEN-LAST:event_areasComboMouseClicked

    private void stopsComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stopsComboFocusGained
        //
    }//GEN-LAST:event_stopsComboFocusGained

    private void stopsComboMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopsComboMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_stopsComboMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        //
    }//GEN-LAST:event_formMouseMoved

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        //
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        timeInfo test = new timeInfo(route, busStopID);
        String[] lol = test.getTimes();
        for (int i = 0; i < lol.length; i++)
          jTextArea.setText(lol[i]);
    }//GEN-LAST:event_jButton2MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Services().setVisible(true);
            }
        });

        /**
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
			 "Saturday", "Sunday"};

        String selectedDay;

        **/
        
    }

    public static void setRoutes()
    {
        //routesCombo.removeAllItems();
        String[] routes = {"383", "384", "358"};
        routesCombo.setModel(new javax.swing.DefaultComboBoxModel(routes));
    }

    public static void setAreas()
    {

        if (!created)
        {
            database.openBusDatabase();
            areasCombo.removeAllItems();
            int[] areas = BusStopInfo.getAreas();

            for(int i=0; i<areas.length; i++)
            areasCombo.addItem(BusStopInfo.getAreaName(areas[i]));

            created = true;
        }

    }

    public static void setStops()
    {
        stopsCombo.removeAllItems();
        int[] stopIDs = BusStopInfo.getBusStopsInArea(
                BusStopInfo.findAreaByName(selectedArea));

        int j;
	for(j = 0; j < stopIDs.length; j++)
	{
          stopsCombo.addItem(BusStopInfo.getName(stopIDs[j]));
	}
	
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox areasCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea;
    public static javax.swing.JComboBox routesCombo;
    public static javax.swing.JComboBox stopsCombo;
    // End of variables declaration//GEN-END:variables

}