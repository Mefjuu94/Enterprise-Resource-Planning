package erp.part;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PartSet {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int WLK;

    @OneToMany(mappedBy = "partSet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Part> Parts;

    @Lob
    private byte[] pdf;

    @Lob
    private byte[] jpg;


}
