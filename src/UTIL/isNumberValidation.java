package UTIL;

import javax.swing.*;

public class isNumberValidation {
    private int m;
    public isNumberValidation(String x){
        isNumber(x);
    }
    public int isNumber(String x){
        try {
            this.m = Integer.parseInt(x);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Apenas numero são permitidos nesse campo!");
            throw new RuntimeException(e);
        }
        return m;
    }


}
