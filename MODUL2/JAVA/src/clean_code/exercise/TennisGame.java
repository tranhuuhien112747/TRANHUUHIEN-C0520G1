package clean_code.exercise;

public class TennisGame {
    public static String getScore(String firstPlayerName, String secondPlayerName, int firstPlayerScore, int secondPlayerScore) {
        String displayScore  = "";
        int tempScore;
        if (firstPlayerScore == secondPlayerScore) {
            switch (firstPlayerScore) {
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
        } else {
            boolean scoreOverFour = firstPlayerScore >= 4 || secondPlayerScore >= 4;
            if (scoreOverFour) {
                int minusResult = firstPlayerScore - secondPlayerScore;
                if (minusResult == 1) displayScore  = "Advantage player1";
                else if (minusResult == -1) displayScore  = "Advantage player2";
                else if (minusResult >= 2) displayScore  = "Win for player1";
                else displayScore  = "Win for player2";
            } else {
                for (int i = 1; i < 3; i++) {
                    if (i == 1) tempScore = firstPlayerScore;
                    else {
                        displayScore  += "-";
                        tempScore = secondPlayerScore;
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
        }
        return displayScore ;
    }
}
