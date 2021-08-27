package com.dev.data.realm

import io.realm.RealmModel
import io.realm.annotations.RealmClass

@RealmClass
open class ArrayRealmModel(
    open var ud: String = "",
    open var name: String = ""
) : RealmModel {

}