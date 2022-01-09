/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.just.hellox;

import java.util.Scanner;

/**
 *
 * @author ali
 */
public class Matrice {
    private int ligne;
    private int coloumn;
    private int[][] matrice;
    private Scanner scanner = new Scanner(System.in);

    public Matrice(int ligne, int coloumn, int[][] matrice) {
        this.ligne = ligne;
        this.coloumn = coloumn;
        this.matrice = matrice;
    }
    
    public Matrice(int ligne, int coloumn) {
        this.ligne = ligne;
        this.coloumn = coloumn;
        matrice = new int[ligne][coloumn];
        System.out.println("Remplir La matrice svp "+(ligne*coloumn)+" Nombre");
        for (int i = 0;i< ligne; i++){
            for(int j = 0;j< coloumn;j++){
                //System.out.print(String.format("Entrez matrice[%d][%d] : ", i, j));
                matrice[i][j] = scanner.nextInt();
            }// end loop (j)
        } // end loop (i)
    } // end Constructor
    
    // Affiche
    public void afficher(){
        for (int i = 0;i< ligne; i++){
                for(int j = 0;j< coloumn;j++){
                    System.out.print(matrice[i][j]+"  " );
                }// end loop (j)
                System.out.println();
            } // end loop (i)
    } // end affiche
    
    public int maximax(){
        System.out.println("Maximax Agorithme");
        System.out.println();
        int maxLigne ,max = matrice[0][0], line = 0;
        for(int i =0 ;i< ligne;i++){
            maxLigne = matrice[i][0];
            for(int j = 1; j< coloumn; j++){    
                if (maxLigne < matrice[i][j]){
                    maxLigne = matrice[i][j];
                }    
            } // end j loop
            // Max Ligne
                System.out.println("Maximum de ligne " +i+" "+" c'est "+maxLigne);
                if (maxLigne > max ){
                    max = maxLigne;
                    line = i;
                } // comparisson max maxligne
        } // end i loop
        System.out.println("max is :" + max+ " investe in line " + line);
        return line;
    }
    
    // maximin
    
    public int maximin(){
        System.out.println("Maximin Agorithme");
        System.out.println();
        int minLigne ,max = Integer.MIN_VALUE, line = 0;
        for(int i =0 ;i< ligne;i++){
            minLigne = matrice[i][0];
            for(int j = 1; j< coloumn; j++){
                
                if (minLigne > matrice[i][j]){
                    minLigne = matrice[i][j];
                }
                
            } // end j loop
            // Max Ligne
                System.out.println("Minimun de ligne " +i+" "+" c'est "+minLigne);
                if (minLigne > max ){
                    max = minLigne;
                    line = i;
                } // comparisson max maxligne
        } // end i loop
        System.out.println("max is :" + max +"  invest in line "+ line);
        return line;
    }
    // step (1)
    public int[] maxCol(){
        int maxColomn  ;
        int [] list = new int[ligne];
        for(int j = 0; j < coloumn; j++){  
            maxColomn = Integer.MIN_VALUE;
            for (int i = 0; i < ligne; i ++){
                if(maxColomn < matrice[i][j]){
                    maxColomn = matrice[i][j];
                }
            }// end i loop 
            //System.out.println("max colomn is "+ maxColomn);
            list[j] = maxColomn;
        }  // end j loop 
        return list ;
    }
    public int[][] resoit(){
       int mat[][] = new int[ligne][coloumn];
       for (int i= 0;i<ligne;i++){
            for (int j = 0; j< coloumn;j++){
                mat[i][j]= matrice[i][j];
            }// end j loop
    } //
     return mat;  
    }
    //step (2)
    public int[][] subMatice(int[] a){
        int mat[][] = resoit();
        for (int i= 0;i<ligne;i++){
            for (int j = 0; j< coloumn;j++){
                mat[i][j]  = a[j]-mat[i][j];
            }// end j loop
    } // end i loop
        return matrice;
    } // end method
    public int minRegret(){
        System.out.println("MinRegret Agorithme");
        System.out.println();
        int maxLigne ,min = Integer.MAX_VALUE, line = 0;
        //step (1)
        int[] list = maxCol(); 
        //step (2)
        int mat[][] = subMatice(list);
        // afficher
        for (int i = 0;i< ligne; i++){
                for(int j = 0;j< coloumn;j++){
                    System.out.print(mat[i][j]+"  " );
                }// end loop (j)
                System.out.println();
            } // end loop (i)
        //step (3)
        for(int i =0 ;i< ligne;i++){
            maxLigne = mat[i][0];
            for(int j = 1; j< coloumn; j++){    
                if (maxLigne < mat[i][j]){
                    maxLigne = mat[i][j];
                }    
            } // end j loop
            // Max Ligne
                System.out.println("Maximum de ligne " +i+" "+" c'est "+maxLigne);
                if (maxLigne < min ){
                    min = maxLigne;
                    line = i;
                } // comparisson max maxligne
        } // end i loop
        System.out.println("max is :" + min+ " investe in line " + line);
        return line;
    } // end minRegret
    
    public int critereHurwicz(){
    System.out.println("CritereHurwicz Algorithme");
    System.out.println();    
    int maxLigne, minLigne ,line = 0;
    double alpha =  0.8,alpha_1, result, max = Double.MIN_VALUE ;
    alpha_1 = 1- alpha;
    for (int i = 0; i<ligne; i++){
        maxLigne = Integer.MIN_VALUE;
        minLigne = Integer.MAX_VALUE;        
        for(int j =0; j<coloumn; j++){
            //System.out.println("* matrice [i][j]"+ matrice[i][j]);
            // max line
            if(maxLigne < matrice[i][j]){
                maxLigne = matrice[i][j];
            }
            // min line
            if(minLigne > matrice[i][j]){
                minLigne = matrice[i][j];
            }
        } // end loop j
        System.out.println("maximun de lign "+ i+" = "+maxLigne+"  min = "+minLigne);
        result  = (alpha * maxLigne)+(alpha_1 * minLigne);
        if (max < result){
            max = result;
            line = i;
        }
    } // end loop i
    System.out.println("max is "+ max + " invest in line "+ line);
    // alpha * max_alt + (1-alpha) * min_alt
    return line;
    }// fin

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColoumn() {
        return coloumn;
    }

    public void setColoumn(int coloumn) {
        this.coloumn = coloumn;
    }
    
    
    
}
