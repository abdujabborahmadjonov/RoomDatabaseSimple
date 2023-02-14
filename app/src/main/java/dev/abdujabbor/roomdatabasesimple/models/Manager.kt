package dev.abdujabbor.roomdatabasesimple.models

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Manager {
    @PrimaryKey(autoGenerate = true)
    var id:Int?  = null

    var name:String? = null
    var number:String? = null

    constructor(id: Int?, name: String?, number: String?) {
        this.id = id
        this.name = name
        this.number = number
    }

    constructor(name: String?, number: String?) {
        this.name = name
        this.number = number
    }

    constructor()
}