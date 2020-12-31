package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do quarto: ");
			int roomNumber = sc.nextInt();

			System.out.print("Data de entrada: ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data de saída: ");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);
			System.out.println();

			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Data de entrada: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de saída: ");
			checkout = sdf.parse(sc.next());
			reservation.updateDates(checkin, checkout);
			System.out.println(reservation);
		} catch (ParseException e) {
			System.out.println("Erro: " + e);
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado !!!" + e);
		}
		sc.close();
	}
}
