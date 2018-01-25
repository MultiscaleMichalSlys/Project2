/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt2.st;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Michał Słyś
 */
class MC {

    Automat[][] tab;
    int rozmiar = 400;
    int l_stanow = 10;
    int nr_iter = 0;
    List<Automat> lista;

    MC(int _rozmiar, int n) {
        rozmiar = _rozmiar;
        if (rozmiar > 400) {
            rozmiar = 400;
        }
        tab = new Automat[_rozmiar][_rozmiar];
        l_stanow = n;
    }

    class Automat {

        int x;
        int y;
        int id;
        int energia;

        Automat() {
            x = 0;
            y = 0;
            energia = 0;
            id = 0;
        }
    }

    void rozlosuj() {
        cleanTable();
        Random r = new Random();
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                tab[i][j].id = r.nextInt(l_stanow - 1) + 1;
            }
        }
    }

    void cleanTable() {
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                tab[i][j] = new Automat();
            }
        }
    }

    void wypisz_tab() {
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }

    }
    
    void iteration() {
        int x1,x2,y1,y2;
        for (int i=0; i<rozmiar; i++) {
            for (int j=0; j<rozmiar; j++) {
                x1 = i - 1;
                x2 = i + 1;
                y1 = j - 1;
                y2 = j + 1;
                if (x1 < 0) {            
                    x1 = rozmiar - 1;
                }
                if (x2 > rozmiar - 1) {
                    x2 = 0;
                }
                if (y1 < 0) {
                    y1 = rozmiar - 1;     
                }
                if (y2 > rozmiar - 1) {
                    y2 = 0;
                }
                
                
               
            }
        }
        
        
    }
    
    
    

//    void interacja(boolean bc) {
//        if (nr_iter == 0 || lista.isEmpty()) {
//            lista = new ArrayList<Automat>();
//            for (int i = 0; i < rozmiar; i++) {
//                for (int j = 0; j < rozmiar; j++) {
//                    Automat a = new Automat();
//                    a.x = i;
//                    a.y = j;
//                    a.id = tab[i][j];
//                    lista.add(a);
//                }
//            }
//        }
//
//        nr_iter++;
//
//        Automat a;
//        boolean granica = false;
//        int x1, x2, y1, y2;
//        int i, j;
//        int ktory;
//
//        do {
//            Random r = new Random();
//            ktory = r.nextInt(lista.size());
//            a = lista.get(ktory);
//            i = a.x;
//            j = a.y;
//
//            x1 = i - 1;
//            x2 = i + 1;
//            y1 = j + 1;
//            y2 = j - 1;
//            if (bc) {
//                if (x1 < 0) {            //---------------periodyczne
//                    x1 = rozmiar - 1;
//                }
//                if (x2 > rozmiar - 1) {
//                    x2 = 0;
//                }
//                if (y1 > rozmiar - 1) {
//                    y1 = 0;
//                }
//                if (y2 < 0) {
//                    y2 = rozmiar - 1;     //---------------sprawdzenie nieperiodycznych przy zliczaniu sasiadow
//                }
//            }
////            granica = true;
////            if ((x1 < 0 || x2 > 399 || y1 > 399 || y2 < 0) && granica == false) {
////                continue;
////            } else if (tab[x1][y1] != tab[i][j]) {
////                granica = true;
////            } else if (tab[i][y1] != tab[i][j]) {
////                granica = true;
////            } else if (tab[x2][y1] != tab[i][j]) {
////                granica = true;
////            } else if (tab[x1][j] != tab[i][j]) {
////                granica = true;
////            } else if (tab[x2][j] != tab[i][j]) {
////                granica = true;
////            } else if (tab[x1][y2] != tab[i][j]) {
////                granica = true;
////            } else if (tab[i][y2] != tab[i][j]) {
////                granica = true;
////            } else if (tab[x2][y2] != tab[i][j]) {
////                granica = true;
////            }
//
//        } while (!granica);
//
//        int energia = 0; //ilosc sasiadow
//        if (x1 >= 0 && y2 >= 0 && tab[x1][y2] != tab[i][j]) {
//            energia++;
//        }
//        if (x1 >= 0 && tab[x1][j] != tab[i][j]) {
//            energia++;
//        }
//        if (x1 >= 0 && y1 < rozmiar && tab[x1][y1] != tab[i][j]) {
//            energia++;
//        }
//        if (y1 < rozmiar && tab[i][y1] != tab[i][j]) {
//            energia++;
//        }
//        if (y2 >= 0 && tab[i][y2] != tab[i][j]) {
//            energia++;
//        }
//        if (x2 < rozmiar && y2 >= 0 && tab[x2][y2] != tab[i][j]) {
//            energia++;
//        }
//        if (x2 < rozmiar && tab[x2][j] != tab[i][j]) {
//            energia++;
//        }
//        if (x2 < rozmiar && y1 < rozmiar && tab[x2][y1] != tab[i][j]) {
//            energia++;
//        }
//
//        int[] t = new int[8];
//        int licznik = 0;
//        if (x1 >= 0 && y1 <= rozmiar - 1 && tab[x1][y1] > 0) {
//            t[licznik++] = tab[x1][y1];
//        }
//        if (x1 >= 0 && tab[x1][j] > 0) {
//            t[licznik++] = tab[x1][j];
//        }
//        if (x1 >= 0 && y2 >= 0 && tab[x1][y2] > 0) {
//            t[licznik++] = tab[x1][y2];
//        }
//        if (y1 <= rozmiar - 1 && tab[i][y1] > 0) {
//            t[licznik++] = tab[i][y1];
//        }
//        if (y2 >= 0 && tab[i][y2] > 0) {
//            t[licznik++] = tab[i][y2];
//        }
//        if (y1 <= rozmiar - 1 && x2 <= rozmiar - 1 && tab[x2][y1] > 0) {
//            t[licznik++] = tab[x2][y1];
//        }
//        if (x2 <= rozmiar - 1 && tab[x2][j] > 0) {
//            t[licznik++] = tab[x2][j];
//        }
//        if (x2 <= rozmiar - 1 && y2 >= 0 && tab[x2][y2] > 0) {
//            t[licznik++] = tab[x2][y2];
//        }
//
//        int najw;
//        //najw= najwiecej(t,licznik);           // ten id ktorego jest najwiecej w otoczeniu
//        Random los = new Random();         // ?????????????????????? losowy id z otoczenia 
//        najw = t[los.nextInt(8)];          //??????????????????????
//
//        int energia2 = 0; //ilosc sasiadow
//        if (x1 >= 0 && y2 >= 0 && tab[x1][y2] != najw) {
//            energia2++;
//        }
//        if (x1 >= 0 && tab[x1][j] != najw) {
//            energia2++;
//        }
//        if (x1 >= 0 && y1 < rozmiar && tab[x1][y1] != najw) {
//            energia2++;
//        }
//        if (y1 < rozmiar && tab[i][y1] != najw) {
//            energia2++;
//        }
//        if (y2 >= 0 && tab[i][y2] != najw) {
//            energia2++;
//        }
//        if (x2 < rozmiar && y2 >= 0 && tab[x2][y2] != najw) {
//            energia2++;
//        }
//        if (x2 < rozmiar && tab[x2][j] != najw) {
//            energia2++;
//        }
//        if (x2 < rozmiar && y1 < rozmiar && tab[x2][y1] != najw) {
//            energia2++;
//        }
//
//        if (energia2 <= energia) {
//            tab[i][j] = najw;
//        }
//
//        lista.remove(ktory);
//
//        // System.out.println(nr_iter);
//    }

    private int najwiecej(int[] lista, int licznik) {
        int i, j, L, W, maxL, maxW = 0;
        maxL = 0;
        for (i = 0; i < licznik; i++) {
            W = lista[i];
            L = 0;
            for (j = 0; j < licznik; j++) {
                if (lista[j] == W) {
                    L++;
                }
            }
            if (L > maxL) {
                maxL = L;
                maxW = W;
            }

        }
        return maxW;
    }

}
