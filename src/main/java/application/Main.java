package application;

import model.entities.Account;
import model.exceptions.DomainExceptions;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data ");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Inicial balance: ");
            Double initBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLim = sc.nextDouble();

            Account account = new Account(number, holder, initBalance, withdrawLim);

            System.out.println();
            System.out.print("Enter amount for withdraw:");
            double amount = sc.nextDouble();

            account.withdraw(amount);
        }
        catch (DomainExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("It looks like you tried to enter some wrong data." + e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println("Internal error: Attempt to access a non-existent object.");
        }
        catch (Exception e) {
            System.out.println("Unexpected error");
        }
        finally {
            sc.close();
        }
    }
}
