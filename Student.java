public class Student extends Person{
    private String ID;
    private int koreanScore;
    private int englishScore;
    private int mathScore;
    private int totalScore;
    private Double averageScore;
    public Student(String name, String ID) {
        super(name);
        this.ID = ID;
    }

    public int getKoreanScore() {
        return koreanScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setKoreanScore(int koreanScore) {
        this.koreanScore = koreanScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }
    public void countScore(){
        this.totalScore = koreanScore+englishScore+mathScore;
        this.averageScore = ((double)this.totalScore)/3;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public String getID() {
        return ID;
    }
}
