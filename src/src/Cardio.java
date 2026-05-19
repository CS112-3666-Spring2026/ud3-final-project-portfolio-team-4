public class Cardio extends Workout
{
    public Cardio(int duration, int distance, int avgPace, int avgHeartRate, int caloriesBurned)
    {
        super(avgHeartRate, caloriesBurned);

        if (duration <= 0 || distance <= 0) {
            throw new IllegalArgumentException("Duration and distance must be positive.");
        }
        this.duration = duration;
        this.distance = distance;
        this.avgPace = avgPace;
    }

    private int duration;
    private int distance;
    private int avgPace;

    public int heartRate(int duration, int distance) {
        // pace in seconds per mile for finer resolution
        double paceMinPerMile = (distance == 0) ? 10.0 : (double) duration / distance;

        // MET: elite (~5 min/mi) ≈ 18, jog (~10 min/mi) ≈ 8, walk (~20 min/mi) ≈ 3.5
        double met = 600.0 / paceMinPerMile; // rough inverse relationship

        // Estimated HR = resting HR + (MET / maxMET) × HR reserve
        // Using standard defaults: resting=65, max=185
        int restingHR = 65, maxHR = 185;
        int hr = (int)(restingHR + (met / 18.0) * (maxHR - restingHR));

        return Math.min(Math.max(hr, restingHR), maxHR); // clamp to [65, 185]
    }

    public void cardioWorkout(int duration, int distance, int avgPace)
    {
        this.duration = duration;
        this.distance = distance;
        this.avgPace = avgPace;
    }

    public int getDuration()
    {
        return duration;
    }

    public int getDistance()
    {
        return distance;
    }

    public int getAvgPace()
    {
        return avgPace;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    public void setAvgPace(int avgPace, int duration, int distance)
    {
        this.avgPace = calculatePace(duration, distance);
    }

    public int calculatePace(int duration, int distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be greater than zero to calculate pace.");
        } else if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero to calculate pace.");
        } else if (duration < distance) {
            throw new IllegalArgumentException("Duration cannot be less than distance to calculate pace.");
        } else {
            avgPace = duration / distance; // Pace in minutes per mile
            if (avgPace < 3)
            {
                throw new IllegalArgumentException("Pace cannot be less than 3 minutes per mile.");
            }
            return avgPace;
        }
    }

    public int calculateCalories()
    {
        int calories = duration * 10;
        setCaloriesBurned(calories);
        return calories;
    }

    public String toString()
    {
        return "Cardio{" +
                "duration=" + duration +
                ", distance=" + distance +
                ", avgPace=" + avgPace +
                ", avgHeartRate=" + getAvgHeartRate() +
                ", caloriesBurned=" + getCaloriesBurned() +
                '}';
    }

    @Override
    public boolean equals(Object other)
    {
        return super.equals(other);
    }
}
