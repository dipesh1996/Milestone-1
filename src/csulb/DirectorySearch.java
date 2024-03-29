/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csulb;

import cecs429.documents.DirectoryCorpus;
import cecs429.documents.Document;
import cecs429.documents.DocumentCorpus;
import cecs429.index.Index;
import cecs429.index.InvertedIndex;
import cecs429.index.Posting;
import cecs429.query.BooleanQueryParser;
import cecs429.query.QueryComponent;
import cecs429.text.AdvancedTokenProcessor;
import cecs429.text.EnglishTokenStream;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author vwake
 */
public class DirectorySearch extends javax.swing.JFrame {

    private Index[] index;
    //private String path;
    //private URI path;
    // private String FileName;
    //  private Object query;
    // private String Directorypath;
    // private Object query;
    String query;
    private String input;
    private List<String> listKeys;
    private DocumentCorpus corpus;
    private List<Posting> result_docs = new ArrayList();

    /**
     * Creates new form DirectorySearch
     */
    public DirectorySearch() {
        initComponents();
        Document_list.setVisible(false);
        Document_list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int Id = Document_list.getSelectedIndex();
                    Reader r = corpus.getDocument(result_docs.get(Id).getDocumentId()).getContent();
                    Scanner s = new Scanner(r);
                    String content = "";
                    while (s.hasNextLine()) {
                        content += s.nextLine();
                    }

                    new ResultDocument(content).setVisible(true);

                }
            }

        });
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
        DirectorySelectionButton = new javax.swing.JButton();
        DirectoryInput = new javax.swing.JTextField();
        IndexButton = new javax.swing.JButton();
        VocabButton = new javax.swing.JButton();
        StemButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        querytext = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Document_list = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Result_field = new javax.swing.JTextArea();
        end = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        document_no = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose Directory");

        DirectorySelectionButton.setText("Browse");
        DirectorySelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirectorySelectionButtonActionPerformed(evt);
            }
        });

        DirectoryInput.setToolTipText("Select directory to index");
        DirectoryInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DirectoryInputActionPerformed(evt);
            }
        });

        IndexButton.setText("Index");
        IndexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IndexButtonActionPerformed(evt);
            }
        });

        VocabButton.setText("Print Vocab");
        VocabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VocabButtonActionPerformed(evt);
            }
        });

        StemButton.setText("Stem");
        StemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StemButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        querytext.setToolTipText("Enter the query");
        querytext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                querytextActionPerformed(evt);
            }
        });

        Document_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Document_list);

        Result_field.setColumns(20);
        Result_field.setRows(5);
        jScrollPane2.setViewportView(Result_field);

        end.setText("Quit");
        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });

        jLabel2.setText("Query");

        jLabel3.setText("Result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(IndexButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(VocabButton)
                        .addGap(72, 72, 72)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(document_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(querytext, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DirectoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DirectorySelectionButton))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DirectoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DirectorySelectionButton)
                    .addComponent(jLabel1))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(querytext, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(document_no)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VocabButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IndexButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DirectorySelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirectorySelectionButtonActionPerformed
        // TODO add your handling code here:

        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.showOpenDialog(this);
        File f = jf.getSelectedFile();
        String path = f.getAbsolutePath();

        DirectoryInput.setText(path);
        // String Directorypath = path;
        System.out.print("Outside Button: " + path);

    }//GEN-LAST:event_DirectorySelectionButtonActionPerformed

    private void IndexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IndexButtonActionPerformed
        try {
            // TODO add your handling code here:
            //  String directoryName = query.substring(5);
            //DocumenCorpus corpus = DirectoryCorpus.loadJsonDirectory(Paths.get(directoryName).toAbsolutePath(), ".json");
            // System.out.print("Path inside button:  " +path);

            String path = DirectoryInput.getText();
            long startTime = System.currentTimeMillis();
            corpus = DirectoryCorpus.loadJsonDirectory(Paths.get(path).toAbsolutePath(), ".json");
            index = indexCorpus(corpus);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;

            document_no.setText("Total time elapsed for indexing : " + elapsedTime / 1000 + " secs");

            // AdvancedTokenProcessor processor = new AdvancedTokenProcessor();
            String query;

        } catch (IOException ex) {
            Logger.getLogger(DirectorySearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_IndexButtonActionPerformed

    private void VocabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VocabButtonActionPerformed

        System.out.println("First 1000 words:: ");
        //  List<String> listKeys = new ArrayList<String>();
        listKeys = index[0].getVocabulary();
        //   System.out.println("IMplemented Vocab");
        String result = "";
        int vocab = 0;
        for (String s : listKeys) {
            if (vocab < 1000) {
                vocab++;
                result += s + "\n";
            }
        }
        Result_field.setText(result);

    }//GEN-LAST:event_VocabButtonActionPerformed

    private void StemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StemButtonActionPerformed
        // TODO add your handling code here:
        // BooleanQueryParser queryparser = new BooleanQueryParser();
        String input = querytext.getText();
        AdvancedTokenProcessor processor = new AdvancedTokenProcessor();
        //String stemmingWord = query.substring(4).trim();

        String result = processor.stem(input);
        Result_field.setText(result);
    }//GEN-LAST:event_StemButtonActionPerformed

    private void DirectoryInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DirectoryInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DirectoryInputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String query = querytext.getText();
        BooleanQueryParser queryparser = new BooleanQueryParser();
        QueryComponent query_component = queryparser.parseQuery(query);
        int i = 0;
        result_docs = query_component.getPostings(index);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        ArrayList<String> documents = new ArrayList<>();

        for (Posting p : result_docs) {
            i++;
            listModel.addElement(corpus.getDocument(p.getDocumentId()).getTitle());

            System.out.println(i + ")" + corpus.getDocument(p.getDocumentId()).getTitle());
        }
        Document_list.setModel(listModel);
        Document_list.setVisible(true);
        if (i == 0) {
            document_no.setText("No Match Found for word \"" + query + "\".");
            //System.out.println("No Match Found for word \"" + query + "\".");
        } else {
            document_no.setText("Total number of Document word \"" + query + "\" occured is :: " + i);

            /* if (choice.toLowerCase().trim().equals("yes")) {
                    System.out.print("Enter the Document Number which you want to print :: ");
                    int Id = scanner.nextInt();
                    scanner.nextLine();
                    Reader r = corpus.getDocument(docs.get(Id-1).getDocumentId()).getContent();
                    Scanner s = new Scanner(r);
                    String content="";
                    while(s.hasNextLine())
                    {
                        content += s.nextLine();
                    }
                    System.out.println(content);
                }*/
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void querytextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_querytextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_querytextActionPerformed

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_endActionPerformed

    private static Index[] indexCorpus(DocumentCorpus corpus) throws IOException {

        HashSet<String> vocabulary = new HashSet<>();
        AdvancedTokenProcessor processor = new AdvancedTokenProcessor();
        InvertedIndex index = new InvertedIndex();
        InvertedIndex biword = new InvertedIndex();
        for (Document d : corpus.getDocuments()) {
            EnglishTokenStream ets = new EnglishTokenStream(d.getContent());
            int term_position = 0;
            String previous = "";
            for (String s : ets.getTokens()) {
                term_position++;
                List<String> word = processor.processToken(s);

                for (int i = 0; i < word.size(); i++) {
                    index.addTerm(word.get(i), d.getId(), term_position);

                    if (previous != "") {
                        biword.addTerm(previous + " " + word.get(i), d.getId());
                    }
                    previous = word.get(i);

                }

            }
            ets.close();
        }
        InvertedIndex[] i = {index, biword};

        return i;
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
            java.util.logging.Logger.getLogger(DirectorySearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DirectorySearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DirectorySearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DirectorySearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DirectorySearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DirectoryInput;
    private javax.swing.JButton DirectorySelectionButton;
    private javax.swing.JList<String> Document_list;
    private javax.swing.JButton IndexButton;
    private javax.swing.JTextArea Result_field;
    private javax.swing.JButton StemButton;
    private javax.swing.JButton VocabButton;
    private javax.swing.JLabel document_no;
    private javax.swing.JButton end;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField querytext;
    // End of variables declaration//GEN-END:variables
}
