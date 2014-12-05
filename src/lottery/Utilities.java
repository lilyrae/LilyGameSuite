package lottery;

import java.util.ArrayList;

public class Utilities {
	
	public static int[] generateRandomNumb(int randomSize, int range){
		
		int [] randomNumb = new int[randomSize];
		
		for(int i = 0; i < randomSize; i++){
			//generate random numbers
			randomNumb[i] = (int)(Math.random()*range)+1;
		}
		
		return randomNumb;
		//return array
	}
		
	public static int compareArrays(int[] arr1, int[] arr2){
		
		int match = 0;
		
		// go through each element from both arrays and compare
		for(int i = 0; i < 5; i++){
				
			for(int j = 0; j < 5; j++){
		
				if(arr1[i] == arr2[j]){
					match++;
				}	
			}
		}
			
		return match;
	}
	
	//function cannot operate with matrix length = multiple of 100
	public static boolean isWinRowColumn(int [][] matrix, int length) {
		
		int count = 0;
		
		boolean victory = false;
		
		//check through the elements in the columns on matrix[i][j]
		for (int i=0; i<length; i++){
			
			count = 0;
			
			for (int j=0; j<length; j++){
				
				//sum all the matrix elements in a column
				count += matrix[i][j];
			}
			
			// compare sum with expected value for a win from 1 column
			if (count== 100*length){
				victory = true;
			}
			
			if (count == length){
				victory = true;
			}
		}
		
		//check through the elements in the rows
		for (int j=0; j<length; j++){
			
			count = 0;
			
			for (int i=0; i<length; i++){
				
				//sum all the matrix elements in a row
				count += matrix[i][j];
			}
			
			// compare sum with expected value for a win from 1 row
			if (count== 100*length){
				victory = true;
			}
			
			if (count == length){
				victory = true;
			}
		}
		
		return victory;
	}
	
	public static boolean isWinDiagonal(int [][] matrix, int length) {
		
		boolean victory = false;
		
		int count = 0;
		
		for (int i=0; i<length; i++){
			
			//sum all the matrix elements in left to right diagonal
			count += matrix[i][i];
		}
		
		// compare sum with expected value for a win from diagonal
		if (count== 100*length){
			victory = true;
		}
		
		if (count == length){
			victory = true;

		}
		
		count = 0;
		
		for (int i=0; i<length; i++){
			
			int j = length -1 - i;
			
			//sum all the matrix elements in left to right diagonal
			count += matrix[i][j];
		}
		
		// compare sum with expected value for a win from diagonal
		if (count== 100*length){
			victory = true;
		}
		
		if (count == length){
			victory = true;
		}
		
		return victory;
	}
	
	public static int[] defenseStrategy(int length, int[][] matrix){
		
		int[] position = new int[2];
		
		position[0]= -1;
		
		int count;
		
		//check rows for two symbols in a row
		for (int i=0; i<length; i++){
				
			count=0;
			
			for (int j=0; j<length; j++){
						
					//sum all the matrix elements in a column
						count += matrix[i][j];
					}
					
			//if about to lose or about to win
					if (count== 2 || count == 200){
						
						for(int j=0; j<length; j++)
							
							if(matrix[i][j]==0){
								
								position[0]=i;
								position[1]=j;
								
								return position;
							}
					}
				}
				
		//check rows for two symbols in a row
		for (int j=0; j<length; j++){
			
			count=0;
			
			for (int i=0; i<length; i++){
						
				//sum all the matrix elements in a column
				count += matrix[i][j];
			}
					
			//if about to lose or about to win
			if (count== length-1 || count == 100*(length-1)){
				
				for(int i=0; i<length; i++)
							
							if(matrix[i][j]==0){
								
								position[0]=i;
								position[1]=j;

								return position;
							}
					}
				}
		
		count=0;
		
		//check left diagonal for two symbols in a row	
		for (int i=0; i<length; i++){
					
			//sum all the matrix elements in a column
			count += matrix[i][i];
		}
					
		//if about to lose or about to win
		if (count== length-1 || count == 100*(length-1)){
			
			for(int i=0; i<length; i++){
						
				if(matrix[i][i]==0){
							
					position[0]=i;
					position[1]=i;
					
					return position;
				}	
			}
		}
			
		count=0;
		
		//check right diagonal for two symbols in a row
		for (int i=0; i<length; i++){
					
			int j = length -1 - i;
					
			//sum all the matrix elements in left to right diagonal
			count += matrix[i][j];
		}
				
		if (count== length-1 || count == 100*(length-1)){
			
			for (int i=0; i<length; i++){
				
				int j = length -1 - i;
		
				if(matrix[i][j]==0){
					
					position[0]=i;
					position[1]=j;
							
					return position;
				}	
			}
		}
		
		return position;
	}
	
	public static ArrayList<Integer> basicStrategy(int length, int[][] matrix){
		
		int count;
		
		ArrayList<Integer> choices =new ArrayList<Integer>();
		
		//check rows for your sign
		for (int i=0; i<length; i++){
			
			count =0;
					
			for (int j=0; j<length; j++){
						
					//sum all the matrix elements in a column
						count += matrix[i][j];
					}
					
			//if already entered value in this row
					if (count== 100){
						
						for(int j=0; j<length; j++)
							
							if(matrix[i][j]==0){
								
								choices.add(i);
								choices.add(j);
							}
					}
				}
				
		//check columns for your sign
		for (int j=0; j<length; j++){
			
			count=0;
			
			for (int i=0; i<length; i++){
						
				//sum all the matrix elements in a column
				count += matrix[i][j];
			}
					
			//if already entered value in this column
			if (count== 100){
				
				for(int i=0; i<length; i++)
							
							if(matrix[i][j]==0){
								
								choices.add(i);
								choices.add(j);
								
							}
					}
				}
		
		count=0;
		
		//check left diagonal
		for (int i=0; i<length; i++){
					
			count += matrix[i][i];
		}
					
		if (count== 100){
			
			for(int i=0; i<length; i++){
						
				if(matrix[i][i]==0){
							
					choices.add(i);
					choices.add(i);
							
				}	
			}
		}
			
		count=0;
		
		//check right diagonal
		for (int i=0; i<length; i++){
					
			int j = length -1 - i;

			count += matrix[i][j];
		}
		
		if (count== 100){
			
			for (int i=0; i<length; i++){

				int j = length -1 - i;
		
				if(matrix[i][j]==0){
					
					choices.add(i);
					choices.add(j);
				}	
			}
		}
		
		return choices;
	}
	
	public static ArrayList<Integer> findEmptySpaces(int length, int[][] matrix){
		
		ArrayList<Integer> choices =new ArrayList<Integer>();
		
		//check rows for your sign
		for (int i=0; i<length; i++){
					
			for (int j=0; j<length; j++){
						
				if(matrix[i][j]==0){
					
					choices.add(i);
					choices.add(j);
				}
			}
		}

		return choices;
	}
	
	public static ArrayList<Integer> findEmptyCorners(int[][] matrix){
		
		ArrayList<Integer> choices =new ArrayList<Integer>();
		
		int[][] goodChoices = {{0,0},{0,2},{2,0},{2,2}};
		
		for(int i=0; i<4; i++){
			
			//if the corners are empty
			if(matrix[goodChoices[i][0]][goodChoices[i][1]] == 0){
				
				choices.add(goodChoices[i][0]);
				choices.add(goodChoices[i][1]);
				
			}
			
		}
		
		return choices;
		
	}
	
}


