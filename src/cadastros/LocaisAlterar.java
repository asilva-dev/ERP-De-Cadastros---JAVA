package cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LocaisAlterar extends JInternalFrame {
	
	/**
	 * Alteração de Locais
	 * 
	 * @author Beatriz Felipe
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lb_nome, lb_num, lb_end;
	JTextField tf_nome, tf_num, tf_end;
    JLabel cb_tipo;
    JButton bt_salvar, bt_limpar, bt_fechar;
	
	public LocaisAlterar() {
		
		this.setBounds(200,200,400,150);
		this.closable = true;
		this.setTitle("Alteração de Locais");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		alterarForm();
		this.setVisible(true);
	}
    
    public void alterarForm() {
		
    	lb_nome   = new JLabel("Nome:");
		tf_nome    = new JTextField("");
		bt_salvar     	  = new JButton("Alterar");   
		
		getContentPane().setLayout(null);
		getContentPane().add(lb_nome);
        getContentPane().add(tf_nome);

        getContentPane().add(bt_salvar);

        (lb_nome).setBounds(20, 20, 100, 30);
        (tf_nome).setBounds(20, 50, 200, 30);
        (bt_salvar).setBounds(250, 45, 120, 30);
        
        this.bt_salvar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Locais locais = new Locais();

					locais.setNome(tf_nome.getText());
					
					LocaisDAO loc = new LocaisDAO();
					loc.selecionarBanco(locais);
					
					if(locais.getNome() != null) {
						
						alterarForm(locais);
						
					 } else {
						 JOptionPane.showMessageDialog(null, "Erro! Campos não inseridos para consulta!");
					 }
					
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente!");
				} 
			}
		});
   
	
	}
		
	private void alterarForm(Locais locais) {
		
		JInternalFrame alterar = new JInternalFrame();
		this.setBounds(200,200,500,350);
		this.closable = true;
		this.setTitle("Alteração de Locais");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lb_nome   = new JLabel("Nome:");
		tf_nome   = new JTextField(locais.getNome());
		lb_num     = new JLabel("Número:");
		tf_num     = new JTextField(locais.getNumero());
		cb_tipo 	= new JLabel("Tipo de Local:");
		cb_tipo 	= new JComboBox();
		lb_end      = new JLabel("Endereço:");
		tf_end      = new JTextField(locais.getEndereco());
		//bt_salva("Salvar");   
		
		cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
				"Selecione o Tipo de Local","Departamentos", "Salas", "Armários"
				}));
		
		cb_tipo.setSelectedIndex(cli.getTipoCli());
	//Adiciona os componentes ao formulário
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_nome);
		getContentPane().add(tf_nome);
        getContentPane().add(lb_num);
        getContentPane().add(tf_num);
        getContentPane().add(lb_end);
        getContentPane().add(tf_end);
        getContentPane().add(cb_tipo);
        getContentPane().add(bt_salvar);
        getContentPane().add(bt_limpar);
        getContentPane().add(bt_fechar);
        
        lb_nome     .setBounds(20, 20, 100, 15);
        tf_nome     .setBounds(20, 40, 400, 25);   
        lb_num    .setBounds(20, 70, 100, 15);
        tf_num     .setBounds(20, 90, 150, 25);
        lb_end      .setBounds(190, 70, 100, 25);
        tf_end      .setBounds(190, 90, 150, 25);
        cb_tipo     .setBounds(20, 130, 250, 25);   
        bt_salvar   .setBounds(20, 170, 80, 30);   
        bt_limpar   .setBounds(110, 170, 80, 30);   
        bt_fechar   .setBounds(200, 170, 80, 30); 
        
        this.setVisible(true);
        
        
        this.bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					locais.setNome(tf_nome.getText());
					locais.setTipo(cb_tipo.getSelectedIndex());
					locais.setEndereco(tf_end.getText());
					locais.setNumero(tf_num.getText());
					

					String out = "";
					out += "\nNome: " + locais.getNome();
					out += "\nEndereço: " + locais.getEndereco();
					out += "\nNumero: " + locais.getNumero();
					out += "\nTipo de Local: " + (locais.getTipoStr() == 1 ? "Departamentos" : "Salas" : "Armários");
					out += "\n";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					LocaisDAO inst = new LocaisDAO(locais);
					inst.inserirBanco(locais);
					
					if(resposta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Inserido com Sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Inserção Cancelada!");
					}
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente!");
				}
				
				
			}
		});
        
	}
	
}

