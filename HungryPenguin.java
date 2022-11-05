public class HungryPenguin{
    //Visited is a constant to check if terrain is already seen or not
    public static int Visited = 5;
    public static int Shark = 3;
    //These three constants are used to implement vectors for different types of movements
    public static int[][] LandVecs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int[][] IceVecs = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    public static int[][] WaterVecs = {{3, 3}, {-3, 3}, {3, -3}, {-3, -3}};

    //This void method prints the world by switch conditions
    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
       for (int i = 0; i < world.length; i++) {
        for (int j = 0; j < world[0].length; j++)  {
            if(j != 0)
                System.out.print("\t");
            switch (world[i][j]) {
                case 0:
                    System.out.print("L");
                    break;
                case 1:
                    System.out.print("I");
                    break;
                case 2:
                    System.out.print("W");
                    break;
                case 3:
                    System.out.print("S");
                    break;
                case 4:
                    System.out.print("F");
                    break;
            }
            if(i == pinguRow && j == pinguColumn)
                System.out.print("(P)");
        }
        System.out.println("");
      }
    }

    //These three methods are used to walk through the terrains by different possibilities of movement and check multiple valid opportunities to stay on some of them
    //With built-in loops code offers us 4 different movements for each type of terrains with the help of the vectors determined above
    public static boolean land(int[][] world, int row, int column) {
        for (int i = 0; i < 4; i++) 
            if (row + LandVecs[i][0] < world.length && row + LandVecs[i][0] >= 0 && column + LandVecs[i][1] < world[0].length && column + LandVecs[i][1] >= 0 && world[row + LandVecs[i][0]][column + LandVecs[i][1]] != Shark && world[row + LandVecs[i][0]][column + LandVecs[i][1]] != Visited)
                if (isFishReachable(world, row + LandVecs[i][0], column + LandVecs[i][1]))
                    return true;
        return false;
    }

    public static boolean ice(int[][] world, int row, int column) {
        for (int i = 0; i < 4; i++) 
            if (row + IceVecs[i][0] < world.length && row + IceVecs[i][0] >= 0 && column + IceVecs[i][1] < world[0].length && column + IceVecs[i][1] >= 0 && world[row + IceVecs[i][0]][column + IceVecs[i][1]] != Shark && world[row + IceVecs[i][0]][column + IceVecs[i][1]] != Visited)
                if (isFishReachable(world, row + IceVecs[i][0], column + IceVecs[i][1]))
                    return true;
        return false;
    }

    public static boolean water(int[][] world, int row, int column) {
        for (int i = 0; i < 4; i++) 
            if (row + WaterVecs[i][0] < world.length && row + WaterVecs[i][0] >= 0 && column + WaterVecs[i][1] < world[0].length && column + WaterVecs[i][1] >= 0 && world[row + WaterVecs[i][0]][column + WaterVecs[i][1]] != Shark && world[row + WaterVecs[i][0]][column + WaterVecs[i][1]] != Visited)
                if (isFishReachable(world, row + WaterVecs[i][0], column + WaterVecs[i][1]))
                    return true;
        return false;
    }
    

    //This boolean method is called recursively to reach every element of an array and check whether on the obtained terrain is fish or not
    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn) {
        switch(world[pinguRow][pinguColumn]) {
            case 4:
                return true;
            case 0:
                world[pinguRow][pinguColumn] = Visited;
                return land(world, pinguRow, pinguColumn);
            case 1:
                world[pinguRow][pinguColumn] = Visited;
                return ice(world, pinguRow, pinguColumn);
            case 2:
                world[pinguRow][pinguColumn] = Visited;
                return water(world, pinguRow, pinguColumn);
        }
        return false;
    }

    public static int[][] generateExampleWorldOne(){
        return new int[][] {{2,3,3,3,3,3}, {3,0,3,3,4,3}, {3,3,3,3,3,1}, {3,3,3,0,1,3}, {3,3,3,3,3,3}};
    }

    public static int[][] generateExampleWorldTwo(){
        return new int[][] {{0,0,0,2}, {0,0,0,1}, {0,1,3,4}, {3,4,3,3}};
    }

    public static void main(String[] args){
        int pinguRow = 0;
        int pinguColumn = 0;
        int[][] world = generateExampleWorldOne();
        printWorld(world, pinguRow, pinguColumn);
        System.out.println(""+isFishReachable(world, pinguRow, pinguColumn));
    }
}