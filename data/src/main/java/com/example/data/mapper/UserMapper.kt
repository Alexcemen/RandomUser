package com.example.data.mapper

import com.example.data.local.entity.*
import com.example.data.remote.dto.*

class UserMapper {

    fun dtoToEntity(dto: UserDto): UserEntity {
        return UserEntity(
            id = 0,
            gender = dto.gender,
            name = dto.name?.let {
                NameEntity(
                    title = it.title,
                    first = it.first,
                    last = it.last
                )
            },
            location = dto.location?.let { location ->
                LocationEntity(
                    street = location.street?.let {
                        StreetEntity(
                            number = it.number,
                            name = it.name
                        )
                    },
                    city = location.city,
                    state = location.state,
                    country = location.country,
                    postcode = location.postcode,
                    coordinates = location.coordinates?.let {
                        CoordinatesEntity(
                            latitude = it.latitude,
                            longitude = it.longitude
                        )
                    },
                    timezone = location.timezone?.let {
                        TimezoneEntity(
                            offset = it.offset,
                            description = it.description
                        )
                    }
                )
            },
            email = dto.email,
            login = dto.login?.let {
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
            dob = dto.dob?.let {
                DobEntity(
                    date = it.date,
                    age = it.age
                )
            },
            registered = dto.registered?.let {
                RegisteredEntity(
                    date = it.date,
                    age = it.age
                )
            },
            phone = dto.phone,
            cell = dto.cell,
            userId = dto.id?.let {
                IdEntity(
                    name = it.name,
                    value = it.value
                )
            },
            picture = dto.picture?.let {
                PictureEntity(
                    large = it.large,
                    medium = it.medium,
                    thumbnail = it.thumbnail
                )
            },
            nat = dto.nat
        )
    }
}