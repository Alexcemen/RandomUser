package com.randomuser.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val localId: Int = 0,

    val gender: String?,

    @Embedded(prefix = "name_")
    val name: NameEntity?,

    @Embedded(prefix = "location_")
    val location: LocationEntity?,

    val email: String?,

    @Embedded(prefix = "login_")
    val login: LoginEntity?,

    @Embedded(prefix = "dob_")
    val dob: DobEntity?,

    @Embedded(prefix = "registered_")
    val registered: RegisteredEntity?,

    val phone: String?,
    val cell: String?,

    @Embedded(prefix = "id_")
    val remotedId: IdEntity?,

    @Embedded(prefix = "picture_")
    val picture: PictureEntity?,

    val nat: String?
)