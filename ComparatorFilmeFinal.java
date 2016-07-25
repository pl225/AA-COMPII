/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Comparator;

/**
 *
 * @author Matheus
 */
public class ComparatorFilmeFinal implements Comparator<Filme> {

    @Override
    public int compare(Filme o1, Filme o2) {
        if (o1.getNotaFinal()==o2.getNotaFinal()) {
            return Integer.compare(o2.getTotalUsuarios(), o1.getTotalUsuarios());
        } else {
            return Double.compare(o2.getNotaFinal(), o1.getNotaFinal());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
