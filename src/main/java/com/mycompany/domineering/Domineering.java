/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domineering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class Domineering extends JFrame{
    
    private static JButton[][] buttons;
    private static DomineeringPosition currentPosition;
    private GameSearch game ;
    private static boolean player1PlaysHorizontal ;
    private boolean currentPlayerPlaysHorizontal;
    private static int helpRemainingPlayer1 = 3; // Initial help counts for player 1
    private static int helpRemainingPlayer2 = 3; // Initial help counts for player 2
    private int niveau ;
    private int nbr ;
    private boolean HH;
    private String currentSessionName;
    private List<DomineeringSession> savedsSessions;
    private static Color player1Color = Color.BLUE;
    private static Color player2Color = Color.RED;
    
    public Domineering ()
    {
         
        // si je veut que le premier joueur jou horizontal et si je ne specifie pas donc la valeur par defaut est false 
//        this.currentPlayerPlaysHorizontal = true ; 
        this.nbr = 6 ;
        initComponents(); 
        patch(this.nbr, ButtonClickListenerHH.class);
        jRadioButton4.setSelected(true);
        initializeGame();
        setTitle("Jeux du Domineering");
        loadSavedSessions();
        
    }
     private static class DomineeringSession implements Serializable {
        DomineeringPosition position;
        boolean currentPlayerPlaysHorizontal;
        int helpRemainingPlayer1;
        int helpRemainingPlayer2;
        String sessionName;
        int niveau;int nbr;Boolean HH;

        DomineeringSession(DomineeringPosition position, boolean currentPlayerPlaysHorizontal,
                           int helpRemainingPlayer1, int helpRemainingPlayer2, String sessionName,int niveau,int nbr,Boolean HH) {
            this.position = position;
            this.currentPlayerPlaysHorizontal = currentPlayerPlaysHorizontal;
            this.helpRemainingPlayer1 = helpRemainingPlayer1;
            this.helpRemainingPlayer2 = helpRemainingPlayer2;
            this.sessionName = sessionName;
            this.niveau=niveau;
            this.nbr=nbr;
            this.HH=HH;
             
        }
    }
    // initialiser le jeux du domineering 
    private void initializeGame() {
        currentPosition = new DomineeringPosition(player1PlaysHorizontal , this.nbr);
        game=new DomineeringGame(this.nbr , this.niveau);
        currentSessionName = null;
    }
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">    
     //initiliser l'interface utilisateur :
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        helpBoutton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        SelectBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        histbutton = new javax.swing.JButton();
        existbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans Narrow", 0, 18)); // NOI18N
        jLabel1.setText("Voici votre patch");
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Grille de 8X8");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
     
        jLabel2.setText("Contre qui tu veut jouer:");

        buttonGroup.add(jRadioButton2);
        jRadioButton2.setText("Contre l'humain");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup.add(jRadioButton3);
        jRadioButton3.setText("Contre la machine");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Grille de 6X6");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        helpBoutton.setText("Aide");
        helpBoutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBouttonActionPerformed(evt);
            }
        });

        jLabel3.setText("Choisir votre niveau :");
        jLabel3.setVisible(false);

        SelectBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Debutant", "Intermediaire", "Expert" }));
        SelectBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectBoxActionPerformed(evt);
            }
        });
        SelectBox.setVisible(false);
        jLabel4.setText("Choisir le type du grille :");

        histbutton.setText("historique");
        histbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histbuttonActionPerformed(evt);
            }
        });

        existbutton.setText("exist");
        existbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(helpBoutton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(SelectBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(existbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(histbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton4)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(114, 114, 114))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(SelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(existbutton)
                                .addGap(26, 26, 26)
                                .addComponent(histbutton)))))
                .addGap(9, 9, 9)
                .addComponent(helpBoutton)
                .addContainerGap(131, Short.MAX_VALUE))
        );

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
}
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    this.nbr = 8 ;
    currentPosition = new DomineeringPosition(player1PlaysHorizontal , this.nbr);
    game=new DomineeringGame(this.nbr , this.niveau);     
    jPanel1.removeAll();
    // Mettez à jour la patch avec une grille de 8x8
    patch(this.nbr , ButtonClickListenerHH.class);
    jRadioButton2.setSelected(true);
    HH=true;
    // Rafraîchissez le jPanel1
    jPanel1.revalidate();
    jPanel1.repaint();
    } 
                                                         
    
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) 
    { 
            resetGame() ; 
     HH=true;
    currentPosition = new DomineeringPosition(player1PlaysHorizontal , this.nbr);
    this.niveau = 5 ; 
    game=new DomineeringGame(this.nbr , this.niveau);     
    jPanel1.removeAll();
    // Mettez à jour la patch avec une grille de 8x8
    patch(this.nbr , ButtonClickListenerHH.class);
    helpBoutton.setVisible(true);
    jRadioButton2.setSelected(true);
    // Rafraîchissez le jPanel1
    jPanel1.revalidate();
    jPanel1.repaint();    
    }
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        resetGame() ; 
    HH=false;
    currentPosition = new DomineeringPosition(player1PlaysHorizontal , this.nbr);
    this.niveau = 5 ; 
    game=new DomineeringGame(this.nbr , this.niveau);     
    jPanel1.removeAll();
    // Mettez à jour la patch avec une grille de 8x8
    patch(this.nbr , ButtonClickListenerHP.class);
    // pour initialiser le maxdepth 
    jLabel3.setVisible(true);
    SelectBox.setVisible(true);
    // Rafraîchissez le jPanel1
    helpBoutton.setVisible(false);
    jPanel1.revalidate();
    jPanel1.repaint();    
    } 
    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                              
      this.nbr = 6 ;
    currentPosition = new DomineeringPosition(player1PlaysHorizontal , this.nbr);
    game=new DomineeringGame(this.nbr , this.niveau);     
    jPanel1.removeAll();
    // Mettez à jour la patch avec une grille de 8x8
    patch(this.nbr , ButtonClickListenerHH.class);
    HH=true;
    // Rafraîchissez le jPanel1
    jPanel1.revalidate();
    jPanel1.repaint();
    }
    private void histbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        replayGame();
    }                                          

    private void existbuttonActionPerformed(java.awt.event.ActionEvent evt)
    {                                              
        saveSession();
        resetGame();
    } 
    
    private void SelectBoxActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String SelectedValue = SelectBox.getSelectedItem().toString() ; 
        if(SelectedValue.equals("Debutant"))
        {
         this.niveau = 5 ;   
         game=new DomineeringGame(this.nbr , this.niveau); 
        }
        else if(SelectedValue.equals("Intermediaire"))
        {
            this.niveau = 7 ;
            game=new DomineeringGame(this.nbr , this.niveau); 
        }
        else if(SelectedValue.equals("Expert")) {
            this.niveau = 8 ; 
            game=new DomineeringGame(this.nbr , this.niveau); 
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
            java.util.logging.Logger.getLogger(DomineeringF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DomineeringF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DomineeringF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DomineeringF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {   
            Domineering domineering = new Domineering();
            domineering.setVisible(true) ; 
            }
        });
    }
    
    public void patch(int r, Class<? extends ActionListener> listenerClass) {
    jPanel1.setLayout(new GridLayout(r, r));
    buttons = new JButton[r][r];
    try {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));

                ActionListener listener = listenerClass.getDeclaredConstructor(Domineering.class, int.class, int.class, int.class)
                        .newInstance(Domineering.this, i, j, this.nbr);

                button.addActionListener(listener);
                buttons[i][j] = button;
                jPanel1.add(button);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton  helpBoutton ; 
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> SelectBox;
    private javax.swing.JButton existbutton;
    private javax.swing.JButton histbutton;

        public class ButtonClickListenerHH implements ActionListener {
         private int row;
         private int col;
         private int nbrB;

         // Ajoutez un constructeur prenant trois paramètres de type int
         public ButtonClickListenerHH(int row, int col, int nbrB) {
             this.row = row;
             this.col = col;
             this.nbrB = nbrB;
         }
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isValidMove(row, col)) {
                    makeMove(row, col);
                    currentPlayerPlaysHorizontal = !currentPlayerPlaysHorizontal;
                    updateUI();
                    // Check for a winner
                     if (endGame()) {
            String winner = (currentPlayerPlaysHorizontal == player1PlaysHorizontal) ? "Player 2": "Player 1";
            JOptionPane.showMessageDialog(Domineering.this, winner + " wins!", "Game Over",
                    JOptionPane.INFORMATION_MESSAGE);
                   
                    if(currentSessionName!=null){
                    System.out.println(currentSessionName);
                    Optional<DomineeringSession> existingSession = savedsSessions.stream()
                    .filter(session -> session.sessionName.equals(currentSessionName))
                    .findFirst();

                    if (existingSession.isPresent()) {
              
                    deleteSession(existingSession.get());
                    currentSessionName=null;
                     }}
                    resetGame();
                     }
                } else {
                    JOptionPane.showMessageDialog(Domineering.this, "Invalid move. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
              
        }
        
    public class ButtonClickListenerHP implements ActionListener {
    private int row;
    private int col;
    private int nbrB;

    public ButtonClickListenerHP(int row, int col, int nbrB) {
        this.row = row;
        this.col = col;
        this.nbrB = nbrB;
    }

    @Override
        public void actionPerformed(ActionEvent e) {
                
           if (isValidMove(row, col)) {
                makeMove(row, col);
                updateUI();
                
            } else {
                JOptionPane.showMessageDialog(Domineering.this, "Invalid move. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if the move is invalid
            }

            // Check for a winner after human player's move
             if (endGame1()) {
            String winner = (currentPlayerPlaysHorizontal == player1PlaysHorizontal) ? "Player 1": "Player 2";
            JOptionPane.showMessageDialog(Domineering.this, winner + " wins!", "Game Over",
                    JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(currentSessionName);
                    if(currentSessionName!=null){
                    System.out.println(currentSessionName);
                    Optional<DomineeringSession> existingSession = savedsSessions.stream()
                    .filter(session -> session.sessionName.equals(currentSessionName))
                    .findFirst();

                    if (existingSession.isPresent()) {
              
                    deleteSession(existingSession.get());
                    currentSessionName=null;
                     }}
                    resetGame();
                     }
            // AI's move after human player
            DomineeringPosition suggestedPosition = getPosition(currentPosition);
            if (suggestedPosition != null) {
                currentPosition = suggestedPosition;
                updateUI();
            }

            // Check for a winner after AI's move
           if (endGame()) {
            String winner = (currentPlayerPlaysHorizontal == player1PlaysHorizontal) ? "Player 2": "Player 1";
            JOptionPane.showMessageDialog(Domineering.this, winner + " wins!", "Game Over",
                    JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(currentSessionName);
                    if(currentSessionName!=null){
                    System.out.println(currentSessionName);
                    Optional<DomineeringSession> existingSession = savedsSessions.stream()
                    .filter(session -> session.sessionName.equals(currentSessionName))
                    .findFirst();

                    if (existingSession.isPresent()) {
              
                    deleteSession(existingSession.get());
                    currentSessionName=null;
                     }}
                    resetGame();
                     }
        }
    private DomineeringPosition getPosition(DomineeringPosition currentPosition) {
        Vector result = game.alphaBeta_Search(currentPosition);       
        if (result != null && result.size() > 1) {
            Object secondElement = result.elementAt(1);
            if (secondElement instanceof DomineeringPosition){
                return (DomineeringPosition) secondElement;
            } else {
                System.out.println("Le deuxième élément n'est pas un DomineeringPosition.");
            }
        }
        return null;
    }
    }
    
    private void makeMove(int row, int col) {
            // Update the game state based on the move
            DomineeringMove move = new DomineeringMove(row, col, currentPlayerPlaysHorizontal);
            currentPosition.makeMove(move);
        }
    private boolean endGame() {
        return !currentPosition.hasPossibleMoves(currentPlayerPlaysHorizontal);
    }
     private boolean endGame1() {
        return !currentPosition.hasPossibleMoves(!currentPlayerPlaysHorizontal);
    }

    private void resetGame() {
        currentPosition = new DomineeringPosition(player1PlaysHorizontal, this.nbr);
        currentPlayerPlaysHorizontal = player1PlaysHorizontal;
        currentSessionName=null;
        helpRemainingPlayer1 = 3; // Initial help counts for player 1
        helpRemainingPlayer2 = 3;
        updateUI();
    }
    private boolean isValidMove(int row, int col) {
        return currentPosition.isValidMove(row, col, currentPlayerPlaysHorizontal);
    }
    private void updateUI() {
        for (int i = 0; i < this.nbr; i++) {
            for (int j = 0; j < this.nbr; j++) {
                Color cellColor = Color.WHITE; // Default color for empty cells

                if (currentPosition.getSymbolAt(i, j) == 1) {
                    cellColor = player1Color;
                } else if (currentPosition.getSymbolAt(i, j) == -1) {
                    cellColor = player2Color;
                }

                buttons[i][j].setBackground(cellColor);
            }
        }
    }
    
    private void helpBouttonActionPerformed(java.awt.event.ActionEvent evt) {  
    if (getHelpRemaining() > 0) {
        this.niveau = 5 ;
        decreaseHelpRemaining();
        // Call the Alpha-Beta algorithm and make the suggested move
        Vector v = game.alphaBeta(0, currentPosition, !currentPlayerPlaysHorizontal);
        Position suggestedPosition = (Position) v.elementAt(1);
        currentPosition.copyFrom((DomineeringPosition) suggestedPosition); 
        // Mise à jour du joueur actuel après le mouvement suggéré
        currentPlayerPlaysHorizontal = !currentPlayerPlaysHorizontal;
        updateUI();

        // Display a message or update the UI to indicate that help was used
        JOptionPane.showMessageDialog(Domineering.this, "Help used! Suggested move made.", "Help",
                JOptionPane.INFORMATION_MESSAGE);

        // Update the "Help" button text to show the remaining help times

        // Check for a winner
        
        if (endGame()) {
            String winner = (currentPlayerPlaysHorizontal == player1PlaysHorizontal) ? "Player 2": "Player 1";
            JOptionPane.showMessageDialog(Domineering.this, winner + " wins!", "Game Over",
                    JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(currentSessionName);
                    if(currentSessionName!=null){
                    System.out.println(0);
                    Optional<DomineeringSession> existingSession = savedsSessions.stream()
                    .filter(session -> session.sessionName.equals(currentSessionName))
                    .findFirst();

                    if (existingSession.isPresent()) {
                    deleteSession(existingSession.get());
                    currentSessionName=null;
                     }}
                    resetGame();
                     }
    } else {
        JOptionPane.showMessageDialog(Domineering.this, "No more help available.", "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
    
       private int getHelpRemaining() {
            return (currentPlayerPlaysHorizontal == player1PlaysHorizontal) ? helpRemainingPlayer1 : helpRemainingPlayer2;
        }

        private void decreaseHelpRemaining() {
            if (currentPlayerPlaysHorizontal == player1PlaysHorizontal) {
                helpRemainingPlayer1--;
            } else {
                helpRemainingPlayer2--;
            }
        }
        
           private void saveSession() {
        if(currentSessionName==null){
        if (!endGame()) {
            String sessionName = JOptionPane.showInputDialog(this, "Enter a name for the saved session:");
            DomineeringSession session = new DomineeringSession(currentPosition,
                    currentPlayerPlaysHorizontal, helpRemainingPlayer1, helpRemainingPlayer2, sessionName,niveau,nbr,HH);
            savedsSessions.add(session);
            serializeSessions();
        }
        
    }else{
            Optional<DomineeringSession> existingSession = savedsSessions.stream()
                    .filter(session -> session.sessionName.equals(currentSessionName))
                    .findFirst();

            if (existingSession.isPresent()) {
                if (endGame()) {
                    deleteSession(existingSession.get());
                    // Remove the session if the game has ended
                    
                } else {
                    // Replace the existing session if not in endgame
                    existingSession.get().position = currentPosition;
                    existingSession.get().currentPlayerPlaysHorizontal = currentPlayerPlaysHorizontal;
                    existingSession.get().helpRemainingPlayer1 = helpRemainingPlayer1;
                    existingSession.get().helpRemainingPlayer2 = helpRemainingPlayer2;
                    serializeSessions();
                }
               
            }
    }}

  
    
    private void replayGame() {
    String[] sessionNames = savedsSessions.stream().map(session -> session.sessionName).toArray(String[]::new);
    String selectedSession = (String) JOptionPane.showInputDialog(this,
            "Choose a session to replay or delete:", "Replay/Delete Game",
            JOptionPane.QUESTION_MESSAGE, null, sessionNames, sessionNames[0]);

    if (selectedSession != null) {
        DomineeringSession selectedSessionObj = savedsSessions.stream()
                .filter(session -> session.sessionName.equals(selectedSession))
                .findFirst().orElse(null);

        if (selectedSessionObj != null) {
            int option = JOptionPane.showOptionDialog(this,
                    "Do you want to replay or delete the selected session?",
                    "Replay/Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Replay", "Delete"}, "Replay");

            if (option == JOptionPane.YES_OPTION) {
                // Replay the selected session
               currentSessionName = selectedSessionObj.sessionName;
               currentPosition = selectedSessionObj.position;
               currentPlayerPlaysHorizontal = selectedSessionObj.currentPlayerPlaysHorizontal;
               helpRemainingPlayer1 = selectedSessionObj.helpRemainingPlayer1;
               helpRemainingPlayer2 = selectedSessionObj.helpRemainingPlayer2;
               niveau=selectedSessionObj.niveau;
               nbr=selectedSessionObj.nbr;
               HH=selectedSessionObj.HH;
                jPanel1.removeAll();
                if(HH){
                patch(nbr , ButtonClickListenerHH.class);
                helpBoutton.setVisible(true);
                jRadioButton2.setSelected(true);
                }
                else {
                patch(nbr , ButtonClickListenerHP.class);
                helpBoutton.setVisible(false);
                jRadioButton3.setSelected(true);
                }
                if(nbr==6){
                jRadioButton4.setSelected(true);
                }
                else if(nbr==8){
                jRadioButton1.setSelected(true);
                }
                switch (niveau) {
                    case 5 -> SelectBox.setSelectedItem("Debutant");
                    case 7 -> SelectBox.setSelectedItem("Intermediaire");
                    case 8 -> SelectBox.setSelectedItem("Expert");
                    default -> {
                    }
                }
          
                jPanel1.revalidate();
                jPanel1.repaint();

                updateUI();
            } else if (option == JOptionPane.NO_OPTION) {
                // Delete the selected session
                savedsSessions.remove(selectedSessionObj);
                serializeSessions() ;
            }
        }
    }else {}
}


    private void serializeSessions() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sessi.ser"))) {
            oos.writeObject(savedsSessions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  private void loadSavedSessions() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sessi.ser"))) {
        savedsSessions = (List<DomineeringSession>) ois.readObject();
    } catch (FileNotFoundException e) {
        // File not found, set savedSessions to a new ArrayList
        savedsSessions = new ArrayList<>();
    } catch (IOException | ClassNotFoundException e) {
        // Other exceptions, set savedSessions to a new ArrayList
        savedsSessions = new ArrayList<>();
    }
}
  private void deleteSession(DomineeringSession session) {
        savedsSessions.remove(session);
        serializeSessions();
        JOptionPane.showMessageDialog(this, "Selected session deleted successfully.", "Delete Successful",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}

       
