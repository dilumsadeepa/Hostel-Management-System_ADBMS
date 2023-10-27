package com.adms.hms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room_assets", schema = "hms", catalog = "")
public class RoomAssetsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "room_id", nullable = false)
    private int roomId;
    @Basic
    @Column(name = "asset_id", nullable = false)
    private int assetId;
    @Basic
    @Column(name = "no_of_assets", nullable = false)
    private int noOfAssets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public int getNoOfAssets() {
        return noOfAssets;
    }

    public void setNoOfAssets(int noOfAssets) {
        this.noOfAssets = noOfAssets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomAssetsEntity that = (RoomAssetsEntity) o;

        if (id != that.id) return false;
        if (roomId != that.roomId) return false;
        if (assetId != that.assetId) return false;
        if (noOfAssets != that.noOfAssets) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roomId;
        result = 31 * result + assetId;
        result = 31 * result + noOfAssets;
        return result;
    }
}
