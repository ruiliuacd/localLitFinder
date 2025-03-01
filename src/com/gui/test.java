/*
 * test.java
 *
 * Created on __DATE__, __TIME__
 */

package com.gui;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.lucene.index.IndexNotFoundException;
import org.apache.lucene.queryParser.ParseException;

import com.index_search.testIndexer;
import com.index_search.testSearch;

/**
 *
 * @author  __USER__
 */
public class test extends javax.swing.JFrame {

	/** Creates new form test */
	public test() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		textField1 = new java.awt.TextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextPane1 = new javax.swing.JTextPane();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextField2.setText("M:\\opt");
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jButton1.setText("\u5f00\u59cb\u5efa\u7acb\u7d22\u5f15\u6587\u4ef6");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u5f00\u59cb\u641c\u7d22");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jTextField1.setText("jTextField1");
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextField3.setText("\u8bf7\u8f93\u5165\u5173\u952e\u8bcd");
		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}
		});

		textField1.setText("textField1");
		textField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textField1ActionPerformed(evt);
			}
		});

		jScrollPane1.setViewportView(jTextPane1);

		jButton3.setText("\u6587\u4ef6\u76ee\u5f55");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("\u7d22\u5f15\u76ee\u5f55");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jMenu1.setText("File");

		jMenuItem1.setText("\u5efa\u7acb\u7d22\u5f15");
		jMenu1.add(jMenuItem1);

		jMenu3.setText("Menu");
		jMenu1.add(jMenu3);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(55, 55, 55)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		912,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addContainerGap())
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						textField1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						517,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addContainerGap())
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField3,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						1130,
																						Short.MAX_VALUE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jButton2)
																								.addContainerGap())
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jButton1)
																								.addContainerGap())
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																												.addComponent(
																														jTextField1,
																														javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jTextField2,
																														javax.swing.GroupLayout.Alignment.LEADING,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														1031,
																														Short.MAX_VALUE))
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGap(8,
																																		8,
																																		8)
																																.addComponent(
																																		jButton3))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																.addComponent(
																																		jButton4)))
																								.addContainerGap()))))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(32, 32, 32)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton3))
								.addGap(61, 61, 61)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButton4))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton1)
								.addGap(99, 99, 99)
								.addComponent(textField1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jTextField3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton2)
								.addGap(18, 18, 18)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										242,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		// JFileChooser.FILES_ONLY
		// JFileChooser.DIRECTORIES_ONLY
		int returnVal = fc.showOpenDialog(this);
		File file_choosed = fc.getSelectedFile();
		System.out.println(file_choosed.getAbsolutePath());
		jTextField2.setText(file_choosed.getAbsolutePath());
	}

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String q = jTextField3.getText();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		// JFileChooser.FILES_ONLY
		// JFileChooser.DIRECTORIES_ONLY
		int returnVal = fc.showOpenDialog(this);
		File file_choosed = fc.getSelectedFile();
		System.out.println(file_choosed.getAbsolutePath());
		jTextField1.setText(file_choosed.getAbsolutePath());
	}

	private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		String q = jTextField3.getText();
		path = jTextField2.getText();
		try {
			String t = testSearch.search(path, q);
			jTextPane1.setText(t);
		} catch (IndexNotFoundException a) {
			JOptionPane.showMessageDialog(null, "请选择索引目录", "。。。",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		pdfDir = jTextField1.getText();
		path = jTextField2.getText();
		System.out.println(path + "dddddddddddddddd" + pdfDir);

		try {
			testIndexer indx = new testIndexer(path);
			indx.assortDirtoIndex(pdfDir);
			indx.close();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("cuo");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("cuo cuo");
			System.exit(-1);
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new test().setVisible(true);
			}
		});
	}

	private String pdfDir = null;
	private String path = null;

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextPane jTextPane1;
	private java.awt.TextField textField1;
	// End of variables declaration//GEN-END:variables

}