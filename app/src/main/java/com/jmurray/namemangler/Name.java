package com.jmurray.namemangler;

/**
 * Created by Joshua on 10/10/2017.
 */

public class Name {
    private int mNameId;
    private boolean mNameUsed;

    public Name(int nameId, boolean nameUsed) {
        mNameId = nameId;
        mNameUsed = nameUsed;
    }

    public int getNameId() {
        return mNameId;
    }

    public void setNameId(int nameId) {
        mNameId = nameId;
    }

    public boolean isNameUsed() {
        return mNameUsed;
    }

    public void setNameUsed(boolean nameUsed) {
        mNameUsed = nameUsed;
    }
}
