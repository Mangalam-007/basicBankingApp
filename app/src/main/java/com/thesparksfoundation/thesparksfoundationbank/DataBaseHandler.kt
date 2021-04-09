//package com.thesparksfoundation.thesparksfoundationbank
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import android.widget.Toast
//import android.widget.Toast.makeText
//
//val DATABASE_NAME = "MyDB"
//val TABLE_NAME = "Users"
//val COL_NAME= "name"
//val COL_AGE = "age"
//val COL_ID="id"
//
//class DataBaseHandler(fragment: AllCustomersFragment ): SQLiteOpenHelper(fragment.requireContext(), DATABASE_NAME, null,1 ) {
//    override fun onCreate(db: SQLiteDatabase?) {
//        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
//                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COL_NAME + " VARCHAR(256)," +
//                COL_AGE + " INTEGER)";
//        db?.execSQL(createTable)
//        var cv = ContentValues()
//        cv.put(COL_NAME, "Gupta")
//        cv.put(COL_AGE, 23)
//        var result1 = db?.insert(TABLE_NAME, null, cv)
//    }
//
//    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
//
//    }
//
//    fun insertData() {
//        val db = this.writableDatabase
//        var cv = ContentValues()
//        cv.put(COL_NAME, "Gupta")
//        cv.put(COL_AGE, 23)
//        var result1 = db.insert(TABLE_NAME, null, cv)
//        cv.put(COL_NAME, "Ishant Gupta")
//        cv.put(COL_AGE, 20)
//        var result = db.insert(TABLE_NAME, null, cv)
//
////        if (result == -1.toLong())
////            Toast.makeText(AllCustomersFragment.require, "Failed", Toast.LENGTH_SHORT).show()
////        else
////            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
//    }
//
//    fun readData(): MutableList<User> {
//        var list: MutableList<User> = ArrayList()
//        val db = this.readableDatabase
//        val query = "Select * from " + TABLE_NAME
//        val result = db.rawQuery(query, null)
//        if (result.moveToFirst()) {
//            do {
//                var user = User()
//                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
//                user.name = result.getString(result.getColumnIndex(COL_NAME))
//                user.age = result.getString(result.getColumnIndex(COL_AGE)).toInt()
//                list.add(user)
//            } while (result.moveToNext())
//        }
//        result.close()
//        db.close()
//        return list
//    }
//    fun deleteData(){
//        val db=this.writableDatabase
//        db.delete(TABLE_NAME,null, null)
//        db.close()
//    }
//
//    fun updateData(){
//        val db = this.writableDatabase
//        val query = "Select * from " + TABLE_NAME
//        val result = db.rawQuery(query, null)
//        if (result.moveToFirst()) {
//            do {
//                var cv= ContentValues()
//                cv.put(COL_AGE,(result.getInt(result.getColumnIndex(COL_AGE))+1))
//                db.update(TABLE_NAME, cv, COL_ID +"=? AND " + COL_NAME
//                        + "+?", arrayOf(result.getString(result.getColumnIndex(COL_ID))))
//            } while (result.moveToNext())
//        }
//        result.close()
//        db.close()
//    }
//
//}