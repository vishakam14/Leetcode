package leastCost;

public class bestPath {

public static void main(String[] args) {
int[][] arrMatrix = { { 1, 0, 0, 0, 0, 0 }, { 5, 4, -1, 3, 2, -1 }, { 5, 2, 1, 3, -1, -1 }, { 5, 2, 1, 3, 0, 1 } };
String path = Integer.toString(arrMatrix[0][0]);	
int row = 0;
int col = 0;
int visited[][] = new int[arrMatrix.length][arrMatrix[0].length];
visited[0][0] = arrMatrix[0][0];	
while (true)
{
    int down = row < arrMatrix.length - 1 ? arrMatrix[row + 1][ col] : arrMatrix[row][ col];
    int right = col < arrMatrix[0].length - 1 ? arrMatrix[row][ col + 1] : arrMatrix[row][col];
    if (row == arrMatrix.length - 1 && col == arrMatrix[0].length - 1)
        break;

    else if (down == -1 && right == -1)
    {
        arrMatrix[row][ col] = 9999;
        arrMatrix[row - 1][col] = 9999;
        row = row != 0 ? --row : arrMatrix.length - 1;
        col = col != 0 ? --col : arrMatrix[0].length - 1;
    }
        
     // Check if tuple below current column != -1 when it's the last column
        else if (down == -1 && col < arrMatrix[0].length - 1)
        { 
        	visited[row][col + 1] = right;
        	path+=right;
        	++col;
        	}

        else if (down == -1 && col == arrMatrix[0].length - 1)
        {
        	arrMatrix[row][col] = 9999; 
        	--col; 
        	}

        // Check if tuple beside current row != -1 when it's the last row
        else if (right == -1 && row < arrMatrix.length - 1)
        { 
        	visited[row + 1][ col] = down; 
        	path+=down;
        	++row; 
        	}

        else if (right == -1 && row == arrMatrix.length - 1)
        { 
        	arrMatrix[row][col] = 9999; 
        	--row; 
        	}

        // Check if down value is lesser than right value and the down value != -1
        else if (down < right && down != -1 && row < arrMatrix.length - 1)
        { 
        	visited[row + 1][col] = down; 
        	path+=down;
        	++row;
        	}
        
        else if (right < down && right != -1 && col < arrMatrix[0].length)
        { 
        	visited[row][col + 1] = right; 
        	path+=right;
        	++col;
        	}

        // Check if right value != -1 when it's the last row
        else if (row == arrMatrix.length - 1 && right != -1)
        {
        	visited[row][col + 1] = right; 
        	path+=right;
        	++col; 
        	}

        // Check if down value != -1 when it's the last column
        else if (col == arrMatrix[0].length - 1 && down != -1)
        { 
        	visited[row + 1][col] = down; 
        	path+=down;
        	++row;
        	}
    }
for(int i = 0; i<visited.length; i++)
{
    for(int j = 0; j<visited[0].length; j++)
    {
        System.out.print(visited[i][j]);
    }
    System.out.println();
}

System.out.println(path);	
	}
}
