package com.adms.hms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assets", schema = "hms", catalog = "")
public class AssetsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "assets_category_id", nullable = false)
    private int assetsCategoryId;
    @Basic
    @Column(name = "no_of_assets", nullable = false)
    private int noOfAssets;
    @Basic
    @Column(name = "hostel_id", nullable = false)
    private int hostelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssetsCategoryId() {
        return assetsCategoryId;
    }

    public void setAssetsCategoryId(int assetsCategoryId) {
        this.assetsCategoryId = assetsCategoryId;
    }

    public int getNoOfAssets() {
        return noOfAssets;
    }

    public void setNoOfAssets(int noOfAssets) {
        this.noOfAssets = noOfAssets;
    }

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssetsEntity that = (AssetsEntity) o;

        if (id != that.id) return false;
        if (assetsCategoryId != that.assetsCategoryId) return false;
        if (noOfAssets != that.noOfAssets) return false;
        if (hostelId != that.hostelId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + assetsCategoryId;
        result = 31 * result + noOfAssets;
        result = 31 * result + hostelId;
        return result;
    }
}
