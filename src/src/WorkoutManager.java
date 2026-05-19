import java.util.ArrayList;
import java.util.List;

public class WorkoutManager {

    private final List<Workout> workouts = new ArrayList<>();

    public void addWorkout(Workout workout) {
        if (workout == null) {
            throw new IllegalArgumentException("Workout cannot be null");
        }
        workouts.add(workout);
    }

    public int getTotalCalories() {
        int sum = 0;
        for (Workout w : workouts) {
            sum += w.getCaloriesBurned();
        }
        return sum;
    }

    public List<Workout> getWorkouts() {
        return new ArrayList<>(workouts);
    }
}
