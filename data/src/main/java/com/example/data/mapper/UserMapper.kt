package com.example.data.mapper

import com.example.data.local.entity.*
import com.example.data.remote.dto.*
import com.example.domain.model.Coordinates
import com.example.domain.model.Dob
import com.example.domain.model.Location
import com.example.domain.model.Login
import com.example.domain.model.Name
import com.example.domain.model.Picture
import com.example.domain.model.Registered
import com.example.domain.model.Street
import com.example.domain.model.Timezone
import com.example.domain.model.User
import com.example.domain.model.UserId

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

    fun entityToDomain(entity: UserEntity): User {
        return User(
            id = entity.id,
            gender = entity.gender,
            name = entity.name?.let {
                Name(
                    title = it.title,
                    first = it.first,
                    last = it.last
                )
            },
            location = entity.location?.let { location ->
                Location(
                    street = location.street?.let { street ->
                        Street(
                            number = street.number,
                            name = street.name
                        )
                    },
                    city = location.city,
                    state = location.state,
                    country = location.country,
                    postcode = location.postcode,
                    coordinates = location.coordinates?.let { coordinate ->
                        Coordinates(
                            latitude = coordinate.latitude,
                            longitude = coordinate.longitude
                        )
                    },
                    timezone = location.timezone?.let { timezone ->
                        Timezone(
                            offset = timezone.offset,
                            description = timezone.description
                        )
                    }
                )
            },
            email = entity.email,
            login = entity.login?.let {
                Login(
                    uuid = it.uuid,
                    username = it.username,
                    password = it.password,
                    salt = it.salt,
                    md5 = it.md5,
                    sha1 = it.sha1,
                    sha256 = it.sha256
                )
            },
            dob = entity.dob?.let {
                Dob(
                    date = it.date,
                    age = it.age
                )
            },
            registered = entity.registered?.let {
                Registered(
                    date = it.date,
                    age = it.age
                )
            },
            phone = entity.phone,
            cell = entity.cell,
            userId = entity.userId?.let {
                UserId(
                    name = it.name,
                    value = it.value
                )
            },
            picture = entity.picture?.let {
                Picture(
                    large = it.large,
                    medium = it.medium,
                    thumbnail = it.thumbnail
                )
            },
            nat = entity.nat
        )
    }

    fun domainToEntity(domain: User): UserEntity {
        return UserEntity(
            id = domain.id,
            gender = domain.gender,
            name = domain.name?.let {
                NameEntity(
                    title = it.title,
                    first = it.first,
                    last = it.last
                )
            },
            location = domain.location?.let { location ->
                LocationEntity(
                    street = location.street?.let { street ->
                        StreetEntity(
                            number = street.number,
                            name = street.name
                        )
                    },
                    city = location.city,
                    state = location.state,
                    country = location.country,
                    postcode = location.postcode,
                    coordinates = location.coordinates?.let { coordinates ->
                        CoordinatesEntity(
                            latitude = coordinates.latitude,
                            longitude = coordinates.longitude
                        )
                    },
                    timezone = location.timezone?.let { timezone ->
                        TimezoneEntity(
                            offset = timezone.offset,
                            description = timezone.description
                        )
                    }
                )
            },
            email = domain.email,
            login = domain.login?.let {
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
            dob = domain.dob?.let {
                DobEntity(
                    date = it.date,
                    age = it.age
                )
            },
            registered = domain.registered?.let {
                RegisteredEntity(
                    date = it.date,
                    age = it.age
                )
            },
            phone = domain.phone,
            cell = domain.cell,
            userId = domain.userId?.let {
                IdEntity(
                    name = it.name,
                    value = it.value
                )
            },
            picture = domain.picture?.let {
                PictureEntity(
                    large = it.large,
                    medium = it.medium,
                    thumbnail = it.thumbnail
                )
            },
            nat = domain.nat
        )
    }
}