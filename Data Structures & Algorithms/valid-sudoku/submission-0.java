class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        List<Set<Character>> columns = new ArrayList<>();
        List<Set<Character>> squares = new ArrayList<>();

        for(int i = 0; i < 9; i++) columns.add(new HashSet<Character>());
        for(int i = 0; i < 3; i++) squares.add(new HashSet<Character>());


        for(int i = 0; i < 9; i++){
            row.clear();
            if(i%3 == 0) for(Set<Character> s : squares) s.clear();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!row.add(board[i][j])) return false;
                    if(!columns.get(j).add(board[i][j])) return false;
                    if(!squares.get(j/3).add(board[i][j])) return false;
                }
            }
        }

        return true;
    }

}
