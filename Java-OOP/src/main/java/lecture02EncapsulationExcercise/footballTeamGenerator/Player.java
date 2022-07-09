package lecture02EncapsulationExcercise.footballTeamGenerator;


public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        if (isValid(endurance, "Endurance")) {
            this.endurance = endurance;
        }
    }

    private void setSprint(int sprint) {
        if (isValid(sprint, "Sprint")) {
            this.sprint = sprint;
        }
    }

    private void setDribble(int dribble) {
        if (isValid(dribble, "Dribble")) {
            this.dribble = dribble;
        }
    }

    private void setPassing(int passing) {
        if (isValid(passing, "Passing")) {
            this.passing = passing;
        }
    }

    private void setShooting(int shooting) {
        if (isValid(shooting, "Shooting")) {
            this.shooting = shooting;
        }
    }

    private boolean isValid(Integer stat, String statName) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }
        return true;
    }

    public double overallSkillLevel() {
        return 1.0 * (endurance + sprint + dribble + passing + shooting) / 5;
    }
}
