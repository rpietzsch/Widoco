/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widoco.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import widoco.Configuration;

/**
 *
 * @author dgarijo
 */
public class SelectLanguage extends javax.swing.JFrame {
private final Configuration c;
private final GuiStep2 g;
private final String previousLang;//an auxiliar param to knw if the text field is being edited
    /**
     * Creates new form SelectLanguage
     * @param g
     * @param c
     */
    public SelectLanguage(GuiStep2 g, Configuration c) {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        this.setLocation(x, y);
        
        this.g = g;
        this.c = c;
        
        Iterator<String> itLanguages = c.getLanguagesToGenerateDoc().iterator();
        String lang = "";
        while(itLanguages.hasNext()){
            String nextL = itLanguages.next();
            if (nextL.contains("en")){
                en.setSelected(true);
            } 
            else if(nextL.contains("es")){
                es.setSelected(true);
            }
            else if(nextL.contains("pt")){
                pt.setSelected(true);
            }else{
                otherText.setText(nextL);
                lang = nextL;
            }
        }
        this.previousLang = lang;
        //load the languages here
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
        doneButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        otherText = new javax.swing.JTextField();
        en = new javax.swing.JRadioButton();
        es = new javax.swing.JRadioButton();
        it = new javax.swing.JRadioButton();
        fr = new javax.swing.JRadioButton();
        pt = new javax.swing.JRadioButton();
        de = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Languages...");
        setAlwaysOnTop(true);

        jLabel1.setText("Select languages from the following list:");

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Other (will select labels in that lang):");

        en.setText("en (default)");

        es.setText("es");

        it.setText("it (coming soon)");
        it.setEnabled(false);

        fr.setText("fr (coming soon)");
        fr.setEnabled(false);

        pt.setText("pt");

        de.setText("de (coming soon)");
        de.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(otherText)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pt)
                            .addComponent(fr)
                            .addComponent(es)
                            .addComponent(en)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(de)
                            .addComponent(it))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(en)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(es)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(it)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(de)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doneButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        //set the languages
       if(en.isSelected()){
           this.c.addLanguageToGenerate("en");
       }else{
           this.c.removeLanguageToGenerate("en");
       }
       if(es.isSelected()){
           this.c.addLanguageToGenerate("es");
       }else{
           this.c.removeLanguageToGenerate("es");       
       }
       if(pt.isSelected()){
           this.c.addLanguageToGenerate("pt");
       }else{
           this.c.removeLanguageToGenerate("pt");       
       }
       String otherL = otherText.getText();
       if(!"".equals(otherL)){
           this.c.addLanguageToGenerate(otherL);
       }else{//empty text
           if(!"".equals(previousLang)){
               c.removeLanguageToGenerate(previousLang);
           }
       }
       if(c.getLanguagesToGenerateDoc().isEmpty()){
           c.addLanguageToGenerate("en");
       }
       g.refreshLanguages();
       this.dispose();
    }//GEN-LAST:event_doneButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton de;
    private javax.swing.JButton doneButton;
    private javax.swing.JRadioButton en;
    private javax.swing.JRadioButton es;
    private javax.swing.JRadioButton fr;
    private javax.swing.JRadioButton it;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField otherText;
    private javax.swing.JRadioButton pt;
    // End of variables declaration//GEN-END:variables
}
