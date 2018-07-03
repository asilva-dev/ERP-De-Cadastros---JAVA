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

public class LocaisDeletar extends JInternalFrame {
	
	/**
	 * Exclusão de Locais
	 * 
	 * @author Beatriz Felipe
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lb_nome, lb_num, lb_end;
	JTextField tf_nome, tf_num, tf_end;
    JComboBox cb_tipo;
    JButton bt_salvar, bt_limpar, bt_fechar;
	
	public LocaisDeletar() {
		
		this.setBounds(200,200,400,150);
		this.closable = true;
		this.setTitle("Deletar Local");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		deletarForm();
		this.setVisible(true);
	}
    
    public void deletarForm() {
		
    	lb_nome    = new JLabel("Nome:");
		tf_nome	   = new JTextField("");
		bt_salvar     	  = new JButton("Deletar");   
		
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
					Locais locais = new locais();

					locais.setNome(Integer.parseInt(tf_nome.getText()));
					
					LocaisDAO locais = new LocaisDAO();
					locais.selecionarBanco(locais);
					
					String out = "Deseja deletar este local:";
					out += "Nome: " + cliente.getNome();
					out += "\nCPF: " + cliente.getNumero();
					out += "\nEndereço: " + cliente.getEnd();
					out += "\nTipo de Local: " + (cliente.getTipoStr() == 1 ? "Departamento" : "Sala" : "Armário");
					out += "\n";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					locais.deletarBanco(locais);
					
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
