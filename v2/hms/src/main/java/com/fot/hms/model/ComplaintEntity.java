package com.fot.hms.model;
import jakarta.persistence.*;

import java.io.Serializable;

import java.util.Date;

@Entity
public class ComplaintEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private int complaintId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_index")
    private String userIndex;

    @Column(name = "complaint", columnDefinition = "TEXT", length = 2000)
    private String complaint;

    @Column(name = "res_id")
    private int resId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "complaint_date")
    private Date complaintDate;

    @Column(name = "evidence_image")
    private String evidenceImage;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name = "user_index", referencedColumnName = "index_no", insertable = false, updatable = false)
    private UsersEntity userByIndex;

    @ManyToOne
    @JoinColumn(name = "res_id", referencedColumnName = "res_id", insertable = false, updatable = false)
    private ResourceEntity resource;

}
