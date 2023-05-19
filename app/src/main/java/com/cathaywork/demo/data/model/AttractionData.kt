package com.cathaywork.demo.data.model

import com.google.gson.annotations.SerializedName

class AttractionData (
    @SerializedName("total")
    val total: Int,
    @SerializedName("data")
    val data:List<Data>
)
data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("name_zh")
    val name_zh:String,
    @SerializedName("open_status")
    val open_status:Int,
    @SerializedName("introduction")
    val introduction:String,
    @SerializedName("open_time")
    val open_time:String,
    @SerializedName("zipcode")
    val zipcode:String,
    @SerializedName("distric")
    val distric:String,
    @SerializedName("address")
    val address:String,
    @SerializedName("tel")
    val tel:String,
    @SerializedName("fax")
    val fax:String,
    @SerializedName("email")
    val email:String,
    @SerializedName("months")
    val months:String,
    @SerializedName("nlat")
    val nlat:Double,
    @SerializedName("elong")
    val elong:Double,
    @SerializedName("official_site")
    val official_site:String,
    @SerializedName("facebook")
    val facebook:String,
    @SerializedName("ticket")
    val ticket:String,
    @SerializedName("remind")
    val remind:String,
    @SerializedName("staytime")
    val staytime:String,
    @SerializedName("modified")
    val modified:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("category")
    val category:List<Category>,
    @SerializedName("target")
    val target:List<Target>,
    @SerializedName("service")
    val service:List<Service>,
    @SerializedName("images")
    val images:List<Images>,
)
data class Category(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String
)
data class Target(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String
)
data class Service(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String
)
data class Images(
    @SerializedName("src")
    val src : String,
    @SerializedName("subject")
    val subject : String,
    @SerializedName("ext")
    val ext : String
)