package com.example.baatuni

class User {
    var name:String? = null
    var email:String? = null
    var uid:String? = null

    constructor(){}

    constructor(Name: String?,Email: String?, Uid: String?){
        this.name = Name
        this.email = Email
        this.uid = Uid
    }
}