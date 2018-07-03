package cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LocaisInserir extends JInternalFrame {
	/**
	 * Inserção de Locais
	 * 
	 * @author Beatriz Felipe
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lb_nome, lb_num, lb_end;
	JTextField tf_nome, tf_num, tf_end;
    JComboBox cb_tipo;
    JButton bt_salvar, bt_limpar, bt_fechar;
    
    public LocaisInserir() {

    	this.setBounds(200,200,500,350);
		this.setResizable(false);
		this.setTitle("Cadastro de Locais");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		CadastroForm();
		this.setVisible(true);
		
    }
	private void CadastroForm() {
		
		lb_nome = new JLabel("Nome");
		tf_nome = new JTextField("");
		lb_num = new JLabel ("Número");
		tf_num = new JTextField("");
		lb_end = new JLabel ("Endereço");
		tf_end = new JTextField ("");
		cb_tipo        = new JComboBox();
		bt_salvar      = new JButton("Salvar");   
        bt_limpar      = new JButton("Limpar");   
        bt_fechar      = new JButton("Fechar");   
        
		cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
				"Selecione o Tipo de Local","Departamentos", "Salas", "Armários"
				}));
		
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
		        
		        this.bt_salvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						
						try {
							
							Locais locais = new Locais();
							locais.setNome(tf_nome.getText());
							locais.setEndereco(tf_end.getText());
							locais.setNumero(tf_num.getText());
							locais.setTipo(cb_tipo.getSelectedIndex());
		
							
							String out = "";
							out += "\nNome: " + locais.getNome();
							out += "\nEndereço: " + locais.getEndereco();
							out += "\nNumero: " + locais.getNumero();
							out += "\nTipo de Local: " + (locais.getTipo() == 1 ? "Departamentos" : "Salas" : "Armários");
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
