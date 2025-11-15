package com.randomuser.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}