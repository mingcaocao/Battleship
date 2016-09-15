package battleship;

public abstract class Ship {

	private int bowRow;
	private int bowColumn;
	int length;
	private boolean horizontal;
	boolean[] hit = new boolean[4];
	Ocean ocean1;

	/**
	 * get the length of ship
	 * @return length
	 */
	int getLength(){
		return this.length;
	}

	/**
	 * get the row of ship's bow
	 * @return row number
	 */
	int getBowRow() {
		return bowRow;
	}

	/**
	 * set the row number of bow
	 * @param bowRow
	 */
	void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}

	/**
	 * get the column of bow
	 * @return column number of row
	 */
	int getBowColumn() {
		return bowColumn;
	}

	/**
	 * set the column number of bow
	 * @param bowColumn
	 */
	void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}

	/**
	 * get if the ship is horizontal
	 * @return
	 */
	boolean isHorizontal() {
		return horizontal;
	}

	/**
	 * set if the ship is horizontal
	 * @param horizontal
	 */
	void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * abstract method
	 * @return ship's type in child class
	 */
	abstract String getShipType();

	/**
	 * to check if the ship can be put at the intended area
	 * check if the area and outer area of the ship is occupied by any other ship
	 * if yes, return false; otherwise, return true.
	 * Firstly, check if the ship is horizontal or not.
	 * Secondly, check if the ship would stick beyond the bond.
	 * Then check if the ship would be put at the edge of the ocean.
	 * At the end, check the specific area for each case.
	 * @param row - row number of bow
	 * @param column - column number of bow
	 * @param horizontal - the ship is horizontal or not
	 * @param ocean - the ocean ship put into
	 * @return if it's ok to place the ship
	 */
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		if(horizontal){
			if(column + getLength() > 10){
				return false;
			}
			else if(column == 0){
				if(row == 0){
					for(int i = column; i < column + getLength() + 1; i++){
						if(ocean.isOccupied(row, i) || ocean.isOccupied(row + 1, i)){
							return false;
						}
						else{
							continue;
						}
					}
					return true;
				}
				else if(row == 9){
					for(int i = column; i < column + getLength() + 1; i++){
						if(ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, i)){
							return false;
						}
						else{
							continue;
						}
					}
					return true;
				}
				else{
					for(int i = column; i < column + getLength() + 1; i++){
						if(ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, i) || ocean.isOccupied(row + 1, i)){
							return false;
						}
						else{
							continue;
						}
					}
					return true;
				}
			}
			else{
				if(column + getLength() == 10){
					if(row == 0){
						for(int i = column - 1; i < column + getLength(); i++){
							if(ocean.isOccupied(row, i) || ocean.isOccupied(row + 1, i)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
					else if(row == 9){
						for(int i = column - 1; i < column + getLength(); i++){
							if(ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, i)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
					else{
						for(int i = column - 1; i < column + getLength(); i++){
							if(ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, i) || ocean.isOccupied(row + 1, i)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}

				}
				else{
					if(row == 0){
						for(int i = column - 1; i < column + getLength() + 1; i++){
							if(ocean.isOccupied(row, i) || ocean.isOccupied(row + 1, i)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
					else if(row == 9){
						for(int i = column - 1; i < column + getLength() + 1; i++){
							if(ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, i)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
					else{
						for(int i = column - 1; i < column + getLength() + 1; i++){
							if(ocean.isOccupied(row, i) || ocean.isOccupied(row - 1, i) || ocean.isOccupied(row + 1, i)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
				} 
			}
		}
		else{
			if(row + getLength() > 10){
				return false;
			}
			else if(row == 0){
				if(column == 0){
					for(int i = row; i < row + getLength() + 1; i++){
						if(ocean.isOccupied(i, column) || ocean.isOccupied(i, column + 1)){
							return false;
						}
						else{
							continue;
						}
					}
					return true;
				}
				else if(column == 9){
					for(int i = row; i < row + getLength() + 1; i++){
						if(ocean.isOccupied(i, column) || ocean.isOccupied(i, column - 1)){
							return false;
						}
						else{
							continue;
						}
					}
					return true;
				}
				else{
					for(int i = row; i < row + getLength() + 1; i++){
						if(ocean.isOccupied(i, column) || ocean.isOccupied(i, column - 1) || ocean.isOccupied(i, column + 1)){
							return false;
						}
						else{
							continue;
						}
					}
					return true;
				}

			}
			else{
				if(row + getLength() == 10){
					if(column == 0){
						for(int i = row - 1; i < row + getLength(); i++){
							if(ocean.isOccupied(i, column) || ocean.isOccupied(i, column + 1)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
					else if(column == 9){
						for(int i = row - 1; i < row + getLength(); i++){
							if(ocean.isOccupied(i, column) || ocean.isOccupied(i, column - 1)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
					else{
						for(int i = row - 1; i < row + getLength(); i++){
							if(ocean.isOccupied(i, column) || ocean.isOccupied(i, column - 1) || ocean.isOccupied(i, column + 1)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
				
				}
				else{
					if(column == 0){
						for(int i = row - 1; i < row + getLength() + 1; i++){
							if(ocean.isOccupied(i, column) || ocean.isOccupied(i, column + 1)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
					else if(column == 9){
						for(int i = row - 1; i < row + getLength() + 1; i++){
							if(ocean.isOccupied(i, column) || ocean.isOccupied(i, column - 1)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
					else{
						for(int i = row - 1; i < row + getLength() + 1; i++){
							if(ocean.isOccupied(i, column) || ocean.isOccupied(i, column - 1) || ocean.isOccupied(i, column + 1)){
								return false;
							}
							else{
								continue;
							}
						}
						return true;
					}
				}
			}
		}
	}

	/**
	 * place the ship at the specific area of the ocean
	 * @param row - the row number of the bow
	 * @param column - the column number of the bow
	 * @param horizontal - set if the ship would be placed horizontally
	 * @param ocean - the ocean that the ship would be placed on
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		setBowRow(row);
		setBowColumn(column);
		setHorizontal(horizontal);
		if(horizontal){
			for(int j = column; j < column + getLength(); j++){
				ocean.ships[row][j] = this;
			}
		}
		else{
			for(int i = row; i < row + getLength(); i++){
				ocean.ships[i][column] = this;
			}
		}
	}

	/**
	 * helper method for shootAt method, check if the square checked occupied by this ship
	 * @param row - the row number of the square checked
	 * @param column - the column number of the square checked
	 * @return true if occupied by this ship; otherwise, return false.
	 */
	boolean isOccupied(int row, int column){
		if(row == bowRow && column >= bowColumn){
			if(column - bowColumn < getLength()){
				return true;
			}
			else{
				return false;
			}
		}
		else if(column == bowColumn && row >= bowRow){
			if(row - bowRow < getLength()){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	/**
	 * check if this ship occupies the squared specified, then check if the ship is sunk
	 * if not sunk, return true and the corresponding element of hit array becomes true;
	 * otherwise, return false
	 * @param row - the row number of the square checked
	 * @param column - the column number of the square checked
	 * @return - if the ship is successfully hit
	 */
	boolean shootAt(int row, int column){
		if(isOccupied(row, column)){
			if(isSunk()){
				return false;
			}
			else{
				if(horizontal){
					hit[column - this.getBowColumn()] = true;
				}
				else{
					hit[row - this.getBowRow()] = true;
				}
				return true;
			}
		}
		else{
			return false;
		}	
	}

	boolean isSunk(){
		for(boolean impact : hit){
			if(impact){
				continue;
			}
			else{
				return false;
			}
		}
		return true;
	}

	/**
	 * if ship is sunk, return x;
	 * otherwise, return S.
	 */
	@Override
	public String toString(){
		if(isSunk()){
			return "x";
		}
		else{
			return "S";
		}
	}

}
