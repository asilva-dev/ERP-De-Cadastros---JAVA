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

public class ColaboradoresDeletar extends JInternalFrame {
	
	/**
	 * Create by Amanda Priscila da Silva
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JLabel lb_nome, lb_cpf, lb_dtnasc, lb_tel, lb_cel,lb_endereco;
	JTextField tf_nome, tf_cpf, tf_dtnasc, tf_tel, tf_cel,tf_endereco;
	JComboBox cb_tipo;
        JButton bt_deletar;
    
    public ColaboradoresDeletar() {
    	
    	this.setBounds(200,200,400,150);
		this.setTitle("Deletar Colaborador");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		deletarForm();
		this.setVisible(true);
		
    }
    
    public void deletarForm() {
		
		lb_nome        = new JLabel("Nome");
		tf_nome        = new JTextField();
		lb_cpf         = new JLabel("CPF");
		tf_cpf         = new JTextField("");
		bt_deletar     	  = new JButton("Deletar");   
		
		getContentPane().setLayout(null);
		getContentPane().add(lb_nome);
                getContentPane().add(tf_nome);
                getContentPane().add(lb_cpf);
                getContentPane().add(tf_cpf);
                getContentPane().add(bt_deletar);
        
        (lb_nome).setBounds(20, 20, 90, 30);
        (tf_nome).setBounds(20, 50, 90, 30);
        (lb_cpf).setBounds(130, 20, 100, 30);
        (tf_cpf).setBounds(130, 50, 100, 30);
        (bt_deletar).setBounds(280, 48, 80, 30);
        
                    
        this.bt_deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Colaboradores colaboradores = new Colaboradores();
					
					ColaboradoresDAO del = new ColaboradoresDAO();
					
					del.selecionarColaboradores(colaboradores);
					
					String out = "Deseja deletar este colaborador?";
					out += "\nNome: " + colaboradores.getNome();
					out += "\nData de Nascimento: " + colaboradores.getDtnasc();
					out += "\nTelefone: " + colaboradores.getTelefone();
					out += "\nCelular: " + colaboradores.getCelular();
					out += "\nEndereco: " + colaboradores.getEndereco();
					out += "\nCpf: " + colaboradores.getCpf();
					out += "\nTipo: " + colaboradores.getTipoInt();
					out += "\n";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					if(resposta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Deletado com Sucesso!");
						
						del.deletarColab(colaboradores);
						
					} else {
						JOptionPane.showMessageDialog(null, "Exclus�o Cancelada!");
					}
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente!");
				}
				
				
			}
		});	
	}
}