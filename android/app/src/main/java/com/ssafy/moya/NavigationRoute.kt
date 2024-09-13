package com.ssafy.moya

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object ParkList

@Serializable
object ExploreList

@Serializable
data class ExploreDetail(val itemId: Int)

@Serializable
data class ParkDetail(val itemId: Int)

@Serializable
object Encyc

@Serializable
data class EncycDetail(val itemId: Int)

@Serializable
object ExploreStart

//TODO 나중에 dataclass로 수정하고 userId 전송하도록
@Serializable
object UserProfileEdit

@Serializable
object Login