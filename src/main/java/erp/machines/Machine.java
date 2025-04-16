package erp.machines;

import erp.orders.JobOrder;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Machine {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "assignedMachine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobOrder> jobOrders = new ArrayList<>();


    //    private List<CustomUser> whoCanUse;
    private boolean isActive;

    private Duration totalWorkTime;

    private Instant startTime;

    public Machine() {
        this.totalWorkTime = Duration.ZERO;
    }

    public void startTask() {
        startTime = Instant.now();
    }


    public void stopTask() {
        if (startTime != null) {
            Instant endTime = Instant.now();
            Duration taskDuration = Duration.between(startTime, endTime);
            totalWorkTime = totalWorkTime.plus(taskDuration);

            long hours = totalWorkTime.toHours();
            long minutes = totalWorkTime.toMinutes() % 60;
            long seconds = totalWorkTime.getSeconds() % 60;

            System.out.printf("Czas pracy maszyny: %d godz. %d min. %d sek.%n", hours, minutes, seconds);
        }
    }

    public Duration getTotalWorkTime() {
        return totalWorkTime;
    }

    public abstract void start();

    public abstract void stop();

    public abstract void performTask();
}



