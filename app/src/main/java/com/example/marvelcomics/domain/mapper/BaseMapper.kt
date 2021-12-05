package com.example.marvelcomics.domain.mapper

interface BaseMapper<Input, Output> {
    fun map(input: Input): Output
}