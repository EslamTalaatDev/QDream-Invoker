package com.dev.data.realm

import io.realm.Realm
import io.realm.RealmResults

interface RealmInterface {

    fun addOrUpdateDataRealmModel(realm: Realm, data: RealmModel): Boolean
    fun getData(realm: Realm, id: String): RealmModel
    fun deleteData(realm: Realm, data: RealmModel): Boolean
    fun removeLastRealmModel(realm: Realm)
    fun getAllDAta(realm: Realm): RealmResults<RealmModel>
}

