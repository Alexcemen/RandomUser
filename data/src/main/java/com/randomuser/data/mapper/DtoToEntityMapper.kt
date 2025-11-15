package com.randomuser.data.mapper

import com.randomuser.data.local.entity.CoordinatesEntity
import com.randomuser.data.local.entity.DobEntity
import com.randomuser.data.local.entity.IdEntity
import com.randomuser.data.local.entity.LocationEntity
import com.randomuser.data.local.entity.LoginEntity
import com.randomuser.data.local.entity.NameEntity
import com.randomuser.data.local.entity.PictureEntity
import com.randomuser.data.local.entity.RegisteredEntity
import com.randomuser.data.local.entity.StreetEntity
import com.randomuser.data.local.entity.TimezoneEntity
import com.randomuser.data.local.entity.UserEntity
import com.randomuser.data.remote.dto.UserDto

class DtoToEntityMapper : Mapper<UserDto, UserEntity> {

    override fun map(input: UserDto): UserEntity {
        return UserEntity(
            localId = 0,
            gender = input.gender,
            name = input.name?.let {
                NameEntity(
                    title = it.title,
                    first = it.first,
                    last = it.last
                )
            },
            location = input.location?.let { location ->
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
            email = input.email,
            login = input.login?.let {
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
            dob = input.dob?.let {
                DobEntity(
                    date = it.date,
                    age = it.age
                )
            },
            registered = input.registered?.let {
                RegisteredEntity(
                    date = it.date,
                    age = it.age
                )
            },
            phone = input.phone,
            cell = input.cell,
            remotedId = input.id?.let {
                IdEntity(
                    name = it.name,
                    value = it.value
                )
            },
            picture = input.picture?.let {
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