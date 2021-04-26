package Chapter10;
import java.util.Scanner;
public class BankAccount 
{	
	static Scanner scanner = new Scanner(System.in);
	static double balance,  annualInterestRate,  monthlyServiceCharges;
	static int monthlyDepositNumber, monthlyWithdrawNumber;
	
	public static void constructor()
	{
		System.out.println("What is the account's balance?");
		balance = scanner.nextDouble();
		System.out.println("What is the annual interest rate?");
		annualInterestRate = scanner.nextDouble();
		System.out.println("What is the monthly service charges?");
		monthlyServiceCharges = scanner.nextDouble();
		System.out.println("What is the monthly number of deposits?");
		monthlyDepositNumber = scanner.nextInt();
		System.out.println("What is the monhtly number of withdraws?");
		monthlyWithdrawNumber = scanner.nextInt();
		getBalance();
		getAnnualInterestRate();
		getMonthlyServiceCharges();
	}
	
	public void deposit()
	{	
		System.out.println("How much would you like to deposit?");
		double depositMoney = scanner.nextDouble();
		while(depositMoney < 0)
		{
			System.out.println("Cannot deposit negative money. Please try again.");
			depositMoney = scanner.nextDouble();
		}
		monthlyDepositNumber++;
		balance += depositMoney;
		System.out.println("Monthly Deposit Number: "  + monthlyDepositNumber);
		System.out.println("Current balance: $" + String.format("%.2f", balance));
		getMonthlyDepositNumber();
	}

	public void withdraw()
	{
		System.out.println("How much would you like to withdraw?");
		double withdrawMoney = scanner.nextDouble();
		while(withdrawMoney < 0)
		{
			System.out.println("Cannot withdraw negative money. Please try again.");
			withdrawMoney = scanner.nextDouble();
		}
		while(withdrawMoney > balance)
		{
			System.out.println("Cannot withdraw more money than the current balance.");
			withdrawMoney = scanner.nextDouble();
		}
		monthlyWithdrawNumber++;
		balance -= withdrawMoney;
		System.out.println("Monthly Withdraw Number: "  + monthlyWithdrawNumber);
		System.out.println("Current balance: $" + String.format("%.2f", balance));
		getMonthlyWithdrawNumber();
	}
	
	public static void calcInterest()
	{
		double monthlyInterestRate = annualInterestRate / 12;
		double monthlyInterest = balance * monthlyInterestRate;
		balance += monthlyInterest;
	}
	
	public void monthlyProcess()
	{
		balance -= monthlyServiceCharges;
		calcInterest();
		monthlyDepositNumber = 0;
		monthlyWithdrawNumber = 0;
		monthlyServiceCharges = 0;
		System.out.println("Balance after the monthly process: $" + String.format("%.2f", balance));
	}
	
	public static double getBalance() 
	{
		return balance;
	}

	public static double getAnnualInterestRate() 
	{
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(double annualInterestRate) 
	{
		BankAccount.annualInterestRate = annualInterestRate;
	}

	public static double getMonthlyServiceCharges() 
	{
		return monthlyServiceCharges;
	}

	public static void setMonthlyServiceCharges(double monthlyServiceCharges)
	{
		BankAccount.monthlyServiceCharges = monthlyServiceCharges;
	}

	public static int getMonthlyDepositNumber() 
	{
		return monthlyDepositNumber;
	}

	public static void setMonthlyDepositNumber(int monthlyDepositNumber) 
	{
		BankAccount.monthlyDepositNumber = monthlyDepositNumber;
	}

	public static int getMonthlyWithdrawNumber() {
		return monthlyWithdrawNumber;
	}

	public static void setMonthlyWithdrawNumber(int monthlyWithdrawNumber) 
	{
		BankAccount.monthlyWithdrawNumber = monthlyWithdrawNumber;
	}
}
	
