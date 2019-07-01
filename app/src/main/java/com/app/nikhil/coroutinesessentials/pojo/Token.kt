package com.app.nikhil.coroutinesessentials.pojo


import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("id")
    val id: Int = 1,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("app")
    val app: App? = null,
    @SerializedName("token")
    val token: String = "",
    @SerializedName("hashed_token")
    val hashedToken: String = "",
    @SerializedName("token_last_eight")
    val tokenLastEight: String = "",
    @SerializedName("note")
    val note: String = "",
    @SerializedName("note_url")
    val noteUrl: String = "",
    @SerializedName("created_at")
    val createdAt: String = "",
    @SerializedName("updated_at")
    val updatedAt: String = "",
    @SerializedName("scopes")
    val scopes: List<String>? = null,
    @SerializedName("fingerprint")
    val fingerprint: String = ""
) {
    data class App(
        @SerializedName("name")
        val name: String = "",
        @SerializedName("url")
        val url: String = "",
        @SerializedName("client_id")
        val clientId: String = ""
    )
}