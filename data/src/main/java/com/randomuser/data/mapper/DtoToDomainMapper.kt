package com.randomuser.data.mapper

import com.randomuser.data.remote.dto.UserDto
import com.randomuser.domain.model.Coordinates
import com.randomuser.domain.model.Dob
import com.randomuser.domain.model.Location
import com.randomuser.domain.model.Login
import com.randomuser.domain.model.Name
import com.randomuser.domain.model.Picture
import com.randomuser.domain.model.Registered
import com.randomuser.domain.model.Street
import com.randomuser.domain.model.Timezone
import com.randomuser.domain.model.User
import com.randomuser.domain.model.UserId

class DtoToDomainMapper : Mapper<UserDto, User> {

    override fun map(input: UserDto): User {
        return User(
            id = 0,
            gender = input.gender ?: "",
            name = input.name?.let {
                Name(
                    title = it.title ?: "",
                    first = it.first ?: "",
                    last = it.last ?: ""
                )
            } ?: Name(
                title = "",
                first = "",
                last = ""
            ),
            location = input.location?.let { location ->
                Location(
                    street = location.street?.let { street ->
                        Street(
                            number = street.number ?: 0,
                            name = street.name ?: ""
                        )
                    } ?: Street(
                        number = 0,
                        name = ""
                    ),
                    city = location.city ?: "",
                    state = location.state ?: "",
                    country = location.country ?: "",
                    postcode = location.postcode ?: "",
                    coordinates = location.coordinates?.let { coord ->
                        Coordinates(
                            latitude = coord.latitude ?: "",
                            longitude = coord.longitude ?: ""
                        )
                    } ?: Coordinates(
                        latitude = "",
                        longitude = ""
                    ),
                    timezone = location.timezone?.let { tz ->
                        Timezone(
                            offset = tz.offset ?: "",
                            description = tz.description ?: ""
                        )
                    } ?: Timezone(
                        offset = "",
                        description = ""
                    )
                )
            } ?: Location(
                street = Street(
                    number = 0,
                    name = ""
                ),
                city = "",
                state = "",
                country = "",
                postcode = "",
                coordinates = Coordinates(
                    latitude = "",
                    longitude = ""
                ),
                timezone = Timezone(
                    offset = "",
                    description = ""
                )
            ),
            email = input.email ?: "",
            login = input.login?.let { login ->
                Login(
                    uuid = login.uuid ?: "",
                    username = login.username ?: "",
                    password = login.password ?: "",
                    salt = login.salt ?: "",
                    md5 = login.md5 ?: "",
                    sha1 = login.sha1 ?: "",
                    sha256 = login.sha256 ?: ""
                )
            } ?: Login(
                uuid = "",
                username = "",
                password = "",
                salt = "",
                md5 = "",
                sha1 = "",
                sha256 = ""
            ),
            dob = input.dob?.let { dob ->
                Dob(
                    date = dob.date ?: "",
                    age = dob.age ?: 0
                )
            } ?: Dob(
                date = "",
                age = 0
            ),
            registered = input.registered?.let { reg ->
                Registered(
                    date = reg.date ?: "",
                    age = reg.age ?: 0
                )
            } ?: Registered(
                date = "",
                age = 0
            ),
            phone = input.phone ?: "",
            cell = input.cell ?: "",
            userId = input.id?.let { id ->
                UserId(
                    name = id.name ?: "",
                    value = id.value ?: ""
                )
            } ?: UserId(
                name = "",
                value = ""
            ),
            picture = input.picture?.let { picture ->
                Picture(
                    large = picture.large ?: "",
                    medium = picture.medium ?: "",
                    thumbnail = picture.thumbnail ?: ""
                )
            } ?: Picture(
                large = "",
                medium = "",
                thumbnail = ""
            ),
            nat = input.nat ?: ""
        )
    }
}