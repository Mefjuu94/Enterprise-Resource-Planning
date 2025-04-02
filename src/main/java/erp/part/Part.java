package erp.part;

import jakarta.persistence.*;

import java.time.Duration;

@Entity
public class Part {

    @Id
    @GeneratedValue
    private long Id;

    private String name;
    private int WLK;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partSetId")
    private PartSet partSet;

    @Lob
    private byte[] pdf;

    @Lob
    private byte[] jpg;

    private Duration duration;

}
