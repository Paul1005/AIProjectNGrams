public class NGram {
    private int recentHistory;
    private float prob1;
    private float prob2;
    private float prob3;
    private float prob4;
    private float prob5;

    public NGram(int recentHistory){
        this.recentHistory = recentHistory;
        this.prob1 = 0;
        this.prob2 = 0;
        this.prob3 = 0;
        this.prob4 = 0;
        this.prob5 = 0;
    }

    public float getRecentHistory() {
        return recentHistory;
    }

    public void setRecentHistory(int recentHistory) {
        this.recentHistory = recentHistory;
    }

    public float getProb1() {
        return prob1;
    }

    public void setProb1(float prob1) {
        this.prob1 = prob1;
    }

    public float getProb2() {
        return prob2;
    }

    public void setProb2(float prob2) {
        this.prob2 = prob2;
    }

    public float getProb3() {
        return prob3;
    }

    public void setProb3(float prob3) {
        this.prob3 = prob3;
    }

    public float getProb4() {
        return prob4;
    }

    public void setProb4(float prob4) {
        this.prob4 = prob4;
    }

    public float getProb5() {
        return prob5;
    }

    public void setProb5(float prob5) {
        this.prob5 = prob5;
    }
}
