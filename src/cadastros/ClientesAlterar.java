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

public class ClientesAlterar extends JInternalFrame {
	
	/**
	 * Alteração de Clientes
	 * 
	 * @author Evellyn dos Santos Silva
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lb_nome, lb_rg, lb_cpf, lb_tel, lb_email, lb_end, lb_tipoCli;
	JTextField tf_nome, tf_rg, tf_cpf, tf_tel, tf_email, tf_end;
	JComboBox cb_tipoCli;
    JButton bt_salvar;
	
	public ClientesAlterar() {
		
		this.setBounds(200,200,400,150);
		this.closable = true;
		this.setTitle("Alteração de Clientes");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		alterarForm();
		this.setVisible(true);
	}
    
    public void alterarForm() {
		
    	lb_cpf    = new JLabel("CPF/CNPJ:");
		tf_cpf    = new JTextField("");
		bt_salvar     	  = new JButton("Alterar");   
		
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
					
					Clientes cli = new Clientes();

					cli.setCpf(Integer.parseInt(tf_cpf.getText()));
					
					ClientesDAO cliente = new ClientesDAO();
					cliente.selecionarBanco(cli);
					
					if(cli.getCpf()> 1) {
						
						alterarForm(cli);
						
					 } else {
						 JOptionPane.showMessageDialog(null, "Erro! Campos não inseridos para consulta!");
					 }
					
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente!");
				} 
			}
		});
   
	
	}
		
	private void alterarForm(Clientes cli) {
		
		JInternalFrame alterar = new JInternalFrame();
		this.setBounds(200,200,500,350);
		this.closable = true;
		this.setTitle("Alteração de Clientes");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lb_nome   = new JLabel("Nome:");
		tf_nome   = new JTextField(cli.getNome());
		lb_rg     = new JLabel("RG:");
		tf_rg     = new JTextField(Integer.toString(cli.getRg()));
		lb_tipoCli = new JLabel("Tipo de Pessoa:");
		cb_tipoCli= new JComboBox();
		//lb_cpf    = new JLabel("CPF/CNPJ:");
		//tf_cpf    = new JTextField("");
		lb_tel    = new JLabel("Telefone:");
		tf_tel    = new JTextField(Integer.toString(cli.getTel()));
		lb_email  = new JLabel("E-mail:");
		tf_email  = new JTextField(cli.getEmail());		
		lb_end      = new JLabel("Endereço:");
		tf_end      = new JTextField(cli.getEnd());
		//bt_salva("Salvar");   
		
		cb_tipoCli.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
						"Pessoa Física", "Pessoa Jurídica"
					}));
		
		cb_tipoCli.setSelectedIndex(cli.getTipoCli());
	//Adiciona os componentes ao formulário
		getContentPane().setLayout(null);
		
		//Define o posicionamento dos componentes na tela (posição da coluna, posição da linha, comprimento da linha, altura da linha)
		//Adiciona os componentes ao formulário		
		getContentPane().add(lb_nome);
        getContentPane().add(tf_nome);
        getContentPane().add(lb_rg);
        getContentPane().add(tf_rg);
        getContentPane().add(lb_tipoCli);
        getContentPane().add(cb_tipoCli);
        getContentPane().add(lb_cpf);
        getContentPane().add(tf_cpf);
        getContentPane().add(lb_tel);
        getContentPane().add(tf_tel);
        getContentPane().add(lb_email);
        getContentPane().add(tf_email);
        getContentPane().add(lb_end);
        getContentPane().add(tf_end);
        getContentPane().add(bt_salvar);
		
        (lb_cpf).setBounds(20, 20, 90, 30);
        (tf_cpf).setBounds(20, 50, 90, 30);
        (lb_rg).setBounds(130, 20, 100, 30);
        (tf_rg).setBounds(130, 50, 100, 30);
        (lb_tipoCli).setBounds(250, 20, 200, 30);
        (cb_tipoCli).setBounds(250, 50, 200, 30);
        (lb_nome).setBounds(20, 90, 150, 30);
        (tf_nome).setBounds(20, 120, 440, 30);
        (lb_end).setBounds(20, 150, 250, 30);
        (tf_end).setBounds(20, 180, 440, 30);
        (lb_email).setBounds(20, 220, 80, 30);
        (tf_email).setBounds(20, 250, 160, 30);
        (lb_tel).setBounds(200, 220, 80, 30);
        (tf_tel).setBounds(200, 250, 80, 30);
        (bt_salvar).setBounds(340, 240, 90, 40);
        
        this.setVisible(true);
        
        
        this.bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					cli.setNome(tf_nome.getText());
					cli.setCpf(Integer.parseInt(tf_cpf.getText()));
					cli.setTipoCli(cb_tipoCli.getSelectedIndex());
					cli.setRg(Integer.parseInt(tf_rg.getText()));
					cli.setEnd(tf_end.getText());
					cli.setEmail(tf_email.getText());
					cli.setTel(Integer.parseInt(tf_tel.getText()));
					
					String out = "";
					out += "Nome: " + cli.getNome();
					out += "\nCPF: " + cli.getCpf();
					out += "\nTipo do Cadastro: " + (cli.getTipoCli() == 1 ? "Pessoa Física" : "Pessoa Jurídica");
					out += "\nRG: " + cli.getRg();
					out += "\nEndereço: " + cli.getEnd();
					out += "\nE-mail: " + cli.getEmail();
					out += "\nTelefone: " + cli.getTel();
					out += "\n";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					ClientesDAO cliente = new ClientesDAO(cli);
					cliente.alterarBanco(cli);
					
					if(resposta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Alterado Cancelada.");
					}
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente.");
				}
				
				
			}
		});
        
	}
}
