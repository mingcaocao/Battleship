package battleship;

import java.util.ArrayList;
import java.util.Random;

public class Ocean {
	Ship[][] ships = new Ship[10][10];
	boolean[][] hit = new boolean[10][10];
	int shotsFired;
	int hitCount;
	int shipsSunk;
	ArrayList<Ship> shipDeployed;

	/**
	 * initialize the ocean
	 */
	Ocean(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++ ){
				this.ships[i][j] = new EmptySea();
			}
		}
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
		this.shipDeployed = new ArrayList<Ship>();
	}

	/**
	 * place all ships randomly,
	 * first place one battleship, then two cruisers, three destroyers and last four submarines
	 * check if ok to place first, then place
	 */
	void placeAllShipsRandomly(){
		Random rand = new Random();
		while(true){
			int row = rand.nextInt(10);
			int column = rand.nextInt(10);
			boolean horizontal = rand.nextBoolean();
			Battleship battleship1 = new Battleship();
			if(battleship1.okToPlaceShipAt(row, column, horizontal, this)){
				battleship1.placeShipAt(row, column, horizontal, this);
				shipDeployed.add(battleship1);
				break;
			}
			else{
				continue;
			}
		}
		
		for(int i = 0; i < 2; i++){
			while(true){
				int row = rand.nextInt(10);
				int column = rand.nextInt(10);
				boolean horizontal = rand.nextBoolean();
				Cruiser cruiser1 = new Cruiser();
				if(cruiser1.okToPlaceShipAt(row, column, horizontal, this)){
					cruiser1.placeShipAt(row, column, horizontal, this);
					shipDeployed.add(cruiser1);
					break;
				}
				else{
					continue;
				}
			}
		}
		
		for(int i = 0; i < 3; i++){
			while(true){
				int row = rand.nextInt(10);
				int column = rand.nextInt(10);
				boolean horizontal = rand.nextBoolean();
				Destroyer destroyer1 = new Destroyer();
				if(destroyer1.okToPlaceShipAt(row, column, horizontal, this)){
					destroyer1.placeShipAt(row, column, horizontal, this);
					shipDeployed.add(destroyer1);
					break;
				}
				else{
					continue;
				}
			}
		}
		
		for(int i = 0; i < 4; i++){
			while(true){
				int row = rand.nextInt(10);
				int column = rand.nextInt(10);
				boolean horizontal = rand.nextBoolean();
				Submarine submarine1 = new Submarine();
				if(submarine1.okToPlaceShipAt(row, column, horizontal, this)){
					submarine1.placeShipAt(row, column, horizontal, this);
					shipDeployed.add(submarine1);
					break;
				}
				else{
					continue;
				}
			}
		}
	}

	/**
	 * check if the square is occupied by any ship
	 * @param row - the row number of square
	 * @param column - the column number of square
	 * @return
	 */
	boolean isOccupied(int row, int column){
		if(ships[row][column].getShipType().equals("empty")){
			return false;
		}
		return true;
	}

	/**
	 * update the shotsFired instance;
	 * check if the square is occupied,
	 * then check if the ship is sunk.
	 * if no, update hitCount instance and return true;
	 * otherwise, return false.
	 * @param row - the row number of square
	 * @param column- the column number of square
	 * @return
	 */
	boolean shootAt(int row, int column){
		hit[row][column] = true;
		shotsFired ++;
		if(isOccupied(row, column)){
			if(ships[row][column].isSunk()){
				return false;
			}
			else{
				hitCount++;
				return true;
			}
		}
		else{
			return false;
		}
	}

	/**
	 * get the number of shots fired
	 * @return
	 */
	int getShotsFired(){
		return shotsFired;
	}

	/**
	 * get the number of hit count
	 * @return
	 */
	int getHitCount(){
		return hitCount;
	}

	/**
	 * get the number of ship sunk;
	 * use an array containing all ships
	 * check every ship's statue of being sunk or not;
	 * get the sunk ships number 
	 * @return
	 */
	int getShipsSunk(){
		int shipVanquished = 0;
		for(Ship ship : shipDeployed){
			if(ship.isSunk()){
				shipVanquished++;
			}
		}
		shipsSunk = shipVanquished;
		return shipsSunk;
	}

	/**
	 * check if the game is over by checking if all ships(10 ships) are sunk
	 * @return
	 */
	boolean isGameOver(){
		if(shipsSunk == 10){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * get the ocean 2d array
	 * @return
	 */
	Ship[][] getShipArray(){
		return this.ships;
	}

	/**
	 * print out the ocean map
	 */
	void print(){
		for(int i = 0; i < 10; i++){
			System.out.print("\t" + i);
		}
		System.out.print("\n");
		for(int j = 0; j < 10; j++){
			System.out.print(j + "\t");
			for(int k = 0; k < 10; k++){
				if(hit[j][k]){
					System.out.print(ships[j][k] + "\t");
				}
				else{
					System.out.print(".\t");
				}
			}
			System.out.print("\n\n");
		}
	}

}
