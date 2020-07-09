package clean_code.exercise;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int playerScore1, int playerScore2) {
        String displayScore  = "";
        int tempScore;
        if (playerScore1 == playerScore2) {
            switch (playerScore1) {
                case 0:
                    displayScore  = "Love-All";
                    break;
                case 1:
                    displayScore  = "Fifteen-All";
                    break;
                case 2:
                    displayScore  = "Thirty-All";
                    break;
                case 3:
                    displayScore  = "Forty-All";
                    break;
                default:
                    displayScore  = "Deuce";
                    break;

            }
        } else if (playerScore1 >= 4 || playerScore2 >= 4) {
            int minusResult = playerScore1 - playerScore2;
            if (minusResult == 1) displayScore  = "Advantage player1";
            else if (minusResult == -1) displayScore  = "Advantage player2";
            else if (minusResult >= 2) displayScore  = "Win for player1";
            else displayScore  = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = playerScore1;
                else {
                    displayScore  += "-";
                    tempScore = playerScore2;
                }
                switch (tempScore) {
                    case 0:
                        displayScore  += "Love";
                        break;
                    case 1:
                        displayScore  += "Fifteen";
                        break;
                    case 2:
                        displayScore  += "Thirty";
                        break;
                    case 3:
                        displayScore  += "Forty";
                        break;
                }
            }
        }
        return displayScore ;
    }
}
