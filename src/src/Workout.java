public abstract class Workout {

    protected int avgHeartRate;
    protected int caloriesBurned;

    public Workout(int avgHeartRate, int caloriesBurned) {
        if (avgHeartRate < 0 || caloriesBurned < 0) {
            throw new IllegalArgumentException("Average heart rate and calories burned must be non-negative integers.");
        }
        this.avgHeartRate = avgHeartRate;
        this.caloriesBurned = caloriesBurned;
    }

    public int getAvgHeartRate() {
        return avgHeartRate;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setAvgHeartRate(int avgHeartRate) {
        if (avgHeartRate < 0) {
            throw new IllegalArgumentException("Average heart rate must be non-negative.");
        }
        this.avgHeartRate = avgHeartRate;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        if (caloriesBurned < 0) {
            throw new IllegalArgumentException("Calories burned must be non-negative.");
        }
        this.caloriesBurned = caloriesBurned;
    }

    public abstract int calculateCalories();

    @Override
    public String toString() {
        return "Workout{" +
                "avgHeartRate=" + avgHeartRate +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}
