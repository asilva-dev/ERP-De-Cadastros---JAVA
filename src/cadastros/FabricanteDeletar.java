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

public class FabricanteDeletar extends JInternalFrame {
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lb_razaoSocial, lb_CNPJ, lb_IE, lb_IM, lb_logradouro, lb_bairro, lb_cidade, lb_UF, lb_pais, lb_cep, lb_telefone, lb_contato, lb_URL;
	JTextField tf_razaoSocial, tf_CNPJ, tf_IE, tf_IM, tf_logradouro, tf_bairro, tf_cidade, tf_UF, tf_pais, tf_cep, tf_telefone, tf_contato, tf_URL;
    JButton bt_salvar;
    JButton bt_deletar;
    
    public FabricanteDeletar() {
    	
    	this.setBounds(200,200,400,150);
		this.setTitle("Deletar Fabricante");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		deletarForm();
		this.setVisible(true);
		
    }
    
    public void deletarForm() {
		
		lb_razaoSocial        = new JLabel("Razão Social: ");
		tf_razaoSocial        = new JTextField("");
		lb_CNPJ               = new JLabel("CNPJ: ");
		tf_CNPJ               = new JTextField();
		bt_deletar     	  = new JButton("Deletar");   
		
		getContentPane().setLayout(null);
		getContentPane().add(lb_razaoSocial);
        getContentPane().add(tf_razaoSocial);
        getContentPane().add(lb_CNPJ);
        getContentPane().add(tf_CNPJ);
        getContentPane().add(bt_deletar);
        
        (lb_razaoSocial).setBounds(20, 20, 90, 30);
        (tf_razaoSocial).setBounds(20, 50, 90, 30);
        (lb_CNPJ).setBounds(130, 20, 100, 30);
        (tf_CNPJ).setBounds(130, 50, 100, 30);
        (bt_deletar).setBounds(280, 48, 80, 30);
        
        
        this.bt_deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Fabricante fab = new Fabricante();
					
					fab.setRazaoSocial(tf_razaoSocial.getText());
					fab.setCNPJ(tf_CNPJ.getText());
					
					FabricanteDAO del = new FabricanteDAO();
					
					del.selecionarBanco(fab);
					
					String out = "Deseja deletar este fabricante?";
					
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					if(resposta == JOptionPane.YES_OPTION) {
						
						del.deletarBanco(fab);
						
						JOptionPane.showMessageDialog(null, "Deletado com Sucesso!");
						
						
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
