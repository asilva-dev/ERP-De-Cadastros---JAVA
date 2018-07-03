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

public class InstituicaoDeletar extends JInternalFrame {
	
	/**
	 * Exclusão das Instituições
	 * 
	 * @author Felipe Trindade Antoniolli
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lb_agencia, lb_conta, lb_endereco, lb_nomeTitular, lb_cpfCnpj, lb_idBanco, lb_tipoConta;
	JTextField tf_agencia, tf_conta, tf_tipoConta, tf_endereco, tf_nomeTitular, tf_cpfCnpj, tf_idBanco;
	JRadioButton rb_ativo;
	JComboBox cb_tipoConta;
    JButton bt_deletar;
    
    public InstituicaoDeletar() {
    	
    	this.setBounds(200,200,400,150);
		this.setTitle("Deletar Instituição");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		deletarForm();
		this.setVisible(true);
		
    }
    
    public void deletarForm() {
		
		lb_agencia        = new JLabel("Agencia");
		tf_agencia        = new JTextField();
		lb_conta          = new JLabel("Conta");
		tf_conta          = new JTextField("");
		bt_deletar     	  = new JButton("Deletar");   
		
		getContentPane().setLayout(null);
		getContentPane().add(lb_agencia);
        getContentPane().add(tf_agencia);
        getContentPane().add(lb_conta);
        getContentPane().add(tf_conta);
        getContentPane().add(bt_deletar);
        
        (lb_agencia).setBounds(20, 20, 90, 30);
        (tf_agencia).setBounds(20, 50, 90, 30);
        (lb_conta).setBounds(130, 20, 100, 30);
        (tf_conta).setBounds(130, 50, 100, 30);
        (bt_deletar).setBounds(280, 48, 80, 30);
        
        
        this.bt_deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Instituicao instituicao = new Instituicao();
					
					instituicao.setAgencia(Integer.parseInt(tf_agencia.getText()));
					instituicao.setConta(Integer.parseInt(tf_conta.getText()));
					
					InstituicaoDAO del = new InstituicaoDAO();
					
					del.selecionarBanco(instituicao);
					
					String out = "Deseja deletar está instituicão?";
					out += "\nAgencia: " + instituicao.getAgencia();
					out += "\nConta: " + instituicao.getConta();
					out += "\nTipo da Conta: " + (instituicao.getTipoConta() == 1 ? "Conta Corrente" : "Conta Poupança");
					out += "\nEndereço: " + instituicao.getEndereco();
					out += "\nTitular: " + instituicao.getNomeTitular();
					out += "\nCpf/Cnpj: " + instituicao.getCpfCnpj();
					out += "\nBanco: " + instituicao.getIdBanco();
					out += "\nAtivo: " + instituicao.getAtivo();
					out += "\n";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					if(resposta == JOptionPane.YES_OPTION) {
						
						del.deletarBanco(instituicao);
						
						JOptionPane.showMessageDialog(null, "Deletado com Sucesso!");
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Exclusão Cancelada!");
					}
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente!");
				}
				
				
			}
		});	
	}
}
