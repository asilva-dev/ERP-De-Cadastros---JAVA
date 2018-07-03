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

public class ProdutoInserir extends JInternalFrame{
	

	private static final long serialVersionUID = 1L;
	JLabel lb_produto, lb_descr, lb_fabricante, lb_tipoMaterial, lb_tags, lb_ativo;
	JTextField tf_produto, tf_descr, tf_fabricante, tf_tags;
	JRadioButton rb_ativo;
	JComboBox cb_tipoMaterial;
    JButton bt_salvar;
	
	public ProdutoInserir() {
		
		this.setBounds(200,200,500,350);
		this.closable = true;
		this.setTitle("Cadastro de Produto");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		CadastroForm();
		this.setVisible(true);
	}

	
	public void CadastroForm() {
		
		lb_produto   = new JLabel("Produto: ");
		tf_produto   = new JTextField("");
		lb_descr     = new JLabel("Descrição:");
		tf_descr     = new JTextField();
		lb_fabricante = new JLabel("Tipo de Pessoa:");
		tf_fabricante = new JTextField();
		lb_tipoMaterial    = new JLabel("CPF/CNPJ:");
		cb_tipoMaterial    = new JComboBox("");
		lb_tags    = new JLabel("Tags: ");
		tf_tags    = new JTextField("");
		lb_ativo  = new JLabel("Ativo: ");
		rb_ativo  = new JRadioButton("");		
		bt_salvar   = new JButton("Salvar");   
		
		cb_tipoMaterial.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
						"Perecível", "Nao Perecivel"
					}));
			 
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_produto);
        getContentPane().add(tf_produto);
        getContentPane().add(lb_descr);
        getContentPane().add(tf_descr);
        getContentPane().add(lb_fabricante);
        getContentPane().add(tf_fabricante);
        getContentPane().add(lb_tipoMaterial);
        getContentPane().add(cb_tipoMaterial);
        getContentPane().add(lb_tags);
        getContentPane().add(tf_tags);
        getContentPane().add(lb_ativo);
        getContentPane().add(rb_ativo);
        getContentPane().add(bt_salvar);
		
        (lb_produto).setBounds(20, 20, 90, 30);
        (tf_produto).setBounds(20, 50, 90, 30);
        (lb_descr).setBounds(130, 20, 100, 30);
        (tf_descr).setBounds(130, 50, 100, 30);
        (lb_fabricante).setBounds(250, 20, 200, 30);
        (tf_fabricante).setBounds(250, 50, 200, 30);
        (lb_tipoMaterial).setBounds(20, 90, 150, 30);
        (cb_tipoMaterial).setBounds(20, 120, 440, 30);
        (lb_tags).setBounds(20, 150, 250, 30);
        (tf_tags).setBounds(20, 180, 440, 30);
        (lb_ativo).setBounds(20, 220, 80, 30);
        (rb_ativo).setBounds(20, 250, 160, 30);

        (bt_salvar).setBounds(340, 240, 90, 40);
        
        this.bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Produto prod = new Produto();
					
					prod.setProduto(tf_produto.getText());
					prod.setDescr(tf_descr.getText());
					prod.setFabricante(tf_fabricante.getText());
					prod.setTipoMaterial(cb_tipoMaterial.getSelectedIndex());
					prod.setTags(tf_tags.getText());
					prod.setAtivo(rb_ativo.getText());
					
					
					int resposta = JOptionPane.showConfirmDialog(null, "Inserir dados? ");
					
					ProdutoDAO prod = new ProdutoDAO(produto);
					prod.inserirBanco(produto);
					
					if(resposta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Inserido com Sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Inser��o Cancelada.");
					}
				} catch (Exception ex) { 	
					JOptionPane.showMessageDialog(null, "Verifique se os campos foram inseridos corretamente.");
				}
				
				
			}
		});
        
	}
	
}