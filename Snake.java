public class Snake {
    int[][] snake = new int[255][3];
    int length = 4;

    {
        snake[3] = new int[]{8, 5, 3};
        snake[2] = new int[]{8, 4, 3};
        snake[1] = new int[]{8, 3, 3};
        snake[0] = new int[]{8, 2, 3};
    }

    public void addLength(){
        for(int i = length++; i > 0; i--){
            snake[i] = snake[i - 1].clone();
        }

        switch (snake[0][2]){
            case 1 -> {
                snake[0] = new int[]{snake[1][0], snake[1][1] + 1, snake[1][2]};
            }

            case 2 -> {
                snake[0] = new int[]{snake[1][0] - 1, snake[1][1], snake[1][2]};
            }

            case 3 -> {
                snake[0] = new int[]{snake[1][0], snake[1][1] - 1, snake[1][2]};
            }

            case 5 -> {
                snake[0] = new int[]{snake[1][0] + 1, snake[1][1], snake[1][2]};
            }
        }
    }

    public void move(int way){
        for(int i = 0; i < length - 1; i++){
            snake[i] = snake[i + 1].clone();
        }

        switch (way){
            case 1 -> {
                snake[length - 1] = new int[]{snake[length - 1][0], snake[length - 1][1] - 1, 1};
                if(snake[length - 1][1] - 1 == 2){
                    addLength();
                }
            }

            case 2 -> {
                snake[length - 1] = new int[]{snake[length - 1][0] + 1, snake[length - 1][1], 2};
                if(snake[length - 1][0] + 1 == 2){
                    addLength();
                }
            }

            case 3 -> {
                snake[length - 1] = new int[]{snake[length - 1][0], snake[length - 1][1] + 1, 1};
                if(snake[length - 1][1] + 1 == 2){
                    addLength();
                }
            }

            case 5 -> {
                snake[length - 1] = new int[]{snake[length - 1][0] - 1, snake[length - 1][1], 2};
                if(snake[length - 1][0] - 1 == 2){
                    addLength();
                }
            }
        }
    }
}
