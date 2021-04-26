package Chapter10;

public class AccountDemoTest
{
	public static void main(String[] args) 
	{	BankAccount bankAccountTest = new BankAccount();
		SavingsAccount savingAccountTest = new SavingsAccount();
	
		bankAccountTest.constructor();
		bankAccountTest.deposit();
		System.out.println("");
		bankAccountTest.withdraw();
		bankAccountTest.calcInterest();
		bankAccountTest.monthlyProcess();
		System.out.println("");
		
		savingAccountTest.withdraw();
		System.out.println("");
		savingAccountTest.deposit();
		savingAccountTest.monthlyProcess();
	}

}
