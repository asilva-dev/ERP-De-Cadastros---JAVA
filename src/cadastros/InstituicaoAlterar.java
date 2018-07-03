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

public class InstituicaoAlterar extends JInternalFrame {
	
	/**
	 * Altera��o de Institui��es
	 * 
	 * @author Felipe Trindade Antoniolli
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	JLabel lb_agencia, lb_conta, lb_endereco, lb_nomeTitular, lb_cpfCnpj, lb_idBanco, lb_tipoConta;
	JTextField tf_agencia, tf_conta, tf_tipoConta, tf_endereco, tf_nomeTitular, tf_cpfCnpj, tf_idBanco;
	JRadioButton rb_ativo;
	JComboBox cb_tipoConta;
        JButton bt_salvar;
    
    public InstituicaoAlterar() {
    	
    	this.setBounds(200,200,400,150);
		this.setTitle("Alterar Institui��o");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		alterarForm();
		this.setVisible(true);
		
    }
    
    public void alterarForm() {
		
		lb_agencia        = new JLabel("Agencia");
		tf_agencia        = new JTextField();
		lb_conta          = new JLabel("Conta");
		tf_conta          = new JTextField("");
		bt_salvar     	  = new JButton("Salvar");   
		
		getContentPane().setLayout(null);
		getContentPane().add(lb_agencia);
        getContentPane().add(tf_agencia);
        getContentPane().add(lb_conta);
        getContentPane().add(tf_conta);
        getContentPane().add(bt_salvar);
        
        (lb_agencia).setBounds(20, 20, 90, 30);
        (tf_agencia).setBounds(20, 50, 90, 30);
        (lb_conta).setBounds(130, 20, 100, 30);
        (tf_conta).setBounds(130, 50, 100, 30);
        (bt_salvar).setBounds(280, 48, 80, 30);
        
        this.bt_salvar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Instituicao instituicao = new Instituicao();

					instituicao.setAgencia(Integer.parseInt(tf_agencia.getText()));
					instituicao.setConta(Integer.parseInt(tf_conta.getText()));
					
					InstituicaoDAO inst = new InstituicaoDAO(instituicao);
					inst.selecionarBanco(instituicao);
					
					if(instituicao.getAgencia() > 0 && instituicao.getConta() > 0) {
						
						alterarForm(instituicao);
						
					 } else {
						 JOptionPane.showMessageDialog(null, "Erro! Campos n�o inseridos para consulta!");
					 }
					
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente!");
				} 
			}
		});
   
	
	}
		
	private void alterarForm(Instituicao instituicao) {
		
		JInternalFrame alterar = new JInternalFrame();
		this.setBounds(200,200,500,350);
		this.setResizable(false);
		this.setTitle("Cadastro de Institui��es");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		
		
		Boolean ativo = instituicao.getAtivo() == 1 ? true : false;
		
		
		//Nesta parte estou inicializando os meus componentes
		//lb_agencia        = new JLabel("Agencia");
		//tf_agencia        = new JTextField("");
		//lb_conta          = new JLabel("Conta");
		cb_tipoConta      = new JComboBox();
		//tf_conta          = new JTextField("");
		lb_endereco       = new JLabel("Endere�o");
		tf_endereco       = new JTextField(instituicao.getEndereco());
		lb_nomeTitular    = new JLabel("Nome do Titular");
		tf_nomeTitular    = new JTextField(instituicao.getNomeTitular());
		lb_cpfCnpj        = new JLabel("CPF/CNPJ");
		tf_cpfCnpj	      = new JTextField(Integer.toString(instituicao.getCpfCnpj()));
		lb_idBanco        = new JLabel("N� Banco");
		tf_idBanco        = new JTextField(Integer.toString(instituicao.getIdBanco()));
		//bt_salvar     	  = new JButton("Salvar");   
        lb_tipoConta      = new JLabel("Tipo de Conta");
        rb_ativo          = new JRadioButton("Ativo", ativo);
        
        cb_tipoConta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
					"Conta Corrente", "Conta Poupan�a"
				}));
        
        cb_tipoConta.setSelectedIndex(instituicao.getTipoConta());
		//Adiciona os componentes ao formul�rio
		getContentPane().setLayout(null);
		
		//Define o posicionamento dos componentes na tela (posi��o da coluna, posi��o da linha, comprimento da linha, altura da linha)
		//Adiciona os componentes ao formul�rio
        getContentPane().add(lb_agencia);
        getContentPane().add(tf_agencia);
        getContentPane().add(lb_conta);
        getContentPane().add(cb_tipoConta);
        getContentPane().add(tf_conta);
        getContentPane().add(lb_endereco);
        getContentPane().add(tf_endereco);
        getContentPane().add(lb_nomeTitular);
        getContentPane().add(tf_nomeTitular);
        getContentPane().add(lb_cpfCnpj);
        getContentPane().add(tf_cpfCnpj);
        getContentPane().add(lb_idBanco);
        getContentPane().add(tf_idBanco);
        getContentPane().add(bt_salvar);
        getContentPane().add(lb_tipoConta);
        getContentPane().add(rb_ativo);
        
        //Define o posicionamento dos componentes na tela (posi��o da coluna, posi��o da linha, comprimento da linha, altura da linha)
        (lb_agencia).setBounds(20, 20, 90, 30);
        (tf_agencia).setBounds(20, 50, 90, 30);
        (lb_conta).setBounds(130, 20, 100, 30);
        (tf_conta).setBounds(130, 50, 100, 30);
        (lb_tipoConta).setBounds(260, 20, 200, 30);
        (cb_tipoConta).setBounds(260, 50, 200, 30);
        (lb_endereco).setBounds(20, 90, 150, 30);
        (tf_endereco).setBounds(20, 120, 440, 30);
        (lb_nomeTitular).setBounds(20, 150, 250, 30);
        (tf_nomeTitular).setBounds(20, 180, 440, 30);
        (lb_cpfCnpj).setBounds(20, 220, 80, 30);
        (tf_cpfCnpj).setBounds(20, 250, 160, 30);
        (lb_idBanco).setBounds(200, 220, 80, 30);
        (tf_idBanco).setBounds(200, 250, 80, 30);
        (rb_ativo).setBounds(290, 245, 80, 30);
        (bt_salvar).setBounds(370, 240, 90, 40);
        
        this.setVisible(true);
        
        
        this.bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					instituicao.setIdBanco(instituicao.getIdBanco());
					instituicao.setAgencia(Integer.parseInt(tf_agencia.getText()));
					instituicao.setConta(Integer.parseInt(tf_conta.getText()));
					instituicao.setTipoConta(cb_tipoConta.getSelectedIndex());
					instituicao.setEndereco(tf_endereco.getText());
					instituicao.setNomeTitular(tf_nomeTitular.getText());
					instituicao.setCpfCnpj(Integer.parseInt(tf_cpfCnpj.getText()));
					instituicao.setIdBanco(Integer.parseInt(tf_idBanco.getText()));
					
					if(rb_ativo.isSelected())
						instituicao.setAtivo(1);
					
					String out = "";
					out += "Agencia: " + instituicao.getAgencia();
					out += "\nConta: " + instituicao.getConta();
					out += "\nTipo da Conta: " + (instituicao.getTipoConta() == 1 ? "Conta Corrente" : "Conta Poupan�a");
					out += "\nEndere�o: " + instituicao.getEndereco();
					out += "\nTitular: " + instituicao.getNomeTitular();
					out += "\nCpf/Cnpj: " + instituicao.getCpfCnpj();
					out += "\nBanco: " + instituicao.getIdBanco();
					out += "\nAtivo: " + instituicao.getAtivo();
					out += "\n";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					InstituicaoDAO inst = new InstituicaoDAO(instituicao);
					inst.alterarBanco(instituicao);
					
					if(resposta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Inserido com Sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Inser��o Cancelada!");
					}
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente!");
				}
				
				
			}
		});
        
	}
}
