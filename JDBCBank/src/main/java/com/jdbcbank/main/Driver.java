package com.jdbcbank.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.jdbcbank.beans.BankAccount;
import com.jdbcbank.beans.BankUser;
import com.jdbcbank.dao.BankAccountDAO;
import com.jdbcbank.dao.BankAccountDAOImpl;
import com.jdbcbank.dao.BankUserDAO;
import com.jdbcbank.dao.BankUserDAOImpl;

public class Driver {
	public static void main(String[] args) throws IOException {
		String filename = "src/main/resources/connection.properties";
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String superusername = prop.getProperty("superusername");
		String superpassword = prop.getProperty("superpassword");
		BankUserDAO bankUserDAO = new BankUserDAOImpl();
		BankAccountDAO bankAccountDAO = new BankAccountDAOImpl();
		Scanner scanner = new Scanner(System.in);
		int choice=99;
		int isAdmin=0;
		String num;
		System.out.println("Welcome to Revature Bank!!");
		while(choice != 0) {
			System.out.println("Please select an option");
			System.out.println("1.Sign in");
			System.out.println("2.Create an account");
			System.out.println("0.Exit");
			num = scanner.nextLine();
			scanner.reset();
			try {
				choice = Integer.parseInt(num);
			}
			catch(Exception e) {
				System.out.println("You have entered an invalid value.");
				System.out.println("Please Start Over!");
				System.out.println("------------------");
				choice = 99;
			}
			switch (choice) {
			case 1:
				System.out.print("Please enter your username: ");
				String userName = scanner.nextLine().toLowerCase();
				scanner.reset();
				System.out.print("Please enter your Password: ");
				scanner.reset();
				String userPassword = scanner.nextLine();

				int bankUser=0;
				if(userName.equals(superusername) && userPassword.equals(superpassword)) {
					//System.out.println("here");
					isAdmin=1;
					bankUser = 1000;
				}else {
					bankUser = bankUserDAO.login(userName, userPassword);
					isAdmin=0;
				}
				if(bankUser > 0) {
					//System.out.println(bankUser);
					int c=99;	
					do {
						System.out.println("Please select an option");
						System.out.println("1.Your bank account list");
						System.out.println("2.Create a new bank account");
						if(isAdmin==1 && bankUser==1000)
							System.out.println("3.Access all user information");
						System.out.println("0.Exit");
						String num1 = scanner.nextLine();
						scanner.reset();
						try {
							c = Integer.parseInt(num1);
						}
						catch(Exception e) {
							System.out.println("You have entered an invalid value.");
							System.out.println("Please Start Over!");
							System.out.println("------------------");
						}
						switch (c) {
						case 1:
							int d = 99;
							while (d!=0){
								int i =bankAccountDAO.getAccounts(bankUser).size();
								int[] arr = new int[i];
								int j=0;
								System.out.printf( "%-15s %-20s %-15s %n","No:", "Account Name", "Balance");
								for(BankAccount ba : bankAccountDAO.getAccounts(bankUser)) {
									arr[j]=ba.getAccountId();
									System.out.printf( "%-15s %-20s %-15s %n",j+1, ba.getAccountName(), ba.getBalance());
									j++;
								}
								System.out.println("1.Deposit");
								System.out.println("2.Withdraw");
								System.out.println("3.Delete account");
								System.out.println("0.Exit");
								String num2 = scanner.nextLine();
								scanner.reset();
								try {
									d = Integer.parseInt(num2);
								}
								catch(Exception e) {
									System.out.println("------------------");
								}
								switch (d) {
								case 1:
									try {
										System.out.print("Enter the account no:");
										int e = scanner.nextInt();
										scanner.reset();
										System.out.print("Enter the deposit amount:");
										double deposit = scanner.nextDouble();
										scanner.reset();
										//System.out.println(e+" "+deposit+arr[e-1]);

										if(deposit>0 && e>0 && e<=i) {
											bankAccountDAO.deposit(arr[e-1], deposit);
											System.out.println("Deposit is successful");
											d=99;
										}else System.out.println("Invalid input");
									}
									catch (Exception e2) {
										System.out.println("Invalid input");
									}

									d=99;
									break;
								case 2:
									try {
										System.out.print("Enter the account no:");
										int f = scanner.nextInt();
										scanner.reset();
										System.out.print("Enter the withdrawl amount:");
										double withdraw = scanner.nextDouble();
										scanner.reset();
										double balance = bankAccountDAO.balance(arr[f-1]);
										if(withdraw>0 && f>0 && f<=i && withdraw<=balance) {
											bankAccountDAO.withDraw(arr[f-1], withdraw);
											System.out.println("Withdrawl is successful");
											d=99;
										}else System.out.println("Invalid amount");
									}catch (Exception e2) {
										System.out.println("Invalid input");
									}
									d=99;
									break;
								case 3:
									try {
										System.out.print("Enter the account no:");
										int f = scanner.nextInt();
										scanner.reset();
										double balance = bankAccountDAO.balance(arr[f-1]);
										if(f>0 && f<=i && balance == 0.0) {
											bankAccountDAO.deleteBankAccount(arr[f-1]);
											System.out.println("Successful!!");
											d=99;
										}else System.out.println("Invalid amount");
									}catch (Exception e2) {
										System.out.println("Invalid input");
									}
									d=99;
									break;

								default:
									break;
								}

							} 
							break;


						case 2:
							if(bankAccountDAO.createBankAccount(bankUser))
								System.out.println("Your account has been created successfully!!");
							else System.out.println("Error!! Please try again");
							break;
						case 3:
							if(bankUser == 1000 && isAdmin == 1) {
								int e = 99;
								do {
									int i =bankUserDAO.getAllAccounts().size();
									int[] arr = new int[i];
									int j=0;
									System.out.printf( "%-15s %-20s %-20s %-15s %n","No:", "Username", "First Name","Last Name");
									for( BankUser ba : bankUserDAO.getAllAccounts()) {
										arr[j]=ba.getBankUser();
										System.out.printf( "%-15s %-20s %-20s %-15s %n",j+1, ba.getUserName(), ba.getFirstName(),ba.getLastName());
										j++;
									}
									System.out.println("1.Update user details");
									System.out.println("2.Delete account");
									System.out.println("0.Exit");
									Scanner sc2 = new Scanner(System.in);
									String num2 = sc2.nextLine();
									sc2.reset();
									try {
										e = Integer.parseInt(num2);
									}
									catch(Exception e1) {
										System.out.println("------------------");
									}
									switch (e) {
									case 1:
										try {
											String firstName;
											String lastName;
											Scanner sc = new Scanner(System.in);
											Scanner sc3 = new Scanner(System.in);
											Scanner sc4 = new Scanner(System.in);
											System.out.println("Enter the account no:");
											int f = sc.nextInt();
											
											System.out.println("Enter the firstname: ");
											firstName = sc3.nextLine();
											
											System.out.println("Enter the lastname: ");
											lastName = sc4.nextLine();
											
											if(f>0 && f<=i) {
												bankUserDAO.updateUserAccount(arr[f-1],firstName,lastName);
												System.out.println("Successful!!");
												e=99;
											}else System.out.println("Invalid amount");
										}catch (Exception e2) {
											System.out.println("Invalid input");
										}
										e = 99;
										break;
									case 2:
										try {
											System.out.print("Enter the account no:");
											int f = scanner.nextInt();
											scanner.reset();
											if(arr[f-1] != 1000) {
												if(f>0 && f<=i) {
													bankUserDAO.deleteUserAccount(arr[f-1]);
													System.out.println("Successful!!");
													e=99;
												}else System.out.println("Invalid amount");
											}else System.out.println("Can't delete a superuser");

										}catch (Exception e2) {
											System.out.println("Invalid input");
										}
										e = 99;
										break;

									default:
										System.out.println("------------------");
										break;
									}
								}while(e!=0);
							} else System.out.println("Invalid input");

							break;
						default:

							System.out.println("------------------");
							break;
						}

					} while (c!=0);

				}else {
					System.out.println("User not found");
					System.out.println("------------------");
				}
				break;
			case 2:
				if(bankUserDAO.createBankUser()) {
					System.out.println("Successful!!");
				}
				choice = 99;

				break;
			case 0:
				System.out.println("Thanks for using Revature Bank");

				break;

			default: 
				System.out.println("You have entered an invalid value.");
				System.out.println("Please Start Over!");
				System.out.println("------------------");
				break;
			}
		}
	}
}
