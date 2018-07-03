
package cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")

/**
 * Classe principal do Programa (main)
 * 
 * @author Felipe Trindade Antoniolli
 * 
 */

public class Principal extends JFrame {
	
	JMenuBar menu = new JMenuBar();
	
	//Itens do Menu
	private JMenu produtos         = null;
	private JMenu fornecedores     = null;
	private JMenu clientes         = null;
	private JMenu colaboradores    = null;
	private JMenu locais           = null;
	private JMenu instFinanceira   = null;
	private JMenu sobre			   = null;
	private JMenuItem cadProd      = null;
	private JMenuItem altProd      = null;
	private JMenuItem cadForn      = null;
	private JMenuItem altForn      = null;
	private JMenuItem cadColab	   = null;
	private JMenuItem altColab     = null;
	private JMenuItem cadCli       = null;
	private JMenuItem altCli       = null;
	private JMenuItem delCli       = null;
	private JMenuItem cadLocais    = null;
	private JMenuItem altLocais    = null;
	private JMenuItem delLocais    = null;
	private JMenuItem cadInst      = null;
	private JMenuItem altInst      = null;
	private JMenuItem delInst      = null;
	private JMenuItem sobreNos     = null;
	

	
	//Construtor de inser��o dos bot�es do menu
	public Principal() {
		
		this.setBounds(100,100,1000,720);
		this.setTitle("Cadastros");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Bot�es do menu
		this.produtos         = new JMenu("Produtos");
		this.clientes	      = new JMenu("Cliente");
		this.colaboradores    = new JMenu("Colaboradores");
		this.locais  		  = new JMenu("Locais");
		this.instFinanceira   = new JMenu("Institui��es Financeiras");
		this.sobre            = new JMenu("Sobre");
		
		//Op��es do Menu de Cadastro
		this.cadProd    = new JMenuItem("Novo Cadastro");
		this.cadCli     = new JMenuItem("Novo Cliente");
		this.altCli     = new JMenuItem("Alterar Cliente");
		this.delCli     = new JMenuItem("Deletar Cliente");
		this.cadColab   = new JMenuItem("Novo Cadastro");
		this.altColab   = new JMenuItem("Alterar Colaborador");
		this.cadLocais  = new JMenuItem("Novo Cadastro");
		this.altLocais  = new JMenuItem("Alterar Local");
		this.delLocais  = new JMenuItem("Deletar Local");
		this.cadInst    = new JMenuItem("Nova Instituicao");
		this.altInst    = new JMenuItem("Alterar Instituicao");
		this.delInst    = new JMenuItem("Deletar Instituicao");
		this.altProd    = new JMenuItem("Alterar Cadastro");
		this.altForn    = new JMenuItem("Alterar Cadastro");
		this.sobreNos	= new JMenuItem("Sobre N�s");
		
		//Adicionando os bot�es do menu no JFrame
		menu.add(produtos);
		menu.add(clientes);
		menu.add(colaboradores);
		menu.add(locais);
		menu.add(instFinanceira);
		menu.add(sobre);
		
		//Adicionando as op��es de cadastro do menu dentro dos bot�es do menu
		this.produtos.add(cadProd);
		this.clientes.add(cadCli);
		this.clientes.add(altCli);
		this.clientes.add(delCli);
		this.colaboradores.add(cadColab);
		this.colaboradores.add(altColab);
		this.locais.add(cadLocais);
		this.locais.add(altLocais);
		this.locais.add(delLocais);
		this.instFinanceira.add(cadInst);
		this.instFinanceira.add(altInst);
		this.instFinanceira.add(delInst);
		this.produtos.add(altProd);
		this.produtos.add(altForn);
		this.sobre.add(sobreNos);
		
		
		//Adicionando as op��es de cadastro do menu dentro dos bot�es do menu
		
		this.setLayout(null);
		this.setJMenuBar(menu);
		this.validate();
		this.setVisible(true);
		
		
		//Chamando a classe CadastroInst no momento em que � apertado o bot�o
		this.cadInst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstituicaoInserir cadastro = new InstituicaoInserir();
				cadastro.setLocation(250, 100);
				getContentPane().add(cadastro);
				cadastro.moveToFront();
				
			}
		});
		this.altInst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstituicaoAlterar alterar = new InstituicaoAlterar();
				alterar.setLocation(250, 200);
				getContentPane().add(alterar);
				alterar.moveToFront();
			}
		});
		this.delInst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstituicaoDeletar deletar = new InstituicaoDeletar();
				deletar.setLocation(150, 200);
				getContentPane().add(deletar);
				deletar.moveToFront();
			}
		});
		this.cadCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesInserir inserir = new ClientesInserir();
				inserir.setLocation(250, 100);
				getContentPane().add(inserir);
				inserir.moveToFront();
			}
		});	
		this.altCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesAlterar alterar = new ClientesAlterar();
				alterar.setLocation(150, 200);
				getContentPane().add(alterar);
				alterar.moveToFront();
			}
		});
		this.delCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesDeletar deletar = new ClientesDeletar();
				deletar.setLocation(150, 200);
				getContentPane().add(deletar);
				deletar.moveToFront();
			}
		});
		//Chamando a classe Colaboradores no momento em que � apertado o bot�o
			this.cadColab.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ColaboradorInserir cadastroColab = new ColaboradorInserir();
					cadastroColab.setLocation(5, 5);
					getContentPane().add(cadastroColab);
							
					}
			});
			this.altColab.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ColaboradoresAlterar alterarColab = new ColaboradoresAlterar();
					alterarColab.setLocation(5, 5);
					getContentPane().add(alterarColab);
				}
			});

			//Chamando a classe Produtos no momento em que � apertado o bot�o
			this.cadProd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProdutoInserir cadastroProd = new ProdutoInserir();
					cadastroProd.setLocation(5, 5);
					getContentPane().add(cadastroProd);
					
				}
			});
			this.cadForn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FabricanteInserir cadastroForn = new FabricanteInserir();
					cadastroForn.setLocation(5, 5);
					getContentPane().add(cadastroForn);
					
				}
			});
			this.cadCli.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClientesInserir inserir = new ClientesInserir();
					inserir.setLocation(250, 100);
					getContentPane().add(inserir);
					inserir.moveToFront();
				}
			});	
			this.altCli.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClientesAlterar alterar = new ClientesAlterar();
					alterar.setLocation(150, 200);
					getContentPane().add(alterar);
					alterar.moveToFront();
				}
			});
			this.delCli.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClientesDeletar deletar = new ClientesDeletar();
					deletar.setLocation(150, 200);
					getContentPane().add(deletar);
					deletar.moveToFront();
				}
			});
		
		//Apresentando caixa de mensagem do sobre n�s
		this.sobreNos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String out = "";
				out += "IFSP ";
				out += "\nCriado pelos membros:";
                                out += "\nAmanda Priscila da Silva - GU17661218";				
				out += "\nEvellyn dos Santos Silva - GU1760921";
				out += "\nFelipe Trindade Antoniolli - GU1761048";
                                out += "\nGabriela Alves - GU3002896";
				out += "\n Vers�o: 0.1 beta";
				JOptionPane.showMessageDialog(null, out);
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		
		new Principal();
		
	}
}
