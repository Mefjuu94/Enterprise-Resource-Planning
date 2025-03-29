package erp.part;

import jakarta.persistence.*;

@Entity
public class part {

    @Id
    @GeneratedValue
    private long Id;

    private String name;
    private int WLK;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partSetId")
    private partSet partSet;

    @Lob
    private byte[] pdf;

}
