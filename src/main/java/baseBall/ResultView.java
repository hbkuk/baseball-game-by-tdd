package baseBall;

public class ResultView {
    public static String result(BallStatusResult ballStatusResult) {
        StringBuilder stringBuilder = new StringBuilder();

        if(ballStatusResult.isThreeStrike()) {
            return stringBuilder.append("All Strike!!!").append("\n").toString();
        }
        if(!ballStatusResult.isZeroStrike()) {
            stringBuilder.append("Strike ").append(ballStatusResult.getStrikeCount()).append("\n");
        }
        if(!ballStatusResult.isZeroBall()) {
            stringBuilder.append("Ball ").append(ballStatusResult.getBallCount()).append("\n");
        }
        if(ballStatusResult.isNothing()) {
            stringBuilder.append("Nothing").append("\n");
        }
        return stringBuilder.toString();
    }
}
