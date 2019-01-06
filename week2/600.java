public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image == null || image.length == 0) {
            return 0;
        }
        
        if (image[0] == null || image[0].length == 0) {
            return 0;
        }
        
        int col = image[0].length - 1, row = image.length - 1;
        
        int top = findTop(image, 0, x);
        int bot = findBot(image, x, row);
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, col);
        System.out.println(top + " " + bot + " " + left + " " + right );
        return (bot - top + 1) * (right - left + 1);
    }
    
    private boolean isEmptyRow(char[][] chars, int loc) {
        for (int i = 0; i < chars[0].length; i++) {
            if (chars[loc][i] == '1') {
                return false;
            }
        }
        return true;
    }
    
    private boolean isEmptyCol(char[][] chars, int loc) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i][loc] == '1') {
                return false;
            }
        }
        return true;
    }
    
    private int findTop(char[][] chars, int x, int y) {
        int top = x, down = y;
        
        while (top + 1 < down) {
            int mid = top + (down - top) / 2;
            if (!isEmptyRow(chars, mid)) {
                down = mid;
            } else {
                top = mid;
            }
        }
        
        if (!isEmptyRow(chars,top)){
            return top;
        }
        return down;
    }
    
    private int findBot(char[][] chars, int x, int y) {
        int top = x, down = y;
        
        while (top + 1 < down) {
            int mid = top + (down - top) / 2;
            if (!isEmptyRow(chars, mid)) {
                top = mid;
            } else {
                down = mid;
            }
        }
        
        if (!isEmptyRow(chars,down)) {
            return down;
        }
        return top;
    }
    
    private int findLeft(char[][] chars, int x, int y) {
        int left = x, right = y;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (!isEmptyCol(chars, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (!isEmptyCol(chars,left)) {
            return left;
        }
        return right;
    }
    
    private int findRight(char[][] chars, int x, int y) {
        int left = x, right = y;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (!isEmptyCol(chars, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (!isEmptyCol(chars,right)) {
            return right;
        }
        return left;
    }
}