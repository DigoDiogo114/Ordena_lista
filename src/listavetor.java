import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class listavetor extends JFrame {
	
	private JTextArea txtArea;
	private JButton btnAZ;
	private JButton btnZA;
	private JButton btnReverse;
	private JButton btnRmvDuplicados;
	private JButton btnRmvVazio;
	private JButton btnTrim;
	private JButton btnToUp;
	private JButton btnToDown;
	private JButton btnToCapitalizar;
	private String[] listNomes;
	private int tamanhoLista;
	
	public listavetor() {
		setSize(500, 500);
		setLayout(null);
		componentesCriar();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void componentesCriar() {
		txtArea = new JTextArea();
		txtArea.setBounds(10, 10, 300, 450);
		txtArea.setBackground(Color.gray);
		getContentPane().add(txtArea);
		
		btnAZ = new JButton(new AbstractAction("TO AZ") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarArray();
				ordenarLista();
				txtArea.setText("");
				listarOrdenado();
				
			}
		});
		btnAZ.setBounds(320, 10, 170, 30);
		getContentPane().add(btnAZ);
		
		btnZA = new JButton(new AbstractAction("TO ZA") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarArray();
				ordenarLista();
				inverterLista();
				txtArea.setText("");
				listarOrdenado();
			}
		});
		btnZA.setBounds(320, 50, 170, 30);
		getContentPane().add(btnZA);
		
		btnReverse = new JButton(new AbstractAction("Lança o reverse") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarArray();
				inverterLista();
				txtArea.setText("");
				listarOrdenado();
			}
		});
		btnReverse.setBounds(320, 90, 170, 30);
		getContentPane().add(btnReverse);
		
		btnRmvDuplicados = new JButton(new AbstractAction("Remove os gemeos") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarArray();
				txtArea.setText("");
				removerDuplicados();
				listarOrdenado();
			}
		});
		
		btnRmvDuplicados.setBounds(320, 130, 170, 30);
		getContentPane().add(btnRmvDuplicados);

		btnRmvVazio = new JButton(new AbstractAction("Remove void") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarArray();
				txtArea.setText("");
				removerVazio();
				listarOrdenado();
			}
		});
		btnRmvVazio.setBounds(320, 170, 170, 30);
		getContentPane().add(btnRmvVazio);

		btnTrim = new JButton(new AbstractAction("TRIM DO IT") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarArray();
				txtArea.setText("");
				trim();
				listarOrdenado();
			}
		});
		btnTrim.setBounds(320, 210, 170, 30);
		getContentPane().add(btnTrim);
		
		btnToUp = new JButton(new AbstractAction("Pra cima") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarArray();
				txtArea.setText("");
				praCima();
				listarOrdenado();
			}
		});
		btnToUp.setBounds(320, 250, 170, 30);
		getContentPane().add(btnToUp);
		
		btnToDown = new JButton(new AbstractAction("Pra baixo") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarArray();
				txtArea.setText("");
				praBaixo();
				listarOrdenado();
			}
		});
		btnToDown.setBounds(320, 290, 170, 30);
		getContentPane().add(btnToDown);
		
		btnToCapitalizar = new JButton(new AbstractAction("Capitalismo") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listarArray();
				txtArea.setText("");
				praBaixo();
				capitalizar();
				listarOrdenado();
			}
		});
		btnToCapitalizar.setBounds(320, 330, 170, 30);
		getContentPane().add(btnToCapitalizar);
	}
	
	public static void main(String[] args) {
		new listavetor();
	}
	
	public void listarArray() {
		String[] linhas = txtArea.getText().split("\n");
		tamanhoLista = linhas.length;
		listNomes = new String[tamanhoLista];
		for (int i = 0; i < tamanhoLista; i++) {
			listNomes[i] = linhas[i];
		}
	}
	
	public void listarOrdenado() {
		for (int i = 0; i < tamanhoLista; i++) {
			String guardaTxt = txtArea.getText();
			txtArea.setText(guardaTxt.concat(listNomes[i]).concat("\n"));
		}
	}
	
	public void ordenarLista() {
		for (int i = 0; i < tamanhoLista - 1; i++) {
			for (int j = i + 1; j < tamanhoLista; j++) {
				if (listNomes[i].compareTo(listNomes[j]) > 0) {
					String temp = listNomes[i];
					listNomes[i] = listNomes[j];
					listNomes[j] = temp;
				}
			}
		}
	}
	
	public void inverterLista() {
		for (int i = 0; i < tamanhoLista / 2; i++) {
			String temp = listNomes[i];
			listNomes[i] = listNomes[tamanhoLista - 1 - i];
			listNomes[tamanhoLista - 1 - i] = temp;
		}
	}
	
	public void removerDuplicados() {
		for (int i = 0; i < tamanhoLista; i++) {
			String strCompare = listNomes[i];
			for (int j = i + 1; j < tamanhoLista; j++) {
				if (strCompare.equals(listNomes[j])) {
					listNomes[j] = null;
				}
			}
		}
		compactarLista();
	}
	
	public void removerVazio() {
		for (int i = 0; i < tamanhoLista; i++) {
			if (listNomes[i].isEmpty()) {
				listNomes[i] = null;
			}
		}
		compactarLista();
	}
	
	public void trim() {
		for (int i = 0; i < tamanhoLista; i++) {
			if (listNomes[i] != null) {
				listNomes[i] = listNomes[i].trim();
			}
		}
	}
	
	public void praCima() {
		for (int i = 0; i < tamanhoLista; i++) {
			if (listNomes[i] != null) {
				listNomes[i] = listNomes[i].toUpperCase();
			}
		}
	}
	
	public void praBaixo() {
		for (int i = 0; i < tamanhoLista; i++) {
			if (listNomes[i] != null) {
				listNomes[i] = listNomes[i].toLowerCase();
			}
		}
	}
	
	public void capitalizar() {
		for (int i = 0; i < tamanhoLista; i++) {
			if (listNomes[i] != null) {
				String[] separaPalavras = listNomes[i].split(" ");
				String unir = "";
				for (int j = 0; j < separaPalavras.length; j++) {
					if (!separaPalavras[j].isEmpty()) {
						separaPalavras[j] = separaPalavras[j].substring(0, 1).toUpperCase() + separaPalavras[j].substring(1);
						unir += separaPalavras[j];
						if (j != separaPalavras.length - 1) {
							unir += " ";
						}
					}
				}
				listNomes[i] = unir;
			}
		}
	}
	
	public void compactarLista() {
		String[] novaLista = new String[tamanhoLista];
		int index = 0;
		for (int i = 0; i < tamanhoLista; i++) {
			if (listNomes[i] != null) {
				novaLista[index] = listNomes[i];
				index++;
			}
		}
		listNomes = novaLista;
		tamanhoLista = index;
	}
}
