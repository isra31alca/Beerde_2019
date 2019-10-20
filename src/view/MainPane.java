package view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import controller.ConectionDb;
import controller.ConsumoEnergetico;
import controller.TableConsumoEnergetico;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MainPane extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea txtResultados;
	private JTextField txtPorcionTerreno;
	private JComboBox<String> comboUbicacion;
	private JComboBox<String> comboTipoConstruccion;
	private JComboBox<String> comboTipoTerreno;
	private JCheckBox chckbxElectricidad;
	private JCheckBox chckbxAgua;
	private JCheckBox chckbxDrenaje;
	private JCheckBox chckbxGas;
	private JButton lblBeerde;
	

	/**
	 * Create the panel.
	 */
	public MainPane() {
		this.setBounds(0, 55, 1300, 645);
		this.setBackground(new Color(61,125,68));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 372, 240);
		add(panel);
		panel.setLayout(null);
		
		IconApp icono = new IconApp();
		icono.setSize(120, 120);
		icono.setLocation(242, 11);
		panel.add(icono);
		
		JLabel lblBienvenidoABeerder = new JLabel("Bienvenido a BEERDE");
		lblBienvenidoABeerder.setFont(new Font("Arial", Font.BOLD, 19));
		lblBienvenidoABeerder.setBounds(14, 32, 206, 38);
		lblBienvenidoABeerder.setForeground(new Color(61,125,68));
		panel.add(lblBienvenidoABeerder);
		
		JTextArea txtrParaObtenerRecomendacione = new JTextArea();
		txtrParaObtenerRecomendacione.setFont(new Font("Arial", Font.BOLD, 19));
		txtrParaObtenerRecomendacione.setText("Para obtener recomendaciones\r\npor favor, llena los \r\nsiguientes campos.");
		txtrParaObtenerRecomendacione.setBounds(14, 136, 297, 73);
		txtrParaObtenerRecomendacione.setForeground(new Color(61,125,68));
		panel.add(txtrParaObtenerRecomendacione);				
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setOpaque(true);
		lblResultados.setBackground(Color.LIGHT_GRAY);
		lblResultados.setForeground(Color.BLACK);
		lblResultados.setFont(new Font("Arial", Font.BOLD, 16));
		lblResultados.setBounds(0, 425, 1300, 30);
		add(lblResultados);
		
		txtResultados = new JTextArea();
		txtResultados.setEditable(false);
		txtResultados.setBounds(0, 455, 1300, 190);
		add(txtResultados);
		
		comboUbicacion = new JComboBox<String>();
		comboUbicacion.setBounds(484, 33, 372, 30);
		add(comboUbicacion);
		
		comboTipoConstruccion = new JComboBox<String>();
		comboTipoConstruccion.setBounds(484, 95, 372, 30);
		add(comboTipoConstruccion);
		
		comboTipoTerreno = new JComboBox<String>();
		comboTipoTerreno.setBounds(484, 164, 372, 30);
		add(comboTipoTerreno);
		
		txtPorcionTerreno = new JTextField();
		txtPorcionTerreno.setFont(new Font("Arial", Font.BOLD, 15));
		txtPorcionTerreno.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPorcionTerreno.setBounds(484, 339, 372, 30);
		add(txtPorcionTerreno);
		txtPorcionTerreno.setColumns(10);
		
		chckbxElectricidad = new JCheckBox("");
		chckbxElectricidad.setOpaque(false);
		chckbxElectricidad.setBounds(493, 236, 40, 30);
		chckbxElectricidad.setIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheck.png")));
		chckbxElectricidad.setSelectedIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckSelected.png")));
		chckbxElectricidad.setRolloverIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckRollover.png")));
		add(chckbxElectricidad);
		
		chckbxAgua = new JCheckBox("");
		chckbxAgua.setOpaque(false);
		chckbxAgua.setBounds(601, 236, 40, 30);
		chckbxAgua.setIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheck.png")));
		chckbxAgua.setSelectedIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckSelected.png")));
		chckbxAgua.setRolloverIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckRollover.png")));
		add(chckbxAgua);
		
		chckbxDrenaje = new JCheckBox("");
		chckbxDrenaje.setOpaque(false);
		chckbxDrenaje.setBounds(685, 236, 40, 30);
		chckbxDrenaje.setIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheck.png")));
		chckbxDrenaje.setSelectedIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckSelected.png")));
		chckbxDrenaje.setRolloverIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckRollover.png")));
		add(chckbxDrenaje);
		
		chckbxGas = new JCheckBox("");
		chckbxGas.setOpaque(false);
		chckbxGas.setBounds(791, 236, 40, 30);
		chckbxGas.setIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheck.png")));
		chckbxGas.setSelectedIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckSelected.png")));
		chckbxGas.setRolloverIcon(new ImageIcon(MainPane.class.getResource("/img/iconCheckRollover.png")));
		add(chckbxGas);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n");
		lblUbicacin.setForeground(Color.WHITE);
		lblUbicacin.setFont(new Font("Arial", Font.BOLD, 17));
		lblUbicacin.setBounds(619, 65, 77, 23);
		add(lblUbicacin);
		
		JLabel lblTipoDeConstruccion = new JLabel("Tipo de construcci\u00F3n");
		lblTipoDeConstruccion.setForeground(Color.WHITE);
		lblTipoDeConstruccion.setFont(new Font("Arial", Font.BOLD, 17));
		lblTipoDeConstruccion.setBounds(571, 136, 166, 17);
		add(lblTipoDeConstruccion);
		
		JLabel lblTipoDeTerreno = new JLabel("Tipo de terreno de construcci\u00F3n");
		lblTipoDeTerreno.setForeground(Color.WHITE);
		lblTipoDeTerreno.setFont(new Font("Arial", Font.BOLD, 17));
		lblTipoDeTerreno.setBounds(535, 205, 253, 16);
		add(lblTipoDeTerreno);
		
		JLabel lblServicios = new JLabel("Servicios de la zona");
		lblServicios.setForeground(Color.WHITE);
		lblServicios.setFont(new Font("Arial", Font.BOLD, 17));
		lblServicios.setBounds(580, 292, 157, 23);
		add(lblServicios);
		
		JLabel lblPorcinDelTerreno = new JLabel("Porci\u00F3n del terreno (m2)");
		lblPorcinDelTerreno.setFont(new Font("Arial", Font.BOLD, 17));
		lblPorcinDelTerreno.setForeground(Color.WHITE);
		lblPorcinDelTerreno.setBounds(563, 380, 209, 23);
		add(lblPorcinDelTerreno);
		
		JLabel lblElectricidad = new JLabel("Electricidad");
		lblElectricidad.setFont(new Font("Arial", Font.BOLD, 15));
		lblElectricidad.setForeground(Color.WHITE);
		lblElectricidad.setBounds(473, 266, 95, 23);
		add(lblElectricidad);
		
		JLabel lblAgua = new JLabel("Agua");
		lblAgua.setFont(new Font("Arial", Font.BOLD, 15));
		lblAgua.setForeground(Color.WHITE);
		lblAgua.setBounds(601, 266, 41, 23);
		add(lblAgua);
		
		JLabel lblDrenaje = new JLabel("Drenaje");
		lblDrenaje.setFont(new Font("Arial", Font.BOLD, 15));
		lblDrenaje.setForeground(Color.WHITE);
		lblDrenaje.setBounds(685, 266, 63, 23);
		add(lblDrenaje);
		
		JLabel lblGas = new JLabel("Gas");
		lblGas.setFont(new Font("Arial", Font.BOLD, 15));
		lblGas.setForeground(Color.WHITE);
		lblGas.setBounds(801, 266, 28, 23);
		add(lblGas);
		
		lblBeerde = new JButton("BEERDE");
		lblBeerde.setForeground(Color.BLACK);
		lblBeerde.setOpaque(true);
		lblBeerde.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeerde.setBackground(Color.WHITE);
		lblBeerde.setFont(new Font("Arial", Font.BOLD, 35));
		lblBeerde.setBounds(950, 270, 296, 94);
		add(lblBeerde);

		llenarComboUbicacion();
		llenarComboConstruccion();
		llenarComboTipoTerreno();
		
		
		chckbxElectricidad.addMouseListener(this);
		chckbxAgua.addMouseListener(this);
		chckbxDrenaje.addMouseListener(this);
		chckbxGas.addMouseListener(this);
		lblBeerde.addMouseListener(this);
		
	}
	
	private void llenarComboUbicacion() {
		comboUbicacion.removeAllItems();
		Connection connection = ConectionDb.connectDatabase();

		TableConsumoEnergetico tConsumoEnergeticon = new TableConsumoEnergetico();
		ArrayList<ConsumoEnergetico> list = tConsumoEnergeticon.getCitys(connection);
		
		for(int i=0; i<list.size();i++) {
			comboUbicacion.addItem(list.get(i).getCiudad());
		}
	}
	
	private void llenarComboConstruccion() {
		comboTipoConstruccion.removeAllItems();
		comboTipoConstruccion.addItem("Domestico");
		comboTipoConstruccion.addItem("Agricola");
		comboTipoConstruccion.addItem("Industrial");
	}
	
	private void llenarComboTipoTerreno() {
		comboTipoTerreno.removeAllItems();
		comboTipoTerreno.addItem("Llano");
		comboTipoTerreno.addItem("Montañoso");
		comboTipoTerreno.addItem("Arenoso");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
		if(e.getSource()==lblBeerde) {
			lblBeerde.setForeground(new Color(0, 153, 255));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		if(e.getSource()==lblBeerde) {
			lblBeerde.setForeground(Color.BLACK);
		}
	}
}
