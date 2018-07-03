package cadastros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClientesInserir extends JInternalFrame{
	
	/**
	 * Inserção de Clientes
	 * 
	 * @author Evellyn dos Santos Silva
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lb_nome, lb_rg, lb_cpf, lb_tel, lb_email, lb_end, lb_tipoCli;
	JTextField tf_nome, tf_rg, tf_cpf, tf_tel, tf_email, tf_end;
	JComboBox cb_tipoCli;
    JButton bt_salvar;
	
	public ClientesInserir() {
		
		this.setBounds(200,200,500,350);
		this.closable = true;
		this.setTitle("Cadastro de Clientes");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		CadastroForm();
		this.setVisible(true);
	}

	
	public void CadastroForm() {
		
		lb_nome   = new JLabel("Nome:");
		tf_nome   = new JTextField("");
		lb_rg     = new JLabel("RG:");
		tf_rg     = new JTextField();
		lb_tipoCli = new JLabel("Tipo de Pessoa:");
		cb_tipoCli= new JComboBox();
		lb_cpf    = new JLabel("CPF/CNPJ:");
		tf_cpf    = new JTextField("");
		lb_tel    = new JLabel("Telefone:");
		tf_tel    = new JTextField("");
		lb_email  = new JLabel("E-mail:");
		tf_email  = new JTextField("");		
		lb_end      = new JLabel("Endereço:");
		tf_end      = new JTextField();
		bt_salvar   = new JButton("Salvar");   
		
		cb_tipoCli.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
						"Pessoa Física", "Pessoa Jurídica"
					}));
			 
		getContentPane().setLayout(null);
		
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
        
        this.bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Clientes cliente = new Clientes();
					
					cliente.setNome(tf_nome.getText());
					cliente.setCpf(Integer.parseInt(tf_cpf.getText()));
					cliente.setTipoCli(cb_tipoCli.getSelectedIndex());
					cliente.setRg(Integer.parseInt(tf_rg.getText()));
					cliente.setEnd(tf_end.getText());
					cliente.setEmail(tf_email.getText());
					cliente.setTel(Integer.parseInt(tf_tel.getText()));
					
					String out = "";
					out += "Nome: " + cliente.getNome();
					out += "\nCPF: " + cliente.getCpf();
					out += "\nTipo do Cadastro: " + (cliente.getTipoCli() == 1 ? "Pessoa Física" : "Pessoa Jurídica");
					out += "\nRG: " + cliente.getRg();
					out += "\nEndereço: " + cliente.getEnd();
					out += "\nE-mail: " + cliente.getEmail();
					out += "\nTelefone: " + cliente.getTel();
					out += "\n";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					ClientesDAO cli = new ClientesDAO(cliente);
					cli.inserirBanco(cliente);
					
					if(resposta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Inserido com Sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Inserção Cancelada.");
					}
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente.");
				}
				
				
			}
		});
        
	}
	
}
