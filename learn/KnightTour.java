public class KnightTour
{
    private static final int N = 9;
    private int soln[][];
 
    public KnightTour()
    {
        soln = new int[N][N];
    }
    
    private boolean isSafe(int x, int y)
    {
        if (x >= 0 && x < N && y >= 0 && y < N && soln[x][y] == -1)
            return true;
        return false;
    }
    
    private void printSolution()
    { 
        System.out.print("     ");
        for (int i = 1; i <= 8; i++)
        {
         System.out.printf("%5d", i);
        }
        System.out.println();
        System.out.println();
        for (int x = 1; x < N; x++)
        {
            System.out.printf("%5d", x);
            for (int y = 1; y < N; y++)
            {
                System.out.printf("%5d", soln[x][y]);
            }
            System.out.println();
        }
    }
 
    private boolean solveKTUtil(int x, int y, int movei, int xMove[],int yMove[])
    {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;
 
        for (k = 0; k < N; k++)
        {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y))
            {
                soln[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, xMove, yMove))
                    return true;
                else
                    soln[next_x][next_y] = -1;
            }
        }
        return false;
    }
 
    public int solveKnightTour()
    {
        for (int x = 0; x < N; x++)
        {
            for (int y = 0; y < N; y++)
            {
                soln[x][y] = 0;
            }
        }
        int xMove[] = { 0, 1, 2, 2, 1, -1, -2, -2, -1 };
        int yMove[] = { 0, -2, -1, 1, 2, 2, 1, -1, -2 };
        int row = 1;
        int col = 1;
        int count = 1;
        int count_repeat = 0;
        int save_row;
        int save_col;
        int moveNumber;                             
        boolean gameover = false;
        soln[1][1] = 1;
        while (gameover == false) 
        {
            moveNumber = (int) Math.ceil(Math.random() * 8);
            //System.out.println("moveNumber= " + moveNumber);
            save_row = row;
            save_col = col;
            row = row + yMove[moveNumber];
            col = col + xMove[moveNumber];
            //System.out.print("row " + row + " col " + col);
            if (row > 0 && row < 9 && col > 0 && col < 9)
                {
                
                    if (soln[row][col] == 0) 
                    {
                        count++; 
                        soln[row][col] = count;
                        System.out.println("row =" + row + " col =" + col + " count =" + count);
                        count_repeat = 0;
                        save_row = row;                       
                        save_col = col;
                    }
           
                    else
                    {
                        row = save_row;
                        col = save_col; 
                        count_repeat++;
                        System.out.println("count_repeat =" + count_repeat);
                        if (count_repeat == 30) 
                        {                         
                            gameover = true;
                            return count; 
                        }
                    }
                }
            else
            {  
               row = save_row;
               col = save_col;
            }
        }
        return 0;
        
    }
    public static void main(String[] arg)
    {   
        int number;
        KnightTour knightTour = new KnightTour();
        System.out.println("the solution is");
        knightTour.solveKnightTour();
        number = knightTour.solveKnightTour();
        knightTour.printSolution();
        System.out.println( " " );
        System.out.println( number + " squares were visited.");        
    }
}
 

       