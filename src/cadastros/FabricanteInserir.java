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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FabricanteInserir extends JInternalFrame {
	
	/**
	 * 
	 */
	
	JLabel lb_razaoSocial, lb_CNPJ, lb_IE, lb_IM, lb_logradouro, lb_bairro, lb_cidade, lb_UF, lb_pais, lb_cep, lb_telefone, lb_contato, lb_URL;
	JTextField tf_razaoSocial, tf_CNPJ, tf_IE, tf_IM, tf_logradouro, tf_bairro, tf_cidade, tf_UF, tf_pais, tf_cep, tf_telefone, tf_contato, tf_URL;
    JButton bt_salvar;

    public FabricanteInserir() {

    	this.setBounds(200,200,500,350);
		this.setResizable(false);
		this.setTitle("Cadastro de Fabricantes");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.closable = true;
		CadastroForm();
		this.setVisible(true);
		
    }
    
    private void CadastroForm() {
		
		//Nesta parte estou inicializando os meus componentes
		lb_razaoSocial        = new JLabel("Razão Social: ");
		tf_razaoSocial        = new JTextField("");
		lb_CNPJ               = new JLabel("CNPJ: ");
		tf_CNPJ               = new JTextField();
		lb_IE                 = new JLabel("IE: ");
        tf_IE                 = new JTextField("");
		lb_IM                 = new JLabel("IM: ");
		tf_IM                 = new JTextField("");
		lb_logradouro         = new JLabel("Logradouro: ");
		tf_logradouro         = new JTextField("");
		lb_bairro	          = new JLabel("Bairro: ");
		tf_bairro             = new JTextField("");
		lb_cidade             = new JLabel("Cidade: ");
        tf_cidade             = new JTextField("");
        lb_UF                 = new JLabel("UF: ");
		tf_UF                 = new JTextField("");
		lb_pais	              = new JLabel("Pais: ");
		tf_pais               = new JTextField("");
		lb_CEP                = new JLabel("CEP: ");
        tf_CEP                = new JTextField("");
        lb_telefone           = new JLabel("Telefone: ");
		tf_telefone           = new JTextField("");
		lb_contato            = new JLabel("Contato: ");
        tf_contato            = new JTextField("");
		lb_URL                = new JLabel("URL: ");
		tf_URL                = new JTextField("");
		bt_salvar     	  = new JButton("Salvar");   
        
        
       
		getContentPane().setLayout(null);
		
		//Adiciona os componentes ao formul�rio
        getContentPane().add(lb_razaoSocial);
        getContentPane().add(tf_razaoSocial);
        getContentPane().add(lb_CNPJ);
        getContentPane().add(tf_CNPJ);
        getContentPane().add(lb_IE);
        getContentPane().add(tf_IE);
        getContentPane().add(lb_IM);
        getContentPane().add(tf_IM);
        getContentPane().add(lb_logradouro);
        getContentPane().add(tf_logradouro);
        getContentPane().add(lb_bairro);
        getContentPane().add(tf_bairro);
        getContentPane().add(lb_cidade);
        getContentPane().add(tf_cidade);
        getContentPane().add(lb_UF);
        getContentPane().add(tf_UF);
        getContentPane().add(lb_pais);
        getContentPane().add(tf_pais);
        getContentPane().add(lb_CEP);
        getContentPane().add(tf_CEP);
        getContentPane().add(lb_telefone);
        getContentPane().add(tf_telefone);
        getContentPane().add(lb_contato);
        getContentPane().add(tf_contato);
        getContentPane().add(lb_URL);
        getContentPane().add(tf_URL);
        getContentPane().add(bt_salvar);
        
        
        //Define o posicionamento dos componentes na tela (posi��o da coluna, posi��o da linha, comprimento da linha, altura da linha)
        (lb_razaoSocial).setBounds(20, 20, 90, 30);
        (tf_razaoSocial).setBounds(20, 50, 90, 30);
        (lb_CNPJ).setBounds(130, 20, 100, 30);
        (tf_CNPJ).setBounds(130, 50, 100, 30);
        (lb_IE).setBounds(260, 20, 200, 30);
        (tf_IE).setBounds(260, 50, 200, 30);
        (lb_IM).setBounds(20, 90, 150, 30);
        (tf_IM).setBounds(20, 120, 440, 30);
        (lb_logradouro).setBounds(20, 150, 250, 30);
        (tf_logradouro).setBounds(20, 180, 440, 30);
        (lb_bairro).setBounds(20, 220, 80, 30);
        (tf_bairro).setBounds(20, 250, 160, 30);
        (lb_cidade).setBounds(200, 220, 80, 30);
        (tf_cidade).setBounds(200, 250, 80, 30);
        (lb_UF).setBounds(200, 300, 80, 30);
        (tf_UF).setBounds(290, 300, 80, 30);
        (lb_pais).setBounds(200, 320, 80, 30);
        (tf_pais).setBounds(290, 320, 80, 30);
        (lb_CEP).setBounds(200, 340, 80, 30);
        (tf_CEP).setBounds(290, 360, 80, 30);
        (lb_telefone).setBounds(200, 300, 80, 30);
        (tf_telefone).setBounds(290, 300, 80, 30);
        (lb_contato).setBounds(200, 320, 80, 30);
        (tf_contato).setBounds(290, 320, 80, 30);
        (lb_URL).setBounds(200, 340, 80, 30);
        (tf_URL).setBounds(290, 360, 80, 30);
        (bt_salvar).setBounds(370, 240, 90, 40);
        
        
        this.bt_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					
					Fabricante fab = new Fabricante();

                   
                    prod.setRazaoSocial(tf_razaoSocial.getText());
                    prod.setCNPJ(tf_CNPJ.getText());
                    prod.setIE(tf_IE.getText());
                    prod.setIM(tf_IM.getText());
                    prod.setLogradouro(tf_logradouro.getText());
                    prod.setBairro(tf_bairro.getText());
                    prod.setUF(tf_UF.getText());
                    prod.setPais(tf_pais.getText());
                    prod.setCEP(tf_CEP.getText());
                    prod.setTelefone(tf_telefone.getText());
                    prod.setContato(tf_contato.getText());
                    prod.setURL(tf_URL.getText());
				
					
					int resposta = JOptionPane.showConfirmDialog(null, "Confirma inserir dados? ");
					
					FabricanteDAO fabricante = new FabricanteDAO(fab);
					fabricante.inserirBanco(fab);
					
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