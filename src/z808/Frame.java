package z808;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author João Pedro Bretanha
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    public Frame(Z808 proc) {
        super("Z808");
        initComponents();
        this.proc = proc;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JPanel();
        AbrirBotao = new javax.swing.JButton();
        CarregarBotao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MemTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        AXValor = new javax.swing.JLabel();
        IPValor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DXValor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SIValor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SPValor = new javax.swing.JLabel();
        TamExtraPilha = new javax.swing.JComboBox(TamExtra);
        jLabel6 = new javax.swing.JLabel();
        ExecutarBotao = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        DSValor = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SSValor = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LastInst = new javax.swing.JLabel();
        Zeroflag = new javax.swing.JCheckBox();
        Sinalflag = new javax.swing.JCheckBox();
        Overflowflag = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        CSValor = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        SRValor = new javax.swing.JLabel();
        SRVALOR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AbrirBotao.setText("Abrir");
        AbrirBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirBotaoActionPerformed(evt);
            }
        });

        CarregarBotao.setText("Carregar");
        CarregarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarregarBotaoActionPerformed(evt);
            }
        });

        MemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Endereço", "Instrução/Dado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(MemTable);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("IP:");

        AXValor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        IPValor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("AX:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setText("DX:");

        DXValor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel4.setText("SI:");

        SIValor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setText("SP:");

        SPValor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        TamExtraPilha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "10", "20", "30" }));

        jLabel6.setText("Tamanho extra para pilha");

        ExecutarBotao.setText("Executar");
        ExecutarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExecutarBotaoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel7.setText("DS:");

        DSValor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel8.setText("SS:");

        SSValor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        jLabel9.setText("Última Instrução executada:");

        LastInst.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        Zeroflag.setText("Zero Flag");
        Zeroflag.setEnabled(false);

        Sinalflag.setText("Sinal Flag");
        Sinalflag.setEnabled(false);

        Overflowflag.setText("Overflow Flag");
        Overflowflag.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel10.setText("CS:");

        CSValor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel11.setText("SR:");

        SRValor.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        SRVALOR.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TamExtraPilha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addComponent(AbrirBotao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CarregarBotao))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DXValor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SIValor))
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SPValor))
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DSValor))
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SSValor))
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IPValor))
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CSValor)))
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Sinalflag)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PainelLayout.createSequentialGroup()
                                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(PainelLayout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Zeroflag))
                                                    .addGroup(PainelLayout.createSequentialGroup()
                                                        .addGap(11, 11, 11)
                                                        .addComponent(Overflowflag)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(SRValor, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(ExecutarBotao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addContainerGap())))
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AXValor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(10, 10, 10)
                                .addComponent(SRVALOR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LastInst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AbrirBotao)
                            .addComponent(CarregarBotao)
                            .addComponent(jLabel1)
                            .addComponent(IPValor)))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(ExecutarBotao)))
                .addGap(13, 13, 13)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addComponent(SRValor)
                                .addGap(41, 41, 41))
                            .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(SRVALOR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AXValor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DXValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(SIValor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(SPValor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(DSValor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(SSValor)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(Zeroflag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Sinalflag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Overflowflag)
                                .addGap(129, 129, 129)))
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(CSValor))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TamExtraPilha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastInst))
                    .addComponent(jLabel6))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExecutarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExecutarBotaoActionPerformed
        String opcode;
        //do{
            if((flag_para == 0) && !(IPValor.getText().isEmpty())){
                int indice_linha = MemTable.getSelectedRow();

                int end_real = proc.getIP(); //Integer.parseInt(IPValor.getText()); //proc.getIndices().get(indice_linha);
                try{
                    Instrucao inst = (Instrucao)proc.getMemoria().get(end_real);
                    opcode = inst.getOpcode();
                    int end_alterado = proc.executa(inst, LastInst, end_real);
                    atualiza_regsandflags();
                    if( end_alterado != -1){      //precisa atualizar a tabela de memoria
                        int linha = proc.getIndices().indexOf(end_alterado);
                        MemTable.setValueAt(proc.getMemoria().get(end_alterado).getValor(), linha, 1);
                    }

                }
                catch(ClassCastException e){
                    opcode = "Dado";
                }

                if(opcode.equals("F4")){
                    flag_para = 1;
                }
                else{
                    int prox_linha = proc.getIndices().indexOf(Integer.parseInt(IPValor.getText()));
                    MemTable.setRowSelectionInterval(prox_linha, prox_linha);
                    flag_para = 0;
                }
            }
    }//GEN-LAST:event_ExecutarBotaoActionPerformed

    private void CarregarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarregarBotaoActionPerformed
        if( arqv != null){
            proc.carregaDados1();
            int tam_extra = Integer.parseInt(TamExtraPilha.getSelectedItem().toString());  //pega valor selecionado na combobox pra criar a area extra de pilha
            proc.setSP(proc.carregaPilha(tam_extra));
            SPValor.setText(String.valueOf(proc.getSP()));  //atualiza valor do reg sp com a pos do final da pilha
            DefaultTableModel model=new DefaultTableModel(){   //cria um default table model
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {  //torna a tabela nao editavel para o usuario
                    return false;
                }
            } ;
            MemTable.setModel(model);   //atrela o modelo criado a jtable MemTable
            model.addColumn("Endereço");    //adiciona coluna de endereço
            model.addColumn("Instrução/dado");  //adiciona coluna de instrucao/dados
            MemTable.getColumnModel().getColumn(0).setPreferredWidth(30);  //seta largura da coluna 0
            MemTable.getColumnModel().getColumn(1).setPreferredWidth(110);  //seta largura da coluna 1

            ArrayList<Integer> Indices = proc.getIndices();
            Hashtable<Integer,Thing> Memoria = proc.getMemoria();
            for(int i=0; i < Indices.size(); i++){
                int end = Indices.get(i);
                Thing algo = Memoria.get(end);
                try{
                    Dado d = (Dado)algo;
                    model.addRow(new String[]{String.valueOf(end),String.valueOf(d.getValor())});
                }
                catch(ClassCastException e){
                    Instrucao inst = (Instrucao)algo;
                    String opcode = inst.getOpcode();
                    if(inst.getTipo() == 1){
                        model.addRow(new String[]{String.valueOf(end),opcode});
                    }
                    else{
                        model.addRow(new String[]{String.valueOf(end),opcode+" "+inst.getValor()});
                    }
                }
            }
            // model.
            MemTable.setRowSelectionInterval(proc.getQtde_dados1(), proc.getQtde_dados1());
            proc.setIP(Indices.get(MemTable.getSelectedRow()));
            IPValor.setText(String.valueOf(proc.getIP()));
        }
    }//GEN-LAST:event_CarregarBotaoActionPerformed

    private void AbrirBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirBotaoActionPerformed
        jFileChooser1 = new JFileChooser();   //cria o jfilechooser
        jFileChooser1.setAcceptAllFileFilterUsed(false);  //nao deixa ele mostrar all files
        jFileChooser1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  //mostrar apenas diretorios e arquivos
        jFileChooser1.addChoosableFileFilter(new MyFilter());    //atrela ao filtro myfilter (pra mostrar apenas .asm e diretorios)
        int returnval = jFileChooser1.showOpenDialog(null); //mostra a janela para abrir arquivos
        if( (returnval == JFileChooser.CANCEL_OPTION) || returnval == JFileChooser.ERROR_OPTION){
            arqv = null;
        }
        else{
            arqv = jFileChooser1.getSelectedFile();
            proc.setLig(arqv);
        }
    }//GEN-LAST:event_AbrirBotaoActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AXValor;
    private javax.swing.JButton AbrirBotao;
    private javax.swing.JLabel CSValor;
    private javax.swing.JButton CarregarBotao;
    private javax.swing.JLabel DSValor;
    private javax.swing.JLabel DXValor;
    private javax.swing.JButton ExecutarBotao;
    private javax.swing.JLabel IPValor;
    private javax.swing.JLabel LastInst;
    private javax.swing.JTable MemTable;
    private javax.swing.JCheckBox Overflowflag;
    private javax.swing.JPanel Painel;
    private javax.swing.JLabel SIValor;
    private javax.swing.JLabel SPValor;
    private javax.swing.JLabel SRVALOR;
    private javax.swing.JLabel SRValor;
    private javax.swing.JLabel SSValor;
    private javax.swing.JCheckBox Sinalflag;
    private javax.swing.JComboBox TamExtraPilha;
    private javax.swing.JCheckBox Zeroflag;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    // variaveis criadas
    private JFileChooser jFileChooser1;
    private File arqv = null;
    private int flag_para = 0;
    private Z808 proc;
    private String[] TamExtra ={"0", "10", "20", "30"};

    private void atualiza_regsandflags() {
        AXValor.setText(String.valueOf(proc.getAX()));
        IPValor.setText(String.valueOf(proc.getIP()));
        DXValor.setText(String.valueOf(proc.getDX()));
        SIValor.setText(String.valueOf(proc.getSI()));
        SPValor.setText(String.valueOf(proc.getSP()));
        SSValor.setText(String.valueOf(proc.getSS()));
        DSValor.setText(String.valueOf(proc.getDS()));
        CSValor.setText(String.valueOf(proc.getCS()));
        SRVALOR.setText(String.valueOf(proc.getSR()));
        if( (proc.getSR() == 1) || (proc.getSR() == 5)){
            Sinalflag.setSelected(true);
        }
        else{
            Sinalflag.setSelected(false);
        }
        if( (proc.getSR() == 2) || (proc.getSR() == 6)){
            Zeroflag.setSelected(true);
        }
        else{
            Zeroflag.setSelected(false);
        }
        if( (proc.getSR() == 5) || (proc.getSR() == 6)){
            Overflowflag.setSelected(true);
        }
        else{
            Overflowflag.setSelected(false);
        }
    }
    
    private static class MyFilter extends FileFilter {

        public MyFilter() {
        }
        
        @Override
        public boolean accept(File f) {
           String filename = f.getName();
           return filename.endsWith(".txt") || f.isDirectory();
        }

        @Override
        public String getDescription() {
           return "*.txt";
        }
    }

}
