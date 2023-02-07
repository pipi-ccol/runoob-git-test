package com.djht.fourteenth_session.HJK;

import androidx.recyclerview.widget.RecyclerView;

public class itemModel_h{
    private String airName;//空调名称
    private String roomName;//房间名称
    private boolean state;//开机状态

    public itemModel_h(String airName, String roomName) {
        this.airName = airName;
        this.roomName = roomName;
    }

    public itemModel_h() {

    }

    public void setAirName(String airName) {
        this.airName = airName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getAirName() {
        return airName;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isState() {
        return state;
    }

    @Override
    public String toString() {
        return "itemModel_h{" +
                "airName='" + airName + '\'' +
                ", roomName='" + roomName + '\'' +
                ", state=" + state +
                '}';
    }
}
