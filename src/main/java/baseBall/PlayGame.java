package baseBall;

import java.util.Scanner;

public class PlayGame {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager(new Scanner(System.in));
        gameManager.play();
    }
}
