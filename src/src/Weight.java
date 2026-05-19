public class Weight extends Workout
{
    private int duration; // in minutes
    private int sets; // number of sets
    private int reps; // number of reps per set


    public Weight(int duration, int sets, int reps, int avgHeartRate, int caloriesBurned)
    {
        super(avgHeartRate, caloriesBurned);

        if (duration <= 0 || sets <= 0 || reps <= 0) {
            throw new IllegalArgumentException("Duration, sets, and reps must be positive integers.");
        }
        this.duration = duration;
        this.sets = sets;
        this.reps = reps;
    }



    // Weights — intensity comes from volume (sets × reps) relative to duration
    public int heartRate(int duration, int sets, int reps) {
        if (duration == 0) return 65;
        double volumePerMin = (double)(sets * reps) / duration;

        int restingHR = 65, maxHR = 185;
        double intensity = Math.min(volumePerMin / 4.0, 1.0);
        int hr = (int)(restingHR + intensity * (maxHR - restingHR));
        setAvgHeartRate(hr);
        return Math.min(Math.max(hr, restingHR), maxHR);
    }

    public void weightsWorkout(int duration, int sets, int reps)
    {
        this.duration = duration;
        this.sets = sets;
        this.reps = reps;
    }

    public void setSets(int sets)
    {
        this.sets = sets;
    }

    public void setReps(int reps)
    {
        this.reps = reps;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }

    public int getSets()
    {
        return sets;
    }

    public int getReps()
    {
        return reps;
    }

    public String toString()
    {
        return "Weights{" +
                "duration=" + duration +
                ", sets=" + sets +
                ", reps=" + reps +
                ", avgHeartRate=" + getAvgHeartRate() +
                ", caloriesBurned=" + getCaloriesBurned() +
                '}';
    }
    @Override
    public boolean equals(Object other)
    {
        return super.equals(other);
    }
    public int calculateCalories()
    {
        int calories = duration * 3; // Example calories burned
        setCaloriesBurned(calories);
        return calories;
    }
}
