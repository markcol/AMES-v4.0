/* ============================================================================
 * AMES Wholesale Power Market Test Bed (Java): A Free Open-Source Test-Bed
 *         for the Agent-based Modeling of Electricity Systems
 * ============================================================================
 *
 * (C) Copyright 2008, by Hongyan Li, Junjie Sun, and Leigh Tesfatsion
 *
 *    Homepage: http://www.econ.iastate.edu/tesfatsi/AMESMarketHome.htm
 *
 * LICENSING TERMS
 * The AMES Market Package is licensed by the copyright holders (Junjie Sun,
 * Hongyan Li, and Leigh Tesfatsion) as free open-source software under the
 * terms of the GNU General Public License (GPL). Anyone who is interested is
 * allowed to view, modify, and/or improve upon the code used to produce this
 * package, but any software generated using all or part of this code must be
 * released as free open-source software in turn. The GNU GPL can be viewed in
 * its entirety as in the following site: http://www.gnu.org/licenses/gpl.html
 */

/*
 * PowerGridConfigure1.java
 *
 * Created on June 5, 2007, 4:41 PM
 */

package AMESGUIFrame;


import javax.swing.JOptionPane;

import amesmarket.Support;

public class PowerGridConfigure1 extends javax.swing.JFrame {

	/** Creates new form PowerGridConfigure1
	 * @param frame
	 */
	public PowerGridConfigure1(AMESFrame frame) {
		this.mainFrame = frame;
		this.setTitle("Step 1: Input global parameters");
		this.initComponents();
	}

	public void SetInitParameters(int iNode, int iBranch, int ITransformer, int iGen, int iLSE, double V, double P) {

		this.iTotalNodeNumber=iNode;
		this.iTotalBranchNumber=iBranch;
		this.iTotalTransformerNumber=ITransformer;
		this.iTotalGenNumber=iGen;
		this.iTotalLSENumber=iLSE;
		this.VBase=V;
		this.PowerBase=P;

		this.GridNodeTextField.setText(String.valueOf(this.iTotalNodeNumber));
		this.GridLineTextField.setText(String.valueOf(this.iTotalBranchNumber));
		this.GeneratorTextField.setText(String.valueOf(this.iTotalGenNumber));
		this.LSETextField.setText(String.valueOf(this.iTotalLSENumber));

		this.PowerBaseTextField.setText(String.valueOf(this.PowerBase));
		this.VBaseTextField.setText(String.valueOf(this.VBase));
	}
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		this.jPanel1 = new javax.swing.JPanel();
		this.jLabel1 = new javax.swing.JLabel();
		this.jLabel2 = new javax.swing.JLabel();
		this.GridNodeTextField = new javax.swing.JTextField();
		this.jLabel3 = new javax.swing.JLabel();
		this.GridLineTextField = new javax.swing.JTextField();
		this.jLabel5 = new javax.swing.JLabel();
		this.GeneratorTextField = new javax.swing.JTextField();
		this.jLabel6 = new javax.swing.JLabel();
		this.LSETextField = new javax.swing.JTextField();
		this.CancelButton = new javax.swing.JButton();
		this.NextButton = new javax.swing.JButton();
		this.jPanel2 = new javax.swing.JPanel();
		this.jLabel4 = new javax.swing.JLabel();
		this.jLabel7 = new javax.swing.JLabel();
		this.jLabel8 = new javax.swing.JLabel();
		this.VBaseTextField = new javax.swing.JTextField();
		this.PowerBaseTextField = new javax.swing.JTextField();

		this.jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		this.jPanel1.setFont(new java.awt.Font("Arial", 0, 12));

		this.jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
		this.jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.jLabel1.setText(" Input total number of");
		this.jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.jLabel2.setFont(new java.awt.Font("Arial", 0, 12));
		this.jLabel2.setText("Grid Buses");
		this.jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.GridNodeTextField.setFont(new java.awt.Font("Arial", 0, 12));
		this.GridNodeTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		this.GridNodeTextField.setText("3");
		this.GridNodeTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.jLabel3.setFont(new java.awt.Font("Arial", 0, 12));
		this.jLabel3.setText("Grid Branches");
		this.jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.GridLineTextField.setFont(new java.awt.Font("Arial", 0, 12));
		this.GridLineTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		this.GridLineTextField.setText("3");
		this.GridLineTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.jLabel5.setFont(new java.awt.Font("Arial", 0, 12));
		this.jLabel5.setText("GenCos");
		this.jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.GeneratorTextField.setFont(new java.awt.Font("Arial", 0, 12));
		this.GeneratorTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		this.GeneratorTextField.setText("3");
		this.GeneratorTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.jLabel6.setFont(new java.awt.Font("Arial", 0, 12));
		this.jLabel6.setText("LSEs");
		this.jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.LSETextField.setFont(new java.awt.Font("Arial", 0, 12));
		this.LSETextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		this.LSETextField.setText("3");
		this.LSETextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
		this.jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(46, 46, 46)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(this.jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(this.jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
												.addComponent(this.jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
												.addComponent(this.jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
												.addComponent(this.jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(32, 32, 32)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(this.GridNodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(this.GeneratorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(this.GridLineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(this.LSETextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(43, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(6, 6, 6)
						.addComponent(this.jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(this.jLabel2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.jLabel3)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.jLabel5)
										.addGap(6, 6, 6)
										.addComponent(this.jLabel6))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(this.GridNodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.GridLineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.GeneratorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(6, 6, 6)
										.addComponent(this.LSETextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		this.CancelButton.setFont(new java.awt.Font("Arial", 0, 12));
		this.CancelButton.setText("Cancel");
		this.CancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		this.CancelButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PowerGridConfigure1.this.CancelButtonActionPerformed(evt);
			}
		});

		this.NextButton.setFont(new java.awt.Font("Arial", 0, 12));
		this.NextButton.setText("Next >>");
		this.NextButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		this.NextButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PowerGridConfigure1.this.NextButtonActionPerformed(evt);
			}
		});

		this.jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		this.jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
		this.jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.jLabel4.setText("Set base values for voltage and apparent power");
		this.jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.jLabel7.setFont(new java.awt.Font("Arial", 0, 12));
		this.jLabel7.setText("Voltage Base");
		this.jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.jLabel8.setFont(new java.awt.Font("Arial", 0, 12));
		this.jLabel8.setText("Apparent Power Base");
		this.jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		this.VBaseTextField.setFont(new java.awt.Font("Arial", 0, 12));
		this.VBaseTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		this.VBaseTextField.setText("10");
		this.VBaseTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		this.VBaseTextField.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PowerGridConfigure1.this.VBaseTextFieldActionPerformed(evt);
			}
		});

		this.PowerBaseTextField.setFont(new java.awt.Font("Arial", 0, 12));
		this.PowerBaseTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		this.PowerBaseTextField.setText("100");
		this.PowerBaseTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		this.PowerBaseTextField.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PowerGridConfigure1.this.PowerBaseTextFieldActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this.jPanel2);
		this.jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(20, 20, 20)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(this.jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(this.jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(this.PowerBaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(this.VBaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addContainerGap(18, Short.MAX_VALUE)
						.addComponent(this.jLabel4)
						.addContainerGap())
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(this.jLabel4)
						.addGap(17, 17, 17)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel7)
								.addComponent(this.VBaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(this.PowerBaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(this.jLabel8))
						.addContainerGap(29, Short.MAX_VALUE))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(111, 111, 111)
										.addComponent(this.CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(49, 49, 49)
										.addComponent(this.NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(this.jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(this.jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(this.jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(this.CancelButton)
								.addComponent(this.NextButton))
						.addContainerGap())
				);

		this.pack();
	}// </editor-fold>//GEN-END:initComponents

	private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
		PowerGridConfigure2 config2 = this.mainFrame.getConfig2();

		if(this.mainFrame.isNewCase()) {
			String strMessage="";

			strMessage=this.DataVerify();
			if(!strMessage.isEmpty()) {
				JOptionPane.showMessageDialog(this, strMessage, "Case Data Verify Message", JOptionPane.ERROR_MESSAGE);
				return;
			}

			this.mainFrame.setNewCaseInitialData(this.iTotalNodeNumber, this.iTotalBranchNumber, this.iTotalGenNumber, this.iTotalLSENumber, this.VBase, this.PowerBase);
		}

		this.setVisible(false);
		this.mainFrame.activeConfig2();
	}//GEN-LAST:event_NextButtonActionPerformed

	public void saveData() {
		this.mainFrame.setVBase(this.VBase);
		this.mainFrame.setPBase(this.PowerBase);
	}

	public String DataVerify() {
		String strMessage="";

		String strTemp =this.GridNodeTextField.getText();
		int iTemp;

		String message="The total grid bus number should bigger than 2!";
		try {
			iTemp=Integer.parseInt(strTemp);

			if(iTemp<3) {
				strMessage+=message;
			} else {
				this.iTotalNodeNumber=iTemp;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, message, "Error Message", JOptionPane.ERROR_MESSAGE);
			return message;
		}

		strTemp =this.GridLineTextField.getText();
		message="The total grid branch number should bigger than 2!";
		try {
			iTemp=Integer.parseInt(strTemp);

			if(iTemp<3) {
				strMessage+=message;;
			} else {
				this.iTotalBranchNumber=iTemp;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, message, "Error Message", JOptionPane.ERROR_MESSAGE);
			return message;
		}

		strTemp =this.GeneratorTextField.getText();
		message="The total generator number should bigger than or equal to 1!";
		try {
			iTemp=Integer.parseInt(strTemp);

			if(iTemp<1) {
				strMessage+=message;;
			} else {
				this.iTotalGenNumber=iTemp;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, message, "Error Message", JOptionPane.ERROR_MESSAGE);
			return message;
		}

		strTemp =this.LSETextField.getText();
		message="The total LSE number should bigger than or equal to 1!";
		try {
			iTemp=Integer.parseInt(strTemp);

			if(iTemp<1) {
				strMessage+=message;;
			} else {
				this.iTotalLSENumber=iTemp;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, message, "Error Message", JOptionPane.ERROR_MESSAGE);
			return message;
		}

		strTemp =this.VBaseTextField.getText();
		message="The voltage base value should bigger than 0!";
		try {
			double dTemp=Support.parseDouble(strTemp);

			if(dTemp<0) {
				strMessage+=message;;
			} else {
				this.VBase=dTemp;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, message, "Error Message", JOptionPane.ERROR_MESSAGE);
			return message;
		}

		strTemp =this.PowerBaseTextField.getText();
		message="The apperant power base value should bigger than 0!";
		try {
			double dTemp=Support.parseDouble(strTemp);

			if(dTemp<0) {
				strMessage+=message;
			} else {
				this.PowerBase=dTemp;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, message, "Error Message", JOptionPane.ERROR_MESSAGE);
			return message;
		}

		return strMessage;
	}

	private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
		this.setVisible(false);
	}//GEN-LAST:event_CancelButtonActionPerformed

	private void VBaseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VBaseTextFieldActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_VBaseTextFieldActionPerformed

	private void PowerBaseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerBaseTextFieldActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_PowerBaseTextFieldActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton CancelButton;
	private javax.swing.JTextField GeneratorTextField;
	private javax.swing.JTextField GridLineTextField;
	private javax.swing.JTextField GridNodeTextField;
	private javax.swing.JTextField LSETextField;
	private javax.swing.JButton NextButton;
	private javax.swing.JTextField PowerBaseTextField;
	private javax.swing.JTextField VBaseTextField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	// End of variables declaration//GEN-END:variables
	public int iTotalNodeNumber;
	public int iTotalBranchNumber;
	public int iTotalTransformerNumber;
	public int iTotalGenNumber;
	public int iTotalLSENumber;

	public double VBase;
	public double PowerBase;

	private AMESFrame mainFrame;

}