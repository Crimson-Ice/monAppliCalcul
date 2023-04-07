package com.example.monappli.DAO;

import android.content.Context;

public class HighScoreBaseHelper extends DataBaseHelper {
    public HighScoreBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, dataBaseVersion);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + HighScoreDao.TABLE_NAME + " (" +
                HighScoreDao.COLUMN_PLAYER_NAME + " VARCHAR(32)," +
                HighScoreDao.COLUMN_SCORE + " INTEGER NOT NULL)";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS "+ HighScoreDao.TABLE_NAME;
    }
}