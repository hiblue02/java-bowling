package bowling.domain.state;

import bowling.domain.Score;
import bowling.domain.Scores;


public class Strike extends Finished {

    public Strike(Score score) {
        super(Scores.of(score));

        if(!score.isStrike()){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int bonusCount() {
        return 2;
    }

    @Override
    public boolean canGetBonus() {
        return true;
    }

    @Override
    public BowlingRecordState getBowlingState() {
        return BowlingRecordState.STRIKE;
    }

}