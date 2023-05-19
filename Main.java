public class Main{
    public static void main(String[] args) {
        InputThread inputScanner = new InputThread();
        inputScanner.start();

        Snake s = new Snake();

        int answer = 3;
        int[][] battlefield = new int[15][17];
        int[] score = new int[]{(int)(Math.random() * 14), (int)(Math.random() * 16)};

        boolean game = true;

        while (game){
            battlefield[s.snake[0][0]][s.snake[0][1]] = 0;

            if(inputScanner.hasInput()) {
                answer = Integer.parseInt(inputScanner.getInput());
            }

            if(answer != 1 && answer != 2 && answer != 3 && answer != 5){
                game = false;
            }else {
                s.move(answer);
            }

            if(s.snake[s.length - 1][0] == score[0] && s.snake[s.length - 1][1] == score[1]){
                s.addLength();
                battlefield[score[0]][score[1]] = 1;
                score = null;
            }

            if(score == null){
                do {
                    score = new int[]{(int) (Math.random() * 14), (int) (Math.random() * 16)};
                } while (battlefield[score[0]][score[1]] == 1);
            }

            battlefield[score[0]][score[1]] = 2;

            for(int[] i: s.snake){
                try{
                    battlefield[i[0]][i[1]] = 1;
                }catch (ArrayIndexOutOfBoundsException e){
                    game = false;
                }
            }

            System.out.println("###################");
            for(int [] i: battlefield){
                System.out.print("#");
                for(int j: i){
                    System.out.print((j == 0) ? ' ' : (j == 1) ? '#' : '*');
                }
                System.out.print("#");
                System.out.println();
            }
            System.out.println("###################");

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for(int i=0; i<10; i++) System.out.println("\n\n\n\n\n\n\n\n\n\n");
        }

        System.out.println("Вы проиграли!");
        return;
    }
}