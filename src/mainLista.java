import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class mainLista extends JFrame{
	
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
	private ArrayList<String> listNomes = new ArrayList<String>();
	
	public mainLista() {
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
				Collections.sort(listNomes);
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
				Collections.sort(listNomes);
				Collections.reverse(listNomes);
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
				Collections.reverse(listNomes);
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
				removeDuplicados();
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
				removeVazio();
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
		new mainLista();
	}
	
	public void listarArray() {
		String[] linhas = txtArea.getText().split("\n");
		listNomes.clear();
		for (String l : linhas) {
			listNomes.add(l);
		}
	}
	
	public void listarOrdenado() {
		
		for(int i = 0; i < listNomes.size(); i++) {
			String guardaTxt = txtArea.getText();
			txtArea.setText(guardaTxt.concat(listNomes.get(i)).concat("\n"));
		}
	}
	
	public void removeDuplicados() {
		for(int i=0; i<listNomes.size(); i++) {
			String strCompare = listNomes.get(i).toString();
			for(int j=i+1; j<listNomes.size(); j++) {
				if(strCompare.compareTo(listNomes.get(j).toString())==0) {
					listNomes.remove(j);
					j--;
				}
			}
		}
	}
	
	public void removeVazio() {
		for(int i=0; i<listNomes.size(); i++) {
			String strCompare = listNomes.get(i).toString();
			if(strCompare.compareTo("")==0) {
				listNomes.remove(i);
				i--;
			}
		}
	}
	
	public void trim() {
		for(int i=0; i<listNomes.size(); i++) {
			listNomes.set(i, listNomes.get(i).toString().trim());
		}
	}
	
	public void praCima() {
		for(int i=0; i<listNomes.size(); i++) {
			listNomes.set(i, listNomes.get(i).toString().toUpperCase());
		}
	}
	
	public void praBaixo() {
		for(int i=0; i<listNomes.size(); i++) {
			listNomes.set(i, listNomes.get(i).toString().toLowerCase());
		}
	}
	
	public void capitalizar() {
		for(int i=0; i<listNomes.size(); i++) {
			if(listNomes.get(i).toString()==""){
				continue;
			}
			String[] separaPalavras = listNomes.get(i).split(" ");
			String unir = new String();
			System.out.println(separaPalavras.length);
			for(int j = 0; j<separaPalavras.length; j++) {
				separaPalavras[j] = separaPalavras[j].substring(0, 1).toUpperCase()+(separaPalavras[j].substring(1));
				if(j==separaPalavras.length-1) {
					unir = unir.concat(separaPalavras[j]);
				}
				else {
					unir = unir.concat(separaPalavras[j]+" ");
				}
			}
			listNomes.set(i, unir);
			System.out.println(separaPalavras.length);
		}
	}
}
