package cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ClientesDeletar extends JInternalFrame {
	
	/**
	 * Exclusão de Clientes
	 * 
	 * @author Evellyns dos Santos Silva
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lb_nome, lb_rg, lb_cpf, lb_tel, lb_email, lb_end, lb_tipoCli;
	JTextField tf_nome, tf_rg, tf_cpf, tf_tel, tf_email, tf_end;
	JComboBox cb_tipoCli;
    JButton bt_salvar;
	
	public ClientesDeletar() {
		
		this.setBounds(200,200,400,150);
		this.closable = true;
		this.setTitle("Deletar Cliente");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		deletarForm();
		this.setVisible(true);
	}
    
    public void deletarForm() {
		
    	lb_cpf    = new JLabel("CPF/CNPJ:");
		tf_cpf    = new JTextField("");
		bt_salvar     	  = new JButton("Deletar");   
		
		getContentPane().setLayout(null);
		getContentPane().add(lb_cpf);
        getContentPane().add(tf_cpf);

        getContentPane().add(bt_salvar);

        (lb_cpf).setBounds(20, 20, 100, 30);
        (tf_cpf).setBounds(20, 50, 200, 30);
        (bt_salvar).setBounds(250, 45, 120, 30);
        
        this.bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					Clientes cliente = new Clientes();

					cliente.setCpf(Integer.parseInt(tf_cpf.getText()));
					
					ClientesDAO cli = new ClientesDAO();
					cli.selecionarBanco(cliente);
					
					String out = "Deseja deletar este cliente:";
					out += "Nome: " + cliente.getNome();
					out += "\nCPF: " + cliente.getCpf();
					out += "\nTipo do Cadastro: " + (cliente.getTipoCli() == 1 ? "Pessoa Física" : "Pessoa Jurídica");
					out += "\nRG: " + cliente.getRg();
					out += "\nEndereço: " + cliente.getEnd();
					out += "\nE-mail: " + cliente.getEmail();
					out += "\nTelefone: " + cliente.getTel();
					out += "\n";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					cli.deletarBanco(cliente);
					
					if(resposta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Exclusão Cancelada.");
					}
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente.");
				}
				
				
			}
		});	
	}
}
