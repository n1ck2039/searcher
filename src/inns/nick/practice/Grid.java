package inns.nick.practice;

/**
 * Created by Nick.Inns on 06/08/2016.
 */
public class Grid {

    char[][] theArray = {
            {'b', 'a', 'n', 'a', 'n', 'a', 'a', 'n', 'a', 'b'},
            {'b', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'a'},
            {'a', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'n'},
            {'n', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'a'},
            {'a', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'n'},
            {'n', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'a'},
            {'a', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z'},
            {'h', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z'},
            {'i', 'a', 'n', 'a', 'n', 'a', 'z', 'z', 'z', 'z'},
            {'j', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z'}};

    char[] target = {'b', 'a', 'n', 'a', 'n', 'a'};

    public void displayContents(){
        for (int i =0; i < 10; i++ ){
            for (int j = 0; j < 10; j++ ){
                System.out.print(this.theArray[i][j]);
                if (j == 9) {
                    System.out.print('\n');
                }
                else {
                    System.out.print(' ');
                }
            }
        }
    }

    private int searchForHitsByRow(){
        int tMarker = 0;  // points to the target we are looking for
        int totalHits = 0;
        for (int row = 0; row < 10; row ++) {
            for (int column = 0; column < 10; column++) {
                if (this.theArray[row][column] == target[tMarker]) {
                    tMarker++;
                    if (tMarker == (target.length - 1)) {
                        System.out.println("String found in line " + row);
                        totalHits++;
                        tMarker = 0;
                    }
                }
                else {
                    if (tMarker > 0) {
                        tMarker = 0;
                        column--;
                    }
                }
            }
        }
        return (totalHits);
        }

    private int searchForHitsByCol(){
        int tMarker = 0;
        int totalHits = 0;
        for (int column = 0; column < 10; column ++) {
            for (int row = 0; row < 10; row++) {
                if (this.theArray[row][column] == target[tMarker]) {
                    tMarker++;
                    if (tMarker == (target.length - 1)) {
                        System.out.println("String found in column " + column);
                        totalHits++;
                        tMarker = 0;
                    }
                }
                else {
                    if (tMarker > 0) {
                        tMarker = 0;
                        row--;
                    }
                }
            }
        }
        return (totalHits);
    }

    public int searchForHits(){
        int rowHits = 0;
        int colHits = 0;
        rowHits = searchForHitsByRow();
        colHits = searchForHitsByCol();
        return (rowHits + colHits);
    }
}

