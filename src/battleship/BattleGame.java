package battleship;

import java.util.Scanner;

public class BattleGame {

	/**
	 * main method, taking command from players and printing out indication and ocean map
	 * @param args
	 */
	public static void main(String[] args) {
		Ocean ocean1 = new Ocean();
		ocean1.placeAllShipsRandomly();
		System.out.println("Game start!");
		ocean1.print();
		while(true){
			if(ocean1.isGameOver()){
				System.out.println("Game over! Your final score is " + ocean1.getShotsFired() + ". Well done!");
				break;
			}
			else{
				int row, column;
				Scanner reader = new Scanner(System.in);
				while(true){
					System.out.println("Please input the row you want to hit:");
					row = reader.nextInt();
					if(row >= 0 && row <= 9){
						break;
					}
					else{
						System.out.println("Please enter a valid value!");
					}
				}
				while(true){
					System.out.println("Please input the column you want to hit:");
					column = reader.nextInt();
					if(column >= 0 && column <= 9){
						break;
					}
					else{
						System.out.println("Please enter a valid value!");
					}
				}
				ocean1.ships[row][column].shootAt(row, column);
				if(ocean1.shootAt(row, column)){
					System.out.println("Hit!");
				}
				else{
					System.out.println("Miss!");
				}
				System.out.println("Current score(ShotsFired): " + ocean1.getShotsFired() + ". Ships have been sunk: " + ocean1.getShipsSunk() + ".");
				ocean1.print();
			}
		}

	}

}
