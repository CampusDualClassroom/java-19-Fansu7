package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int intArrayBi[][] = new int[intArrayTri.length][intArrayTri.length];
        for (int i = 0; i < intArrayBi.length; i++) {
            for (int j = 0; j < intArrayBi.length; j++) {
                intArrayBi[i][j] = intArrayTri[0][i][j] + intArrayTri[1][i][j] + intArrayTri[2][i][j];
            }
        }
        return intArrayBi;
    }



    public static String getBidimensionalString(int[][] intArrayBi) {
        String finalString = "";
        for (int i = 0; i < intArrayBi.length; i++) {
            finalString += stringFlatMatrixRow(intArrayBi, i);
            if (intArrayBi.length != i+1){
                finalString += "\n";
            }

        }

        return finalString;
    }

    public static String getUnidimensionalString(int[] uniArray) {
        String arrayToString = "";
        for (int i = 0; i < uniArray.length; i++) {
            arrayToString += (uniArray[i]);
            if (uniArray.length != i+1){
                arrayToString+=" ";
            }
        }
        return arrayToString;
    }

    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] newArray = new int[columns];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = i+1;
        }
        return newArray;
    }

    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] newArray = new int[rows][columns];
        int contador = 1;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                newArray[i][j]= contador++;
            }
        }
        return newArray;
    }

    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] newArray = new int[depth][rows][columns];
        int contador = 1;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                for (int k = 0; k < newArray.length; k++) {
                    newArray[i][j][k] = contador++;
                }
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
