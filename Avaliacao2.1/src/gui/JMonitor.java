package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import monitorsystem.Sistema;
import javax.swing.*;

@SuppressWarnings("serial")
public class JMonitor extends JFrame implements ActionListener {
	private JTextField txtX;
	private JTextField txtY;
	private JButton btnMonitorar;
	private JLabel lblUnidade;
	private JCheckBox VBox;
	private JCheckBox TBox;
	private JCheckBox COBox;
	private JCheckBox CHBox;
	Sistema sistema;
	
	public JMonitor(Sistema s) {
		this.setSistema(s);
	};
	
	public void run() throws Exception {
		this.instantiate();
		this.asmBorder();
		this.render();
	};
	
	private void instantiate() throws Exception {
		this.lblUnidade = new JLabel("Bem-vindo! Aguardando comando...");
		this.lblUnidade.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		this.txtX = new JTextField();
		this.txtY = new JTextField();
		this.VBox = new JCheckBox("V");
		this.TBox = new JCheckBox("T");
		this.COBox = new JCheckBox("CO2");
		this.CHBox = new JCheckBox("CH4");
		this.btnMonitorar = new JButton("Monitorar");
		btnMonitorar.addActionListener(this);
	};
	
	private void render() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Sistema de Monitoramento");
		this.setSize(475, 125);
		this.setVisible(true);
	};
	
	private void asmBorder() {
		JPanel pnlSouth = new JPanel();	
		JPanel pnlCenter = new JPanel();
		
		pnlSouth.setLayout(new GridLayout(1, 1));
		pnlSouth.add(this.lblUnidade);
		
		pnlCenter.setLayout(new GridLayout(1, 1));
		pnlCenter.add(this.txtX);
		pnlCenter.add(this.txtY);
		pnlCenter.add(this.VBox);
		pnlCenter.add(this.TBox);
		pnlCenter.add(this.COBox);
		pnlCenter.add(this.CHBox);
		
		this.setLayout(new BorderLayout());
		this.add(pnlSouth, BorderLayout.SOUTH);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(this.btnMonitorar, BorderLayout.NORTH);
	};

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(this.btnMonitorar)) 
			try {
				doMonitorar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		this.repaint();
	};
	
	private void doMonitorar() throws Exception {
		float x = Float.parseFloat(this.txtX.getText());
		float y = Float.parseFloat(this.txtY.getText());
		
		String id = this.sistema.monitorar(x, y, this.VBox.isSelected(), this.TBox.isSelected(), this.COBox.isSelected(), this.CHBox.isSelected());
		this.lblUnidade.setText("Unidade Monitora de ID: " + id + " foi posicionada!");
	};
	
	public void setSistema(Sistema s) {
		this.sistema = s;
	};
}
