package UI;

import DAO.FuncaoDAO;
import DTO.FuncaoDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Funcoens_UI {
    private JPanel Funcoes_panel;
    private JPanel Funcoes;
    private JTextField texto_codigo;
    private JTextField texto_descricao;
    private JButton editarButton;
    private JButton salvarButton;
    private JTable Tabela;
    private JButton novoButton;
    private JButton cancelarButton;
    private JCheckBox inativoCheckBox;
    private FuncaoDAO funcaoDAO = new FuncaoDAO();
    private FuncaoDTO funcaoDto = new FuncaoDTO();
    private List<FuncaoDTO> funcoes = funcaoDAO.getFuncoes();

    public Funcoens_UI() {
        UpdateTable(false);
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(texto_codigo.getText().isEmpty() || texto_codigo.getText().isBlank()){
                    JOptionPane.showMessageDialog(null, "Informe o código do item a ser modificado!");
                    texto_codigo.requestFocus();
                    return;
                }
                int text;
                try{
                    text = Integer.parseInt(texto_codigo.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Apenas numeros são permitidos!");
                    texto_codigo.requestFocus();
                    throw new RuntimeException(ex);
                }
                for (int i = 0; i < funcoes.size(); i++) {
                    if(funcoes.get(i).getId() == text){
                        funcaoDto.setId(funcoes.get(i).getId());
                        funcaoDto.setDescricao(funcoes.get(i).getDescricao().toUpperCase());
                        texto_codigo.setText(new String(String.valueOf(funcaoDto.getId())));
                        texto_descricao.setText(funcoes.get(i).getDescricao());
                        inativoCheckBox.setSelected(funcoes.get(i).isInativo());
                        organizarFormulario(2);
                        return;
                    }
                }

            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!texto_descricao.getText().isBlank() || !texto_descricao.getText().isEmpty()){
                    funcaoDto.setDescricao(texto_descricao.getText().toUpperCase());
                    funcaoDto.setInativo(inativoCheckBox.isSelected());
                    if(funcaoDto.getId() == 0){
                        funcaoDAO.setFuncion(funcaoDto);
                        UpdateTable(true);
                        texto_descricao.setText("");
                        organizarFormulario(1);
                        return;
                    }
                    else{
                        funcaoDAO.updateFuncao(funcaoDto);
                        UpdateTable(true);
                        texto_descricao.setText("");
                        organizarFormulario(4);
                        return;
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "A descrição não pode ser nula!");
                    return;
                }
            }
        });
        novoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcaoDto.limparFuncao();
                texto_descricao.setText("");
                texto_codigo.setText("");
                organizarFormulario(3);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcaoDto.limparFuncao();
                texto_descricao.setText("");
                texto_codigo.setText("");
                organizarFormulario(4);
            }
        });
    }

    private void organizarFormulario(int x){
        switch (x){
            case 1:
                salvarButton.setEnabled(false);
                texto_descricao.setEnabled(false);
                texto_descricao.setEditable(false);
                texto_codigo.setEditable(true);
                texto_codigo.setEnabled(true);
                break;
            case 2:
                salvarButton.setEnabled(true);
                texto_codigo.setEnabled(false);
                texto_codigo.setEditable(false);
                texto_descricao.setEditable(true);
                texto_descricao.setEnabled(true);
                editarButton.setEnabled(false);
                novoButton.setEnabled(false);
                break;
            case 3:
                editarButton.setEnabled(false);
                novoButton.setEnabled(false);
                salvarButton.setEnabled(true);
                cancelarButton.setEnabled(false);
                texto_codigo.setEditable(false);
                texto_codigo.setEnabled(false);
                texto_descricao.setEnabled(true);
                texto_descricao.setEditable(true);
                break;
            case 4:
                novoButton.setEnabled(true);
                editarButton.setEnabled(true);
                salvarButton.setEnabled(false);
                cancelarButton.setEnabled(false);
                texto_descricao.setEnabled(false);
                texto_codigo.setEnabled(true);
                texto_codigo.setEditable(true);
                break;
        }
    }

    public JPanel getFuncoes_panel() {
        return Funcoes_panel;
    }
    public void UpdateTable(boolean x){
        if(!x){
            organizarFormulario(1);
        }
        funcoes = funcaoDAO.getFuncoes();
        String[] columnN = {"ID", "Descrição", "inativo"};
        Object[][] data = new Object[funcoes.size()][];
        for (int i = 0; i < funcoes.size(); i++) {
            String inativo = funcoes.get(i).isInativo() == true ? "inativo":"ativo";
            data[i] = new Object[] {funcoes.get(i).getId(), funcoes.get(i).getDescricao(), inativo};
        }
        Tabela.setModel(new DefaultTableModel(data, columnN));
    }

}
