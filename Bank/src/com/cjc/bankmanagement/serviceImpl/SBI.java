package com.cjc.bankmanagement.serviceImpl;
import com.cjc.bankmanagement.model.Account;
import com.cjc.bankmanagement.service.RBI;
import java.util.Scanner;
import java.util.Random;

public class SBI implements RBI
{

	private Account ac = new Account();
	Scanner in = new Scanner(System.in);
	@Override
	public void createAccount() 
	{
		System.out.println("Welcome to SBI\nPlease enter the Details to open a savings Account");
		
		System.out.println("Enter Your Name: ");
		ac.setName(in.next()+in.nextLine());
		System.out.println("Enter Aadhar Card Number: ");
		ac.setAdharNo(in.next());
		System.out.println("Enter Mobile Number You Want To Register: ");
		ac.setMobNo(in.next());
		System.out.println("Enter Your Gender: ");
		ac.setMobNo(in.next());
		System.out.println("Enter Your Age: ");
		ac.setMobNo(in.next());
		
		System.out.println("THANKS FOR ENTERING PERSONAL DETAILS...! YOUR ACCOUNT HAS BEEN CREATED");
		Random rm = new Random();
		int accNum = rm.nextInt(1000000,9999999);
		ac.setAccNo(accNum);
		System.out.println("Congratulations! Your Account Number is: "+ac.getAccNo());
		System.out.println("Do you want to credit some amount right after account creation? Enter y/n : ");
		char ch = in.next().charAt(0);
		
		if(ch == 'y')
		{
			System.out.println("Enter the amount you want to credit: ");
			double amount = in.nextDouble();
			ac.setBalance(amount);
		}
		else
			ac.setBalance(0);
		
		System.out.println("Your Bank Balance right after account opening is: "+ac.getBalance());
		
		
	}

	@Override
	public void displayAllDetails()
	{
		System.out.println("The Customer Details Are: ");
		System.out.println("Name: "+ac.getName());
		System.out.println("Aadhar Num: "+ac.getAdharNo());
		System.out.println("Mobile: "+ac.getMobNo());
		System.out.println("Gender: "+ac.getGender());
		System.out.println("Age: "+ac.getAge());
		
		System.out.println("The Bank Details Are: ");
		System.out.println("Account Number: "+ac.getAccNo());
		System.out.println("Balance: "+ac.getBalance());
		
	}

	@Override
	public void depositeMoney() 
	{
		
			char ch='y';
			while(ch=='y')
			{
	
				System.out.println("Enter the amount you want to deposite:=> ");
				double deposite=in.nextDouble();
				if(deposite > 0)
				{
				ac.setBalance(ac.getBalance() + deposite);
				System.out.println("Deposite Transaction Successful...Current Banlace: "+ac.getBalance());
				
				}
				else
				{
					System.out.println("Please enter the valid amount...");
				}
				
				System.out.println("Do you want to repeate the deposite transaction? y/n Enter:=>");
				ch = in.next().charAt(0);
			}
				
	}

	@Override
	public void withdrawal() 
	{
		char ch='y';
		while(ch=='y')
		{

			System.out.println("Enter the amount you want to withdraw:=> ");
			double withdraw=in.nextDouble();
			if(ac.getBalance() >= withdraw)
			{
				ac.setBalance(ac.getBalance() - withdraw);
				System.out.println("Withdrawal Transaction Successful...Current Banlace: "+ac.getBalance());
				
			}
			else
			{	System.out.println("Bank balance is not sufficient for withdrawal");}
			
			System.out.println("Do you want to repeate the withdrawal transaction? y/n Enter:=>");
			ch = in.next().charAt(0);
		}
						
	}

	@Override
	public void balanceCheck() {
		// TODO Auto-generated method stub
		Random rm = new Random();
		int otp = rm.nextInt(1000,9999);
		System.out.print("OTP for Balance Check request is "+otp);
		System.out.println("\nEnter the OTP set to you :=> ");
		int check=in.nextInt();
		if(otp == check)
			System.out.println("Current Bank Balance Is: "+ac.getBalance());
		else
			System.out.println("OTP didn't match");
		
	}

}
