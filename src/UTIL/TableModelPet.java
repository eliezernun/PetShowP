package UTIL;

import DTO.PetDTO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelPet extends AbstractTableModel {
    private List<PetDTO> dados;
    private String [] columnN = {"Nome","Nascimento","Tamanho","inativo"};

    @Override
    public String getColumnName(int column){
        return columnN[column];
    }

    @Override
    public int getRowCount() {

        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return columnN.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                dados.get(rowIndex).getNome_pet();
                break;
            case 1:
                dados.get(rowIndex).getAniversario_pet();
                break;
            case 2:
                dados.get(rowIndex).getTamanho_pet();
                break;
            case 3:
                dados.get(rowIndex).isInativo_pet();
                break;

        }
        return null;
    }
    public  void setListPets(List<PetDTO> lista){
        this.dados = lista;
        System.out.println(dados);
    }

}
