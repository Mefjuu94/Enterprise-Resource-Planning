package erp.machines;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class machine {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private long width;
    private long height;
    private long depth;
}
