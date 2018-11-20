//You are supposed to add your comments

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point
{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + (x+1) + ", " + (y+1) + "]";
    }
}

class PointsAndScores
{
    int score;
    Point point;

    PointsAndScores(int score, Point point)
    {
        this.score = score;
        this.point = point;
    }
}

class Board { 
    int size =5;
    List<Point> availablePoints;
    Scanner scan = new Scanner(System.in);
    int[][] board = new int[5][5];

    public Board()
    {
    }

    public boolean isGameOver()
    {
        return (hasXWon() || hasOWon() || getAvailablePoints().isEmpty());
    }

    public double heuristicMethodRow()

    {
        double scores=0;

        for (int i = 0; i < size; ++i)
        {
            ArrayList Line = new ArrayList();
            for (int j = 0; j < size; ++j)
            {

                if (board[i][j]==1)
                {
                    //X
                    Line.add(1);
                }

                else if (board[i][j]==2)
                {
                    Line.add(2);
                }


            }
            if (Line.contains(1)&&(!Line.contains(2)))
            {
                scores = scores + Math.pow(10,Line.size());
            }
            if (!(Line.contains(1))&&(Line.contains(2)))
            {
                scores = scores - Math.pow(10,Line.size());
            }


        }


            return scores;
    }


    public double heuristicMethodCol()

    {
        double scores=0;

        for (int i = 0; i < size; ++i)
        {
            ArrayList Line = new ArrayList();
            for (int j = 0; j < size; ++j)
            {

                if (board[j][i]==1)
                {
                    //X
                    Line.add(1);
                }

                else if (board[j][i]==2)
                {
                    Line.add(2);
                }


            }
            if (Line.contains(1)&&(!Line.contains(2)))
            {
                scores = scores + Math.pow(10,Line.size());
            }
            if (!(Line.contains(1))&&(Line.contains(2)))
            {
                scores = scores - Math.pow(10,Line.size());
            }


        }


        return scores;
    }

    public double heuristicMethodDiag()

    {
        double scores=0;
        ArrayList Line = new ArrayList();
        for 



            if (Line.contains(1)&&(!Line.contains(2)))
            {
                scores = scores + Math.pow(10,Line.size());
            }
            if (!(Line.contains(1))&&(Line.contains(2)))
            {
                scores = scores - Math.pow(10,Line.size());
            }


        }


        return scores;
    }


    public boolean hasXWon() {
        if ((   board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == board[3][3] &&
                board[0][0] == board[4][4] &&
                board[0][0] == 1)

                ||

                (board[0][4] == board[1][3] &&
                board[0][4] == board[2][2] &&
                board[0][4] == board[3][1] &&
                board[0][4] == board[4][0] &&
                board[0][4] == 1))
        {
            return true;
        }

        for (int i = 0; i < size; ++i) {
            if (((
                    //
                    board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2] &&
                    board[i][0] == board[i][3] &&
                    board[i][0] == board[i][4] &&
                    board[i][0] == 1)
                    ||
                    (
                    board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i] &&
                    board[0][i] == board[3][i] &&
                    board[0][i] == board[4][i] &&
                    board[0][i] == 1)))
            {
                return true;
            }
        }
        return false;
    }

    public boolean hasOWon() {
        if (((
                board[0][0] == board[1][1] &&
                board[0][0] == board[2][2] &&
                board[0][0] == board[3][3] &&
                board[0][0] == board[4][4] &&
                board[0][0] == 2)

                ||
                (
                        board[0][4] == board[1][3] &&
                        board[0][4] == board[2][2] &&
                        board[0][4] == board[3][1] &&
                        board[0][4] == board[4][0] &&
                        board[0][4] == 2)))
        {
             return true;
        }
        for (int i = 0; i < size; ++i)
        {
        if    (((board[i][0] == board[i][1]) && (board[i][0] == board[i][2]) && (board[i][0] == board[i][3]) && (board[i][0] == board[i][4]) && (board[i][0] == 2)) ||
                    ((board[0][i] == board[1][i]) && (board[0][i] == board[2][i]) && (board[0][i] == board[3][i]) && (board[0][i] == board[4][i]) && (board[0][i] == 2)))
            {
                return true;
            }
        }
        return false;
    }

    public List<Point> getAvailablePoints() {
        availablePoints = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }
    
    public int getState(Point point){
    	return board[point.x][point.y];
    }

    public void placeAMove(Point point, int player) {
        board[point.x][point.y] = player;   
    }


    public void displayBoard() {
        System.out.println();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
 		if (board[i][j]==1)           
                    System.out.print("X ");
                else if (board[i][j]==2)
                    System.out.print("O ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
}
