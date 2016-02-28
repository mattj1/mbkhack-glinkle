package com.mbkhack.glinkle;

import com.mbkhack.glinkle.model.Charity;

import java.util.ArrayList;
import java.util.List;

public class CharityManager {

    List<Charity> charityList;

    public CharityManager() {
        charityList = new ArrayList<>(5);

        charityList.add(new Charity("Alameda Food Bank", "Alameda County Community Food Bank has been in business since 1985.", "file:///android_asset/header_photo_1.jpg"));
        charityList.add(new Charity("Red Cross", "The American Red Cross exists to provide compassionate care.", "file:///android_asset/header_photo_2.jpg"));
        charityList.add(new Charity("A Home Away for Homelessness", "Every child deserves  safe and supportive spaces.", "file:///android_asset/header_photo_3.jpg"));
        charityList.add(new Charity("Martha’s Kitchen", "", "file:///android_asset/header_photo_4.jpg"));
    }

    public List<Charity> getCharityList() {
        return charityList;
    }
}
