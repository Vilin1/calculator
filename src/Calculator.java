import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;



class Calculator {
//show the operator in label
	void setMethod(String str) {
		method.setText(str);
		operation = str;
	}

//check number
boolean check(String str) {
	Pattern pattern = Pattern.compile("[0-9]*");
	return pattern.matcher(str).matches();
}

//caculator the result
	void calculate() {
		String strNum1 = num1.getText();
		String strNum2 = num2.getText();
		//illegal 
		if(!check(strNum1)||!check(strNum2)||operation.equals("")) {
			result.setText("E!");
		} else {
			double temp = 0;
			double douNum1 = Double.valueOf(strNum1);
			double douNum2 = Double.valueOf(strNum2);
			boolean tag = true;
			if(operation.equals("+")) {
				temp = douNum1 + douNum2;
			} else if(operation.equals("-")) {
				temp = douNum1 - douNum2;
			} else if(operation.equals("*")) {
				temp = douNum1 * douNum2;
			} else if(operation.equals("/")) {
				temp = douNum1 / douNum2;
			} else {
				result.setText("E!");
				tag = false;
			}
			if(tag) {
				String reStr = String.valueOf(temp);
				result.setText(reStr);
			}
		}
	}
	
	void createWindow() {
		int colmn1 = 10, colmn2 = 80, colmn3 = 150, colmn4 = 220, colmn5 = 290;
		int row1 = 10, row2 = 80;

		//new main window
		JFrame jframe = new JFrame("Calculator");
		jframe.setSize(5*SIZE+60, 2*SIZE+60);
		jframe.setLayout(null);
		jframe.setDefaultCloseOperation(3);

		//set num1 
		num1 = new JTextField("12");
		//show in enter
		num1.setHorizontalAlignment(JTextField.CENTER);
		num1.setVisible(true);
		num1.setBounds(colmn1, row1, SIZE,SIZE);

		//set operator
		method = new JLabel("", JLabel.CENTER);
		method.setBounds(colmn2, row1, SIZE, SIZE);

		//set num2
		num2 = new JTextField("2");
		num2.setHorizontalAlignment(JTextField.CENTER);
		num2.setBounds(colmn3, row1, SIZE, SIZE);

		equel = new JLabel("==", JLabel.CENTER);
		equel.setHorizontalAlignment(JLabel.CENTER);
		equel.setBounds(colmn4, row1, SIZE, SIZE);

		//show result
		result = new JLabel("", JLabel.CENTER);
		result.setBounds(colmn5, row1, SIZE, SIZE);

		//set button
		JButton buttonAdd = new JButton("+");
		buttonAdd.setBounds(colmn1, row2, SIZE, SIZE);
		//set eventlister
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMethod("+");
			}
		});

		JButton buttonSub = new JButton("-");
		buttonSub.setBounds(colmn2, row2, SIZE, SIZE);
		//set eventlister
		buttonSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMethod("-");
			}
		});

		JButton buttonMul = new JButton("*");
		buttonMul.setBounds(colmn3, row2, SIZE, SIZE);
		//set eventlister
		buttonMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMethod("*");
			}
		});

		JButton buttonDiv = new JButton("/");
		buttonDiv.setBounds(colmn4, row2, SIZE, SIZE);
		//set eventlister
		buttonDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMethod("/");
			}
		});

		JButton buttonOk = new JButton("OK");
		buttonOk.setBounds(colmn5, row2, SIZE, SIZE);
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
		});

		//add element to jframe
		jframe.add(num1);
		jframe.add(num2);
		jframe.add(method);
		jframe.add(equel);
		jframe.add(result);

		//add element to jframe
		jframe.add(buttonAdd);
		jframe.add(buttonSub);
		jframe.add(buttonMul);
		jframe.add(buttonDiv);
		jframe.add(buttonOk);
		jframe.setVisible(true);

	}

	public static void main(String args[]) {
		Calculator c = new Calculator();
		c.createWindow();
	}

	//member
	private static final int SIZE = 60;
	private JTextField num1 = null, num2 = null;
	private JLabel method = null, equel = null, result = null;
	private String operation = "";
}
