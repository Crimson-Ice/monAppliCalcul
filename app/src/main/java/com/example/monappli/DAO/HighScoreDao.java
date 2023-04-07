package com.example.monappli.DAO;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.monappli.model.entities.HighScore;


public class HighScoreDao extends BaseDao<HighScore> {
    public static String TABLE_NAME = "HIGHSCORE";
    public static String COLUMN_PLAYER_NAME = "PLAYER_NAME";
    public static String COLUMN_SCORE = "SCORE";

    public HighScoreDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected void putValues(ContentValues values, HighScore entity) {
        values.put(COLUMN_PLAYER_NAME, entity.getPlayerName());
        values.put(COLUMN_SCORE, entity.getScore());

    }

    @Override
    protected HighScore getEntity(Cursor cursor) {
        Integer indexColumnCalcul = cursor.getColumnIndex(COLUMN_PLAYER_NAME);
        Integer indexColumnResultat = cursor.getColumnIndex(COLUMN_SCORE);
        if( cursor.getCount()>0){
            HighScore monCalcul = new HighScore(cursor.getString(indexColumnCalcul), cursor.getInt(indexColumnResultat));
            return monCalcul;
        }
        return null;
    }
}