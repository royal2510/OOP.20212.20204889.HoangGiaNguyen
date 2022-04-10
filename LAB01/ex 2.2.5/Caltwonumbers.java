import javax.swing.JOptionPane;
public class Caltwonumbers{
	public static void main (String[] args){
		String strNum1, Strnum2,strNotification;
	strNum1 = JOptionPane.showInputDialog(null,"please enter 1st num: ", JOptionPane.INFORMATION_MESSAGE);
	strNum2 = JOptionPane.showInputDialog(null,"please enter 2nd num: ", JOptionPane.INFORMATION_MESSAGE);	
	double num1 = Double.parseDouble(strNum1);
	double num2 = Double.parseDouble(strNum2);

	strNotification = "Sum: " + (num1+num2)+"\n difference: "+(num1-num2) +"\n product: "+(num1*num2)
	+"\n quotient:" +(num1/num2); 
	JOptionPane.showMessageDialog(null,strNotification,"Calculate two numbers",JOptionPane.INFORMATION_MESSAGE);
	System.exit(0);
	}
}