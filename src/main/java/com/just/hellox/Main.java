/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.just.hellox;

/**
 *
 * @author ali
 */
public class Main {
    
    // 40 45 +05      | 100  60 -50
    // 70 30 -13      | 080  50 -10
    // 53 45 -05      | 040  20 -05
           
    public static void main(String[] args) {
        Matrice m = new Matrice(3, 3);
        System.out.println("**** ****");
        m.afficher();
        System.out.println("**** ****");
        int [] a = m.maximax();
        System.out.println("**** ****");
        int [] b = m.maximin();
        System.out.println("**** ****");
        int [] c = m.minRegret();
        System.out.println("**** ****");
        double []d = m.critereHurwicz();
    }
}
