package com.example.marvelcomics.domain.mapper

interface Mapper<Input, Output> {
    fun map(input: Input): Output
}