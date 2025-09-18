package com.quber.todolistexample

import android.content.Context
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

const val FILE_NAME = "todoList.dat"

fun writeData(items: SnapshotStateList<String>, context: Context) {
    val fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
    var oos = ObjectOutputStream(fos)
    val itemList = ArrayList<String>()
    itemList.addAll(items)
    oos.writeObject(itemList)
    oos.close()
}

fun readData(context: Context): SnapshotStateList<String> {
    var itemList: ArrayList<String>
    try {
        val fis = context.openFileInput(FILE_NAME)
        val ois = ObjectInputStream(fis)
        itemList = ois.readObject() as ArrayList<String>
    } catch (e: Exception) {
        itemList = ArrayList()
    }

    val items = SnapshotStateList<String>()
    items.addAll(itemList)
    return items
}