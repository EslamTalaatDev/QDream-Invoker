package com.dev.data.realm

  import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class RealmModel(
    @PrimaryKey open var _ID: Long = 0,
    open var name: String = ""
)

    : RealmObject() {}


// when using array

//@RealmClass
//open class RealmModel(
//        @PrimaryKey open var _ID: Long = 0,
//        open var product_id: String = "",
//
//        open var array: RealmList<ArrayRealmModel>? = RealmList())
//        : RealmObject() {
//}