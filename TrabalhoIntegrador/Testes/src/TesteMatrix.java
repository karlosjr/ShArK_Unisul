import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Color;

public class TesteMatrix extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteMatrix frame = new TesteMatrix();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TesteMatrix() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(35, 24, 380, 229);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
		table.setRowHeight(20);
		table.setShowVerticalLines(true);
		table.setModel(new DefaultTableModel(
			    new Object[][]{
			        {null, null, null, null, null, "", null},
			        {null, null, null, null, null, null, null},
			        {null, null, null, null, null, null, null},
			        {null, null, null, null, null, null, null},
			        {null, null, null, null, null, null, null},
			        {null, null, null, null, null, null, null},
			        {null, null, null, null, null, null, null},
			        {null, null, null, null, null, null, null},},
			    //Les titres des colonnes
			    new String[]{
			        "reference", "CIN/RC", "nom", "prenom",
			        "payement", "date payement", "categorie"
			    }) {

			    boolean[] columnEditables = new boolean[]{
			        false, false, false, false, false, false, false
			    };

			    public boolean isCellEditable(int row, int column) {
			        return columnEditables[column];
			    }
			});
		contentPane.add(table);
	}
	
}
