package com.dev.data.realm

import io.realm.Realm
import io.realm.RealmResults

class RealmService : RealmInterface {


    override fun getAllDAta(realm: Realm): RealmResults<RealmModel> {
        return realm.where(RealmModel::class.java).findAll()
    }

    override fun addOrUpdateDataRealmModel(realm: Realm, data: RealmModel): Boolean {
        return try {
            realm.beginTransaction()

            realm.copyToRealmOrUpdate(data)
            realm.commitTransaction()
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun getData(realm: Realm, id: String): RealmModel {
        return realm.where(RealmModel::class.java).equalTo("id", id).findFirst()!!
    }

    override fun deleteData(realm: Realm, data: RealmModel): Boolean {
        return try {
            realm.beginTransaction()

            data.deleteFromRealm()
            realm.commitTransaction()
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun removeLastRealmModel(realm: Realm) {
        realm.beginTransaction()
        getLastDataRealmModel(realm).deleteFromRealm()
        realm.commitTransaction()
    }

    fun getLastDataRealmModel(realm: Realm): RealmModel {
        return realm.where(RealmModel::class.java).findAll().last()!!
    }



}