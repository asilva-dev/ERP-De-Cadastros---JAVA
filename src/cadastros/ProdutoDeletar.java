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

public class ProdutoDeletar extends JInternalFrame {
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 1L;
	JLabel lb_produto, lb_descr, lb_fabricante, lb_tipoMaterial, lb_tags, lb_ativo;
	JTextField tf_produto, tf_descr, tf_fabricante, tf_tags;
	JRadioButton rb_ativo;
	JComboBox cb_tipoMaterial;
    JButton bt_deletar;
    
    public ProdutoDeletar() {
    	
    	this.setBounds(200,200,400,150);
		this.setTitle("Deletar Produto");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		deletarForm();
		this.setVisible(true);
		
    }
    
    public void deletarForm() {
		
    	lb_produto   = new JLabel("Produto: ");
		tf_produto   = new JTextField("");
		lb_descr     = new JLabel("Descrição:");
		tf_descr     = new JTextField();		
		bt_deletar   = new JButton("Deletar");   
		
		
			 
		getContentPane().setLayout(null);
		
		getContentPane().add(lb_produto);
        getContentPane().add(tf_produto);
        getContentPane().add(lb_descr);
        getContentPane().add(tf_descr);
        getContentPane().add(bt_deletar);
		
        (lb_produto).setBounds(20, 20, 90, 30);
        (tf_produto).setBounds(20, 50, 90, 30);
        (lb_descr).setBounds(130, 20, 100, 30);
        (tf_descr).setBounds(130, 50, 100, 30);

        (bt_deletar).setBounds(340, 80, 90, 40);
        
        
        this.bt_deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Produto prod = new Produto();
					
					prod.setProduto(tf_produto.getText());
					prod.setDescr(tf_descr.getText());
					
					ProdutoDAO del = new ProdutoDAO();
					
					del.selecionarBanco(produto);
					
					String out = "Deseja deletar este produto?";
					
					int resposta = JOptionPane.showConfirmDialog(null, out);
					
					if(resposta == JOptionPane.YES_OPTION) {
						
						del.deletarBanco(produto);
						
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