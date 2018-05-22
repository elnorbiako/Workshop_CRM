package pl.workshop.crmworkshop.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean ifActive;

    private int sort;


}



