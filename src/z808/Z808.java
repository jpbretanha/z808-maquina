package z808;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author João Pedro Bretanha
 */
public class Z808 {

    /**
     * @param args the command line arguments
     */
    private int SP = 0, IP = 0, AX = 0, DX = 0 , SI = 0, DS = 0, SS = 0, CS = 0; // SP-STACK POINTER, IP-INSTRUCTION POINTER, AX-OPERANDO DESTINO/FONTE, DX-OPERANDO FONTE, SI-ÍNDICE, DS-Segmento de Dados SS-Segmento de Pilha, CS-Segmento de Código

    public int getCS() {
        return CS;
    }

    public void setCS(int CS) {
        this.CS = CS;
    }

    public int getSR() {
        return SR;
    }

    public void setSR(int SR) {
        this.SR = SR;
    }
    private int ZF = 0, SF = 0; // ZF-ZERO, SF-SINAL
    private int SR = 0;        // registrador de status, tem as flags OF,ZF e SF (as demais nao foram implementadas)

    public int getDS() {
        return DS;
    }

    public void setDS(int DS) {
        this.DS = DS;
    }

    public int getSS() {
        return SS;
    }

    public void setSS(int SS) {
        this.SS = SS;
    }

    public int getZF() {
        return ZF;
    }

    public void setZF(int ZF) {
        this.ZF = ZF;
    }

    public int getSF() {
        return SF;
    }

    public void setSF(int SF) {
        this.SF = SF;
    }

    public int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public int getIP() {
        return IP;
    }

    public void setIP(int IP) {
        this.IP = IP;
    }

    public int getAX() {
        return AX;
    }

    public void setAX(int AX) {
        this.AX = AX;
    }

    public int getDX() {
        return DX;
    }

    public void setDX(int DX) {
        this.DX = DX;
    }

    public int getSI() {
        return SI;
    }

    public void setSI(int SI) {
        this.SI = SI;
    }
    
    private int qtde_dados1, qtde_dados2, qtde_inst1, qtde_inst2, index_hlt;
    private ArrayList<Integer> Indices;
    private Hashtable<Integer,Thing> Memoria;
    private File lig; 
    public Z808(){
        this.Memoria = new Hashtable<Integer,Thing>();
        this.Indices = new ArrayList<Integer>();
        /*carregaDados1();;
        imprimeMemoria();*/
    }

    public int getQtde_dados1() {
        return qtde_dados1;
    }

    public void setQtde_dados1(int qtde_dados1) {
        this.qtde_dados1 = qtde_dados1;
    }

    public int getQtde_dados2() {
        return qtde_dados2;
    }

    public void setQtde_dados2(int qtde_dados2) {
        this.qtde_dados2 = qtde_dados2;
    }

    public int getQtde_inst1() {
        return qtde_inst1;
    }

    public void setQtde_inst1(int qtde_inst1) {
        this.qtde_inst1 = qtde_inst1;
    }

    public int getQtde_inst2() {
        return qtde_inst2;
    }

    public void setQtde_inst2(int qtde_inst2) {
        this.qtde_inst2 = qtde_inst2;
    }

    public ArrayList<Integer> getIndices() {
        return Indices;
    }

    public void setIndices(ArrayList<Integer> Indices) {
        this.Indices = Indices;
    }

    public Hashtable<Integer, Thing> getMemoria() {
        return Memoria;
    }

    public void setMemoria(Hashtable<Integer, Thing> Memoria) {
        this.Memoria = Memoria;
    }
    

    public File getLig() {
        return lig;
    }

    public void setLig(File lig) {
        this.lig = lig;
    }

    public void carregaDados1() {
        try {
            //System.out.print(lig);
            Scanner sc = new Scanner(new FileReader(lig)).useDelimiter("\\||\\n");
            qtde_dados1 = Integer.parseInt(sc.next());
            qtde_inst1 = Integer.parseInt(sc.next());
            qtde_dados2 = Integer.parseInt(sc.next());
            qtde_inst2 = Integer.parseInt(sc.next()); 
            int index = 0;
            for(int i = 0; i < qtde_dados1; i++ ){
                int valor = Integer.parseInt(sc.next());
                Indices.add(index);
                Dado novo = new Dado(valor);
                Memoria.put(index, novo);
                index= index+2;
            }     
            carregaInst(sc, index, qtde_inst1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Z808.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void imprimeMemoria() {
    
    for(int i = 0; i < Indices.size(); i++){
        int key = Indices.get(i);
        Thing algo = Memoria.get(key);
        try{
            Dado d = (Dado)algo;
            System.out.print("Pos: "+key+"Dado: "+d.getValor()+"\n");
        }
        catch(ClassCastException e){
            Instrucao inst = (Instrucao)algo;
            if(inst.getTipo() == 1){
                System.out.print("Pos: "+key+"Instrucao: "+inst.getOpcode()+"\n");
            }
            else{
                System.out.print("Pos: "+key+"Instrucao: "+inst.getOpcode()+" "+inst.getValor()+"\n");
            }
        }
    }
    
    }

    private void carregaInst(Scanner sc, int index, int qtde_inst) { 
        for(int cont=0; cont < qtde_inst; cont++ ){
            StringTokenizer st = new StringTokenizer(sc.next());
            String opcode;
            int cont_tokens = st.countTokens();
            if(cont_tokens == 1){
                opcode = st.nextToken();
                Indices.add(index);
                Instrucao nova = new Instrucao(opcode, 1);
                Memoria.put(index, nova);
                if(opcode.equalsIgnoreCase("F4") || opcode.equalsIgnoreCase("58") || opcode.equalsIgnoreCase("50") || opcode.equalsIgnoreCase("9D") || opcode.equalsIgnoreCase("9C") || opcode.equalsIgnoreCase("C3")){
                    if(opcode.equalsIgnoreCase("F4")){
                        index_hlt = index;
                    }
                    index++;
                }
                else{  //eh uma instrucao de dois bytes, mas sem cte ou mem
                    index = index+2;
                }
            }
            else{   //tem dois tokens, pode ser 2 bytes EB mem, ou 3 bytes 8984 mem
                opcode = st.nextToken();
                int valor = Integer.parseInt(st.nextToken());
                Indices.add(index);
                Instrucao nova = new Instrucao(opcode,valor ,2);
                Memoria.put(index, nova);
                if( opcode.equalsIgnoreCase("8984") || opcode.equalsIgnoreCase("8B84")){
                    index = index + 3;
                }
                else{
                    index = index +2;
                }
            }
        }
        if(qtde_inst == qtde_inst1){
            carregaDados2(sc, index);
        }
    }

    private void carregaDados2(Scanner sc, int index) {
        for(int i = 0; i < qtde_dados2; i++ ){
            int valor = Integer.parseInt(sc.next());
            Indices.add(index);
            Dado novo = new Dado(valor);
            Memoria.put(index, novo);
            index= index+2;
        }
        carregaInst(sc, index, qtde_inst2);
    }

    public int carregaPilha(int tam_extra) { 
       int prox_index = Indices.get(Indices.size()-1) + 1;       //2º segmento TEM q terminar com hlt
       for(int cont=0; cont < tam_extra; cont++){
           int valor = 0;
           Indices.add(prox_index);
           Dado novo = new Dado(valor);
           Memoria.put(prox_index, novo);
           prox_index = prox_index + 2;
       }
       //imprimeIndices();
       if(tam_extra != 0){
           return prox_index;
       }
       else{
           return prox_index;  
       }
    }

    public int executa(Instrucao inst, JLabel label, int endereco_real) {    // qqer n > 0 = atualiza tab mem , -1 = n precisa atualizar
        int tipo = inst.getTipo();
        String opcode = inst.getOpcode();

        if( tipo == 1){       //nao tem campo valor;
            if(opcode.matches("03C[02]")){   // add ax,dx OU add ax,ax
               if(opcode.charAt(3) == '2' ){
                   AX = DX + AX;
                   label.setText("ADD AX,DX");
               }
               else{
                   AX = AX + AX;
                   label.setText("ADD AX,AX");
               }
               ajusta_flags(AX);
               IP = IP +2;
               return -1;
            }
            else if(opcode.matches("F7F[60]")){             //div ax OU div SI
                String bin_lower = Integer.toBinaryString(AX);
                bin_lower = ajusta_bin_string(bin_lower);
                String bin_higher = Integer.toBinaryString(DX);
                
                bin_higher = bin_higher.concat(bin_lower);
                int dividendo = Integer.parseInt(bin_higher, 2);
                String bin_divisor;
                if(opcode.charAt(3) == '6'){  //div SI
                    bin_divisor = Integer.toBinaryString(SI);
                    label.setText("DIV SI");
                }
                else{
                    bin_divisor = Integer.toBinaryString(AX); 
                    label.setText("DIV AX");
                }
                bin_divisor = ajusta_bin_string(bin_divisor);
                int divisor = Integer.parseInt(bin_divisor, 2);
                AX = dividendo/divisor;
                DX = dividendo % divisor;
                IP = IP +2;
                return -1;
            }
            else if(opcode.matches("2BC[20]")){        //sub ax,dx OU sub ax,ax
                if(opcode.charAt(3) == 2){    //sub ax,dx
                    AX = AX - DX;
                    label.setText("SUB AX,DX");
                }
                else{   // sub ax, ax
                    AX = AX - AX;
                    label.setText("SUB AX,AX");
                }
                ajusta_flags(AX);
                IP = IP + 2;
                return -1;
            }
            else if(opcode.matches("F7E[60]")){   //mul si ou mul ax;
                String multiplicando = Integer.toBinaryString(AX);
                multiplicando = ajusta_32bits(multiplicando);
                multiplicando = multiplicando.substring(16, 32);
                String multiplicador;
                if(opcode.charAt(3) == '6'){
                    multiplicador = Integer.toBinaryString(SI);
                    label.setText("MUL SI");
                }
                else{
                    multiplicador = Integer.toBinaryString(AX); 
                    label.setText("MUL AX");
                }
                int fat1 = Integer.parseInt(multiplicando, 2);
                int fat2 = Integer.parseInt(multiplicador, 2);
                int res = fat1*fat2;
                String res_inteira = Integer.toBinaryString(res);
                res_inteira = ajusta_32bits(res_inteira);
                DX = Integer.parseInt(res_inteira.substring(0, 16), 2);
                AX = Integer.parseInt(res_inteira.substring(16, 32), 2);
                ajusta_flags(AX);
                IP = IP + 2;
                return -1;
            }
            else if(opcode.matches("23C[20]")){   //and ax,dx OU and ax,ax   and ax,ax nao faz nada, nao foi implementada
                if(opcode.charAt(3) == '2'){  // and ax,dx
                    AX = AX & DX;
                    ajusta_flags(AX);
                    label.setText("AND AX,DX");
                }
                else{
                    label.setText("AND AX,AX");
                }
                IP = IP +2;
                return -1;
            }
            else if(opcode.equalsIgnoreCase("F7D0")){     //not ax
                String valor = Integer.toBinaryString(AX);
                valor = ajusta_32bits(valor);
                valor = inverte_bin_string(valor.substring(16, 32));
                short s = (short)Integer.parseInt(valor, 2);
                AX = (int)s;
                IP = IP +2;
                ajusta_flags(AX);
                label.setText("NOT AX");
                return -1;
            }
            else if(opcode.matches("0BC[20]")){  // or ax,dx OU or ax,ax   or ax,ax nao faz nada..
                if(opcode.charAt(3) == '2'){  // or ax,dx
                    AX = AX | DX;
                    ajusta_flags(AX);
                    label.setText("OR AX,DX");
                }
                else{
                    label.setText("OR AX,AX");
                }
                IP = IP +2;
                return -1;
            }
            else if(opcode.matches("33C[20]")){  // xor ax,dx OU xor ax,ax
                if(opcode.charAt(3) == '2'){  // xor ax,dx
                    AX = AX ^ DX;
                    ajusta_flags(AX);
                    label.setText("XOR AX,DX");
                }
                else{
                    AX = 0;            // n xor n = 0 sempre..
                    ZF = 1;
                    label.setText("XOR AX,AX");
                }
                IP = IP +2;
                return -1;
            }
            else if(opcode.equalsIgnoreCase("C3")){        // ret
                int end = SP;
                Thing algo = Memoria.get(end);
                IP = algo.getValor();
                SP = SP + 2;                    //nao sei se ret altera o valor do stack pointer..
                label.setText("RET");
                return -1;
            }
            else if(opcode.matches("8ED[08]")){   // mov ss,ax OU mov ds,ax
                if(opcode.charAt(3) == '0'){ // mov ss,ax
                    SS = AX;
                    ajusta_flags(SS);
                    label.setText("MOV SS,AX");
                }
                else{
                   DS = AX;
                   ajusta_flags(DS); 
                   label.setText("MOV DS,AX");
                }
                IP = IP +2;
                return -1;
            }
            else if(opcode.matches("8CD[08]")){  // mov ax,ss OU mov ax,ds
                if(opcode.charAt(3) == '0'){ // mov ax,ss
                    AX = SS;
                    label.setText("MOV AX,SS");
                }
                else{
                   AX = DS;
                   label.setText("MOV AX,DS");
                }
                ajusta_flags(AX);
                IP = IP +2;
                return -1;
            }
            else if(opcode.equalsIgnoreCase("8CC8")){    // mov ax,cs
                AX = CS; 
                label.setText("MOV AX,CS");
                IP = IP +2;
                return -1;
            }
            else if(opcode.matches("8BC[246]")){   // mov ax,dx OU mov ax,sp OU mov ax,si
                switch(opcode.charAt(3)){
                    case '2': AX = DX; label.setText("MOV AX,DX");  break;
                    case '4': AX = SP; label.setText("MOV AX,SP"); break;
                    case '6': AX = SI; label.setText("MOV AX,SI"); break;
                    
                }
                ajusta_flags(AX);
                IP = IP +2;
                return -1;
            }
            else if(opcode.equalsIgnoreCase("8BE0")){  // mov sp,ax
                SP = AX;
                ajusta_flags(SP);
                IP = IP +2;
                label.setText("MOV SP,AX");
                return -1;
            }
            else if(opcode.matches("8B[DF]0")){  // mov dx,ax OU mov si,ax
                if(opcode.charAt(2) == 'D'){
                    DX = AX;
                    ajusta_flags(DX);
                    label.setText("MOV DX,AX");
                }
                else{
                    SI = AX;
                    ajusta_flags(SI);
                    label.setText("MOV SI,AX");
                }
                IP = IP +2;
                return -1;
            }
            else if(opcode.matches("8[B9]04")){  // mov ax,[si]  OU mov [SI],ax
                if(opcode.charAt(1) == 'B'){
                    AX = Memoria.get(SI).getValor();
                    ajusta_flags(AX);
                    IP = IP + 2;
                    label.setText("MOV AX,"+"["+SI+"]");
                    return -1;
                }
                else{                 //vai alterar algo na memoria mov [si],ax
                    Thing algo = Memoria.get(SI);
                    algo.setValor(AX);
                    IP = IP +2;
                    label.setText("MOV ["+SI+"],AX");
                    return SI;
                }
            }
            else if(opcode.matches("5[80]")){     // pop ax OU push ax
                if(opcode.charAt(1) == '8'){  // pop ax
                    try{
                        AX = Memoria.get(SP).getValor();
                        SP = SP +2;
                        label.setText("POP AX");
                    }
                    catch(NullPointerException e){
                        JOptionPane.showMessageDialog(null, "Pilha vazia", "Erro", JOptionPane.ERROR_MESSAGE); 
                    }
                    IP = IP +1;
                    return -1;
                }
                else{ //push ax
                    /*AX = 5;*/
                    SP = SP -2;
                    
                    if( SP > index_hlt){                        //só pode empilhar se a pilha nao estiver invadindo area de dados, delimitada pelo indice do hlt
                        Thing algo = Memoria.get(SP);
                        algo.setValor(AX);
                        label.setText("PUSH AX");
                        IP = IP +1;       // IP +1 pq é uma instrucao de um byte só
                        return SP;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Pilha invadiu área de dados!!!", "Erro", JOptionPane.ERROR_MESSAGE);
                        SP = SP +2;
                        IP = IP +1;
                        return -1;
                    }
                }
            }
            
            else{            //tipo 1 instrucao vazia
                label.setText("HLT");
                IP = IP +2;
                return -1;
            }
        }
        else{               //tipo 2  -- tem campo valor (cte ou mem)
            if(opcode.equalsIgnoreCase("05")){  // add ax,cte
                AX = AX + inst.getValor();
                ajusta_flags(AX);
                label.setText("ADD AX,#"+inst.getValor());
                IP = IP +2;
                return -1;
            }
            else if(opcode.equalsIgnoreCase("2D")){   // sub ax,cte
                AX = AX - inst.getValor();
                ajusta_flags(AX);
                label.setText("SUB AX,#"+inst.getValor());
                IP = IP +2;
                return -1;
            }
            else if(opcode.equalsIgnoreCase("25")){   // and ax,cte
                AX = AX & inst.getValor();
                ajusta_flags(AX);
                label.setText("AND AX,#"+inst.getValor());
                IP = IP +2;
                return -1;
            }
            else if(opcode.equalsIgnoreCase("0D")){   // or ax,cte
                AX = AX | inst.getValor();
                ajusta_flags(AX);
                label.setText("OR AX,#"+inst.getValor());
                IP = IP +2;
                return -1;
            }
            else if(opcode.equalsIgnoreCase("35")){  // xor ax,cte
                AX = AX ^ inst.getValor();
                ajusta_flags(AX);
                label.setText("XOR AX,#"+inst.getValor());
                IP = IP +2;
                return -1;
            }
            else if( opcode.matches("7[45A]")){  // jz end, jnz end ou jp end
                if(opcode.charAt(1) == '4'){  // jz end
                    switch(SR){
                        case 2: IP = inst.getValor(); break;
                        case 6: IP = inst.getValor(); break;
                        default  : IP = IP +2; break;
                    }
                    label.setText("JZ "+inst.getValor());
                    return -1;
                }
                else if(opcode.charAt(1) == '5'){  // jnz end
                    switch(SR){
                        case 0: IP = inst.getValor(); break;
                        case 1: IP = inst.getValor(); break;
                        case 4: IP = inst.getValor(); break;
                        case 5: IP = inst.getValor(); break;
                        default : IP = IP +2; break;
                    }
                    label.setText("JNZ "+inst.getValor());
                    return -1;
                }
                else{  // jp end
                    switch(SR){
                        case 0: IP = inst.getValor(); break;
                        case 2: IP = inst.getValor(); break;
                        case 4: IP = inst.getValor(); break;
                        case 6: IP = inst.getValor(); break;
                        default : IP = IP +2; break;
                    }
                    label.setText("JP "+inst.getValor());
                    return -1;
                }
            }
            else if(opcode.matches("E[B8]")){   // jmp end ou call end
                if(opcode.charAt(1) == 'B'){  // jmp end
                    IP = inst.getValor();
                    label.setText("JMP "+inst.getValor());
                    return -1;
                }
                else{   // call end
                    SP = SP - 2;
                    Thing algo = Memoria.get(SP);
                    algo.setValor(IP + 2);
                    IP = inst.getValor();
                    label.setText("CALL "+inst.getValor());
                    return SP;
                }
            }
            else if(opcode.matches("A[13]")){   // mov ax,mem ou mov mem,ax
                IP = IP +2;
                if(opcode.charAt(1) == '1'){  // mov ax,mem
                    //imprimeMemoria();
                    int valor = Memoria.get(endereco_real).getValor();
                    AX = valor;
                    ajusta_flags(AX);
                    label.setText("MOV AX,"+inst.getValor());
                    return -1;
                }
                else{  // mov mem, ax
                    Thing algo = Memoria.get(inst.getValor());
                    algo.setValor(AX);
                    label.setText("MOV "+inst.getValor()+",AX");
                    return inst.getValor();
                }
            }
            else if(opcode.matches("8[B9]84")){   // mov ax,mem[si]  ou mov mem[si],ax
                int end_real = SI + inst.getValor();
                IP = IP +3;
                if(opcode.charAt(1) == 'B'){  // mov ax,mem[si]
                    AX = Memoria.get(end_real).getValor();
                    ajusta_flags(AX);
                    label.setText("MOV AX,"+inst.getValor()+"["+SI+"]");
                    return -1;
                }
                else{  // mov mem[si],ax
                    Thing algo = Memoria.get(end_real);
                    algo.setValor(AX);
                    label.setText("MOV "+inst.getValor()+"["+SI+"], AX");
                    return end_real;
                }
            }
            else if(opcode.equalsIgnoreCase("B8")){   // mov ax,cte
                AX = inst.getValor();
                ajusta_flags(AX);
                IP = IP +2;
                label.setText("MOV AX,#"+inst.getValor());
                return -1;
            }
            else{
                IP = IP;
                return -1;
            }
        }
     }

    private String ajusta_bin_string(String bin_string) {
        StringBuilder sb = new StringBuilder();
        int dif = 16 - bin_string.length();
        int cont = 0;
        if( dif > 0){
            while(cont < dif){
                sb.append('0');
                cont++;
            }
            return sb.toString().concat(bin_string);
        }
        else if( dif < 0){
            return bin_string.substring(bin_string.length()-16, bin_string.length());
        }
        else{
            return bin_string;
        }
    }

    private void ajusta_flags(int destino) {
        if((destino > Short.MAX_VALUE) || (destino < Short.MIN_VALUE)){
            SR = SR | 4;
        }
        
        if( destino == 0){
            ZF = 1;
            SF = 0;
            //System.out.print("deu zero");
            SR = SR | 2;
            SR = SR & 6;
            //System.out.printf("sr: %d", SR);
        }
        else{
            ZF = 0;
            // SR = SR & 5;
            if( destino >= 0){
                SF = 0;
                SR = SR & 4;
            }
            else{
                SF = 1;
                SR = SR | 1;
                SR = SR & 5;
            }
        }
        
        
    }

    private String ajusta_32bits(String res_inteira) {
        StringBuilder sb = new StringBuilder();
        int dif = 32 - res_inteira.length();
        int cont = 0;
        if( dif > 0){
            while(cont < dif){
                sb.append('0');
                cont++;
            }
            return sb.toString().concat(res_inteira);
        }
        else{
            return res_inteira;
        }
    }

    private String inverte_bin_string(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
        }
        return sb.toString();
    }

    private void imprimeIndices() {
        for(int i = 0; i < Indices.size(); i++){
            System.out.print("\n"+i+":"+Indices.get(i));
        }
    }
}
