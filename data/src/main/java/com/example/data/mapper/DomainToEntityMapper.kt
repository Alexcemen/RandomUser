package com.example.data.mapper

import com.example.data.local.entity.CoordinatesEntity
import com.example.data.local.entity.DobEntity
import com.example.data.local.entity.IdEntity
import com.example.data.local.entity.LocationEntity
import com.example.data.local.entity.LoginEntity
import com.example.data.local.entity.NameEntity
import com.example.data.local.entity.PictureEntity
import com.example.data.local.entity.RegisteredEntity
import com.example.data.local.entity.StreetEntity
import com.example.data.local.entity.TimezoneEntity
import com.example.data.local.entity.UserEntity
import com.example.domain.model.User

class DomainToEntityMapper : Mapper<User, UserEntity> {

    override fun map(input: User): UserEntity {
        return UserEntity(
            id = input.id,
            gender = input.gender,
            name = input.name.let {
                NameEntity(
                    title = it.title,
                    first = it.first,
                    last = it.last
                )
            },
            location = input.location.let { location ->
                LocationEntity(
                    street = location.street.let { street ->
                        StreetEntity(
                            number = street.number,
                            name = street.name
                        )
                    },
                    city = location.city,
                    state = location.state,
                    country = location.country,
                    postcode = location.postcode,
                    coordinates = location.coordinates.let { coordinates ->
                        CoordinatesEntity(
                            latitude = coordinates.latitude,
                            longitude = coordinates.longitude
                        )
                    },
                    timezone = location.timezone.let { timezone ->
                        TimezoneEntity(
                            offset = timezone.offset,
                            description = timezone.description
                        )
                    }
                )
            },
            email = input.email,
            login = input.login.let {
                LoginEntity(
                    uuid = it.uuid,
                    username = it.username,
                    password = it.password,
                    salt = it.salt,
                    md5 = it.md5,
                    sha1 = it.sha1,
                    sha256 = it.sha256
                )
            },
            dob = input.dob.let {
                DobEntity(
                    date = it.date,
                    age = it.age
                )
            },
            registered = input.registered.let {
                RegisteredEntity(
                    date = it.date,
                    age = it.age
                )
            },
            phone = input.phone,
            cell = input.cell,
            userId = input.userId.let {
                IdEntity(
                    name = it.name,
                    value = it.value
                )
            },
            picture = input.picture.let {
                PictureEntity(
                    large = it.large,
                    medium = it.medium,
                    thumbnail = it.thumbnail
                )
            },
            nat = input.nat
        )
    }
}