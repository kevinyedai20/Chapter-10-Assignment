package Chapter10;
import java.util.Scanner;
public class SavingsAccount extends BankAccount
{
	static Scanner scanner = new Scanner(System.in);
	static String accountStatus;
	
	public static String getAccountStatus() 
	{	
		if(BankAccount.balance > 25)
		{
			accountStatus = "Active";
		}
		else
		{
			accountStatus = "Inactive";
		}
		return accountStatus;
	}
	
	public void deposit()
	{	
		//Variable to hold balance before the deposit
		double x = BankAccount.balance;
		getAccountStatus();
		accountStatusMessage();
		super.deposit();
		if(x != BankAccount.balance && BankAccount.balance > 25)
		{
			System.out.println("The account is currently activated.");
		}
		else
			System.out.println("The account is still inactive after the deposit.");
		getAccountStatus();
	}
	
	public void withdraw()
	{	
		getAccountStatus();
		if(accountStatus.equals("Inactive"))
		{
			System.out.println("Withdrawals are not allowed until the account's balance is above $25 ");
		}
		if(accountStatus.equals("Active"))
		{
			super.withdraw();
		}
	}
		
	public void monthlyProcess()
	{
		if(super.monthlyWithdrawNumber > 4)
		{
			super.monthlyServiceCharges += (super.monthlyWithdrawNumber - 4);
		}
		super.monthlyProcess();
		getAccountStatus();
		
	}
	
	public void accountStatusMessage()
	{
		if(accountStatus.equals("Inactive"))
		{
			System.out.println("The account is currently inactive. Bring the balance above $25 to activate the account.");
		}
		else
		{
			System.out.println("The account is currently activated.");
		}
	}
}

