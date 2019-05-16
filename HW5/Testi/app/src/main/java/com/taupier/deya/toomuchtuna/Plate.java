package com.taupier.deya.toomuchtuna;

import android.content.Context;

public class Plate {

    private String scoopType;
    private int scoopCap;
    private String plate;
    private String scoopsPlated;

    /**
     * Constructor for a plate of something.
     * @param scoopQty
     * @param eatQty
     * @param scoopType
     */
    public Plate(String scoopQty, String eatQty, String scoopType) {
        setScoopType(scoopType);
        setScoopCap(R.string.default_cap);
        plateScoops(scoopQty, eatQty);
    }

    /**
     * Empty constructor for an empty plate.
     */
    public Plate() {
        new Plate(null, null, null);
    }

    /**
     * Constructor for test purposes.
     * @param context
     */
    Plate(Context context) {
        setScoopCap(Integer.parseInt(context.getString(R.string.default_cap)));
        setScoopType(context.getString(R.string.default_type));
        plateScoops(context.getString(R.string.default_scoop_qty),
                context.getString(R.string.default_eat_qty));
    }

    /**
     * If there are scoops and bites, eats and checks if there's still too much tuna.
     * Otherwise, complains.
     * @param scoopQty
     * @param eatQty
     * @throws NumberFormatException
     */
    private void plateScoops(String scoopQty, String eatQty) throws NumberFormatException {
        int scoops;
        int bites;
        if (isInteger(scoopQty) && isInteger(eatQty)) {
            scoops = Integer.parseInt(scoopQty);
            bites = Integer.parseInt(eatQty);
            if (scoops > 0 && bites > 0) {
                eat(scoops, bites);
                if (checkTooMuchTuna(getScoopsPlated(), getScoopCap())) {
                    setPlate("TOO MUCH TUNA!!!!!!");
                } else {
                    setPlate(getScoopsPlated() + " " +
                            getScoopType().toLowerCase() + " on the plate.");
                }
            } else setPlate("Are we out of tuna?");
        } else setPlate("We needed non-zero numbers here!!!");
    }

    /**
     * Runs a check on whether there are more scoops than allowed on plate.
     * @param scoopsPlated
     * @param scoopCap
     * @return
     */
    private boolean checkTooMuchTuna(String scoopsPlated, int scoopCap) {
        if (Integer.parseInt(scoopsPlated) > scoopCap) return true;
        else return false;
    }

    void eat(int scoops, int bites) {
            int scooped = scoops - bites;
            setScoopsPlated(scooped);
    }

    boolean isInteger(String s) {
        for (int a = 0 ; a < s.length(); a ++) {
            if( a == 0 && s.charAt(a) == '-') continue;
            if( !Character.isDigit(s.charAt(a)) ) return false;
        }
        return true;
    }

    public String getScoopType() {
        return scoopType;
    }

    public void setScoopType(String scoopType) {
        this.scoopType = scoopType;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getScoopsPlated() {
        return scoopsPlated;
    }

    public void setScoopsPlated(int scoops) {
        this.scoopsPlated = String.valueOf(scoops);
    }

    public int getScoopCap() {
        return scoopCap;
    }

    public void setScoopCap(int scoopCap) {
        this.scoopCap = scoopCap;
    }
}
