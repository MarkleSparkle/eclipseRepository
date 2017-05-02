import java.util.InputMismatchException;//importing the exception for error detection
import java.util.Scanner;//importing the scanner
public class FinalBank {


	public static void mainMenu(){//main menu prints the main menu 

		System.out.println("TEST 1");
		System.out.println("TEST 2");
		
		System.out.println("$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$");
		System.out.println("$                                           $");
		System.out.println("$      Welcome to Online Banking V2.1       $");
		System.out.println("$===========================================$");
		System.out.println("$                                           $");
		System.out.println("$      To create a new account type - A     $");
		System.out.println("$   To continue with an account type - B    $");
		System.out.println("$                                           $");
		System.out.println("$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$");

	}
	public static double deposit(Scanner reader3, double balance){//Brings in the scanner and the current balance to the method 'deposit'.
		double value=0;												//it adds the amount the user would like to deposit to the balance
		try{//catches any errors
			System.out.println("How much would you like to deposit?");
			value = reader3.nextDouble();
			balance = balance+value;
			//Adds value to the new balance

			System.out.println("Thank you for your deposit! \nYour balance has been updated.\n\n");
		}catch (InputMismatchException e){
			System.out.println("I'm sorry. You have entered an invalid value.\n\n"); 

		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("The number you have entered is out of bounds of the specified boundaries.");
		}


		return (balance);//returns the NEW balance
	}

	public static double withdraw(Scanner reader, double balance){//withdraw subtracts the amount the user would like to withdraw from the balance
		double value=0;

		try{//used to catch any errors
			System.out.println("How much would you like to withdraw?");
			value = reader.nextDouble();
			balance = balance - value;

		}catch (InputMismatchException e){
			System.out.println("I'm sorry. You have entered an invalid value.\n");
		}

		if (balance < 0){//After the subtraction, if the balance is a negative number, the transaction will be reversed and they can try again.
			balance=balance+value;
			System.out.println("I'm sorry, your have tried to withdraw more than you have. \nYou may want to check your balance and try again.\n");
		}
		else{//If the user withdraws a correct amount and the balance is still > 0, the user will go back to the menu and the balance will be updated
			System.out.format("You have withdrawn $%,.2f.%nYour balance has been updated.%n%n",value);
		}
		return (balance);//returns the NEW balance
	}

	public static double balance (double balance){//balance displays the user's balance


		System.out.println("$*$*$*$*$*$*$*$*$*$*$*$*$*$*$\n");
		System.out.format( "Your balance is $%,.2f%n%n",balance);
		System.out.println("$*$*$*$*$*$*$*$*$*$*$*$*$*$*$\n\n\n\n");
		return (balance);
	}

	public static void accountMenu(String name){//account menu method prints the account menu. It uses the user's name


		System.out.println("What would you like to do?\n");

		System.out.println("Check Account Balance --- A");
		System.out.println("Deposit Funds ----------- B");
		System.out.println("Withdraw Funds ---------- C");
		System.out.println("Exit Account ------------ D\n");
	}


	public static void main(String[] args) {//main method

		double balArray[] = new double[5];
		double accNumArray[] = new double[5];
		int pinArray[] = new int[5];
		String nameArray [] = new String [5];
		int option, choice;
		Scanner reader = new Scanner(System.in), reader2 = new Scanner(System.in), reader3 = new Scanner(System.in), reader4 = new Scanner(System.in); 
		int i;
		int counter=0;
		double accountNumber=0, pinNumber=0;
		int index = 0;
		boolean cont = true;
		//opening the variables needed for the entire program

		do{
			mainMenu();//prints the main menu
			choice = 0;
			//stuff to create a new account
			option = (int) reader.next().toUpperCase().charAt(0);//grabs the first character of the user's input to use in the switch statement
			switch (option){

			case 65:{//creating a new account
				//sets the account number for each account.
				accNumArray[counter] = (1000000*(Math.random()));//grabs a random number to use as the user's account number
				System.out.format("Welcome, your new account number is %.0f%n",accNumArray[counter]);//displays the user's number

				System.out.println("Please enter an integer pin number you would like to use.");
				try{
				pinArray[counter]= reader3.nextInt();
				}catch(InputMismatchException e){
					System.out.println("You need to enter an integer number");
				}
				System.out.println("What is your name?");
				try{
				nameArray[counter] = reader4.nextLine();//the user enters input of their desired pin and their name
				}catch(InputMismatchException e){
					System.out.println("Please enter your name correctly");
				}
				System.out.println("Welcome "+nameArray[counter] +".\n\n");
				counter++;//the counter is used to increment the account creation so no one's information will be over written
				break;
			}

			case 66:{//If the user enters B they will enter their account number and pin
				System.out.println("Please enter your valid account number");
				try{
				accountNumber = reader2.nextDouble();
				}catch(InputMismatchException e){
					System.out.println("Please enter a correct account number.");
				}
				System.out.println("Please enter your pin number");
				try{
				pinNumber = reader2.nextDouble();
				}catch(InputMismatchException e){
					System.out.println("Please enter a valid pin number.");
				}
				for (i=0;i<=4;i++){//This checks if the user's input is correct
					if (accountNumber == accNumArray[i] && pinNumber == pinArray[i]){//if it finds a match it will change the incremented i into index to be used in the rest of the program 
						index = i;
						break;
						//breaks out of the loop
					}
				}
			}
			}
			while(choice!=68){//While the choice of the user is not 68, (D) which is used to exit the program, the program will continue

				accountMenu(nameArray[index]);//prints the account menu method with the user's name
				choice = (int) reader2.next().toUpperCase().charAt(0);//grabs the first character of the user's input to use in the switch statement

				switch(choice){

				case 65:{//If the user types A they will continue through the balance method

					balance(balArray[index]);//The balance method brings in the balance of the current account. (index)
					break;
				}
				case 66:{////If the user types B they will continue through the deposit method

					balArray[index]= deposit(reader3, balArray[index]);//The deposit method brings in the reader and the balance for it to add the deposit to.
					//The method deposit returns the new balance and declaring the Array balArray of the current account as the balance for their account.
					break;
				}
				case 67:{//If the user types C they will continue through the withdraw method

					balArray[index]= withdraw(reader, balArray[index]);//The withdraw method brings in the scanner and the balance of the current account
					//The method returns the balance setting the array balArray as the balance for the current account
					break;
				}
				case 68:{//If the user enters D it will the user will be thanked and will exit the program
					System.out.println("Thank you for using Online Banking. \nHave a good day!\n\n\n");
					break;
				}
				default:{//If the user enters anything other than A, B, C, or D they will go back to the menu
					System.out.println("Please enter a valid character.\n");
					break;
				}

				}

			}

		}while(cont=true);//The program will run forever! Therefore it will just loop back to the main menu if the user decided to "log out"
		
		reader.close();
		reader2.close();//close all scanners
		reader3.close();
	}
}