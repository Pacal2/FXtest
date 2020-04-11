package sample;

public class Comics {

    public Comics(String name, int releaseYear, int issues) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.issues = issues;
    }

    public Comics() {

    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getIssues() {
        return issues;
    }

    public void setIssues(int issues) {
        this.issues = issues;
    }

    private int releaseYear;
    private int issues;


}
