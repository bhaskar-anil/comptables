package com.bhaskar.tabcom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class TableModelImpl extends JFrame {
	
	List<String[]> targetMetaData; 
	List<String[]> sourceMetaData;
	
	Map<String,String[]> targetMetaDataMap = new HashMap<String,String[]>();
	Map<String,String[]> sourceMetaDataMap = new HashMap<String,String[]>();


	// JFrame f;
	TableModelImpl() {

		// f=new JFrame();

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		JButton btnAddFlight = new JButton("Compare");
		btnAddFlight.setPreferredSize(new Dimension(40, 40));

		TableMetadata tbmd = new TableMetadata();
		targetMetaData = tbmd.getTableMetadata("PRODUCTS");
		sourceMetaData = tbmd.getTableMetadata("test");

		
		int row = targetMetaData.size();
		int col = 2;

		String data[][] = new String[row][col];

		for (int k = 0; k < row; k++) {
			
			String[] s = targetMetaData.get(k);
			data[k][0] = s[0];
			data[k][1] = "Select a column";
			
			targetMetaDataMap.put(s[0], s);
		}

		String column[] = { "Target", "Source" };

		JTable jt = new JTable(data, column);
	

		JComboBox comboBox = new JComboBox();

		for (int l = 0; l < sourceMetaData.size(); l++) {
			String[] s = sourceMetaData.get(l);
			comboBox.addItem(s[0]);
			sourceMetaDataMap.put(s[0], s);

		}
		jt.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBox));

		// jt.setBounds(30,40,200,300);

		JScrollPane sp = new JScrollPane(jt);
		topPanel.add(sp);
		topPanel.add(btnAddFlight, BorderLayout.SOUTH);

		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		// this.setLayout(new BorderLayout() );
		this.setVisible(true);

		btnAddFlight.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int rowCount = jt.getRowCount();
				int count = 0;
				for(int n = 0 ; n<rowCount; n++){
					boolean b = true;
					String[] t = targetMetaDataMap.get(jt.getValueAt(n, 0));
					String[] s = sourceMetaDataMap.get(jt.getValueAt(n, 1));
					
					if(null!=t&&null!=s){
						if(!s[0].equals(t[0])){
							b = false;
							count++;
						}
						if(!s[1].equals(t[1])){
							b = false;
							count++;
						}
						if(!s[2].equals(t[2])){
							b = false;
							count++;
						}
						
					}else{
						b = false;
						count++;
					}
					if(!b){
						System.out.println("Total mismatch in columns "+count);
					}
					
					
				}
				
				
				
				//System.out.println(t[0]+" "+t[1]+" "+t[2]);
				//System.out.println(s[0]+" "+s[1]+" "+s[2]);
				
				//System.out.println(jt.getValueAt(1, 1));
				// Execute when button is pressed
				System.out.println("You clicked the button");
			}
		});
	}
}
