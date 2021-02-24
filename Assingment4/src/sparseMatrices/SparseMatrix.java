package sparseMatrices;

public final class SparseMatrix {
	
	private final Integer [][] sparseMatrix;
	private final int nonZeroCount;
	private final int rows;
	private final int columns;
	
	public SparseMatrix(int count,Integer [][] matrix){
		
		this.sparseMatrix = new Integer[count][3];
		this.nonZeroCount = count;
		int rows = matrix.length;
		this.rows = rows;
		
		if(rows != 0){
			int cols = matrix[0].length;
			this.columns = cols;
			int k = 0;
			for(int i=0; i < rows; i++){
				for(int j = 0; j < cols; j++){
					if(matrix[i][j] != 0){
						sparseMatrix[k][0] = i;
						sparseMatrix[k][1] = j;
						sparseMatrix[k][2] = matrix[i][j];
						k++;
					}
				}
			}
		}
		else{
			this.columns = 0;
			System.out.println("Empty matrix!!");
		}
	}
	
	public int getRows(){
		return this.rows;
	}
	public int getCols(){
		return this.columns;
	}
	public Integer[][] getSparseMatrix(){
		return this.sparseMatrix;
	}
	
	private static Integer[][] formMatrix(Integer[][] sparseMatrix ,int rows, int cols){
		
		int count = sparseMatrix.length;
		
		Integer [][] matrix = null;
		
		if(rows > 0 && cols > 0){
			matrix = new Integer[rows][cols];

			for(int i=0; i < rows; i++){
				for(int j=0; j < cols; j++){
					matrix[i][j] = 0;
				}
			}
		
			for(int i=0; i < count; i++){
				
				int r = sparseMatrix[i][0];
				int c = sparseMatrix[i][1];
				int value = sparseMatrix[i][2];
			
				matrix[r][c] = value;
			}
		}
		
		return matrix;
		
	}
	
	public Integer [][] transpose(){
		
		Integer [][] transposeMatrix = null;
		if(this.rows == this.columns){
			transposeMatrix = new Integer[this.nonZeroCount][3];
			for(int i=0;i<this.nonZeroCount; i++){
				transposeMatrix[i][0] = this.sparseMatrix[i][1];
				transposeMatrix[i][1] = this.sparseMatrix[i][0];
				transposeMatrix[i][2] = this.sparseMatrix[i][2];
			}
		}
		
		return transposeMatrix;
	}
	public boolean isSymmetrical(){
		
		Integer[][] transposeMatrix = SparseMatrix.formMatrix(this.transpose(), this.rows, this.columns);
		Integer[][] matrix = SparseMatrix.formMatrix(this.getSparseMatrix(),this.rows, this.columns);
		
		if(transposeMatrix != null && matrix != null){
			for(int i = 0; i < this.rows; i++){
				for(int j=0 ; j < this.columns; j++){
					if(transposeMatrix[i][j] != matrix[i][j]){
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public static Integer[][] addMatrix(Integer[][] m1,Integer[][] m2){
		
		Integer[][] result = null;
		
		if(m1 != null && m2 != null){
			
			int r1 = m1.length;
			int c1 = m1[0].length;
			int r2 = m2.length;
			int c2 = m2[0].length;
			
			if(r1 == r2 && c1 == c2){
				result = new Integer[r1][c1];
				for(int i = 0; i < m1.length; i++){
					for(int j = 0;j < m1[0].length; j++){
						result[i][j] = m1[i][j] + m2[i][j];
					}
				}
			}
		}
		return result;
	}
	public static Integer[][] multiplyMatrix(Integer[][] m1,Integer[][] m2){
		
		
		Integer[][] result = null;
		if(m1 != null && m2 != null){
			int r1 = m1.length;
			int c1 = m1[0].length;
			int r2 = m2.length;
			int c2 = m2[0].length;
			if(c1 == r2){
				result = new Integer[r1][c2];		
				for(int i = 0; i < r1; i++){    
					for(int j = 0;j < c2; j++){
						result[i][j]=0;      
						for(int k = 0; k < r2; k++){      
							result[i][j]+= m1[i][k]*m2[k][j];      
						}	  
					}
				}
			}
		}
		return result;
	}
	public static void main(String [] args){
		Integer sparseMatrix[][]
                = {
                    {0, 0, 3, 0, 4},
                    {0, 0, 5, 7, 0},
                    {0, 0, 0, 0, 0},
                    {0, 2, 6, 0, 0}
                };
		SparseMatrix m = new SparseMatrix(6,sparseMatrix);
		Integer[][] transpose = m.transpose();
				
	}

}
