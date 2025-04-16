package erp.orders;

import erp.customUser.CustomUser;
import erp.machines.Machine;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JobOrder {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine assignedMachine;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private CustomUser createdBy;

    private LocalDateTime createdAt;
    private LocalDateTime scheduledFor;

    private String status; // np. "IN_QUEUE", "IN_PROGRESS", "DONE", "CANCELLED"

    // np. JSON z parametrami technologicznymi
    @Lob
    private String jobData;

    // historia zmian statusu
    @OneToMany(mappedBy = "jobOrder", cascade = CascadeType.ALL)
    private List<JobOrderHistory> history = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // gettery/settery
}
