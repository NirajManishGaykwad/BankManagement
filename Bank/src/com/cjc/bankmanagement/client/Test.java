package com.cjc.bankmanagement.client;
import java.util.Scanner;
import com.cjc.bankmanagement.model.Account;
import com.cjc.bankmanagement.serviceImpl.SBI;
import com.cjc.bankmanagement.service.RBI;
public class Test 
{
	public static void main(String[] args)
	{
		RBI bank= new SBI();
		
		char loop='y';
		
		while(loop == 'y')
		{
			System.out.println("====================================================");
			System.out.println("Welcome to Online Banking...");
			System.out.println("Enter 1: For New Account Opening");
			System.out.println("Enter 2: To Deposite Money In Existing Account");
			System.out.println("Enter 3: To Withdraw Money From Existing Account");
			System.out.println("Enter 4: To Check Existing Account Balance");
			System.out.println("Enter 5: To View Existing Account Details");
			System.out.println("====================================================");
			System.out.println("Please Enter Your choise:=> ");
			
			
			Scanner in = new Scanner(System.in);
			char ch=in.next().charAt(0);
			switch(ch)
			{
			case '1': 
				bank.createAccount();
				break;
			case '2': 
				bank.depositeMoney();
				break;
			case '3': 
				bank.withdrawal();
				break;
			case '4': 
				bank.balanceCheck();
				break;
			case '5': 
				bank.displayAllDetails();
				break;
			}
		}
		
	}
}
