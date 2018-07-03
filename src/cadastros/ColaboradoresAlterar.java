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

public class ColaboradoresAlterar extends JInternalFrame{
	
	/**
	 * Create by Amanda Priscila Da Silva
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lb_nome, lb_cpf, lb_dtnasc, lb_tel, lb_cel,lb_endereco;
	JTextField tf_nome, tf_cpf, tf_dtnasc, tf_tel, tf_cel,tf_endereco;
	JComboBox cb_tipo;
    JButton bt_salvar;
    
    public ColaboradoresAlterar() {
    	
    	this.setBounds(200,200,400,150);
		this.setTitle("Alterar Colaborador");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		alterarForm();
		this.setVisible(true);
		
    }
    
    public void alterarForm() {
    	
    	lb_nome        = new JLabel("Nome");
		tf_nome        = new JTextField();
		lb_cpf         = new JLabel("CPF");
		tf_cpf         = new JTextField("");
		bt_salvar     	  = new JButton("Salvar");  
		  
		
		getContentPane().setLayout(null);
		getContentPane().add(lb_nome);
                getContentPane().add(tf_nome);
                getContentPane().add(lb_cpf);
                getContentPane().add(tf_cpf);
                getContentPane().add(bt_salvar);
        
        (lb_nome).setBounds(20, 20, 90, 30);
        (tf_nome).setBounds(20, 50, 90, 30);
        (lb_cpf).setBounds(130, 20, 100, 30);
        (tf_cpf).setBounds(130, 50, 100, 30);
        (bt_salvar).setBounds(280, 48, 80, 30);
        
        this.bt_salvar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Colaboradores colaboradores = new Colaboradores();

					colaboradores.setNome(tf_nome.getText());
					colaboradores.setCpf(Integer.parseInt(tf_cpf.getText()));
					
					ColaboradoresDAO colab = new ColaboradoresDAO(colaboradores);
					colab.selecionarColaboradores(colaboradores);
					
					if(colaboradores.getNome() != null && colaboradores.getCpf() > 0) {
						
						alterarForm(colaboradores);
						
					 } else {
						 JOptionPane.showMessageDialog(null, "Erro! Campos n�o inseridos para consulta!");
					 }
					
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente!");
				} 
			}
		});
   
	
	}
		
	private void alterarForm(Colaboradores colaboradores) {
		
		JInternalFrame alterar = new JInternalFrame();
		this.setBounds(200,200,500,350);
		this.setResizable(false);
		this.setTitle("Cadastro de Colaboradores");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		
		//Nesta parte estou inicializando os meus componentes
		
		lb_nome        = new JLabel("Nome");
		lb_cpf         = new JLabel("CPF");
                lb_dtnasc      = new JLabel("Data de Nascimento");
		lb_tel         = new JLabel("Telefone");
		lb_cel         = new JLabel("Celular");
                lb_endereco    = new JLabel("Endere�o");
		tf_nome        = new JTextField(" ");
		tf_cpf         = new JTextField(" ");
                tf_dtnasc      = new JTextField(" ");
		tf_tel         = new JTextField(" ");
		tf_cel         = new JTextField(" ");
                tf_endereco    = new JTextField(" ");
		cb_tipo        = new JComboBox();
		bt_salvar      = new JButton("Salvar");   
        
        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
        		"Tipo de Colaborador","Proprietarios", "Acionistas", "Funcion�rios", 
				"Terceirizados"
				}));
		//Adiciona os componentes ao formul�rio
		getContentPane().setLayout(null);
		
		//Define o posicionamento dos componentes na tela (posi��o da coluna, posi��o da linha, comprimento da linha, altura da linha)
		//Adiciona os componentes ao formul�rio
		getContentPane().add(lb_nome);
        getContentPane().add(tf_nome);
        getContentPane().add(lb_cpf);
        getContentPane().add(tf_cpf);
        getContentPane().add(lb_dtnasc);
        getContentPane().add(tf_dtnasc);
        getContentPane().add(lb_tel);
        getContentPane().add(tf_tel);
        getContentPane().add(lb_cel);
        getContentPane().add(tf_cel);
        getContentPane().add(lb_endereco);
        getContentPane().add(tf_endereco);
        getContentPane().add(cb_tipo);
        getContentPane().add(bt_salvar);
        
        //Define o posicionamento dos componentes na tela (posi��o da coluna, posi��o da linha, comprimento da linha, altura da linha)
        lb_nome     .setBounds(20, 20, 100, 15);
        tf_nome     .setBounds(20, 40, 400, 25);   
        lb_endereco .setBounds(20, 70, 100, 15);
        tf_endereco .setBounds(20, 90, 400, 25);
        lb_tel      .setBounds(20, 120, 80, 15);
        tf_tel      .setBounds(20, 140, 160, 25);
        lb_cel      .setBounds(220, 120, 80, 15);
        tf_cel      .setBounds(220, 140, 160, 25);
        lb_dtnasc   .setBounds(20, 170, 80, 15);
        tf_dtnasc   .setBounds(20, 190, 160, 25);
        lb_cpf      .setBounds(220, 170, 80, 15);
        tf_cpf      .setBounds(220, 190, 160, 25);          
        cb_tipo     .setBounds(20, 230, 300, 25);   
        bt_salvar   .setBounds(20, 280, 80, 30);   
        
        this.setVisible(true);
        
        
        this.bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Colaboradores colaboradores = new Colaboradores();
					colaboradores.setNome(tf_nome.getText());
					colaboradores.setTelefone(tf_tel.getText());
                    colaboradores.setCpf(Integer.parseInt(tf_cpf.getText()));
					colaboradores.setTipo(cb_tipo.getSelectedIndex());
					
					//if(rb_ativo.isSelected())
						//instituicao.setAtivo(1);
					
					String out = "";
					out += "Certeza que deseja inserir esses itens?\n";
					out += "Nome: " + colaboradores.getNome();
					out += "\nCPF: " + colaboradores.getCpf();
                    out += "\nData de Nascimento: " + colaboradores.getDtnasc();
					out += "\nTelefone: " + colaboradores.getTelefone();
                    out += "\nEndere�o: " + colaboradores.getEndereco();
					out += "\nTipo: " + colaboradores.getTipoStr();
					out += "\n";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					ColaboradoresDAO colab = new ColaboradoresDAO(colaboradores);
					colab.alterarColab(colaboradores);
					
					if(resposta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Altera��o Cancelada!");
					}
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente!");
				}
				
				
			}
		});
        
	}

}
